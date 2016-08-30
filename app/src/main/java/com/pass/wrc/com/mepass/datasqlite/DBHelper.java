package com.pass.wrc.com.mepass.datasqlite;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.pass.wrc.com.mepass.utils.Files;

import java.io.File;


public class DBHelper extends SQLiteOpenHelper {
	private final static String DBName = "MEPASS.db";
	private static DBHelper dbTool = null;
	private static final int dbVersion = 1;
	private DBHelper(Context context) {
		super(context, new File(Files.fileData, DBName).getAbsolutePath(), null, dbVersion);
	}

	public static DBHelper getInstance(Context context) {
		if (dbTool == null) {
			dbTool = new DBHelper(context);
		}
		return dbTool;
	}

	public void onCreate(SQLiteDatabase db) {
		createTable(db);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//		if (newVersion == 2) {
//			db.execSQL("表名");// 
//		}
	}

	
	final String CREATE_WEBSITE = "create table website("
			+ "IndexID INTEGER PRIMARY KEY AUTOINCREMENT,"
			+ "webName varchar(24)," 
			+ "nickName varchar(24)," 
			+ "account varchar(24)," 
			+ "secretCode varchar(24)," 
			+ "email varchar(24)," 
			+ "createTime varchar(24))";

	private boolean createTable(SQLiteDatabase db) {

		db.execSQL(CREATE_WEBSITE);
		
		return true;
	}

}
