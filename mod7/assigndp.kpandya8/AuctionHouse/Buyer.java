package AuctionHouse;

/**
 * The concrete implementation of the Person class.
 */
public class Buyer extends Person {

	public Buyer() {
		type = 0;
	}

	/**
	 * According to the need of buyer show the appropriate items on the menu.
	 */
	@Override
	public boolean showMenu() {
		super.showMenu();
		showAddButton();
		showViewButton();
		showRadioButton();
		showLabels();
		show();
		return ifLogout();
	}


	public void CreateProductMenu(Product theProduct, int theType) {
		if (theType == 0)
		{
			theProductMenu = new MeatProductMenu();
		} else
		{
			theProductMenu = new ProduceProductMenu();
		}
	}

	/*
	 * According to the Product type create a concrete product menu:
	 * meat or produce.
	 */


}
