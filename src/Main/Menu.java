package Main;

import java.util.Scanner;

import Common.Constant;
import Data.CategoryManagement;
import Data.ProductManagement;

public class Menu {
	static Scanner sc = new Scanner(System.in);
	static Constant ct = new Constant();
	static ProductManagement pm = new ProductManagement();
	static CategoryManagement cm = new CategoryManagement();

	public void menuCategory() {
		int key;
		System.out.println("\n");
		do {
			System.out.println("\t\t\t\t\t1.Add");
			System.out.println("\t\t\t\t\t2.Edit");
			System.out.println("\t\t\t\t\t3.Delete");
			System.out.println("\t\t\t\t\t4.Back");

			System.out.println("\t\t\t\t\tYour choose: ");
			key = sc.nextInt();
			String ID = "";

			switch (key) {
			case 1:
				cm.addNode();
				cm.read();
				break;
			case 2:
				cm.read();
				System.out.print("Type ID want edit : ");
				ID = sc.next();
				cm.edit(ID);
				cm.read();
				break;
			case 3:
				System.out.print("Type ID want delete : ");
				ID = sc.next();
				cm.delete(ID);
				break;
			default:
				return;
			}
		} while (key != 4);

	}

	public void menuProduct() {
		int key;
		do {
			System.out.println("\t\t\t\t\t1.Add");
			System.out.println("\t\t\t\t\t2.Edit");
			System.out.println("\t\t\t\t\t3.Delete");
			System.out.println("\t\t\t\t\t4.Find");
			System.out.println("\t\t\t\t\t5.Sort");
			System.out.println("\t\t\t\t\t6.Statistical");

			System.out.println("Your choose: ");
			key = sc.nextInt();
			String ID = "";

			switch (key) {
			case Constant.CASE_ADD:
				pm.add();
				pm.read();
				break;
			case Constant.CASE_EDIT:
				System.out.print("Type ID want edit : ");
				ID = sc.next();
				pm.edit(ID);
				pm.read();
				break;
			case Constant.CASE_DELETE:
				System.out.print("Type ID want delete : ");
				ID = sc.next();
				pm.delete(ID);
				pm.read();
				break;
			case Constant.CASE_FIND:
				System.out.print("Type Name want find : ");
				String name = sc.next();
				pm.findByName(name);
				break;
			case Constant.CASE_ARRANGER:
				pm.sort();
				pm.read();
				break;
			case 6 : 
				pm.Statistical();
				break;
			default:
				return;
			}
		} while (key != 7);
	}
}
