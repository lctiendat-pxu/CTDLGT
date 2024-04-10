package Main;

import java.util.Scanner;
import Common.Constant;
import Main.Menu;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static Constant ct = new Constant();
	static Menu sgm = new Menu();

	public static void main(String[] args) {
		String key = null;
		System.out.println("\n\n");

		do {
			System.out.println("\t\t\t\t\t----------MENU MANAGEMENT---------");
			System.out.println("\t\t\t\t\t1.Category Management");
			System.out.println("\t\t\t\t\t2.Product Management");
			System.out.print("\t\t\t\t\tYour choice: ");
			key = sc.next();

			switch (key) {
			case "1":
				sgm.menuCategory();
				break;
			case "2":
				sgm.menuProduct();
				break;
			case "q":
				System.exit(0);
				break;
			}
		} while (!key.equals("q"));
	}
}
