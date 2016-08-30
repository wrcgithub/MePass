package com.pass.wrc.com.mepass.activity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.pass.wrc.com.mepass.R;
import com.pass.wrc.com.mepass.adapter.QuerAdapter;
import com.pass.wrc.com.mepass.base.BaseActivity;
import com.pass.wrc.com.mepass.base.BaseApplication;
import com.pass.wrc.com.mepass.commons.CommonModels;
import com.pass.wrc.com.mepass.model.WebModel;
import com.pass.wrc.com.mepass.utils.SearchLocal;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Administrator on 0026 08/26.
 */
public class QuerSnapActivity extends BaseActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {

    private long clickTime = 0; //记录第一次点击的时间
    private ListView listView;
    private Button searchBtn;
    private EditText editText;
    private QuerAdapter adapter;
    private  List<WebModel>  data = CommonModels.getStaticModels();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quer);
        initTitle("PASS查询");
        initView();
        setHintTextSize(editText, "输入站点名称并搜索...", 14);
    }


    private void initView() {

        editText = (EditText) findViewById(R.id.station_edit_import);
        editText.addTextChangedListener(textWatcher);

        searchBtn = (Button) findViewById(R.id.station_search_import);
        searchBtn.setOnClickListener(this);


        listView = (ListView) findViewById(R.id.import_listview);
        listView.setOnItemClickListener(this);
        listView.setOnItemLongClickListener(this);
        adapter = new QuerAdapter(this, data);
        listView.setAdapter(adapter);

    }


    private List<WebModel> getData2() {
        List<WebModel> list = new ArrayList<WebModel>();
        WebModel webModel1 = new WebModel();
        webModel1.setAccount("896723974");
        webModel1.setEmail("123688459@qq.com");
        webModel1.setNickName("影子legion");
        webModel1.setSecretCode("********");
        webModel1.setSecretSecurity("小学名_时代学校");
        webModel1.setWebSite("https://www.baidu.com");
        webModel1.setWebName("加入知乎");
        list.add(webModel1);
        WebModel webModel2 = new WebModel();
        webModel2.setAccount("896723974");
        webModel2.setEmail("123688459@qq.com");
        webModel2.setNickName("影子legion");
        webModel2.setSecretCode("********");
        webModel2.setSecretSecurity("小学名_时代学校");
        webModel2.setWebSite("https://www.baidu.com");
        webModel2.setWebName("成功的秘诀");
        list.add(webModel2);
        for (int i = 0; i < 10; i++){
            WebModel webModel = new WebModel();
            webModel.setAccount("896723974");
            webModel.setEmail("123688459@qq.com");
            webModel.setNickName("影子legion");
            webModel.setSecretCode("********");
            webModel.setSecretSecurity("小学名_时代学校");
            webModel.setWebSite("https://www.baidu.com");
            webModel.setWebName("我的网址");
            list.add(webModel);

        }

        return list;
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }


    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

        return false;
    }


    @Override
    protected void onClickView(int id) {

        super.onClickView(id);
        switch (id) {
            case R.id.station_search_import:
                toSearch(editText.getText().toString().trim() + "");
                break;

        }
    }


    private void toSearch(String searchStr) {
        showShortToast("暂不支持");
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

    /**
     * 搜索框监听
     */
    TextWatcher textWatcher = new TextWatcher() {

        @Override
        public void onTextChanged(CharSequence s, int arg1, int arg2, int arg3) {
            // TODO Auto-generated method stub
            if (s != null && s.length() > 0) {
List<WebModel> list = SearchLocal.searchWebModel(s,data);
                if (list != null && list.size() > 0) {
adapter.setData(list);
                } else {
                    showShortToast("搜索为空!");
                }
            } else {
                adapter.setData(data);
            }
        }

        @Override
        public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
                                      int arg3) {
        }

        @Override
        public void afterTextChanged(Editable arg0) {
        }
    };
}
