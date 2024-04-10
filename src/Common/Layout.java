package Common;

public class Layout {

	public static void Header(String type) {
		switch (type) {
		case "p":
			System.out.printf(Code(type), "ID", "Name", "Description", "Price", "Unit", "Quantity ", "Category \n");
			break;
		case "c":
			System.out.printf(Code(type), "ID", "Name \n");
			break;
		}
	}

	public static String Code(String type) {
		String str = "";
		switch (type) {
		case "p":
			str = "| %-10s | %-20s | %-30s | %-10s | %-10s | %-10s | %-10s \n";
			break;
		case "c":
			str = "| %-10s | %-20s \n";
			break;
		}
		return str;
	}
}
