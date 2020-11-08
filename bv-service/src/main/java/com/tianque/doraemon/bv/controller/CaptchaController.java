/*
 *Copyright © 2018 anji-plus
 *安吉加加信息技术有限公司
 *http://www.anji-plus.com
 *All rights reserved.
 */
package com.tianque.doraemon.bv.controller;


import com.tianque.doraemon.bv.model.ResponseModel;
import com.tianque.doraemon.bv.service.CaptchaService;
import com.tianque.doraemon.bv.vo.CaptchaVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/captcha")
public class CaptchaController {

    @Autowired
    private Map<String, CaptchaService> captchaServiceMap;

    @PostMapping("/get")
    public ResponseModel get(@RequestBody CaptchaVO captchaVO) {
        return captchaServiceMap.get(captchaVO.getCaptchaType()).get(captchaVO);
    }

    @PostMapping("/check")
    public ResponseModel check(@RequestBody CaptchaVO captchaVO) {
        return captchaServiceMap.get(captchaVO.getCaptchaType()).check(captchaVO);
    }

    @PostMapping("/verify")
    public ResponseModel verify(@RequestBody CaptchaVO captchaVO) {
        return captchaServiceMap.get(captchaVO.getCaptchaType()).verification(captchaVO);
    }

}
