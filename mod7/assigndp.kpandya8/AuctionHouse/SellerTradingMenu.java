package AuctionHouse;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.text.DateFormat;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
public class SellerTradingMenu extends TradingMenu {

    Offering theOffering;
    Trading theTrading;
    JComboBox<Offering> CombOfferingList = new JComboBox<>();


    JTextField labelTradingName = new JTextField();
    JTextField labelDueDate = new JTextField();
    JTextField SuggestedOffering = new JTextField();

    JLabel jLabel1 = new JLabel();
    JLabel jLabel2 = new JLabel();
    JLabel jLabel3 = new JLabel();
    JButton DecideBidding = new JButton();
    JButton SubmitBidding = new JButton();
    JButton CancelBidding = new JButton();

    public SellerTradingMenu() {
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void jbInit() {
        jLabel1.setText("Trading Info:");
        jLabel1.setBounds(new Rectangle(25, 31, 118, 18));
        this.getContentPane().setLayout(null);

        labelTradingName.setText("jTextField1");
        labelTradingName.setBounds(new Rectangle(192, 31, 341, 22));

        jLabel2.setText("Due Date");
        jLabel2.setBounds(new Rectangle(28, 90, 113, 18));

        labelDueDate.setText("Trading Due Date");
        labelDueDate.setBounds(new Rectangle(195, 87, 337, 22));

        jLabel3.setText("Offerings:");
        jLabel3.setBounds(new Rectangle(28, 151, 118, 18));

        SuggestedOffering.setText("jTextField2");
        SuggestedOffering.setBounds(new Rectangle(197, 149, 339, 22));

        DecideBidding.setText("Decide Bidding");
        DecideBidding.setBounds(new Rectangle(458, 199, 79, 29));
        DecideBidding.addActionListener(this::buttonDiscussBidding_actionPerformed);
        SubmitBidding.setText("Report Bidding");
        SubmitBidding.setBounds(new Rectangle(365, 249, 79, 29));
        SubmitBidding.addActionListener(this::buttonDecideBidding_actionPerformed);
        CancelBidding.setText("Close Session");
        CancelBidding.setBounds(new Rectangle(86, 253, 79, 29));
        CancelBidding.addActionListener(this::buttonClose_actionPerformed);
        CombOfferingList.setBounds(new Rectangle(32, 204, 413, 22));
        this.getContentPane().add(jLabel1, null);
        this.getContentPane().add(labelTradingName, null);
        this.getContentPane().add(jLabel2, null);
        this.getContentPane().add(labelDueDate, null);
        this.getContentPane().add(jLabel3, null);
        this.getContentPane().add(SuggestedOffering, null);
        this.getContentPane().add(CancelBidding, null);
        this.getContentPane().add(CombOfferingList, null);
        this.getContentPane().add(DecideBidding, null);
        this.getContentPane().add(SubmitBidding, null);
    }

    public void ShowMenu(Trading trading, Person person) {
        theTrading = trading;
        labelTradingName.setText(theTrading.tradingName);
        DateFormat theDateFormat = DateFormat.getDateInstance(DateFormat.SHORT);
        labelDueDate.setText(theDateFormat.format(theTrading.dueDate));
        SuggestedOffering.setText(theTrading.suggestedOffering.OfferingFileName);
        refreshOfferingList();
        setVisible(true);
    }

    void buttonClose_actionPerformed(ActionEvent e) {
        theTrading.tradingName = labelTradingName.getText();
        DateFormat tempDateFormat = DateFormat.getDateInstance(DateFormat.SHORT);
        try {
            theTrading.dueDate = tempDateFormat.parse(labelDueDate.getText());
        } catch (Exception ee) {
            //
        }

        theTrading.suggestedOffering.OfferingFileName = SuggestedOffering.getText();
        setVisible(false);
    }

    void buttonDiscussBidding_actionPerformed(ActionEvent e) {
        Offering theOffering = (Offering) CombOfferingList.getSelectedItem();
        if (theOffering == null)
            return;
        OfferingBiddingDialog dialog = new OfferingBiddingDialog();
        dialog.show(theOffering);
        refreshOfferingList();
    }
    void buttonDecideBidding_actionPerformed(ActionEvent e) {
        OfferingIterator iter = new OfferingIterator(theTrading.theOfferingList);
        while (iter.hasNext()) {
            Offering offering = iter.next();
            offering.setDiscussBidding(true);
        }
        refreshOfferingList();
    }
    private void refreshOfferingList() {
        CombOfferingList.removeAllItems();
        OfferingIterator OffIter = new OfferingIterator(theTrading.theOfferingList);
        while (OffIter.hasNext()) {
            theOffering = OffIter.next();
            CombOfferingList.addItem(theOffering);
        }
    }
}
