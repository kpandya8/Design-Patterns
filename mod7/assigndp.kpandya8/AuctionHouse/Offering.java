package AuctionHouse;

import java.util.Date;
public class Offering {
	String theAuthor = "";
	String OfferingFileName = "";
	Date theSubmitData = new Date();
	int theBidding;
	boolean discussBidding = false;

	public Offering() {
	}
	@Override
	public String toString() {
		String string;
		string = theAuthor + "  " + OfferingFileName + " Bidding=" + getBiddingInt() + "  ";
		if (isDiscussed())
			string += "Discussed";
		else
			string += "Not Discussed";

		return (string);
	}

	String getBiddingString() {
		if (isDiscussed())
			return "" + theBidding;
		else
			return "-1";
	}
	int getBiddingInt() {
		return theBidding;
	}
	public void setDiscussBidding(boolean discussBidding) {
		this.discussBidding = discussBidding;
	}
	public boolean isDiscussed() {
		return discussBidding;
	}

}
