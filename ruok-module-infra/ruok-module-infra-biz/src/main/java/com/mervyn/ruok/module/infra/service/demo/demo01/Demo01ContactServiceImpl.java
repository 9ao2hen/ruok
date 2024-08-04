package com.mervyn.ruok.module.infra.service.demo.demo01;

import com.mervyn.ruok.framework.common.pojo.PageResult;
import com.mervyn.ruok.framework.common.util.object.BeanUtils;
import com.mervyn.ruok.module.infra.controller.admin.demo.demo01.vo.Demo01ContactPageReqVO;
import com.mervyn.ruok.module.infra.controller.admin.demo.demo01.vo.Demo01ContactSaveReqVO;
import com.mervyn.ruok.module.infra.dal.dataobject.demo.demo01.Demo01ContactDO;
import com.mervyn.ruok.module.infra.dal.mysql.demo.demo01.Demo01ContactMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import static com.mervyn.ruok.framework.common.exception.util.ServiceExceptionUtil.exception;
import static com.mervyn.ruok.module.infra.enums.ErrorCodeConstants.DEMO01_CONTACT_NOT_EXISTS;

/**
 * 示例联系人 Service 实现类
 *
 * @author mervyn
 */
@Service
@Validated
public class Demo01ContactServiceImpl implements Demo01ContactService {

    @Resource
    private Demo01ContactMapper demo01ContactMapper;

    @Override
    public Long createDemo01Contact(Demo01ContactSaveReqVO createReqVO) {
        // 插入
        Demo01ContactDO demo01Contact = BeanUtils.toBean(createReqVO, Demo01ContactDO.class);
        demo01ContactMapper.insert(demo01Contact);
        // 返回
        return demo01Contact.getId();
    }

    @Override
    public void updateDemo01Contact(Demo01ContactSaveReqVO updateReqVO) {
        // 校验存在
        validateDemo01ContactExists(updateReqVO.getId());
        // 更新
        Demo01ContactDO updateObj = BeanUtils.toBean(updateReqVO, Demo01ContactDO.class);
        demo01ContactMapper.updateById(updateObj);
    }

    @Override
    public void deleteDemo01Contact(Long id) {
        // 校验存在
        validateDemo01ContactExists(id);
        // 删除
        demo01ContactMapper.deleteById(id);
    }

    private void validateDemo01ContactExists(Long id) {
        if (demo01ContactMapper.selectById(id) == null) {
            throw exception(DEMO01_CONTACT_NOT_EXISTS);
        }
    }

    @Override
    public Demo01ContactDO getDemo01Contact(Long id) {
        return demo01ContactMapper.selectById(id);
    }

    @Override
    public PageResult<Demo01ContactDO> getDemo01ContactPage(Demo01ContactPageReqVO pageReqVO) {
        return demo01ContactMapper.selectPage(pageReqVO);
    }

}