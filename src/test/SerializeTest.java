package test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializeTest {
	public static void main(String[] args) throws Exception {
		A obj = new B();

		ByteArrayOutputStream bytes = new ByteArrayOutputStream();
		ObjectOutputStream out = new ObjectOutputStream(bytes);
		out.writeObject(obj);
		out.close();

		String str = new String(bytes.toByteArray());

		ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(str.getBytes()));
		A obj2 = (A) in.readObject();
		obj2.print();	// should print "B"
	}
}

class A implements Serializable {
	private static final long serialVersionUID = -1838044422602108685L;
	int a;

	public void print() {
		System.out.println("A");
	}
}

class B extends A {
	private static final long serialVersionUID = -3881911707962468466L;
	int a;

	public void print() {
		System.out.println("B");
	}
}
