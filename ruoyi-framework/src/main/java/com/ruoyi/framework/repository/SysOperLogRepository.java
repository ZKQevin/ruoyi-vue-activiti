package com.ruoyi.framework.repository;

import com.ruoyi.domain.mo.SysOperLogMo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SysOperLogRepository extends MongoRepository<SysOperLogMo, Long> {
}
