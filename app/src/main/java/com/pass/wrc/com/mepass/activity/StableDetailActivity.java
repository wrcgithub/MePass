package com.pass.wrc.com.mepass.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.pass.wrc.com.mepass.R;
import com.pass.wrc.com.mepass.base.BaseActivity;
import com.pass.wrc.com.mepass.commons.Common;
import com.pass.wrc.com.mepass.model.WebModel;


/**
 * Created by Administrator on 0030 08/30.
 */
public class StableDetailActivity extends BaseActivity {

    private String type = "";
    private TextView netNameText, netSiteText, accountText, nickNameText, emailText, secretCodeText, secretSecurityText, creatTimeText;
    private LinearLayout  netSiteLayoutText, accountLayoutText, nickNameLayoutText, emailLayoutText, secretCodeLayoutText, secretSecurityLayoutText, creatTimeLayoutText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stable_detail);
        initTitle("PASS详情");
        type = getIntent().getStringExtra(Common.P1);
        webModel = (WebModel) getIntent().getSerializableExtra(Common.WEB_MODEL);
        if (type.equals(Common.STABLE)) {

        } else if (type.equals(Common.SNAP)) {

        }

        initView();
        isGson();

    }


    private void initView() {

        netNameText = (TextView) findViewById(R.id.net_name_detail);
        netSiteText = (TextView) findViewById(R.id.net_site_detail);
        accountText = (TextView) findViewById(R.id.account_detail);
        nickNameText = (TextView) findViewById(R.id.nick_name_detail);
        emailText = (TextView) findViewById(R.id.email_name_detail);
        secretCodeText = (TextView) findViewById(R.id.pass_word_detail);
        secretSecurityText = (TextView) findViewById(R.id.pass_security_detail);
        creatTimeText = (TextView) findViewById(R.id.creat_time_detail);

        netSiteLayoutText = (LinearLayout) findViewById(R.id.layout_net_site_detail);
        accountLayoutText = (LinearLayout) findViewById(R.id.layout_account_detail);
        nickNameLayoutText = (LinearLayout) findViewById(R.id.layout_nick_name_detail);
        emailLayoutText = (LinearLayout) findViewById(R.id.layout_email_name_detail);
        secretCodeLayoutText = (LinearLayout) findViewById(R.id.layout_pass_word_detail);
        secretSecurityLayoutText = (LinearLayout) findViewById(R.id.layout_pass_security_detail);
        creatTimeLayoutText = (LinearLayout) findViewById(R.id.layout_creat_time_detail);
    }
    private void isGson(){
        if (type.equals(Common.SNAP)) {
        creatTimeLayoutText.setVisibility(View.VISIBLE);
            creatTimeText.setText(webModel.getCreateTime());
        }
        netNameText.setText(webModel.getWebName());
        if (!TextUtils.isEmpty(webModel.getWebSite())){
            netSiteLayoutText.setVisibility(View.VISIBLE);
            netSiteText.setText(webModel.getWebSite());
        }
        if (!TextUtils.isEmpty(webModel.getAccount())){
            accountLayoutText.setVisibility(View.VISIBLE);
            accountText.setText(webModel.getAccount());
        }
        if (!TextUtils.isEmpty(webModel.getNickName())){
            nickNameLayoutText.setVisibility(View.VISIBLE);
            nickNameText.setText(webModel.getNickName());
        }
        if (!TextUtils.isEmpty(webModel.getEmail())){
            emailLayoutText.setVisibility(View.VISIBLE);
            emailText.setText(webModel.getEmail());
        }
        if (!TextUtils.isEmpty(webModel.getSecretCode())){
            secretCodeLayoutText.setVisibility(View.VISIBLE);
            secretCodeText.setText(webModel.getSecretCode());
        }
        if (!TextUtils.isEmpty(webModel.getSecretSecurity())){
            secretSecurityLayoutText.setVisibility(View.VISIBLE);
            secretSecurityText.setText(webModel.getSecretSecurity());
        }

    }

}
