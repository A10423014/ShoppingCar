package Controller;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import Model.CartItem;
import Model.Db;
import Model.Item;
import Model.ShoppingCart;

public class ShoppingCartController {
	ArrayList<Item> alsi;
	ShoppingCart sc;
	public ShoppingCartController(){
		alsi = new ArrayList<Item>();
		sc = new ShoppingCart();
	}
	public String[] showShopItem(){
		alsi = Db.readItem();
		String[] str = new String[alsi.size()];
		for(int i = 0; i < alsi.size(); i++){
			str[i] = alsi.get(i).getName();
		}
		return str;
	}
	public double getItemPrice(int index){
		return alsi.get(index).getPrice();
	}
	public void addToCart(int index, int num){
		sc.addItem(new CartItem(alsi.get(index).getName(), num, alsi.get(index).getPrice()));
	}
	public void removeCartItem(int index, int num){
		sc.removeItem(index, num);
	}
	public void removeCartItemAll(){
		sc.removeItemAll();
	}
	public String[] showCartItem(){
		return sc.showItems();
	}
	public double getTotalCost(){
		return sc.getTotalCost();
	}
	public void chockOut_Bill(){
		try {
			FileWriter fw = new FileWriter("Bill.txt");
			fw.write(sc.checkOut());
			fw.flush();
	        fw.close();
		} catch (IOException e) {
			// TODO 自動產生的 catch 區塊
			e.printStackTrace();
		}
	}
}
