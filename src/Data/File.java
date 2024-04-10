package Data;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class File {
    static String urlFile = "/Users/lctiendat/Documents/categories.txt";
	public void ghiFile(Category first) {
		FileOutputStream fout = null;
        ObjectOutputStream oos = null;
        try {
            fout = new FileOutputStream(urlFile);
            oos = new ObjectOutputStream(fout);
            oos.writeObject(first);

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (fout != null) {
                try {
                    fout.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
	}

	public Category docFile() {

		Category first = null;

        FileInputStream fin = null;
        ObjectInputStream ois = null;
        try {
            fin = new FileInputStream(urlFile); 
            ois = new ObjectInputStream(fin);
            first = (Category) ois.readObject();
        } catch (ClassNotFoundException e) {
            System.out.println("Category class not found. Please ensure it's available.");
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (fin != null) {
                try {
                    fin.close();
                } catch (IOException e) {
//                    e.printStackTrace();
                }
            }

            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {
//                    e.printStackTrace();
                }
            }
        }
        return first;
    }
}
