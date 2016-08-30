package com.pass.wrc.com.mepass.utils;

import android.content.Intent;
import android.os.Bundle;

import com.pass.wrc.com.mepass.base.BaseActivity;
import com.pass.wrc.com.mepass.commons.Common;
import com.pass.wrc.com.mepass.model.WebModel;

import java.io.Serializable;


/**
 * Created by Administrator on 0026 08/26.
 */
public class SwitchActivity {

    public static void toAty(BaseActivity context, Class<?> activity) {

        Intent intent = new Intent(context, activity);
        context.startActivity(intent);
    }


    public static void toAty(BaseActivity context, Class<?> activity, WebModel webModel) {

        Intent intent = new Intent(context, activity);
        Bundle bundle = new Bundle();
        bundle.putSerializable(Common.WEB_MODEL, (Serializable) webModel);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }


    public static void toAty(BaseActivity context, Class<?> activity, WebModel webModel, String p1, String p2) {

        Intent intent = new Intent(context, activity);
        Bundle bundle = new Bundle();
        bundle.putSerializable(Common.WEB_MODEL, (Serializable) webModel);
        bundle.putString(Common.P1, p1);
        bundle.putString(Common.P2, p2);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }


    public static void toAty(BaseActivity context, Class<?> activity, String p1) {

        Intent intent = new Intent(context, activity);
        Bundle bundle = new Bundle();
        bundle.putString(Common.P1, p1);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }


    public static void toAty(BaseActivity context, Class<?> activity, String p1, String p2) {

        Intent intent = new Intent(context, activity);
        Bundle bundle = new Bundle();
        bundle.putString(Common.P1, p1);
        bundle.putString(Common.P2, p2);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }


    public static void toAty(BaseActivity context, Class<?> activity, String p1, String p2, String p3) {

        Intent intent = new Intent(context, activity);
        Bundle bundle = new Bundle();
        bundle.putString(Common.P1, p1);
        bundle.putString(Common.P2, p2);
        bundle.putString(Common.P3, p3);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }


    public static void toAty(BaseActivity context, Class<?> activity, String p1, String p2, String p3, String p4) {

        Intent intent = new Intent(context, activity);
        Bundle bundle = new Bundle();
        bundle.putString(Common.P1, p1);
        bundle.putString(Common.P2, p2);
        bundle.putString(Common.P3, p3);
        bundle.putString(Common.P4, p4);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }
}
