package com.example.android.myyiwangtong;



import java.io.Serializable;

/**
 * 自己公司服务期返回的数据
 */
public class PayResult implements Serializable {
    private static final long serialVersionUID = 40L;

    public String prepayid;
    public String noncestr;
    public String appid;
    public String packageX;
    public String sign;
    public int timestamp;
    public String partnerid;

    public MerchantsReqData reqData;

    /**
     * alipay :
     */

    public String alipay;

    public int total_price = -1;
}
