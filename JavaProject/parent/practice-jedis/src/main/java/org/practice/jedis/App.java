package org.practice.jedis;

import org.practice.jedis.utility01.RedisClient;

public class App {

	public static void main(String[] args) {

		RedisClient rClient = new RedisClient();
		rClient.testString();

		// RedisPoolClient client = new RedisPoolClient();
		// client.KeyOperate();

	}

}
