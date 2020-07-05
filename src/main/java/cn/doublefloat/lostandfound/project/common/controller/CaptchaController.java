package cn.doublefloat.lostandfound.project.common.controller;

import cn.doublefloat.lostandfound.common.constants.Constants;
import cn.doublefloat.lostandfound.common.utils.IdUtils;
import cn.doublefloat.lostandfound.common.utils.VerifyCodeUtils;
import cn.doublefloat.lostandfound.common.utils.sign.Base64;
import cn.doublefloat.lostandfound.framework.redis.RedisCacheService;
import cn.doublefloat.lostandfound.framework.web.domain.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @author 李广帅
 * @date 2020/6/6 9:18 下午
 */
@RestController
public class CaptchaController {

    @Autowired
    private RedisCacheService redisCacheService;

    @GetMapping("/captchaImage")
    public AjaxResult captcha() throws IOException {
        String verifyCode = VerifyCodeUtils.generateVerifyCode(4);
        // 唯一标识
        String uuid = IdUtils.simpleUUID();
        String verifyKey = Constants.CAPTCHA_CODE_KEY + uuid;

        // 将验证码存入缓存
        redisCacheService.setCacheObject(verifyKey, verifyCode, 3, TimeUnit.MINUTES);

        // 生成图片
        int w = 111;
        int h = 36;
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        VerifyCodeUtils.outputImage(w, h, stream, verifyCode);
        try {
            AjaxResult ajax = AjaxResult.success();
            ajax.put("uuid", uuid);
            ajax.put("img", Base64.encode(stream.toByteArray()));
            return ajax;
        } catch (Exception e) {
            return AjaxResult.error(e.getMessage());
        } finally {
            stream.close();
        }
    }

}
