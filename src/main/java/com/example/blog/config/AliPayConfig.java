package com.example.blog.config;

public class AliPayConfig {
    // 支付宝网关
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

    // 应用ID,你的APPID
    public static String app_id = "2021000118690413";

    // 应用私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCxAwXUhumTLO47I+1FNwJhq3/MDm1k00fXWi9f9yCsm55vTkxNADA8FQZKa7ygCgfl6SrAJEfEMuUu2JFXlkgQqTHydQZV2sAVGeF3BKBmlhEmN+Nmt6PTeJvN91br+Q5jHIJ/6AMh7ZtGS2oh7aIJPJ+7roLmb474aJUjmR9FtWdbOR7OUZgKGoHZmcOICUNQtUH7cIOidMEhV6dJcSmhhXun08tA9MzqMY/DfdZf85QQyjJqzcrWpD413n59cSoB79qZazXlNBggv3baYrBX+1QXEy2h88tWV4/CFV+y7Z2QQ2kRpVb5ZSuU/XN/V47L57Xq3ChBTM+fJAW+25YpAgMBAAECggEAF1VdrGFIYvU2Rid7PHd+4d8Yjo6MTxEm1DV4Lz9FWFt/LA73MeNHeHQRCzheef44gk8VKpTdvPg0i9NSfWg7Aa87/Uj9181pKp7pwKWke0Fm61HMsRqeBt9MMn9bPunqwpfcf/3Wg99ta3u/ds97X5pVOAlOChBEmWw31KR3odmKXgmdOB2179fnHqFZfxOR25D1zzzLhipUD+MZ/QvlJcj3MX1Etbvj3qYRDHENVep+fxu03Vw00TqyenESXy1kLVHROQjqDQGO8iTWZfF87zadqZBgLHe5aQ9bO/Na2a1qGjvcbrNzUY6c4yhVsHs6YnTHifXSMyH5GOVXTS1FPQKBgQDtLCzRYn5kiI1p5ljYXjm0hmwPlQMnm5ePsf1fs2hfFqxzTfiG28t+X7dVuNwHZoi2QThFo7V1VSDMEoAHHIYLdBBRSRyhNAuWGLjLKqi58cbCWjiTvQ1R8BUg572s6pX5J96LZ0mWbBVgkyX3uVvG9CZQ2ilRF26BSU6dl50uMwKBgQC/EEKF+BSR9betZ0/37CwLZKZht97cdSmjwL/0UBL6rQp9p6EuMy6nCfX0Jtb6D8uiw5AHeaHTfiZRXCEw0JzJ5q8C0Em/g5+xir5wVoEwbfuHgkxAb8OKWx/Xr4FeTDszdP04Je6GLLW/R4CiLuqoHXooNOZHWw3cOOYVnCEWMwKBgE3dTul/OJew7Rxzb3+5j6Bg8WE8PsjmICAhA1pEAGQXgY5pbsp3pptauUn/Yt1bIE8Vom/ai1x2EkptWHL9PlTMSf8lzaxu9c7VVvX8j2BcrDBqhmCalKDt/UHMU01NxucB2+JQiqxD19DY/oIR7LuotFufBCmHU9RGSPUcLZJZAoGAEtDRHExgCje+jO8dqvaxJ7YTxI/M/Lz1CtFSlgbEt7cOz20QrHIR6BVNCWxBw4KGtVK4/mN2ElPcBisigaIprqBvH8HPYXLe6ScWtg1uz4wlNyUXyUi4YwmySxVXkifDtL+SqFLj+Iayp1GtU0t3hHLSst7yxpgq90MLNZmYkI0CgYEAzykcUoT9uMIextW76mGed/pr5kB2GsqCPc57LHbavjrXELdkC6FT+Ovah9C0PZFSzvYWVlutOD5QF8bacpppzzn4Vdb61+rLStfkFySyvRtTNaHB//sXlGLK5Z8rY/kWfzyteE8m4svRL8a8089MPf94uIeokZ94K8Mn8CFzH2I=";

    // 支付宝公钥
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEApmClPCml2h3SvCoeHuOrRXqSMCqUGMoNy0B/Mo8yIU/TJXkji6vQmTkTHcs+X31NppQSkPlxaeTO/jRI2pTPRdn/G6ulZ8fdIHXtC3q2O9sd8rcX81WKelCgowfRLYMuBi0+UzMHFL+wAGesa5rbHyNaEI87JwgXNonYZIC6fVa8VZOeMbB5uP8S8wQ8CkR/rLXZeQpAYYRYiobeyhg3Px8FYgQUZiAvsTWtWdhqYkzAgMPwqJN4wwo2p1tyjXFhsLgL8WFJhuVGn7YAhNW0cy7KMDYytg0093fWokQtWFq0KBrmOtJmacmwN8TJcDKEnAbM+gvZPcftd2apQTedKQIDAQAB";

    // 服务器异步通知页面路径，部署在公网下的网页；如果只是自己测试，可以不用在公网下，甚至可以不填，如果不填的话记得把下面代码中设置这一项的那一行注释。
    public static String notify_url = "";

    // 页面跳转同步通知页面路径，部署在公网下的网页；如果只是自己测试，可以不用在公网下，甚至可以不填，如果不填的话记得把下面代码中设置这一项的那一行注释。
    public static String return_url = "";

    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String charset = "utf-8";

/*
在这之后应该再写一个函数，用来记录支付信息，做日志或者数据记录，感兴趣的可以自行查找相关代码。
*/
}
