package org.practice.primary.socket;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * @description ClientPoint.java
 * @author chaoxiong
 * @date 2016年4月4日 上午9:29:18
 * 
 *       http://www.cnblogs.com/springcsc/archive/2009/12/03/1616413.html
 */
public class ClientPoint {

	/**
	 * @description 入口函数
	 * @param args
	 * @return void
	 * @author chaoxiong
	 * @date 2016年4月4日 上午10:35:24
	 */
	public static void main(String[] args) {
		clientTest();
	}

	/**
	 * @description 演示InetAddress类的基本使用
	 * 
	 * @return void
	 * @author chaoxiong
	 * @date 2016年4月4日 上午9:38:05
	 */
	public static void primaryTest() {
		try {
			InetAddress inetA = InetAddress.getByName("www.baidu.com");
			InetAddress inetB = InetAddress.getByName("127.0.0.1");
			InetAddress inetC = InetAddress.getLocalHost();

			String host = inetC.getHostName();
			String ip = inetC.getHostAddress();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @description TODO
	 * 
	 * @return void
	 * @author chaoxiong
	 * @date 2016年4月4日 上午10:35:58
	 */
	public static void clientTest() {
		String serverIP = "127.0.0.1";
		int serverPort = 10000;
		Socket client = null;
		InputStream is = null;
		OutputStream os = null;
		String message = "this is lianzhuang Dept";

		Scanner sc = new Scanner(System.in);

		try {
			System.out.println("【客户端】客户端已启动！");

			client = new Socket(serverIP, serverPort);
			os = client.getOutputStream();
			is = client.getInputStream();
			byte[] feedback = new byte[1024];
			for (int i = 0; i < 10; i++) {
				System.out.println("【客户端】请输入信息内容：");
				message = sc.nextLine();
				os.write(message.getBytes());//发送数据
				int len = is.read(feedback);//接收数据
				System.out.println("【客户端】服务器的反馈信息" + new String(feedback, 0, len));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				is.close();
				os.close();
				client.close();
				System.out.println("客户端已停止！");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
