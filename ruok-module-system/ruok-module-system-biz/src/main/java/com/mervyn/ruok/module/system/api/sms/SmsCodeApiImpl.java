package com.mervyn.ruok.module.system.api.sms;

import com.mervyn.ruok.module.system.api.sms.dto.code.SmsCodeValidateReqDTO;
import com.mervyn.ruok.module.system.api.sms.dto.code.SmsCodeSendReqDTO;
import com.mervyn.ruok.module.system.api.sms.dto.code.SmsCodeUseReqDTO;
import com.mervyn.ruok.module.system.service.sms.SmsCodeService;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import jakarta.annotation.Resource;

/**
 * 短信验证码 API 实现类
 *
 * @author mervyn
 */
@Service
@Validated
public class SmsCodeApiImpl implements SmsCodeApi {

    @Resource
    private SmsCodeService smsCodeService;

    @Override
    public void sendSmsCode(SmsCodeSendReqDTO reqDTO) {
        smsCodeService.sendSmsCode(reqDTO);
    }

    @Override
    public void useSmsCode(SmsCodeUseReqDTO reqDTO) {
        smsCodeService.useSmsCode(reqDTO);
    }

    @Override
    public void validateSmsCode(SmsCodeValidateReqDTO reqDTO) {
        smsCodeService.validateSmsCode(reqDTO);
    }

}
