package AuctionHouse;

import javax.swing.JDialog;
public abstract class TradingMenu extends JDialog  {
    abstract void ShowMenu(Trading trade, Person per);

    public TradingMenu() {
        setModal(true);
        setSize(575, 330);
    }
}
