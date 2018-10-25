package com.java.memory.leak;

public class MemoryLeak {

	/*
	 * public static void main(String[] args) { TaskList taskList = new
	 * TaskList(); final TaskCreator taskCreator = new TaskCreator(taskList);
	 * new Thread(new Runnable() {
	 * 
	 * @Override public void run() { for (int i = 0; i < 100000; i++) {
	 * taskCreator.createTask(); } } }).start();
	 * 
	 * Waiter.class.getInterfaces(); }
	 * 
	 * }
	 * 
	 * class TaskList { private static Deque<Task> tasks = new
	 * ArrayDeque<Task>();
	 * 
	 * public void addTask(Task task) { tasks.add(task);
	 * tasks.peek().execute();// Memory leak! }
	 */
}