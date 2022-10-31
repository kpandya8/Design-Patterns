package AuctionHouse;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class OfferingBiddingDialog extends JDialog{
    Offering theOffering;
    JLabel jLabel1 = new JLabel();
    JTextField TextOffering = new JTextField();
    JButton buttonOK = new JButton();
    JLabel labelOfferingFileName = new JLabel();

    public OfferingBiddingDialog() {
        try {
            jbInit();
            setSize(316, 186);
            setModal(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void jbInit(){
        jLabel1.setText("Offering File Name");
        jLabel1.setBounds(new Rectangle(25, 30, 121, 18));
        this.getContentPane().setLayout(null);
        TextOffering.setBounds(new Rectangle(25, 66, 100, 22));
        buttonOK.setText("OK");
        buttonOK.setBounds(new Rectangle(217, 67, 79, 29));
        buttonOK.addActionListener(this::buttonOK_actionPerformed);
        labelOfferingFileName.setBounds(new Rectangle(212, 34, 163, 18));
        this.getContentPane().add(jLabel1, null);
        this.getContentPane().add(TextOffering, null);
        this.getContentPane().add(labelOfferingFileName, null);
        this.getContentPane().add(buttonOK, null);
    }
    void show(Offering offering) {
        theOffering = offering;
        TextOffering.setText("" + theOffering.getBiddingInt());
        labelOfferingFileName.setText(theOffering.OfferingFileName);
        setVisible(true);
    }
    void buttonOK_actionPerformed(ActionEvent e) {
        theOffering.theBidding = Integer.parseInt(TextOffering.getText());
        setVisible(false);
    }
}
