package Data;

import java.util.Scanner;

import Common.Layout;

public class ProductManagement {

	private Product f;
	static ProductManagement p = new ProductManagement();
	static CategoryManagement cm = new CategoryManagement();
	static Scanner sc = new Scanner(System.in);
	static Layout ly = new Layout();

	public ProductManagement() {
		f = null;
	}

	public Product insertTo(String name, String description, String unit, int price, int quantity, String categoryID) {
		Product n = new Product(name, description, unit, price, quantity, categoryID);
		n.nextLink = f;
		f = n;
		return f;
	}

	public void add() {
		System.out.println("List Category \n");
		cm.read();
		while (true) {
			System.out.print("Name : ");
			String _name = sc.nextLine();
			if (_name.isEmpty()) {
				break;

			} else if (findName(_name) != null) {
				System.out.println("Product with this name already exists.");
				continue;

			} else {
				System.out.print("Description : ");
				String _desc = sc.nextLine();
				System.out.print("Unit : ");
				String _unit = sc.nextLine();
				System.out.print("Price : ");
				int _price = sc.nextInt();
				System.out.print("Quantity : ");
				int _quantity = sc.nextInt();
				System.out.print("Category ID : ");
				String _categoryID = sc.next();
				if (cm.findID(_categoryID) == null) {
					System.out.println("Category does not exists.");
					continue;
				}
				sc.nextLine();
				f = p.insertTo(_name, _desc, _unit, _price, _quantity, _categoryID);
			}
		}
	}

	public void read() {
		Product lp = f;
		System.out.print("\n");
		ly.Header("p");
		while (lp != null) {
			System.out.printf(ly.Code("p"), lp.getID(), lp.getName(), lp.getDescription(), lp.getPrice(), lp.getUnit(),
					lp.getQuantity(), cm.getNameByID(lp.getCategoryID()));
			lp = lp.nextLink;
		}
	}

	public void edit(String ID) {
		Product lp = f;
		while (lp != null) {
			if (lp.getID().equals(ID)) {
				System.out.print("New Name: ");
				String _name = sc.nextLine();
				System.out.print("New Description: ");
				String _desc = sc.nextLine();
				System.out.print("New Unit: ");
				String _unit = sc.nextLine();
				System.out.print("New Price: ");
				int _price = sc.nextInt();
				System.out.print("New Quantity: ");
				int _quantity = sc.nextInt();
				sc.nextLine();

				lp.setDescription(_desc);
				lp.setUnit(_unit);
				lp.setPrice(_price);
				lp.setQuantity(_quantity);
				System.out.println("Product updated successfully.");
				return;
			}
			lp = lp.nextLink;
		}
		System.out.println("Product not found.");
	}

	public void delete(String name) {
		Product prev = null;
		Product curr = f;
		while (curr != null) {
			if (curr.getName().equals(name)) {
				if (prev == null) {
					f = curr.nextLink;
				} else {
					prev.nextLink = curr.nextLink;
				}
				System.out.println("Product deleted successfully.");
				return;
			}
			prev = curr;
			curr = curr.nextLink;
		}
		System.out.println("Product not found.");
	}

	public Product findName(String _name) {
		Product lp = f;
		while (lp != null) {
			if (lp.getName().equals(_name)) {
				return lp;
			}
			lp = lp.nextLink;
		}
		return null;
	}

	public void findByName(String _name) {
		Product lp = f;
		if (findName(_name) == null) {
			System.out.println("Product not found.");
			return;
		}
		System.out.print("\n");
		ly.Header("p");
		System.out.printf(ly.Code("p"), lp.getID(), lp.getName(), lp.getDescription(), lp.getPrice(), lp.getUnit(),
				lp.getQuantity(), cm.getNameByID(lp.getCategoryID()));

	}

	public void sort() {
		if (f == null || f.nextLink == null) {
			return;
		}

		Product sortedList = null;
		Product current = f;
		while (current != null) {
			Product next = current.nextLink;
			sortedList = sortedInsert(sortedList, current);
			current = next;
		}
		f = sortedList;
	}

	private Product sortedInsert(Product sortedList, Product newNode) {
		if (sortedList == null || sortedList.getPrice() >= newNode.getPrice()) {
			newNode.nextLink = sortedList;
			sortedList = newNode;
		} else {
			Product current = sortedList;
			while (current.nextLink != null && current.nextLink.getPrice() < newNode.getPrice()) {
				current = current.nextLink;
			}
			newNode.nextLink = current.nextLink;
			current.nextLink = newNode;
		}
		return sortedList;
	}
	
	
	public void Statistical () {
		Product lp = f;
		System.out.print("\n");
		ly.Header("p");
		while (lp != null) {
			if (lp.getPrice() * lp.getQuantity() >= 10000 ) {
				System.out.printf(ly.Code("p"), lp.getID(), lp.getName(), lp.getDescription(), lp.getPrice(), lp.getUnit(),
						lp.getQuantity(), cm.getNameByID(lp.getCategoryID()));
			}
			lp = lp.nextLink;
		}
	}
	
}
