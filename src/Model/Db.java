package Model;
import java.io.*;
import java.util.*;

public class Db {
	public static ArrayList<Item> readItem() {
		ArrayList<Item> alsi = new ArrayList<Item>();
		Item ci;
		FileReader fr;
		try {
			fr = new FileReader("Item.txt");
			BufferedReader br = new BufferedReader(fr);
			while (br.ready()) {
				String[] str = br.readLine().split(",");
				ci = new Item(str[0], Double.parseDouble(str[1]));
				alsi.add(ci);
			}
			fr.close();
		} catch (Exception ex) {
			System.out.println("Can't open file Or can't find file.");
		}
		return alsi;
		
	}
}
