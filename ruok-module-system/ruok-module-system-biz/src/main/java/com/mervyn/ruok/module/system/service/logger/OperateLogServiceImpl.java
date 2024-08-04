package com.mervyn.ruok.module.system.service.logger;

import com.mervyn.ruok.framework.common.pojo.PageResult;
import com.mervyn.ruok.framework.common.util.object.BeanUtils;
import com.mervyn.ruok.module.system.api.logger.dto.OperateLogCreateReqDTO;
import com.mervyn.ruok.module.system.api.logger.dto.OperateLogPageReqDTO;
import com.mervyn.ruok.module.system.controller.admin.logger.vo.operatelog.OperateLogPageReqVO;
import com.mervyn.ruok.module.system.dal.dataobject.logger.OperateLogDO;
import com.mervyn.ruok.module.system.dal.mysql.logger.OperateLogMapper;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * 操作日志 Service 实现类
 *
 * @author mervyn
 */
@Service
@Validated
@Slf4j
public class OperateLogServiceImpl implements OperateLogService {

    @Resource
    private OperateLogMapper operateLogMapper;

    @Override
    public void createOperateLog(OperateLogCreateReqDTO createReqDTO) {
        OperateLogDO log = BeanUtils.toBean(createReqDTO, OperateLogDO.class);
        operateLogMapper.insert(log);
    }

    @Override
    public PageResult<OperateLogDO> getOperateLogPage(OperateLogPageReqVO pageReqVO) {
        return operateLogMapper.selectPage(pageReqVO);
    }

    @Override
    public PageResult<OperateLogDO> getOperateLogPage(OperateLogPageReqDTO pageReqDTO) {
        return operateLogMapper.selectPage(pageReqDTO);
    }

}
