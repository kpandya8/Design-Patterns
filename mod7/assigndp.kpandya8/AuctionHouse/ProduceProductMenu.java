package AuctionHouse;

import java.awt.Rectangle;
/**
 * A subclass of ProductMenu. One of the concrete products of the factor 
 * method. 
 */
public class ProduceProductMenu extends ProductMenu {

	public ProduceProductMenu() {
		super();
	}

	/**
	 * To show the add buttons.
	 */
	public void showAddButton() {
		TradingAddButton.addActionListener(e -> TradeAddButton_actionPerformed());
		TradingAddButton.setText("Add");
		TradingAddButton.setBounds(new Rectangle(390, 54, 79, 29));
		OptionAddButton.setText("Add");
		OptionAddButton.setBounds(new Rectangle(390, 125, 79, 29));
		this.getContentPane().add(TradingAddButton, null);
		this.getContentPane().add(OptionAddButton, null);

	}

	/**
	 * To show the radio buttons. 
	 */
	public void showRadioButton() {
		TradingRadioButton.setText("Trading");
		TradingRadioButton.setBounds(new Rectangle(21, 55, 103, 26));
		this.getContentPane().add(TradingRadioButton, null);
		OptionRadio.setText("Produce Product Menu");
		OptionRadio.setBounds(new Rectangle(21, 128, 103, 26));
		this.getContentPane().add(OptionRadio, null);
	}

	/**
	 * To show the labels. 
	 */
	public void showLabels() {
		TradingContentLabel.setText("Trading Content");
		TradingContentLabel.setBounds(new Rectangle(23, 186, 432, 99));
		this.getContentPane().add(TradingContentLabel, null);

	}

	/**
	 * To show the view buttons. 
	 */
	public void showViewButton() {
		TradingViewButton.setText("View Produce Product");
		TradingViewButton.setBounds(new Rectangle(290, 54, 79, 29));
		TradingViewButton.addActionListener(e -> TradeViewButton_actionPerformed());
		OptionViewButton.setText("View Produce Product");
		OptionViewButton.setBounds(new Rectangle(290, 124, 79, 29));
		this.getContentPane().add(TradingViewButton, null);
		this.getContentPane().add(OptionViewButton, null);
	}

}
