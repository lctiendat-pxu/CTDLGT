package Common;

import java.util.Random;

public class Constant {
	
	public static final int CASE_ADD = 1;
	public static final int CASE_EDIT = 2;
	public static final int CASE_DELETE = 3;
	public static final int CASE_FIND = 4;
	public static final int CASE_ARRANGER = 5;
	public static final int CASE_EXIT_PROGRAM = 4;
	static public String getSaltString() {
		String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		StringBuilder salt = new StringBuilder();
		Random rnd = new Random();
		while (salt.length() < 10) {
			int index = (int) (rnd.nextFloat() * SALTCHARS.length());
			salt.append(SALTCHARS.charAt(index));
		}
		String saltStr = salt.toString();
		return saltStr;
	}
}
