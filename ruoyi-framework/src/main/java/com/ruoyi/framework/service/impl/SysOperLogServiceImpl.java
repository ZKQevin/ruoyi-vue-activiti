package com.ruoyi.framework.service.impl;


import com.ruoyi.domain.mo.SysOperLogMo;
import com.ruoyi.framework.repository.SysOperLogRepository;
import com.ruoyi.framework.service.ISysOperLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * 操作日志 服务层处理
 * 
 * @author ruoyi
 */
@Service
public class SysOperLogServiceImpl implements ISysOperLogService
{
    @Autowired
    private SysOperLogRepository sysOperLogRepository;

    /**
     * 新增操作日志
     * 
     * @param operLog 操作日志对象
     */
    @Override
    public void insertOperlog(SysOperLogMo operLog)
    {
        sysOperLogRepository.insert(operLog);
    }

    /**
     * 查询系统操作日志集合
     * 
     * @param operLog 操作日志对象
     * @return 操作日志集合
     */
    @Override
    public List<SysOperLogMo> selectOperLogList(SysOperLogMo operLog)
    {
//        return operLogMapper.selectOperLogList(operLog);
        return sysOperLogRepository.findAll();
    }

    /**
     * 批量删除系统操作日志
     * 
     * @param operIds 需要删除的操作日志ID
     * @return 结果
     */
    @Override
    public int deleteOperLogByIds(Long[] operIds)
    {
        Arrays.stream(operIds).forEach(id->sysOperLogRepository.deleteById(id));
        return operIds.length;
    }

    /**
     * 查询操作日志详细
     * 
     * @param operId 操作ID
     * @return 操作日志对象
     */
    @Override
    public SysOperLogMo selectOperLogById(Long operId)
    {
        Optional<SysOperLogMo> byId = sysOperLogRepository.findById(operId);
        SysOperLogMo sysOperLogMo = byId.orElseGet(null);
        return sysOperLogMo;
    }

    /**
     * 清空操作日志
     */
    @Override
    public void cleanOperLog()
    {
        sysOperLogRepository.deleteAll();
    }
}
