package com.pass.wrc.com.mepass.activity;

import android.os.Bundle;
import android.widget.RelativeLayout;

import com.pass.wrc.com.mepass.R;
import com.pass.wrc.com.mepass.base.BaseActivity;
import com.pass.wrc.com.mepass.view.SlidingMenu;


/**
 * Created by Administrator on 0001 09/01.
 */
public class MainMenuActivity extends BaseActivity {

    private SlidingMenu mMenu;
    private RelativeLayout killApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        initTitle("主界面");
        mMenu = (SlidingMenu) findViewById(R.id.id_menu);

        initView();
    }

    private void initView(){
    killApp = (RelativeLayout) findViewById(R.id.kill_app);
    killApp.setOnClickListener(this);


    }


    @Override
    protected void onClickView(int id) {

        super.onClickView(id);
        switch (id){
            case R.id.kill_app:
                showMessage("暂无此功能");
                break;



        }
    }
}
