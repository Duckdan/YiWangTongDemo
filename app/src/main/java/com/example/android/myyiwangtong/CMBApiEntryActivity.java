package com.example.android.myyiwangtong;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.Toast;

import com.example.android.yiwangtongdemo.BuildConfig;
import com.google.gson.Gson;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import cmbapi.CMBApi;
import cmbapi.CMBApiFactory;
import cmbapi.CMBEventHandler;
import cmbapi.CMBRequest;
import cmbapi.CMBResponse;

/**
 * 此页面用于向招商银行一网通发送请求以及接受回调
 * <p>
 * 商户APP需要在onCreate(), onNewIntent()以及onActivityResult方法里面显式调用handleIntent方法，否则将收不到最终的业务处理结果回调。
 * <p>
 * 使用方法：使用的时候直接开启即可，一般不用添加布局视图
 */
public class CMBApiEntryActivity extends AppCompatActivity implements CMBEventHandler {

    private CMBApi cmbApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        cmbApi = CMBApiFactory.createCMBAPI(this, "0755052993");
        Intent intent = getIntent();
        PayResult payResult = (PayResult) intent.getSerializableExtra("payResult");
        CMBRequest request = new CMBRequest();
        try {
            RealMerchantsReqData rmrd = new RealMerchantsReqData();
            rmrd.sign = payResult.sign;
            rmrd.reqData = payResult.reqData;
            request.mRequestData = "jsonRequestData=" + URLEncoder.encode(new Gson().toJson(rmrd), "UTF-8");
            /**
             * 下面这些地址都是根据招商开发文档来配置的
             */
            request.mCMBJumpUrl = BuildConfig.DEBUG ? "cmbmobilebank://CMBLS/FunctionJump?action=gofuncid&funcid=200013&serverid=CMBEUserPay&requesttype=post&cmb_app_trans_parms_start=here" : "cmbmobilebank://CMBLS/FunctionJump?action=gofuncid&funcid=200013&serverid=CMBEUserPay&requesttype=post&cmb_app_trans_parms_start=here";
            request.mH5Url = BuildConfig.DEBUG ? "http://121.15.180.72:801/netpayment/BaseHttp.dll?H5PayJsonSDK" : "https://netpay.cmbchina.com/netpayment/BaseHttp.dll?H5PayJsonSDK";
            request.mMethod = "pay";

            if (TextUtils.isEmpty(request.mH5Url)
                    && TextUtils.isEmpty(request.mCMBJumpUrl)) {
                Toast.makeText(this, "调用失败,cmbJumpUrl,h5Url不能同时为空", Toast.LENGTH_SHORT).show();
                return;
            }
            cmbApi.sendReq(request);
            cmbApi.handleIntent(getIntent(), this);
        } catch (UnsupportedEncodingException e) {
            Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        cmbApi.handleIntent(intent, this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        cmbApi.handleIntent(data, this);
    }

    /**
     * 回调
     *
     * @param cmbResponse
     */
    @Override
    public void onResp(CMBResponse cmbResponse) {
        //成功
        if (0 == cmbResponse.mRespCode) {

        } else {
            //失败
        }
        finish();
    }

}
