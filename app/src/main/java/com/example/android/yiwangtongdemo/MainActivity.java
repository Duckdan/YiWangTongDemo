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
import cmbapi.CMBEventHandler;
import cmbapi.CMBRequest;
import cmbapi.CMBResponse;


public class MainActivity extends Activity implements View.OnClickListener, CMBEventHandler {

    private static final String TAG = "MainActivity";
    private static final String APPID = "12306";
    private static final int MAX_LOG_LENGTH = 4;
    CMBApi cmbApi = null;

    //4个输入框
    private EditText evRequestData = null;
    private EditText evCmbJumpUrl = null;
    private EditText evH5JumpUrl = null;
    private EditText evMethod = null;

    //6个按钮
    private Button btnJumptoCMBApp = null;
    private Button btnJumptoH5 = null;
    private Button btnAutoJump = null;
    private Button btnCheckCMBApp = null;
    private Button btnGetApiVersion = null;

    //EditText
    private EditText tvShowlog = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        cmbApi = CMBApiFactory.createCMBAPI(this,APPID);
        cmbApi.handleIntent(getIntent(),this);
        LogManager.getInstance().clear();
    }

    @Override
    protected void onNewIntent(Intent intent){
        super.onNewIntent(intent);
        setIntent(intent);
        cmbApi.handleIntent(intent,this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        cmbApi.handleIntent(data, this);

    }

    private void initView()
    {
        evCmbJumpUrl = (EditText)findViewById(R.id.cmbjumpurl);
        evH5JumpUrl = (EditText)findViewById(R.id.h5url);
        evMethod = (EditText)findViewById(R.id.method);
        evRequestData = (EditText)findViewById(R.id.requestdata);


        btnAutoJump = (Button)findViewById(R.id.autojump);
        btnAutoJump.setOnClickListener(this);
        btnJumptoCMBApp = (Button)findViewById(R.id.jumpcmb);
        btnJumptoCMBApp.setOnClickListener(this);
        btnJumptoH5 = (Button)findViewById(R.id.jumph5);
        btnJumptoH5.setOnClickListener(this);

        btnCheckCMBApp = (Button)findViewById(R.id.checkappinstalled);
        btnCheckCMBApp.setOnClickListener(this);

        btnGetApiVersion = (Button)findViewById(R.id.getapiversion);
        btnGetApiVersion.setOnClickListener(this);

        tvShowlog = (EditText) findViewById(R.id.showlog);
    }

    private void showLog(){
        if (LogManager.getInstance().isEmpty())return;

        if (LogManager.getInstance().getSize() >= MAX_LOG_LENGTH){
            LogManager.getInstance().removeLast();
        }

        StringBuffer strLog = new StringBuffer();
        for (int i = 0; i < LogManager.getInstance().getSize(); i++){
            strLog.append(LogManager.getInstance().getIndex(i)).append("\n");
        }

        tvShowlog.setText(strLog);
    }

    @Override
    public void onResp(CMBResponse response){
        if (response.mRespCode == 0){
            Toast.makeText(this,"调用成功.str:"+response.mRespMsg,Toast.LENGTH_SHORT).show();
        }
        else {

            Toast.makeText(this,"调用失败",Toast.LENGTH_SHORT).show();
        }

        String resMsg = String.format("onResp：respcode:%s.respmsg:%s",response.mRespCode,response.mRespMsg);
        LogManager.getInstance().addFirst(resMsg);
        showLog();
    }

    private CMBRequest getCMBRequestByInput(){
        String curReqData = evRequestData.getText().toString();
        String curCmbUrl = evCmbJumpUrl.getText().toString();
        String curH5Url = evH5JumpUrl.getText().toString();
        String curMethod = evMethod.getText().toString();

        CMBRequest request = new CMBRequest();
        request.mRequestData = curReqData;
        request.mCMBJumpUrl = curCmbUrl;
        request.mH5Url = curH5Url;
        request.mMethod = curMethod;
        return request;
    }

    private void jumpToCMBApp()
    {
        CMBRequest request = getCMBRequestByInput();
        if (TextUtils.isEmpty(request.mCMBJumpUrl)){
            Toast.makeText(this,"调用失败,cmbJumpUrl不能为空",Toast.LENGTH_SHORT).show();
            return;
        }
        request.mH5Url = "";

        //mCMBJumpUrl需要以http://或者https://开头，参数错误会抛异常:IllegalArgumentException
        try
        {
            cmbApi.sendReq(request);}
        catch (IllegalArgumentException e)
        {
            Toast.makeText(this,e.toString(),Toast.LENGTH_SHORT).show();
        }
    }

    private void jumpToH5web()
    {
        CMBRequest request = getCMBRequestByInput();
        if (TextUtils.isEmpty(request.mH5Url)){
            Toast.makeText(this,"调用失败,h5Url不能为空",Toast.LENGTH_SHORT).show();
            return;
        }
        request.mCMBJumpUrl = "";

        //mH5Url需要以http://或者https://开头，参数错误会抛异常:IllegalArgumentException
        try
        {
            cmbApi.sendReq(request);}
        catch (IllegalArgumentException e){
            Toast.makeText(this,e.toString(),Toast.LENGTH_SHORT).show();
        }
    }

    private void autoJump()
    {
        CMBRequest request = getCMBRequestByInput();
        if (TextUtils.isEmpty(request.mH5Url)
                && TextUtils.isEmpty(request.mCMBJumpUrl)){
            Toast.makeText(this,"调用失败,cmbJumpUrl,h5Url不能同时为空",Toast.LENGTH_SHORT).show();
            return;
        }
        try {
            cmbApi.sendReq(request);
        }
        catch (IllegalArgumentException e){
            Toast.makeText(this,e.toString(),Toast.LENGTH_SHORT).show();
        }
    }

    private void checkCMBApp(){

        boolean bOk = cmbApi.isCMBAppInstalled();
        if (bOk){
            Toast.makeText(this,"招行App已经安装",Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this,"还没有安装招行App",Toast.LENGTH_SHORT).show();
        }

        StringBuffer stringBuffer = new StringBuffer();
        String strformat = bOk?"招行App已经安装":"还没有安装招行App";
        stringBuffer.append("isCMBAppInstalled:").append(strformat).append("\n");

        LogManager.getInstance().addFirst(stringBuffer.toString());
        showLog();
    }

    private void getApiVersion(){
        Toast.makeText(this, cmbApi.getApiVersion(), Toast.LENGTH_SHORT).show();

        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("getApiVersion:").append(cmbApi.getApiVersion()).append("\n");
        LogManager.getInstance().addFirst(stringBuffer.toString());
        showLog();
    }

    @Override
    public void onClick(View target)
    {
        switch (target.getId())
        {
            case R.id.autojump:
                autoJump();
                break;
            case R.id.jumpcmb:
                jumpToCMBApp();
                break;
            case R.id.jumph5:
                jumpToH5web();
                break;
            case R.id.checkappinstalled:
                checkCMBApp();
                break;
            case R.id.getapiversion:
                getApiVersion();
                break;
        }
    }

}
