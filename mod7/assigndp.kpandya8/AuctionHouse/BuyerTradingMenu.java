package AuctionHouse;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class BuyerTradingMenu extends TradingMenu {
    private boolean boolSubmit = false;
    Offering theOffering;
    Trading theTrading;

    JLabel labelTradingName = new JLabel();
    JLabel labelDueDate = new JLabel();
    JTextField textFieldOffering = new JTextField();
    JLabel SuggestedOffering = new JLabel();
    JLabel DecideBidding = new JLabel();
    JButton SubmitBidding = new JButton();
    JButton CancelBidding = new JButton();

    JLabel jLabel1 = new JLabel();
    JLabel jLabel3 = new JLabel();
    JLabel jLabel5 = new JLabel();
    JLabel jLabel6 = new JLabel();
    JLabel jLabel7 = new JLabel();

    public BuyerTradingMenu() {
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        jLabel1.setText("Product: ");
        jLabel1.setBounds(new Rectangle(20, 36, 91, 18));
        this.getContentPane().setLayout(null);

        labelTradingName.setText("jLabel2");
        labelTradingName.setBounds(new Rectangle(258, 35, 282, 18));

        jLabel3.setText("Due Date");
        jLabel3.setBounds(new Rectangle(21, 81, 92, 18));

        labelDueDate.setText("jLabel4");
        labelDueDate.setBounds(new Rectangle(254, 82, 294, 18));

        jLabel5.setText("Offering");
        jLabel5.setBounds(new Rectangle(24, 128, 93, 18));

        textFieldOffering.setText("jTextField1");
        textFieldOffering.setBounds(new Rectangle(251, 127, 211, 22));

        jLabel6.setText("Suggested Offering");
        jLabel6.setBounds(new Rectangle(24, 174, 117, 18));

        jLabel7.setText("DiscussBidding");
        jLabel7.setBounds(new Rectangle(23, 224, 41, 18));

        SuggestedOffering.setText("jLabel8");
        SuggestedOffering.setBounds(new Rectangle(259, 169, 201, 18));

        DecideBidding.setText("jLabel9");
        DecideBidding.setBounds(new Rectangle(258, 226, 41, 18));

        SubmitBidding.setText("Submit");
        SubmitBidding.setBounds(new Rectangle(476, 124, 79, 29));
        SubmitBidding.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                bSubmit_actionPerformed(e);
            }
        });
        CancelBidding.setText("Cancel");
        CancelBidding.setBounds(new Rectangle(475, 164, 79, 29));
        CancelBidding.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                bCancel_actionPerformed(e);
            }
        });
        this.getContentPane().add(jLabel1, null);
        this.getContentPane().add(jLabel3, null);
        this.getContentPane().add(jLabel5, null);
        this.getContentPane().add(jLabel6, null);
        this.getContentPane().add(labelTradingName, null);
        this.getContentPane().add(labelDueDate, null);
        this.getContentPane().add(textFieldOffering, null);
        this.getContentPane().add(jLabel7, null);
        this.getContentPane().add(SuggestedOffering, null);
        this.getContentPane().add(DecideBidding, null);
        this.getContentPane().add(SubmitBidding, null);
        this.getContentPane().add(CancelBidding, null);
    }

    public void ShowMenu(Trading trading, Person thePerson) {
        theTrading = trading;
        OfferingIterator theIter = theTrading.getOfferingIterator();
        theOffering = theIter.next(thePerson.UserName);
        if (theOffering == null) {
            textFieldOffering.setText("");
            DecideBidding.setText("-1");
        } else {
            textFieldOffering.setText(theOffering.OfferingFileName);
            DecideBidding.setText(theOffering.getBiddingString());

        }

        labelTradingName.setText(theTrading.tradingName);
        labelDueDate.setText(theTrading.dueDate.toString());
        SuggestedOffering.setText(theTrading.suggestedOffering.OfferingFileName);

        setVisible(true);

        if (boolSubmit) {
            if (theOffering == null) {
                theOffering = new Offering();
                theTrading.addOffering(theOffering);
            }
            theOffering.theAuthor = thePerson.UserName;
            theOffering.OfferingFileName = textFieldOffering.getText();
            theOffering.theSubmitData = new Date();
        }
    }

    void bSubmit_actionPerformed(ActionEvent e) {
        boolSubmit = true;
        setVisible(false);
    }
    void bCancel_actionPerformed(ActionEvent e) {
        boolSubmit = false;
        setVisible(false);
    }
}
