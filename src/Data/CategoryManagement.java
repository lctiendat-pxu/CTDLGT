package Data;

import java.util.Scanner;

import Common.Layout;

public class CategoryManagement {
	private Category c;
	static CategoryManagement cm = new CategoryManagement();
	static Scanner sc = new Scanner(System.in);
	static Layout ly = new Layout();

	public CategoryManagement() {
		c = null;
	}

	public Category insertNode(Category c, String name) {
		if (c == null) {
			c = new Category(name);
			return c;
		}

		if (c.getName().compareTo(name) > 0) {
			c.l = insertNode(c.l, name);
		}

		else if (c.getName().compareTo(name) < 0) {
			c.r = insertNode(c.r, name);
		}

		return c;
	}

	public void addNode() {
		File f = new File();
		while (true) {
			System.out.print("Name : ");
			String _name = sc.nextLine();
			if (_name.isEmpty()) {
				break;
			} else if (findName(_name) != null) {
				System.out.println("Category with this name already exists.");
				continue;
			} else {
				c = cm.insertNode(c, _name);
				f.ghiFile(c);
			}
		}
	}

	public void read() {
		File f = new File();
		c = f.docFile();
		printInOrder(c);

	}

	private void printInOrder(Category node) {
		if (node != null) {
			printInOrder(node.l);
			System.out.printf(ly.Code("c"), node.getID(), node.getName());
			printInOrder(node.r);
		}
	}

	public void edit(String ID) {
		File f = new File();
		Category lp = c;
		while (lp != null) {
			if (lp.getID().equals(ID)) {
				System.out.print("New Name: ");
				String _name = sc.nextLine();
				sc.nextLine();
				lp.setName(_name);
				System.out.println("Category updated successfully.");
				f.ghiFile(c);
				return;
			}
			lp = lp.nextLink;
		}
		System.out.println("Category not found.");
	}

	public void delete(String ID) {
		Category prev = null;
		Category curr = c;
		while (curr != null) {
			if (curr.getID().equals(ID)) {
				if (prev == null) {
					c = curr.nextLink;
				} else {
					prev.nextLink = curr.nextLink;
				}
				System.out.println("Category deleted successfully.");
				return;
			}
			prev = curr;
			curr = curr.nextLink;
		}
		System.out.println("Category not found.");
	}

	public Category findName(String _name) {
		File f = new File();
		c = f.docFile();
		Category lc = c;
		while (lc != null) {
			if (lc.getName().equals(_name)) {
				return lc;
			}
			lc = lc.nextLink;
		}
		return null;
	}

	public Category findID(String _id) {
		File f = new File();
		c = f.docFile();
		Category lc = c;
		while (lc != null) {
			if (lc.getID().equals(_id)) {
				return lc;
			}
			lc = lc.nextLink;
		}
		return null;
	}

	public String getNameByID(String ID) {
		File f = new File();
		c = f.docFile();
		Category lc = c;
		while (lc != null) {
			if (lc.getID().equals(ID)) {
				return lc.getName();
			}
			lc = lc.nextLink;
		}
		return null;
	}
}
