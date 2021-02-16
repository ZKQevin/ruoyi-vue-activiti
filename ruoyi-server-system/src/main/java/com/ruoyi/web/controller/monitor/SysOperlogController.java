package com.ruoyi.web.controller.monitor;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.core.controller.BaseController;

/**
 * 操作日志记录
 * 
 * @author ruoyi
 */
@RestController
@RequestMapping("/monitor/operlog")
public class SysOperlogController extends BaseController
{
//    @Autowired
//    private ISysOperLogService operLogService;
//
//    @PreAuthorize("@ss.hasPermi('monitor:operlog:list')")
//    @GetMapping("/list")
//    public TableDataInfo list(SysOperLog operLog)
//    {
//        startPage();
//        List<SysOperLog> list = operLogService.selectOperLogList(operLog);
//        return getDataTable(list);
//    }
//
//    @Log(title = "操作日志", businessType = BusinessType.EXPORT)
//    @PreAuthorize("@ss.hasPermi('monitor:operlog:export')")
//    @GetMapping("/export")
//    public AjaxResult export(SysOperLog operLog)
//    {
//        List<SysOperLog> list = operLogService.selectOperLogList(operLog);
//        ExcelUtil<SysOperLog> util = new ExcelUtil<SysOperLog>(SysOperLog.class);
//        return util.exportExcel(list, "操作日志");
//    }
//
//    @PreAuthorize("@ss.hasPermi('monitor:operlog:remove')")
//    @DeleteMapping("/{operIds}")
//    public AjaxResult remove(@PathVariable Long[] operIds)
//    {
//        return toAjax(operLogService.deleteOperLogByIds(operIds));
//    }
//
//    @Log(title = "操作日志", businessType = BusinessType.CLEAN)
//    @PreAuthorize("@ss.hasPermi('monitor:operlog:remove')")
//    @DeleteMapping("/clean")
//    public AjaxResult clean()
//    {
//        operLogService.cleanOperLog();
//        return AjaxResult.success();
//    }
}
