package com.mervyn.ruok.module.system.framework.datapermission.config;

import com.mervyn.ruok.framework.datapermission.core.rule.dept.DeptDataPermissionRuleCustomizer;
import com.mervyn.ruok.module.system.dal.dataobject.dept.DeptDO;
import com.mervyn.ruok.module.system.dal.dataobject.user.AdminUserDO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * system 模块的数据权限 Configuration
 *
 * @author mervyn
 */
@Configuration(proxyBeanMethods = false)
public class DataPermissionConfiguration {

    @Bean
    public DeptDataPermissionRuleCustomizer sysDeptDataPermissionRuleCustomizer() {
        return rule -> {
            // dept
            rule.addDeptColumn(AdminUserDO.class);
            rule.addDeptColumn(DeptDO.class, "id");
            // user
            rule.addUserColumn(AdminUserDO.class, "id");
        };
    }

}
