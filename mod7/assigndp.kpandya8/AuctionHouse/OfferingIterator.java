package AuctionHouse;

import java.util.Iterator;
/**
 * A concrete subclass of ListIterator that iterate the OfferingList 
 */
public class OfferingIterator implements Iterator<Offering> {

	OfferingList OfferingList;
	int currentOfferingNumber = -1;
	/**
	 * If in the OfferingIterator there exists the "next", return true; else return false. 
	 */

	public OfferingIterator(OfferingList theOfferingList) {
		OfferingList = theOfferingList;
		moveToHead();
	}

	public void moveToHead() {
		/// currentSolutionNumber: point to the location before the first element
		currentOfferingNumber = -1;
	}
	/**
	 * If hasNext, return the next offering, move the current Item to the next offering. Else return null.
	 */

	public boolean hasNext() {
		return currentOfferingNumber < OfferingList.size() - 1;
//    throw new java.lang.UnsupportedOperationException("Method hasNext() not yet implemented.");
	}
	public Offering next() {
		if (hasNext()) {
			currentOfferingNumber++;
			return OfferingList.get(currentOfferingNumber);
		} else {
			return null;
		}

	}
	public Offering next(String userName) {
		Offering theOffering;
		theOffering = next();
		while (theOffering != null) {
			if (userName.compareTo(theOffering.theAuthor) == 0) {
				return theOffering;
			}
			theOffering = next();
		}
		return null;
	}

	/**
	 * Remove the current offering from the list. 
	 */
	public void remove() {
		currentOfferingNumber++;
		OfferingList.remove(currentOfferingNumber);
	}

}
