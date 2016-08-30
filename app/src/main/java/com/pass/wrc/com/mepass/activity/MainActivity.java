package com.pass.wrc.com.mepass.activity;

import android.os.Bundle;
import android.text.Selection;
import android.text.Spannable;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.pass.wrc.com.mepass.R;
import com.pass.wrc.com.mepass.base.BaseActivity;
import com.pass.wrc.com.mepass.base.BaseApplication;
import com.pass.wrc.com.mepass.commons.Common;
import com.pass.wrc.com.mepass.utils.SharePreTool;
import com.pass.wrc.com.mepass.utils.SwitchActivity;


public class MainActivity extends BaseActivity {

    private Button confirmBtn;
    private Button clearAccountBtn, clearPassBtn, eyePasssBtn;
    private TextView cancelText, forgetText;
    private EditText accountEdit, passEdit;
    private boolean isHidden = true;
    private long clickTime = 0; //记录第一次点击的时间


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initTitle("登录");
        initView();
        setHintTextSize(accountEdit, "请输入账号...", 14);
        setHintTextSize(passEdit, "请输入密码...", 14);
    }


    @Override
    protected void onResume() {

        super.onResume();
       accountEdit.setText(SharePreTool.getStringSP(this, Common.ACCOUNT_SAVE,""));
        if (!TextUtils.isEmpty(accountEdit.getText().toString())){
            passEdit.requestFocus();
        }
    }


    private void initView() {

        confirmBtn = (Button) findViewById(R.id.main_confirm);
        confirmBtn.setOnClickListener(this);

        cancelText = (TextView) findViewById(R.id.main_cancel);
        cancelText.setOnClickListener(this);
        forgetText = (TextView) findViewById(R.id.main_forget_pass);
        forgetText.setOnClickListener(this);

        clearAccountBtn = (Button) findViewById(R.id.bt_username_clear);
        clearPassBtn = (Button) findViewById(R.id.bt_pwd_clear);
        eyePasssBtn = (Button) findViewById(R.id.bt_pwd_eye);
        clearAccountBtn.setOnClickListener(this);
        clearPassBtn.setOnClickListener(this);
        eyePasssBtn.setOnClickListener(this);

        accountEdit = (EditText) findViewById(R.id.username);
        passEdit = (EditText) findViewById(R.id.password);

    }


    @Override
    protected void onClickView(int id) {

        super.onClickView(id);
        switch (id) {
            case R.id.main_confirm:
                enterLogin(accountEdit.getText().toString().trim() + "", passEdit.getText().toString().trim() + "");
                break;
            case R.id.main_cancel:
                accountEdit.setText("");
                passEdit.setText("");
                break;
            case R.id.main_forget_pass:
                showLongToast("哈╰(￣▽￣)╮ 你是二货吗，密码都忘");
                break;
            case R.id.bt_username_clear:
                accountEdit.setText("");
                break;
            case R.id.bt_pwd_clear:
                passEdit.setText("");
                break;
            case R.id.bt_pwd_eye:
                if (isHidden) {
                    //设置EditText文本为可见的
                    passEdit.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                } else {
                    //设置EditText文本为隐藏的
                    passEdit.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
                isHidden = !isHidden;
                passEdit.postInvalidate();
                //切换后将EditText光标置于末尾
                CharSequence charSequence = passEdit.getText();
                if (charSequence instanceof Spannable) {
                    Spannable spanText = (Spannable) charSequence;
                    Selection.setSelection(spanText, charSequence.length());
                }
                break;

        }
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK) {
            exit();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }


    private void exit() {

        if ((System.currentTimeMillis() - clickTime) > 2 * 1000) {
            showShortToast("再按一次退出程序");
            clickTime = System.currentTimeMillis();
        } else {
            this.finish();
            BaseApplication.getInstance().exit();
        }
    }


    private void enterLogin(String user, String pass) {

        if (user.equals("00") && !pass.equals("123456")) {
            showLongToast("请输入正确的密码！");
        } else if (user.equals("00") && pass.equals("123456")) {
            SharePreTool.setStringSP(MainActivity.this,Common.ACCOUNT_SAVE,user);
            SwitchActivity.toAty(MainActivity.this, QuerStableActivity.class);
            MainActivity.this.finish();
            //          showMessage("抱歉，出现异常，系统即将奔溃，请做好备份！");
        } else {
            showLongToast("请输入正确的账号和密码！");
        }

    }
}
