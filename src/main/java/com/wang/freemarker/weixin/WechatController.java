package com.wang.freemarker.weixin;

import cn.hutool.crypto.digest.DigestUtil;
import com.wang.freemarker.constant.WeixinConstants;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@RestController
@RequestMapping("wechat")
public class WechatController {
    /**
     * 微信公众号增加了服务器配置，一些接收事件会推送到该接口（关注、取消关注）
     * @param xmlInfo
     * @return
     */
    @PostMapping
    public String eventHandle(@RequestBody String xmlInfo){
        System.err.println("/n*****************"+xmlInfo);
        return "yes";
    }

    /**
     * 微信公众号增加服务器配置，需要校验签名
     * @param echoStr
     * @param signature
     * @param timestamp
     * @param nonce
     * @return
     */
    @GetMapping
    public String checkSignature(@RequestParam String echostr,@RequestParam String signature,@RequestParam String timestamp,@RequestParam String nonce){
        String[] array = new String[]{WeixinConstants.token, timestamp, nonce};
        Arrays.sort(array);
        StringBuilder stringBuilder = new StringBuilder();
        for (String str : array) {
            stringBuilder.append(str);
        }
        String sign = DigestUtil.sha1Hex(stringBuilder.toString());
        if (sign.equals(signature)) {
            return echostr;
        }
        return "error";
    }

}
