package com.java.designpatterns.command;

public class WriteFileCommand implements Command {

	private FileSystemReceiver fileSystemReceiver;

	public WriteFileCommand(FileSystemReceiver fileSystemReceiver) {
		this.fileSystemReceiver = fileSystemReceiver;
	}

	@Override
	public void execute() {
		this.fileSystemReceiver.writeFile();
	}

}