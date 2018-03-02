package org.practice.thread2.chap0402;

public class App {

	public static void main(String[] args) {

		Server server = new Server();
		for (int i = 0; i < 10; i++) {
			Task task = new Task("Task " + i);
			server.executeTaks(task);
		}

		server.endServer();
	}

}
