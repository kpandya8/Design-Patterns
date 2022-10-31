package AuctionHouse;

/**
 * The abstract class of the visitor, it can visit class: Façade, Trading, Product. 
 * The real work that need to be done will be implemented in the concrete 
 * visitor classes. 
 */
public abstract class NodeVisitor {

	/**
	 * When visiting a product, it will in turn visit each trading in this product. 
	 */

	public NodeVisitor() {
	}
	abstract public void visitProduct(Product product);


	/**
	 * When visiting a trading, it will compare the current date and the due date of the trading and show the proper reminding information on the Reminder. (The client) 
	 */
	abstract public void visitTrading(Trading trading);

	/**
	 * When visiting Façade, it will in turn visit each product in the Façade.productList 
	 */
	abstract public void visitFacade(Facade facade);

}
