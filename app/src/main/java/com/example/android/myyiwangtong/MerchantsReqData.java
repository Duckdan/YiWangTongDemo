package com.example.android.myyiwangtong;

import java.io.Serializable;

/**
 * 自己服务器返回的数据
 */
public class MerchantsReqData implements Serializable {


    /**
     * dateTime : 20161216140241
     * branchNo : 0755
     * merchantNo : 000054
     * date : 20161216
     * orderNo : 9999153784
     * amount : 0.01
     * expireTimeSpan : 30
     * payNoticeUrl : http://www.merchant.com/path/payNotice.do
     * payNoticePara : aaa
     * clientIP : 99.12.43.61
     * cardType :
     * subMerchantNo :
     * subMerchantName :
     * subMerchantTPCode :
     * subMerchantTPName :
     * payModeType :
     * agrNo : 12345678901234500000
     * merchantSerialNo : 2016062014308880
     * userID : 2016062388888
     * lon : 30.949505
     * lat : 50.949506
     * riskLevel :
     * signNoticeUrl : http://www.merchant.com/path/signNotice.do
     * signNoticePara : 12345678|ABCDEFG|HIJKLM
     * extendInfo : FC77A8996853803BB6981F406BA84939CE96B8D57FFB20B653078B181FA9691D7CFF00D1D3EF21E6B338A3FD33490CAF12078BE885BB49F6016CF5A0314D21BF49738609F8386CB437A76A8DBE1E7E932DBDB18B7C69A8F10900FB8A3C98CB48833B5800A541DD6B5A12F65508C39CD1D51B32DD02CCE362BB5CE4D95E5D29921E603BBE3CA5B650652589013304CC2969E2A1046F91A1849B70001FE23EA8792560BE4FB7994D51BC7E7F5F5E08474F7090A44D435F2BFD7353B081DF80613817FD357CD472390A2EFEB1DA52D72DADD3BD5725FE42FA9D4B19
     * extendInfoEncrypType : RC4
     */

    private String dateTime;
    private String branchNo;
    private String merchantNo;
    private String date;
    private String orderNo;
    private String amount;
    private String expireTimeSpan;
    private String payNoticeUrl;
    private String payNoticePara;
    private String clientIP;
    private String cardType;
    private String subMerchantNo;
    private String subMerchantName;
    private String subMerchantTPCode;
    private String subMerchantTPName;
    private String payModeType;
    private String agrNo;
    private String merchantSerialNo;
    private String userID;
    private String lon;
    private String lat;
    private String riskLevel;
    private String signNoticeUrl;
    private String signNoticePara;
    private String extendInfo;
    private String extendInfoEncrypType;


    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getBranchNo() {
        return branchNo;
    }

    public void setBranchNo(String branchNo) {
        this.branchNo = branchNo;
    }

    public String getMerchantNo() {
        return merchantNo;
    }

    public void setMerchantNo(String merchantNo) {
        this.merchantNo = merchantNo;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getExpireTimeSpan() {
        return expireTimeSpan;
    }

    public void setExpireTimeSpan(String expireTimeSpan) {
        this.expireTimeSpan = expireTimeSpan;
    }

    public String getPayNoticeUrl() {
        return payNoticeUrl;
    }

    public void setPayNoticeUrl(String payNoticeUrl) {
        this.payNoticeUrl = payNoticeUrl;
    }

    public String getPayNoticePara() {
        return payNoticePara;
    }

    public void setPayNoticePara(String payNoticePara) {
        this.payNoticePara = payNoticePara;
    }

    public String getClientIP() {
        return clientIP;
    }

    public void setClientIP(String clientIP) {
        this.clientIP = clientIP;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getSubMerchantNo() {
        return subMerchantNo;
    }

    public void setSubMerchantNo(String subMerchantNo) {
        this.subMerchantNo = subMerchantNo;
    }

    public String getSubMerchantName() {
        return subMerchantName;
    }

    public void setSubMerchantName(String subMerchantName) {
        this.subMerchantName = subMerchantName;
    }

    public String getSubMerchantTPCode() {
        return subMerchantTPCode;
    }

    public void setSubMerchantTPCode(String subMerchantTPCode) {
        this.subMerchantTPCode = subMerchantTPCode;
    }

    public String getSubMerchantTPName() {
        return subMerchantTPName;
    }

    public void setSubMerchantTPName(String subMerchantTPName) {
        this.subMerchantTPName = subMerchantTPName;
    }

    public String getPayModeType() {
        return payModeType;
    }

    public void setPayModeType(String payModeType) {
        this.payModeType = payModeType;
    }

    public String getAgrNo() {
        return agrNo;
    }

    public void setAgrNo(String agrNo) {
        this.agrNo = agrNo;
    }

    public String getMerchantSerialNo() {
        return merchantSerialNo;
    }

    public void setMerchantSerialNo(String merchantSerialNo) {
        this.merchantSerialNo = merchantSerialNo;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getRiskLevel() {
        return riskLevel;
    }

    public void setRiskLevel(String riskLevel) {
        this.riskLevel = riskLevel;
    }

    public String getSignNoticeUrl() {
        return signNoticeUrl;
    }

    public void setSignNoticeUrl(String signNoticeUrl) {
        this.signNoticeUrl = signNoticeUrl;
    }

    public String getSignNoticePara() {
        return signNoticePara;
    }

    public void setSignNoticePara(String signNoticePara) {
        this.signNoticePara = signNoticePara;
    }

    public String getExtendInfo() {
        return extendInfo;
    }

    public void setExtendInfo(String extendInfo) {
        this.extendInfo = extendInfo;
    }

    public String getExtendInfoEncrypType() {
        return extendInfoEncrypType;
    }

    public void setExtendInfoEncrypType(String extendInfoEncrypType) {
        this.extendInfoEncrypType = extendInfoEncrypType;
    }

}
