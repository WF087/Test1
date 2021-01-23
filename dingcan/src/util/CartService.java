package util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import model.Product;






public class CartService{

	

	private static HashMap<Integer, CartItem> items = new HashMap<Integer, CartItem>();
	
	


	public static boolean addItem(Product product) {
		if (!items.containsKey((int)product.getId())) {
			CartItem item = new CartItem();
			item.setProduct(product);
			item.setNumber(1);
			item.setDrop(false);
			items.put((int)product.getId(), item);
			return true;
		}
		return false;
	}

	public static void clear() {
		items.clear();
	}

	public static boolean drop(int pid) {
		if (items.containsKey(pid)) {
			CartItem item = items.get(pid);
			item.setDrop(true);
			return true;
		}
		return false;
	}

	public static List<CartItem> getDropItems() {
		ArrayList<CartItem> list = new ArrayList<CartItem>();
		Iterator<Integer> it = items.keySet().iterator();
		while (it.hasNext()) {
			CartItem item = items.get(it.next());
			if (item.isDrop()) {
				list.add(item);
			}
		}
		return list;
	}

	public  static List<CartItem> getItems() {
		ArrayList<CartItem> list = new ArrayList<CartItem>();
		Iterator<Integer> it = items.keySet().iterator();
		while (it.hasNext()) {
			CartItem item = items.get(it.next());
			if (!item.isDrop()) {
				list.add(item);
			}
		}
		return list;
	}

	public static double getPrice1() {
		double totalPrice = 0;
		Iterator<Integer> it = items.keySet().iterator();
		while (it.hasNext()) {
			CartItem item = items.get(it.next());
			if (!item.isDrop()) {
				totalPrice += item.getProduct().getPrice1()
						* item.getNumber();
			}
		}
		return totalPrice;
	}

	public static double getPrice2() {
		double totalPrice = 0;
		Iterator<Integer> it = items.keySet().iterator();
		while (it.hasNext()) {
			CartItem item = items.get(it.next());
			if (!item.isDrop()) {
				totalPrice += item.getProduct().getPrice2()
						* item.getNumber();
			}
		}
		return totalPrice;
	}

	public static boolean isEmpty() {
		return items.isEmpty();
	}



	public static boolean recovery(int pid) {
		if (items.containsKey(pid)) {
			CartItem item = items.get(pid);
			item.setDrop(false);
			return true;
		}
		return false;
	}



	public static boolean updateNum(int pid, int num) {
		if (items.containsKey(pid)) {
			CartItem item = items.get(pid);
			item.setNumber(num);
			return true;
		}
		return false;
	}

}
