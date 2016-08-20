package com.shupro.oa.mydemo.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * 判断网络连接状况
 * 
 * @author shuheng
 */
public class NetState {
	private	NetState(){}
	
	/**
	 * 通过ping IP 来判断网络状况
	 * @param ips
	 * @return
	 */
	public static boolean isConnectByIp(String ips) {
		boolean connect = false;
		Runtime runtime = Runtime.getRuntime();
		Process process;
		try {
			process = runtime.exec("ping " + ips);
			InputStream is = process.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			String line = null;
			StringBuffer sb = new StringBuffer();
			while ((line = br.readLine()) != null) {
				sb.append(line);
			}
//			System.out.println("返回值为:" + sb);
			is.close();
			isr.close();
			br.close();
			if (null != sb && !sb.toString().equals("")) {
				if (sb.toString().indexOf("TTL") > 0) {
					// 网络畅通 
					connect = true;
				} else {
					// 网络不畅通  
					connect = false;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return connect;
	}

	public static boolean isConnectByURL(String urlStr) {
		boolean connect = false;
		URL url = null;
		try {
			url = new URL(urlStr);
			try {
				InputStream in = url.openStream();
				in.close();
				System.out.println("网络连接正常！");
				connect = true;
			} catch (IOException e) {
				System.out.println("网络连接失败！");
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return connect;
	}
	
	public static void main(String[] args) {
//		NetState netState = new NetState();
//		System.out.println(NetState.isConnectByIp("192.168.1.136"));
		System.out.println(NetState.isConnectByURL("https://www.baidu.com"));
	}
}
