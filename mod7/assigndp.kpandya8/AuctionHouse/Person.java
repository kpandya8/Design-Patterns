package AuctionHouse;

import java.util.Iterator;
/**
 * The Person class is involved in the bridge pattern to show the Menu, and 
 * in factory menu to create proper menu object. It has no idea of the 
 * Meat product menu or produce product menu.
 */
public abstract class Person {

	int type = 0;
	String UserName;
	ClassProductList ProductList;
	ProductMenu theProductMenu;
	Product CurrentProduct;

	/**
	 * Variable of ProductMenu. Use this variable to point to a concrete
	 * productMenu object. Later, it will operate the object.
	 */

	//private ProductMenu productMenu;

	public Person() {ProductList = new ClassProductList();}

	abstract public void CreateProductMenu(Product theProduct, int theType);

	/**
	 * Call the implementation to show the "add" buttons. 
	 */
	public void showAddButton() {
		theProductMenu.showAddButton();
	}

	/**
	 * Call the implementation to show the "view" buttons. 
	 */
	public void showViewButton() {
		theProductMenu.showViewButton();
	}

	/**
	 * Call the implementation to show the radio buttons. 
	 */
	public void showRadioButton() {
		theProductMenu.showRadioButton();
	}

	/**
	 * Call the implementation to show the labels.
	 */
	public void showLabels() {
		theProductMenu.showLabels();
	}

	public void show() {
		theProductMenu.setVisible(true);
	}
	public boolean ifLogout() {
		return theProductMenu.ifLogout();
	}

	// show the trading list
	public boolean showMenu() {
		// create an iterator for the Trading list
		Iterator<Trading> Iter = CurrentProduct.TradingList.iterator();
		theProductMenu.theProduct = CurrentProduct;
		Trading theTrading;
		while (Iter.hasNext()) {
			theTrading = Iter.next();
			theProductMenu.TradingCombox.addItem(theTrading);
		}
		return false;
	}

	/**
	 * The abstract factory method. 
	 */

	public ClassProductList GetProductList() {

		return ProductList;
	}
	public void AddProduct(Product theProduct) {
		ProductList.add(theProduct);
	}


}
