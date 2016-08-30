package com.pass.wrc.com.mepass.utils;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.pass.wrc.com.mepass.R;
import com.pass.wrc.com.mepass.base.BaseActivity;


/**
 * Created by wrc on 2016 08/25.
 */
public class TitleBar {
    
    
    /**
     * title栏根布局
     */
    private View titleView;
    private TextView left_textview;
    private ImageView left_imageview;
    private TextView middle_textview;
    private TextView right_textview;
    private ImageView right_imageview;
//    private  BaseActivity context;
    /**
     * 第一种  初始化方式
     * 这里是直接引用进文件的初始化方式
     * @param context
     */
    public TitleBar(BaseActivity context) {
//        this.context = context;
        titleView = context.findViewById(R.id.title_bar);
        
        left_textview = (TextView) titleView.findViewById(R.id.title_left_textview);
        left_imageview = (ImageView) titleView.findViewById(R.id.title_left_imageview);
        
        middle_textview = (TextView) titleView.findViewById(R.id.title_middle_textview);
        
        right_textview = (TextView) titleView.findViewById(R.id.title_right_textview);
        right_imageview = (ImageView) titleView.findViewById(R.id.title_right_imageview);
        
    }
    
    /**
     * 第二种初始化方式
     * 这里是比如你用代码创建布局的时候使用
     * @param context
     */
    public TitleBar(View context) {
        
        titleView = context.findViewById(R.id.title_bar);
        
        left_textview = (TextView) titleView.findViewById(R.id.title_left_textview);
        left_imageview = (ImageView) titleView.findViewById(R.id.title_left_imageview);
        
        middle_textview = (TextView) titleView.findViewById(R.id.title_middle_textview);
        
        right_textview = (TextView) titleView.findViewById(R.id.title_right_textview);
        right_imageview = (ImageView) titleView.findViewById(R.id.title_right_imageview);
        
    }
    
    /**
     * title 的背景色
     */
    
    public TitleBar setMiddleTitleBgRes(int resid) {
        
        middle_textview.setBackgroundResource(resid);
        
        return this;
    }
    /**
     * title的文本
     *
     * @param text
     * @return
     */
    public TitleBar setMiddleTitleText(String text) {
        
        middle_textview.setVisibility(TextUtils.isEmpty(text) ? View.GONE
                : View.VISIBLE);
        middle_textview.setText(text);
        
        return this;
    }
    
    /**
     * left
     */
    /**
     * 图片按钮
     *
     * @param resId
     * @return
     */
    public TitleBar setLeftImageRes(int resId) {
        
        left_imageview.setVisibility(resId > 0 ? View.VISIBLE : View.GONE);
        left_imageview.setImageResource(resId);
        
        return this;
    }
    
    /**
     * 左边文字按钮
     *
     * @param text
     * @return
     */
    public TitleBar setLeftText(String text) {
        
        left_textview.setVisibility(TextUtils.isEmpty(text) ? View.GONE:View.VISIBLE);
        left_textview.setText(text);
        
        return this;
    }
    
    /**
     * 设置左边的事件
     */
    public TitleBar setLeftTextOrImageListener(View.OnClickListener listener) {
        
        if (left_imageview.getVisibility() == View.VISIBLE) {
            
            left_imageview.setOnClickListener(listener);
            
        } else if (left_textview.getVisibility() == View.VISIBLE) {
            
            left_textview.setOnClickListener(listener);
            
        }
        
        return this;
    }
    
    /**
     * right
     */
    /**
     * 右边图片按钮
     *
     * @param resId
     * @return
     */
    public TitleBar setRightImageRes(int resId) {
        
        right_imageview.setVisibility(resId > 0 ? View.VISIBLE : View.GONE);
        right_imageview.setImageResource(resId);
        
        return this;
    }
    
    /**
     * 右边文字按钮
     *
     * @param text
     * @return
     */
    public TitleBar setRightText(String text) {
        
        right_textview.setVisibility(TextUtils.isEmpty(text) ? View.GONE:View.VISIBLE);
        right_textview.setText(text);
        
        return this;
    }
    
    /**
     * 设置右边的事件
     */
    public TitleBar setRightTextOrImageListener(View.OnClickListener listener) {
        
        if (right_imageview.getVisibility() == View.VISIBLE) {
            
            right_imageview.setOnClickListener(listener);
            
        } else if (right_textview.getVisibility() == View.VISIBLE) {
            
            right_textview.setOnClickListener(listener);
            
        }
        
        return this;
    }
    
    public View build(){
        
        return titleView;
    }
    
}
