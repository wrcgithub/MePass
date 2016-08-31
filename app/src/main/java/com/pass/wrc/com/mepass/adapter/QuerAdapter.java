package com.pass.wrc.com.mepass.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.pass.wrc.com.mepass.R;
import com.pass.wrc.com.mepass.model.WebModel;

import java.util.List;


/**
 * Created by wrc on 08/26 0026.
 */
public class QuerAdapter extends BaseAdapter {

    private LayoutInflater layoutInflater;
    private Context mContext;
    private List<WebModel> data;


    public QuerAdapter(Context context, List<WebModel> data) {

        this.data = data;
        this.mContext = context;
        layoutInflater = LayoutInflater.from(mContext);


    }


    @Override
    public int getCount() {

        return data.size();
    }


    public void setData(List<WebModel> list) {
        if (data != null){
            data  = null;
        }
        data = list;
        notifyDataSetChanged();

    }


    public void addData(List<WebModel> list) {

        data.addAll(list);
        notifyDataSetChanged();

    }


    @Override
    public WebModel getItem(int position) {

        return data.get(position);
    }


    @Override
    public long getItemId(int position) {

        return position;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder = null;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.quer_listview_item, null);
            viewHolder = new ViewHolder();

            viewHolder.netName = (TextView) convertView.findViewById(R.id.net_name);
            viewHolder.nickName = (TextView) convertView.findViewById(R.id.nick_name);
            viewHolder.emailName = (TextView) convertView.findViewById(R.id.email_name);
            viewHolder.passWord = (TextView) convertView.findViewById(R.id.pass_word);
            viewHolder.nickLinear = (LinearLayout) convertView.findViewById(R.id.nick_name_layout);
            viewHolder.emailLinear = (LinearLayout) convertView.findViewById(R.id.email_name_layout);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();

        }
        if (TextUtils.isEmpty(data.get(position).getNickName())){
            viewHolder.nickLinear.setVisibility(View.GONE);
        }
        if (TextUtils.isEmpty(data.get(position).getEmail())){
            viewHolder.emailLinear.setVisibility(View.GONE);
        }
        viewHolder.netName.setText(data.get(position).getWebName());
        viewHolder.nickName.setText(data.get(position).getNickName());
        viewHolder.emailName.setText(data.get(position).getEmail());
        viewHolder.passWord.setText(data.get(position).getSecretCode());


        return convertView;
    }


    private class ViewHolder {

        public TextView netName, nickName, emailName, passWord;
    public LinearLayout nickLinear,emailLinear;
    }
}
