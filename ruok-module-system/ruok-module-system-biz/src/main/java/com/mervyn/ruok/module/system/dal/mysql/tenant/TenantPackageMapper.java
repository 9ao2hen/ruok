package com.mervyn.ruok.module.system.dal.mysql.tenant;

import com.mervyn.ruok.framework.common.pojo.PageResult;
import com.mervyn.ruok.framework.mybatis.core.mapper.BaseMapperX;
import com.mervyn.ruok.framework.mybatis.core.query.LambdaQueryWrapperX;
import com.mervyn.ruok.module.system.controller.admin.tenant.vo.packages.TenantPackagePageReqVO;
import com.mervyn.ruok.module.system.dal.dataobject.tenant.TenantPackageDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 租户套餐 Mapper
 *
 * @author mervyn
 */
@Mapper
public interface TenantPackageMapper extends BaseMapperX<TenantPackageDO> {

    default PageResult<TenantPackageDO> selectPage(TenantPackagePageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<TenantPackageDO>()
                .likeIfPresent(TenantPackageDO::getName, reqVO.getName())
                .eqIfPresent(TenantPackageDO::getStatus, reqVO.getStatus())
                .likeIfPresent(TenantPackageDO::getRemark, reqVO.getRemark())
                .betweenIfPresent(TenantPackageDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(TenantPackageDO::getId));
    }

    default List<TenantPackageDO> selectListByStatus(Integer status) {
        return selectList(TenantPackageDO::getStatus, status);
    }
}
