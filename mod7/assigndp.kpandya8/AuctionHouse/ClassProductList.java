package AuctionHouse;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * The abstract class of the list to be iterated 
 */
public class ClassProductList extends ArrayList<Product> {
	public ClassProductList() {
	}


	void InitializeFromFile() {
		Scanner scanner;
		try {
			String strProductName;
			File file = new File("AuctionHouse/ProductInfo.txt");
			scanner = new Scanner(file);
			while (scanner.hasNextLine()) {
				strProductName = scanner.nextLine();
				Product theProduct;
				theProduct = new Product(strProductName, 0);
				add(theProduct);
			}
			scanner.close();
		} catch (Exception ee) {
			//
		}
	}

}
