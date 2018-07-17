package com.java.designpatterns.command;

public class CloseFileCommand implements Command {

	private FileSystemReceiver fileSystemReceiver;

	public CloseFileCommand(FileSystemReceiver fileSystemReceiver) {
		this.fileSystemReceiver = fileSystemReceiver;
	}

	@Override
	public void execute() {
		this.fileSystemReceiver.closeFile();
	}

}