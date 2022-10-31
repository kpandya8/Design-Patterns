package AuctionHouse;
//Facade Class that implements all the classes in the project.
import java.io.File;
import java.util.Scanner;

public class Facade {

	/**
	 * The object that holds the currently selected product. 
	 */
	private Product theSelectedProduct = null;

	/**
	 * The selected product category: 0: Meat, 1: 
	 */
	private int nProductType = 0;

	/**
	 * The list of products of the entire system. 
	 */
	ClassProductList theProductList;

	/**
	 * The current user. 
	 */
	Person thePerson;

	/**
	 * Show login GUI and return the login result.
	 */
	public Facade() {
	}
	static public boolean Login(UserInfoItem userinfoItem) {
		Login login = new Login();
		login.setModal(true);
		login.setVisible(true);
		userinfoItem.strUserName = login.GetUserName();
		userinfoItem.UserType = login.GetUserType();
		return login.isExit();
	}

	/**
	 * When clicking the add button of the ProductMenu, call this function. This function will add a new trade and fill in the required information. This function will be called 
	 * SellerTradingMenu or BuyerTradingMenu based on the type of the user. It will not update the product menu. The product menu needs to be refreshed outside the function. 
	 */
	void addTrade(Product theProduct) {
		TradingMenu theTradingMenu;
		if (thePerson.type == 0)
		{
			theTradingMenu = new BuyerTradingMenu();
		} else {
			theTradingMenu = new SellerTradingMenu();
		}
		Trading theTrade = new Trading();
		theTradingMenu.ShowMenu(theTrade, thePerson);
		theProduct.addTrading(theTrade);
	}

	/**
	 * When clicking the view button of the ProductMenu, call this function and pass the pointer of the Trading and the person pointer to this function. This function will view the trading information. This function will call SellerTradingMenu or BuyerTradingMenu 
	 * according to the type of the user. 
	 */
	void viewTrade(Trading theTrading) {
		TradingMenu theTradingMenu;
		if (thePerson.type == 0)/// Buyer
		{
			theTradingMenu = new BuyerTradingMenu();
		} else {
			theTradingMenu = new SellerTradingMenu();
		}

		theTradingMenu.ShowMenu(theTrading, thePerson);

	}

	/**
	 * Show the remind box to remind buyer of the upcoming overdue trading window. 
	 */
	public void Remind() {
		Reminder theReminder = new Reminder();
		theReminder.showReminder();
	}

	/**
	 * Create a user object according to the userinfoitem, the object can be a buyer or a seller. 
	 */
	public void CreateUser(UserInfoItem userinfoitem) {
		if (userinfoitem.UserType == UserInfoItem.user_type.Buyer) /// buyer
		{
			thePerson = new Buyer();
		} else
		{
			thePerson = new Seller();
		}
		thePerson.UserName = userinfoitem.strUserName;
	}

	/**
	 * Create the product list of the entire system.
	 */
	void CreateProductList() {
		theProductList = new ClassProductList();
		theProductList.InitializeFromFile();
	}

	/**
	 * Call this function after creating the user. Create productList by reading the UserProduct.txt file. Match the product name with theProductList. Attach the matched product object to the new 
	 * user: Facade.thePerson. ProductList
	 */
	void AttachProductToUser() {
		Scanner scanner;
		File file;
		try {
			file = new File("AuctionHouse/UserProduct.txt");
			scanner = new Scanner(file);
			String strUserName, strProductName, user;
			while (scanner.hasNextLine()) //
			{
				user = scanner.nextLine();
				strUserName = GetUserName(user);
				strProductName = GetProductName(user);
				if (strUserName.compareTo(thePerson.UserName) == 0) /// Validate Username
				{
					theSelectedProduct = FindProductByProductName(strProductName);
					if (theSelectedProduct != null) /// Find the product in product list
					{
						thePerson.AddProduct(theSelectedProduct);
					}
				}
			}
		} catch (Exception ee) {
			//
		}
	}

	private String GetUserName(String aline) {
		int Sep = aline.lastIndexOf(':');
		return aline.substring(0, Sep);
	}

	private String GetProductName(String aline) {
		int Sep = aline.lastIndexOf(':');
		return aline.substring(Sep + 1);
	}
	/**
	 * Show the Product list in a Dialog and return the selected product. 
	 */
	public boolean SelectProduct() {
		ProductSelectDialog theDialog = new ProductSelectDialog();
		theSelectedProduct = theDialog.ShowDialog(thePerson.ProductList);
		thePerson.CurrentProduct = theSelectedProduct;
		nProductType = theDialog.nProductType;
		return theDialog.isLogout();

	}

	/**
	 * This function will call the thePerson. CreateProductMenu0 According to the real object (buyer or seller) and the productLevel, it will call different menu creator and show the menu differently according to the usertype.
	 */
	public boolean productOperation() {
		thePerson.CreateProductMenu(theSelectedProduct,nProductType);
		return thePerson.showMenu();
	}
	private Product FindProductByProductName(String strProductName) {
		ProductIterator Iterator = new ProductIterator(theProductList);
		return Iterator.next(strProductName);
	}
}
