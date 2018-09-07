package com.java.memory.leak;

import java.util.ArrayDeque;
import java.util.Deque;

import com.java.multithreading.Waiter;
import com.sun.javafx.tk.Toolkit.Task;

public class MemoryLeak {

	/*public static void main(String[] args) {
		TaskList taskList = new TaskList();
		final TaskCreator taskCreator = new TaskCreator(taskList);
		new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 100000; i++) {
					taskCreator.createTask();
				}
			}
		}).start();
		
		
		Waiter.class.getInterfaces();
	}

}

class TaskList {
	private static Deque<Task> tasks = new ArrayDeque<Task>();

	public void addTask(Task task) {
		tasks.add(task);
		tasks.peek().execute();// Memory leak!
	}*/
}