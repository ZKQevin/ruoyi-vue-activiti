package com.ruoyi.web.controller.common;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.common.constant.RedisConstants;
import com.ruoyi.common.core.domain.JSONResult;
import com.ruoyi.common.utils.ip.IpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.FastByteArrayOutputStream;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.google.code.kaptcha.Producer;
import com.ruoyi.common.constant.Constants;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.redis.RedisCache;
import com.ruoyi.common.utils.sign.Base64;
import com.ruoyi.common.utils.uuid.IdUtils;

/**
 * 验证码操作处理
 *
 * @author ruoyi
 */
@RestController
public class CaptchaController {
    @Resource(name = "captchaProducer")
    private Producer captchaProducer;

    @Resource(name = "captchaProducerMath")
    private Producer captchaProducerMath;

    @Autowired
    private RedisCache redisCache;

    // 验证码类型
    @Value("${ruoyi.captchaType}")
    private String captchaType;
    // 超过一定次数展示验证码
    @Value("${ruoyi.failturesNum}")
    private Integer failturesNum;

    /**
     * 生成验证码
     */
    @GetMapping("/captchaImage")
    public JSONResult getCode(HttpServletResponse response, HttpServletRequest request) throws IOException {
        Map<String, Object> map = new HashMap<>();
        String uuid = IdUtils.simpleUUID();
        map.put("uuid", uuid);
        String ipAddr = IpUtils.getIpAddr(request);
        String verifyKey = RedisConstants.CAPTCHA_CODE_KEY + uuid;
        Boolean b=false;
        Boolean ipLimit = redisCache.getCacheObject(RedisConstants.CAPTCHA_LIMIT_IP_KEY + ipAddr);

        // 保存验证码信息
        if (ipLimit!=null&&ipLimit==true){
            b=true;
            map.put("captcha",true);
        }else {
            long increment = redisCache.increment(RedisConstants.LOGIN_ERRORS_NUM_KEY + ipAddr, 1);
            if (increment>failturesNum){
                b=true;
                map.put("captcha",true);
                redisCache.setCacheObject(RedisConstants.CAPTCHA_LIMIT_IP_KEY + ipAddr,true);
            }else {
                map.put("captcha",false);
                redisCache.setCacheObject(verifyKey, Constants.GENERAL_CAPTCHA+uuid, Constants.CAPTCHA_EXPIRATION, TimeUnit.MINUTES);
            }
        }


        if (b) {
            String capStr = null, code = null;
            BufferedImage image = null;

            // 生成验证码
            if ("math".equals(captchaType)) {
                String capText = captchaProducerMath.createText();
                capStr = capText.substring(0, capText.lastIndexOf("@"));
                code = capText.substring(capText.lastIndexOf("@") + 1);
                image = captchaProducerMath.createImage(capStr);
            } else if ("char".equals(captchaType)) {
                capStr = code = captchaProducer.createText();
                image = captchaProducer.createImage(capStr);
            }
            // 转换流信息写出
            FastByteArrayOutputStream os = new FastByteArrayOutputStream();
            redisCache.setCacheObject(verifyKey, code, Constants.CAPTCHA_EXPIRATION, TimeUnit.MINUTES);

            try {
                ImageIO.write(image, "jpg", os);
            } catch (IOException e) {
                return JSONResult.errorCustom(e.getMessage());
            }
            map.put("img", Base64.encode(os.toByteArray()));
        }



        return JSONResult.ok(map);
    }
}
