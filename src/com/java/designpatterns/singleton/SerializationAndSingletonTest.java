package com.java.designpatterns.singleton;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

public class SerializationAndSingletonTest {

	 public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
	        SerializationAndSingleton instanceOne = SerializationAndSingleton.getInstance();
	        ObjectOutput out = new ObjectOutputStream(new FileOutputStream(
	                "filename.ser"));
	        out.writeObject(instanceOne);
	        out.close();
	        
	        //deserailize from file to object
	        ObjectInput in = new ObjectInputStream(new FileInputStream(
	                "filename.ser"));
	        SerializationAndSingleton instanceTwo = (SerializationAndSingleton) in.readObject();
	        in.close();
	        
	        System.out.println("instanceOne hashCode="+instanceOne.hashCode());
	        System.out.println("instanceTwo hashCode="+instanceTwo.hashCode());
	        
	    }
	
}
