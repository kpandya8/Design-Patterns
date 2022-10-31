package AuctionHouse;

/**
 * The concrete implementation of the Person class.
 */
public class Seller extends Person {

	public Seller(){
		type = 1;
	}
	/**
	 * According to the need of seller show the appropriate items on the menu. 
	 */

	public boolean showMenu() {
		super.showMenu();
		showAddButton();
		showViewButton();
		showLabels();
		showRadioButton();
		show();
		return ifLogout();
	}



	/*
	 * According to the Product type create a concrete product menu: 
	 * meat or produce. 
	 */
	public void CreateProductMenu(Product theProduct, int theType) {
		if (theType == 1)
		{
			theProductMenu = new MeatProductMenu();
		} else
		{
			theProductMenu = new ProduceProductMenu();
		}
	}


}
