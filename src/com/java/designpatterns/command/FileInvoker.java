package com.java.designpatterns.command;

public class FileInvoker {

	public Command command;

	public FileInvoker(Command command) {
		this.command = command;
	}

	public void execute() {
		this.command.execute();
	}

}
