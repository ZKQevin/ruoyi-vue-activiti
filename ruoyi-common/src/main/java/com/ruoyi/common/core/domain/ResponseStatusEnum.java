package com.ruoyi.common.core.domain;

/**
 * 响应结果枚举，用于提供给GraceJSONResult返回给前端的
 * 本枚举类中包含了很多的不同的状态码供使用，可以自定义
 * 便于更优雅的对状态码进行管理，一目了然
 */
public enum ResponseStatusEnum {

    SUCCESS(200,  "操作成功！"),
    FAILED(500, "操作失败！"),

    // 50x
    UN_LOGIN(501,"请登录后再继续操作！"),
    TICKET_INVALID(502,"会话失效，请重新登录！"),
    NO_AUTH(503,"您的权限不足，无法继续操作！"),
    MOBILE_ERROR(504,"短信发送失败，请稍后重试！"),
    SMS_NEED_WAIT_ERROR(505,"短信发送太快啦~请稍后再试！"),
    SMS_CODE_ERROR(506,"验证码过期或不匹配，请稍后再试！"),
    USER_FROZEN(507,"用户已被冻结，请联系管理员！"),
    USER_UPDATE_ERROR(508,"用户信息更新失败，请联系管理员！"),
    USER_INACTIVE_ERROR(509,"请前往[账号设置]修改信息激活后再进行后续操作！"),
    FILE_UPLOAD_NULL_ERROR(510,"文件不能为空，请选择一个文件再上传！"),
    FILE_UPLOAD_FAILD(511,"文件上传失败！"),
    FILE_FORMATTER_FAILD(512,"文件图片格式不支持！"),
    FILE_MAX_SIZE_ERROR(513,"仅支持500kb大小以下的图片上传！"),
    FILE_NOT_EXIST_ERROR(514,"你所查看的文件不存在！"),
    USER_STATUS_ERROR(515,"用户状态参数出错！"),
    USER_NOT_EXIST_ERROR(516,"用户不存在！"),

    // 自定义系统级别异常 54x
    SYSTEM_INDEX_OUT_OF_BOUNDS(541, "系统错误，数组越界！"),
    SYSTEM_ARITHMETIC_BY_ZERO(542, "系统错误，无法除零！"),
    SYSTEM_NULL_POINTER(543, "系统错误，空指针！"),
    SYSTEM_NUMBER_FORMAT(544, "系统错误，数字转换异常！"),
    SYSTEM_PARSE(545, "系统错误，解析异常！"),
    SYSTEM_IO(546, "系统错误，IO输入输出异常！"),
    SYSTEM_FILE_NOT_FOUND(547, "系统错误，文件未找到！"),
    SYSTEM_CLASS_CAST(548, "系统错误，类型强制转换错误！"),
    SYSTEM_PARSER_ERROR(549, "系统错误，解析出错！"),
    SYSTEM_DATE_PARSER_ERROR(550, "系统错误，日期解析出错！"),

    // admin 管理系统 56x
    ADMIN_USERNAME_NULL_ERROR(561, "管理员登录名不能为空！"),
    ADMIN_USERNAME_EXIST_ERROR(562, "管理员登录名已存在！"),
    ADMIN_NAME_NULL_ERROR(563, "管理员负责人不能为空！"),
    ADMIN_PASSWORD_ERROR(564, "密码不能为空后者两次输入不一致！"),
    ADMIN_CREATE_ERROR(565, "添加管理员失败！"),
    ADMIN_PASSWORD_NULL_ERROR(566, "密码不能为空！"),
    ADMIN_NOT_EXIT_ERROR(567, "管理员不存在或密码错误！"),
    ADMIN_FACE_NULL_ERROR(568, "人脸信息不能为空！"),
    ADMIN_FACE_LOGIN_ERROR(569, "人脸识别失败，请重试！"),
    CATEGORY_EXIST_ERROR(570, "文章分类已存在，请换一个分类名！"),

    // 媒体中心 相关错误 58x
    ARTICLE_COVER_NOT_EXIST_ERROR(580, "文章封面不存在，请选择一个！"),
    ARTICLE_CATEGORY_NOT_EXIST_ERROR(581, "请选择正确的文章领域！"),
    ARTICLE_CREATE_ERROR(582, "创建文章失败，请重试或联系管理员！"),
    ARTICLE_QUERY_PARAMS_ERROR(583, "文章列表查询参数错误！"),
    ARTICLE_DELETE_ERROR(584, "文章删除失败！"),
    ARTICLE_WITHDRAW_ERROR(585, "文章撤回失败！"),
    ARTICLE_REVIEW_ERROR(585, "文章审核出错！"),
    ARTICLE_ALREADY_READ_ERROR(586, "文章重复阅读！"),

    // 人脸识别错误代码
    FACE_VERIFY_TYPE_ERROR(600, "人脸比对验证类型不正确！"),
    FACE_VERIFY_LOGIN_ERROR(601, "人脸登录失败！"),

    // 系统错误，未预期的错误 555
    SYSTEM_ERROR(555, "系统繁忙，请稍后再试！"),
    SYSTEM_OPERATION_ERROR(556, "操作失败，请重试或联系管理员"),
    SYSTEM_RESPONSE_NO_INFO(557, "");


    // 响应业务状态
    private Integer code;

    // 响应消息，可以为成功或者失败的消息
    private String msg;

    ResponseStatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer code() {
        return code;
    }
    public String msg() {
        return msg;
    }
}
