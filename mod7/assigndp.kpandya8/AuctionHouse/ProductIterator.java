package AuctionHouse;
import java.util.Iterator;
/**
 * A concrete subclass of ListIterator that iterates the ProductList 
 */
public class ProductIterator implements Iterator<Product> {

	ClassProductList theProductList;
	int currentProductNumber = -1;
	public ProductIterator(ClassProductList productList) {
		theProductList = productList;
	}

	/**
	 * If in the ProductIterator there exists the "next", return true; else return false. 
	 */
	public boolean hasNext() {
		return currentProductNumber < theProductList.size() - 1;
	}

	/**
	 * If hasNext, return the next product, move the current Item to the next product. Else return null.
	 */
	public Product next() {

		if (hasNext()) {
			currentProductNumber++;
			return theProductList.get(currentProductNumber);
		} else {
			return null;
		}
	}

	/**
	 * Set the current product to the location before the first product.
	 */
	public Product next(String ProductName) {
		Product theProduct;
		theProduct = next();
		while (theProduct != null) {
			if (ProductName.compareTo(theProduct.toString()) == 0) {
				return theProduct;
			}
			theProduct = next();
		}
		return null;
	}

	/**
	 * Remove the current product from the list. 
	 */
	public void remove() {
		if (currentProductNumber == -1)
			currentProductNumber++;
		theProductList.remove(currentProductNumber);
	}

}
