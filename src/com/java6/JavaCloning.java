package com.java6;

public class JavaCloning implements Cloneable {

	private int id;
	private Clone1 clone1;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Clone1 getClone1() {
		return clone1;
	}

	public void setClone1(Clone1 clone1) {
		this.clone1 = clone1;
	}

	public static void main(String[] args) throws CloneNotSupportedException {
		JavaCloning javaCloning1 = new JavaCloning();
		Clone1 clone1 = new Clone1();
		clone1.setClone("Clone1");
		javaCloning1.setClone1(clone1);
		JavaCloning javaCloning2 = (JavaCloning) javaCloning1.clone();
		System.out.println(javaCloning1.clone().equals(javaCloning1));

		javaCloning1.setId(1);
		javaCloning2.setId(3);

		clone1.setClone("Clone2");

		System.out.println(javaCloning1.equals(javaCloning2));
		System.out.println(javaCloning1.hashCode() + "  " + javaCloning1);
		System.out.println(javaCloning2.hashCode() + "  " + javaCloning2);
		System.out.println(javaCloning1.hashCode() == javaCloning2.hashCode());
		System.out.println(javaCloning1 == javaCloning2);
		System.out.println(javaCloning1.getId() == javaCloning2.getId());
		System.out.println(javaCloning1.getId());
		System.out.println(javaCloning2.getId());
		System.out.println(javaCloning1.getClone1().getClone());
		System.out.println(javaCloning2.getClone1().getClone());
	}

}

class Clone1 {
	private String clone;

	public String getClone() {
		return clone;
	}

	public void setClone(String clone) {
		this.clone = clone;
	}

}
