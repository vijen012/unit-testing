package com.unittesting.mockito;

public class A {
	
	private B b;
	
	public A(B b) {
		this.b = b;
	}

	public int usesVoidMethod() {
		try {
			b.voidMethod();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return 1;
	}

}
