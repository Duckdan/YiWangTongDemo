package com.example.android.myyiwangtong;

/**
 * 拼接招行需要的API
 */
public class RealMerchantsReqData {
    /**
     * "version":"1.0",
     * "sign":"见签名处理章节",
     * "signType":"SHA-256",
     */
    public String version = "1.0";
    public String signType = "SHA-256";
    public String sign;
    public MerchantsReqData reqData;

}
