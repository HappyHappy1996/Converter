package ua.nagib;

import java.util.Random;

public class Zukerwatte {

	private static String staticValue = "NO MAN NO CRY";

	public static void sayOliver() {
		System.out.println("Oliver");
	}

	public static void print() {
		System.out.println(staticValue);
	}

	public static void saySmthOther() {
		System.out.println("MOFO");
	}
	
	public static void someMehtod() {
		Random random = new Random();
		boolean b = random.nextBoolean();
		if (b) {
			System.out.println("YOYO 782");
		}
	}

}
