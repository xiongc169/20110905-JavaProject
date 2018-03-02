package org.practice.thread2.chap0604;

public class Event implements Comparable<Event> {

	private int thread;

	private int priority;

	public Event(int thread, int priority) {
		this.thread = thread;
		this.priority = priority;
	}

	public int getThread() {
		return thread;
	}

	public int getPriority() {
		return priority;
	}

	public int compareTo(Event o) {

		if (this.priority > o.getPriority()) {
			return -1;
		} else if (this.priority < o.getPriority()) {
			return 1;
		} else {
			return 0;
		}
	}

}
