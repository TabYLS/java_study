package com.study.java.io.serialize;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author 叶林生
 *
 * @date 2017年6月16日 上午8:58:33
 *
 * @version 1.0
 * 
 */
public class ObjectStreamDemo {
	
	public static void main(String[] args) {
		//writeObj();
		readObj();
	}
	
	public static void readObj() {
		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(new FileInputStream(".\\src\\com\\study\\java\\io\\serialize\\obj.txt"));
			
			Person person = (Person) ois.readObject();
			System.out.println(person);
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (ois != null) {
				try {
					ois.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	public static void writeObj() {
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream(".\\src\\com\\study\\java\\io\\serialize\\obj.txt"));
			oos.writeObject(new Person("李四", 15));
			oos.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (oos != null)
				try {
					oos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}
}
