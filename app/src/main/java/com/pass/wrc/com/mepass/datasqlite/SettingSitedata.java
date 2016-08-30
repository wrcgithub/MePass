package com.pass.wrc.com.mepass.datasqlite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;

import com.pass.wrc.com.mepass.model.WebModel;

import java.util.ArrayList;
import java.util.List;


public class SettingSitedata {
	private DBHelper dbHelper;
	private static SettingSitedata sitedata;

	public static SettingSitedata getSingleton(Context context) {

		if (sitedata == null)
			sitedata = new SettingSitedata(context);
		return sitedata;
	}

	private SettingSitedata(Context context) {
		dbHelper = DBHelper.getInstance(context);
	}
	/**
	 * 增加对象
	 */
	public boolean insert(WebModel webModel) {
		SQLiteDatabase db = null;
		try {
			db = dbHelper.getWritableDatabase();
			db.execSQL(
					"insert into website(webName ,nickName ,account ,"
							+ "secretCode ,email,createTime)"
							+ " values(?,?,?,?,?,?)",
					new Object[] { webModel.getWebName(),
							webModel.getNickName(),
							webModel.getAccount(),
							webModel.getSecretCode(),
							webModel.getCreateTime(),
							webModel.getEmail() });
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			if (db != null)
				db.close();
		}
	}
	/**
	 * 数据查询
	 */
	public synchronized  List<WebModel> select(String string) {
		SQLiteDatabase db = null;
		Cursor crCursor = null;
		List<WebModel> list = null;
		try {
			String sql = "select * from website  ";
			if (!TextUtils.isEmpty(string)) {
				sql += string;
			}
			list = new ArrayList<WebModel>();
			db = dbHelper.getReadableDatabase();
			crCursor = db.rawQuery(sql, null);
			while (crCursor.moveToNext()) {
				WebModel webModel = new WebModel();
				webModel.setIndexID(crCursor.getString(crCursor.getColumnIndex("IndexID")));
				webModel.setWebName(crCursor.getString(crCursor.getColumnIndex("webName")));
				webModel.setNickName(crCursor.getString(crCursor.getColumnIndex("nickName")));
				webModel.setAccount(crCursor.getString(crCursor.getColumnIndex("account")));
				webModel.setSecretCode(crCursor.getString(crCursor.getColumnIndex("secretCode")));
				webModel.setEmail(crCursor.getString(crCursor.getColumnIndex("email")));
				webModel.setCreateTime(crCursor.getString(crCursor.getColumnIndex("createTime")));
				list.add(webModel);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if (crCursor != null)
				crCursor.close();
			if (db != null)
				db.close();
		}
	}


	/**
	 * 删除
	 * @param indexId
	 * @return
	 */
	public boolean delete(String indexId) {
		String sql = "delete from website "+"where IndexId="+"'"+indexId+"'";
		SQLiteDatabase db = null;
		try {
			db = dbHelper.getReadableDatabase();
			db.execSQL(sql);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			if (db != null)
				db.close();
		}
	}

}
