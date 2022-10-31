package AuctionHouse;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;


import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

/**
 * The abstract product of the factor method. 
 */
public abstract class ProductMenu extends JDialog {

	Product theProduct;
	boolean bLogout = true;

	JRadioButton TradingRadioButton = new JRadioButton();
	JComboBox<Trading> TradingCombox = new JComboBox<>();
	JButton TradingViewButton = new JButton();
	JButton TradingAddButton = new JButton();
	JRadioButton OptionRadio = new JRadioButton();
	JLabel TradingContentLabel = new JLabel();
	JButton OptionViewButton = new JButton();
	JButton OptionAddButton = new JButton();
	JButton buttonChangeProduct = new JButton();
	JButton buttonLogout = new JButton();

	public ProductMenu() {

		try {
			jbInit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		setModal(true);
		setSize(503, 294);
	}

	private void jbInit() {
		buttonChangeProduct.setText("Change Product");
		buttonChangeProduct.setBounds(new Rectangle(101, 211, 73, 37));
		buttonChangeProduct.addActionListener(this::buttonChangeProduct_actionPerformed);
		this.getContentPane().setLayout(null);
		this.setTitle("");
		buttonLogout.setText("Logout");
		buttonLogout.setBounds(new Rectangle(267, 215, 73, 37));
		buttonLogout.addActionListener(this::buttonLogout_actionPerformed);
		this.getContentPane().add(buttonChangeProduct, null);
		this.getContentPane().add(buttonLogout, null);
	}

	/**
	 * To show the add buttons. 
	 */
	public abstract void showAddButton();

	/**
	 * To show the view buttons. 
	 */
	public abstract void showViewButton();

	/**
	 * To show the radio buttons. 
	 */
	public abstract void showRadioButton();

	/**
	 * To show the labels. 
	 */
	public abstract void showLabels();

	void TradeAddButton_actionPerformed() {
		Demo.theFacade.addTrade(theProduct);
		refresh();
	}

	void TradeViewButton_actionPerformed() {
		Trading theTrade = (Trading) TradingCombox.getSelectedItem();
		Demo.theFacade.viewTrade(theTrade);
	}

	void refresh() {
		TradingCombox.removeAllItems();
		for (Trading trading : theProduct.TradingList) {
			TradingCombox.addItem(trading);
		}
	}
	void buttonChangeProduct_actionPerformed(ActionEvent e) {
		bLogout = false;
		setVisible(false);
	}

	void buttonLogout_actionPerformed(ActionEvent e) {
		bLogout = true;
		setVisible(false);
	}
	boolean ifLogout() {
		return bLogout;
	}
}
