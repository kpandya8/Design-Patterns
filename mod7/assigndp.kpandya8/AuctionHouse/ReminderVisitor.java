package AuctionHouse;



import java.util.Calendar;
import java.util.Date;


public class ReminderVisitor extends NodeVisitor {

	Reminder m_Reminder;

	public ReminderVisitor(Reminder reminder) {
		m_Reminder = reminder;
	}

	public void visitFacade(Facade facade) {
		ProductIterator productList = new ProductIterator(facade.theProductList);
		while (productList.hasNext()) {
			Product product = productList.next();
			product.accept(this);
		}
	}


	public void visitProduct(Product product) {
		for (Trading trading : product.TradingList) {
			trading.accept(this);
		}

	}

	public void visitTrading(Trading trading) {
		Date today = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(today);
		int ntoday = calendar.get(Calendar.DAY_OF_YEAR);
		calendar.setTime(trading.dueDate);
		int nDueDate = calendar.get(Calendar.DAY_OF_YEAR);
		if (nDueDate <= (ntoday + 1) && nDueDate >= ntoday) /// upcoming
		{
			m_Reminder.listUpcoming.add("Today's Date is" + today + " " + trading.tradingName
					+ " offer expires " + trading.getDueDateString());
		}
		if (nDueDate < ntoday) {

			m_Reminder.listOverdue.add(trading.tradingName + " Offer is due " + trading.getDueDateString());
		}

	}


}
