package com.java.concepts;

import com.java.concepts.InnerClasses.InstanceInnerClass;
import com.java.concepts.InnerClasses.StaticInnerClass;

public class InnerClassMain {

	public static void main(String[] args) {

		InnerClasses innerClasses = new InnerClasses();
		InstanceInnerClass innerClass = innerClasses.new InstanceInnerClass();
		StaticInnerClass staticInnerClass = new StaticInnerClass();

		System.out.println("Inner Class---------");
		innerClasses.m1();

		System.out.println("Instance Inner Class--------------");
		System.out.println(innerClass.a);
		System.out.println(InnerClasses.InstanceInnerClass.s1);
		innerClass.m1();

		System.out.println("Static Inner Class-------------");
		System.out.println(staticInnerClass.a);
		System.out.println(InnerClasses.InstanceInnerClass.s1);
		staticInnerClass.m1();

	}

}