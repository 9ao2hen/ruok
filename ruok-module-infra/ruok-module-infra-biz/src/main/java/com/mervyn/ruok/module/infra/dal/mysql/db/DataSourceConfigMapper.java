package com.mervyn.ruok.module.infra.dal.mysql.db;

import com.mervyn.ruok.framework.mybatis.core.mapper.BaseMapperX;
import com.mervyn.ruok.module.infra.dal.dataobject.db.DataSourceConfigDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 数据源配置 Mapper
 *
 * @author mervyn
 */
@Mapper
public interface DataSourceConfigMapper extends BaseMapperX<DataSourceConfigDO> {
}
