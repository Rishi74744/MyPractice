package com.java.designpatterns.command;

public class FileSystemClient {

	public static void main(String[] args) {
		FileSystemReceiver fileSystemReceiver = FileSystemReceiverUtil.getUnderlyingFileSystem();

		OpenFileCommand openFileCommand = new OpenFileCommand(fileSystemReceiver);
		FileInvoker file = new FileInvoker(openFileCommand);
		file.execute();

		WriteFileCommand writeFileCommand = new WriteFileCommand(fileSystemReceiver);
		file = new FileInvoker(writeFileCommand);
		file.execute();

		CloseFileCommand closeFileCommand = new CloseFileCommand(fileSystemReceiver);
		file = new FileInvoker(closeFileCommand);
		file.execute();
	}

}
