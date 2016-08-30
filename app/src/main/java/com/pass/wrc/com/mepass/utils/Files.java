package com.pass.wrc.com.mepass.utils;

import android.content.Context;

import java.io.File;

public class Files {
//	public static String logfile = "";
	public static String errfile = "";
	public static String fileData = "";

	public static void createFile(Context context) {
		try {

//			logfile = "/storage/sdcard0/MePass/log/";
			errfile = "/storage/sdcard0/MePass/ErrLog/";
			fileData = "/storage/sdcard0/MePass/FileData/";

//			File files = new File(logfile);
			File errfiles = new File(errfile);
			File fileDatas = new File(fileData);
//			if (!files.exists()) {
//				files.mkdirs();
//			}
			if (!errfiles.exists()) {
				errfiles.mkdirs();
			}

			if (!fileDatas.exists()) {
				fileDatas.mkdirs();
			}
//			String cmd = "chmod 777 " + files.getAbsolutePath();
			String cmd2 = "chmod 777 " + errfiles.getAbsolutePath();

//			Runtime.getRuntime().exec(cmd);
			Runtime.getRuntime().exec(cmd2);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
