package com.java.designpatterns.command;

public class FileSystemReceiverUtil {

	public static FileSystemReceiver getUnderlyingFileSystem(){
		 String osName = "Windows";
		 System.out.println("Underlying OS is:"+osName);
		 if(osName.contains("Windows")){
			 return new WindowsFileSystemReceiver();
		 }else{
			 return new UnixFileSystemReceiver();
		 }
	}
	
}