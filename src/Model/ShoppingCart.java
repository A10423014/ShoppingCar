package Model;

import java.util.ArrayList;

public class ShoppingCart {
	private ArrayList<CartItem> shoppingList;

	public ShoppingCart() {
		shoppingList = new ArrayList<CartItem>();
	}

	public void addItem(CartItem item) {
		System.out.printf("%d %s add to shopping cart\n", item.getQuantity(), item.getName());
		for (CartItem tt : shoppingList) {
			if(tt.getName().equals(item.getName())){
				tt.setQuantity(tt.getQuantity() + item.getQuantity());
				return;
			}
		}
		shoppingList.add(item);
	}

	public void removeItem(int index, int num) {
		try {
			CartItem ci = shoppingList.get(index);
			ci.setQuantity(ci.getQuantity() - num);
			System.out.printf("Remove the %d %s.\n", num, ci.getName());
			if (ci.getQuantity() <= 0) {
				shoppingList.remove(index);
				System.out.printf("%s out of the car.\n", ci.getName());
			}
		} catch (Exception ex) {
			System.out.println("We don't have this item.");
		}
	}
	public void removeItemAll() {
		shoppingList.clear();
		System.out.println("All items out of the car.");
	}

	public String[] showItems() {
		String[] str = new String[shoppingList.size()+2];
		str[0] = "No.|                Item Name|  Quantity|    Price|    Subtotal";
		str[1] = "---+-------------------------+----------+---------+-----------+\n";
		int i = 2;
		for (CartItem tt : shoppingList) {
			str[i] = String.format("%3d|%25s|%10d|%9.2f|%12.2f\n", i - 2, tt.getName(), tt.getQuantity(), tt.getPrice(), tt.getQuantity() * tt.getPrice());
			i++;
		}
		return str;
	}
	
	public String checkOut() {
		if(shoppingList.size() == 0){
			return "Nothing!Can not checkout!";
		}
		double total = 0;
		String str = "";
		str += "No.|                Item Name|  Quantity|    Price|    Subtotal\n";
		str += "---+-------------------------+----------+---------+------------\n";
		int i = 0;
		for (CartItem tt : shoppingList) {
			str += String.format("%3d|%25s|%10d|%9.2f|%12.2f\n", i, tt.getName(), tt.getQuantity(), tt.getPrice(), tt.getQuantity() * tt.getPrice());
			total += tt.getQuantity() * tt.getPrice();
			i++;
		}
		str += "---+-------------------------+----------+---------+------------\n";
		str += String.format("Total: %.2f\n", total);
		this.removeItemAll();
		return str;
	}
	
	public double getTotalCost(){
		double total = 0;
		for (CartItem tt : shoppingList) {
			total += tt.getQuantity() * tt.getPrice();
		}
		return total;
	}
}
