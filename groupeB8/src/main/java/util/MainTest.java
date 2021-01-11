package util;

import entities.User;

public class MainTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		User u = new User("Claude", "jean", "bru", "email");
		PasswordHasher hasher = new PasswordHasher();
		
		System.out.println("Password : " + u.getPassword() + " => " + hasher.hashWith256(u.getPassword()));
	}

}
