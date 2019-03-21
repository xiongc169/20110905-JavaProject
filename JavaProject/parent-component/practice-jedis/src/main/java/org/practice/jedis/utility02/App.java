package org.practice.jedis.utility02;

public class App {

	public static void main(String[] args) {

		try {
			RedisPoolClient client = new RedisPoolClient();
			client.KeyOperate();
		} catch (Exception e) {
			String msg = e.getMessage();
			System.out.println(msg);
		}

	}

}
