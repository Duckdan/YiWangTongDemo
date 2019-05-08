package com.example.android.yiwangtongdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import cmbapi.CMBApi;
import cmbapi.CMBApiFactory;
import cmbapi.CMBPayCallback;
/**
 * Created by 80251421 on 2018/7/19.
 */

public class PayActivity extends Activity implements View.OnClickListener {

    private EditText evPayUrl = null;
    private EditText evMethod = null;
    private EditText evAppid = null;
    private EditText tvShowlog = null;


    private Button btnCheckCMBApp = null;
    private Button btnGetApiVersion = null;
    private Button btnAutoJump = null;
    private Button btnOldSdk = null;

    private static String APPID = "12306";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay);
        initView();
    }


    protected void onResume(){
        super.onResume();

        LogManager.getInstance().clear();
    }

    private void initView()
    {
        evPayUrl = (EditText)findViewById(R.id.apayurl);
        evMethod = (EditText)findViewById(R.id.method_pay);
        evAppid = (EditText)findViewById(R.id.appid_pay);


        btnAutoJump = (Button)findViewById(R.id.paycall);
        btnAutoJump.setOnClickListener(this);

        btnCheckCMBApp = (Button)findViewById(R.id.checkappinstalled_pay);
        btnCheckCMBApp.setOnClickListener(this);

        btnGetApiVersion = (Button)findViewById(R.id.getapiversion_pay);
        btnGetApiVersion.setOnClickListener(this);

        btnOldSdk = (Button)findViewById(R.id.tranfer_old);
        btnOldSdk.setOnClickListener(this);
    }

    private void payCall(){
        String strAppid = evAppid.getText().toString();
        String strMethod = evMethod.getText().toString();
        String strPayUrl = evPayUrl.getText().toString();
        CMBApi.PaySdk.callPay(this, strAppid, strMethod, strPayUrl, new CMBPayCallback()
        {
           public void onSuccess(String aUrl){
               Toast.makeText(PayActivity.this,"调用成功.str:"+aUrl,Toast.LENGTH_SHORT).show();
           }

           public void onError(String aUrl){
               Toast.makeText(PayActivity.this,"调用失败.str:"+aUrl,Toast.LENGTH_SHORT).show();
           }
        });
    }

    private void getSDKVersion(){

        CMBApi cmbApi = CMBApiFactory.createCMBAPI(this, CMBApi.PaySdk.mAppId);
        String version = cmbApi.getApiVersion();
        Toast.makeText(PayActivity.this,"version:"+version,Toast.LENGTH_SHORT).show();
    }

    private void getAppId(){
        String appId = CMBApi.PaySdk.mAppId;
        if (TextUtils.isEmpty(appId)){
            appId = evAppid.getText().toString();
        }
        Toast.makeText(PayActivity.this,"appid:"+appId,Toast.LENGTH_SHORT).show();
    }

    private void tranferOldSdk(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    private void checkCMBAppInstalled(){
        CMBApi cmbApi = CMBApiFactory.createCMBAPI(this, CMBApi.PaySdk.mAppId);
        String strToast = cmbApi.isCMBAppInstalled()?"已安装招行app":"未安装招行app";
        Toast.makeText(PayActivity.this,strToast,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View target)
    {
        switch (target.getId())
        {
            case R.id.paycall:
                payCall();
                break;
            case R.id.getapiversion_pay:
                getSDKVersion();
                break;
            case R.id.checkappinstalled_pay:
                checkCMBAppInstalled();
                break;
            case R.id.tranfer_old:
                tranferOldSdk();
                break;
        }
    }
}
