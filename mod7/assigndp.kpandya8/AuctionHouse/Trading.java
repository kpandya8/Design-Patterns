package AuctionHouse;


import java.text.DateFormat;
import java.util.Date;

public class Trading {

	protected String tradingName;
	protected Date dueDate = new Date();
	protected OfferingList theOfferingList = new OfferingList();
	protected Offering suggestedOffering = new Offering();

	public Trading() {
	}

	public void addOffering(Offering theOffering) {
		theOfferingList.add(theOffering);
	}

	public OfferingIterator getOfferingIterator() {
		return new OfferingIterator(theOfferingList);
	}

	public String toString() {
		return tradingName;
	}

	public String getDueDateString() {
		DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.SHORT);
		return dateFormat.format(dueDate);
	}

	public void accept(NodeVisitor visitor) {
		visitor.visitTrading(this);
	}

}
