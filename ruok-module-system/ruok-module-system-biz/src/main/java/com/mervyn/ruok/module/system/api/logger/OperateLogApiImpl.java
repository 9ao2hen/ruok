package com.mervyn.ruok.module.system.api.logger;

import com.mervyn.ruok.framework.common.pojo.PageResult;
import com.mervyn.ruok.framework.common.util.object.BeanUtils;
import com.mervyn.ruok.module.system.api.logger.dto.OperateLogCreateReqDTO;
import com.mervyn.ruok.module.system.api.logger.dto.OperateLogPageReqDTO;
import com.mervyn.ruok.module.system.api.logger.dto.OperateLogRespDTO;
import com.mervyn.ruok.module.system.dal.dataobject.logger.OperateLogDO;
import com.mervyn.ruok.module.system.service.logger.OperateLogService;
import com.fhs.core.trans.anno.TransMethodResult;
import jakarta.annotation.Resource;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * 操作日志 API 实现类
 *
 * @author mervyn
 */
@Service
@Validated
public class OperateLogApiImpl implements OperateLogApi {

    @Resource
    private OperateLogService operateLogService;

    @Override
    @Async
    public void createOperateLog(OperateLogCreateReqDTO createReqDTO) {
        operateLogService.createOperateLog(createReqDTO);
    }

    @Override
    @TransMethodResult
    public PageResult<OperateLogRespDTO> getOperateLogPage(OperateLogPageReqDTO pageReqDTO) {
        PageResult<OperateLogDO> operateLogPage = operateLogService.getOperateLogPage(pageReqDTO);
        return BeanUtils.toBean(operateLogPage, OperateLogRespDTO.class);
    }

}
