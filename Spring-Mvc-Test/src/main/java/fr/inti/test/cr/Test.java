package fr.inti.test.cr;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Test {

	public static void main(String[] args) {
		BCryptPasswordEncoder bc = new BCryptPasswordEncoder(12);
		System.out.println(bc.encode("user"));
	}
}
