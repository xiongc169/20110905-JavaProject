package org.practice.activemq.Test;

import javax.jms.JMSException;

public class App {

	public static void main(String[] args) {

		Sender sender = new Sender();
		ReceiverSync receiver = new ReceiverSync();

		try {
			// sender.Send();
			receiver.run();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			String msg = e.getMessage();
			System.out.println(msg);
		}

	}

}
