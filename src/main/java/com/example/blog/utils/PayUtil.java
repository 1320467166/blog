package com.example.blog.utils;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.example.blog.config.AliPayConfig;
import org.springframework.stereotype.Component;

@Component
public class PayUtil {

    /**
     *
     * @param outTradeNo  商户订单号，商户网站订单系统中唯一订单号，必填   可以使用当前时间
     * @param totalAmount  付款金额，必填
     * @param subject 主题
     * @param body 商品描述，可空
     * @return
     */
    public  String aLiPay(String outTradeNo,String totalAmount,String subject,String body) {
        //获得初始化的AlipayClient对象，这个时候就把我们在AlipayConfig中设置的收款方商户信息设置进去了
        AlipayClient alipayClient = new DefaultAlipayClient(AliPayConfig.gatewayUrl, AliPayConfig.app_id, AliPayConfig.merchant_private_key, "json", AliPayConfig.charset, AliPayConfig.alipay_public_key, AliPayConfig.sign_type);

        // 设置请求参数
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();

        // 设置两个网页，一个异步通知网页，一个支付结束跳转页面，初学者若没有部署在服务器上的网页，可以把这两行注释掉
        alipayRequest.setReturnUrl("http://www.baidu.com");
        // alipayRequest.setNotifyUrl(AlipayConfig.notify_url);
        try {
            alipayRequest.setBizContent("{\"out_trade_no\":\""+ outTradeNo +"\","   // 设置订单号
                    + "\"total_amount\":\""+ totalAmount +"\","     // 设置订单总额
                    + "\"subject\":\""+ subject +"\","      // 设置订单主题
                    + "\"timeout_express\":\"10m\","        // 设置该订单最晚付款时间，这里设置的是10分钟
                    + "\"body\":\""+ body +"\","        // 设置该订单商品的描述
                    // + "\"qr_pay_mode\":\""+ Constants.QR_PAY_MODE +"\","
                    + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");

            // 发起生成订单请求
            String result = alipayClient.pageExecute(alipayRequest).getBody();
            return result;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
    }
}
