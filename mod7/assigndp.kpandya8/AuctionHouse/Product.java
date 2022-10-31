package AuctionHouse;

import java.util.ArrayList;

public class Product {

	String ProductName;

	public ArrayList<Trading> TradingList = new ArrayList<>();
	int NumOfTrade;
	int ProductType;

	public Product(String strProduct, int theType) {
		this.ProductName = strProduct;

		// 0 MeatProductMenu 1 ProduceProductMenu
		this.ProductType = theType;

		this.NumOfTrade = 0;
	}

	public void addTrading(Trading newTrade) {
		TradingList.add(newTrade);
	}

	public String toString() {
		return ProductName;
	}

	void accept(NodeVisitor visitor) {
		visitor.visitProduct(this);
	}

}
