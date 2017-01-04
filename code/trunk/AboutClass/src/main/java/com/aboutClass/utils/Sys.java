package com.aboutClass.utils;

import java.io.File;
import java.net.InetAddress;
import java.net.URISyntaxException;
import java.net.UnknownHostException;
/**
 * 系统信息获取
 *
 * @author gq
 */
public class Sys {
	/**
	 * 获取web-inf/class/下面的文件或者文件夹路径
	 * 
	 * @param subpath
	 *            子路径或者文件
	 * @return
	 */
	public static String GetClassPath(String subpath) {
		if (subpath == null) {
			subpath = "";
		}
		return GetClassRoot() + subpath;
	}

	/**
	 * 获取web-inf/class/目录的完整路径
	 * 
	 * @return
	 */
	@SuppressWarnings("deprecation")
	public static String GetClassRoot() {
		String temp;
		try {
			temp = Sys.class.getResource("/").toURI().getPath();
		} catch (URISyntaxException e) {
			e.printStackTrace();
			temp = java.net.URLDecoder.decode(Sys.class.getResource("/").getPath());
		}
		if (!temp.endsWith("/") && !temp.endsWith("\\")) {
			temp += File.separator;
		}
		return temp;
	}

	/**
	 * 获取web-inf/下面的文件或者文件夹路径
	 * 
	 * @param subpath
	 *            子路径或者文件
	 * @return
	 */
	public static String GetWebInfPath(String subpath) {
		if (subpath == null) {
			subpath = "";
		}
		return GetWebInfRoot() + subpath;
	}

	/**
	 * 获取web-inf/目录的完整路径
	 * 
	 * @return
	 */
	public static String GetWebInfRoot() {
		File f = new File(GetClassRoot());
		String temp = f.getParentFile().getAbsolutePath().trim();
		if (!temp.endsWith("/") && !temp.endsWith("\\")) {
			temp += File.separator;
		}
		return temp;
	}

	/**
	 * 获取web系统根目录下面的文件或者文件夹路径
	 * 
	 * @param subpath
	 *            子路径或者文件
	 * @return
	 */
	public static String GetWebPath(String subpath) {
		if (subpath == null) {
			subpath = "";
		}
		return GetWebRoot() + subpath;
	}

	/**
	 * 获取web系统根目录的完整路径
	 * 
	 * @return
	 */
	public static String GetWebRoot() {
		File f = new File(GetClassRoot());
		String temp = f.getParentFile().getParentFile().getAbsolutePath().trim();
		if (!temp.endsWith("/") && !temp.endsWith("\\")) {
			temp += File.separator;
		}
		return temp;
	}

	/**
	 * 是否为Window系统
	 * 
	 * @return
	 */
	public static boolean isWindowsOS() {
		boolean isWindowsOS = false;
		String osName = System.getProperty("os.name");
		if (osName.toLowerCase().indexOf("windows") > -1) {
			isWindowsOS = true;
		}
		return isWindowsOS;
	}

	
}
