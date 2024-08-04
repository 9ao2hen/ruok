package com.mervyn.ruok.module.infra.dal.mysql.job;

import com.mervyn.ruok.framework.common.pojo.PageResult;
import com.mervyn.ruok.framework.mybatis.core.mapper.BaseMapperX;
import com.mervyn.ruok.framework.mybatis.core.query.LambdaQueryWrapperX;
import com.mervyn.ruok.module.infra.controller.admin.job.vo.job.JobPageReqVO;
import com.mervyn.ruok.module.infra.dal.dataobject.job.JobDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 定时任务 Mapper
 *
 * @author mervyn
 */
@Mapper
public interface JobMapper extends BaseMapperX<JobDO> {

    default JobDO selectByHandlerName(String handlerName) {
        return selectOne(JobDO::getHandlerName, handlerName);
    }

    default PageResult<JobDO> selectPage(JobPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<JobDO>()
                .likeIfPresent(JobDO::getName, reqVO.getName())
                .eqIfPresent(JobDO::getStatus, reqVO.getStatus())
                .likeIfPresent(JobDO::getHandlerName, reqVO.getHandlerName())
        );
    }

}
