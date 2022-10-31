package AuctionHouse;


import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.io.File;
import java.util.Scanner;

import AuctionHouse.UserInfoItem.user_type;

public class Login extends JDialog{
    boolean mBExit = false;
    JLabel Username = new JLabel();
    JLabel Password = new JLabel();
    JButton loginButton = new JButton();
    JButton buttonExit = new JButton();
    JTextField userNameText = new JTextField();
    JPasswordField passwordText = new JPasswordField();

    JRadioButton BuyerRadio = new JRadioButton();

    JRadioButton SellerRadio = new JRadioButton();
    ButtonGroup buttonGroup1 = new ButtonGroup();

    private String userBox = null;
    private user_type userType = user_type.Buyer; // default to Buyer

    public Login() {
        try {
            jbInit();
            setSize(300, 300);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void jbInit() throws Exception{
        this.getContentPane().setLayout(null);
        Username.setText("UserName");
        Username.setBounds(new Rectangle(26, 52, 80, 18));
        Password.setText("Password");
        Password.setBounds(new Rectangle(26, 119, 80, 18));
        loginButton.setText("Login");
        loginButton.setBounds(new Rectangle(31, 212, 85, 28));
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                loginButton_actionPerformed(e);
            }
        });
        buttonExit.setText("Exit");
        buttonExit.setBounds(new Rectangle(180, 211, 97, 28));
        buttonExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonExit_actionPerformed(e);
            }
        });
        userNameText.setBounds(new Rectangle(100, 52, 144, 22));
        passwordText.setBounds(new Rectangle(100, 119, 147, 22));
        BuyerRadio.setSelected(true);
        BuyerRadio.setText("Buyer");
        BuyerRadio.setBounds(new Rectangle(37, 164, 103, 26));
        SellerRadio.setText("Seller");
        SellerRadio.setBounds(new Rectangle(177, 164, 103, 26));
        this.getContentPane().add(Username, null);
        this.getContentPane().add(Password, null);
        this.getContentPane().add(loginButton, null);
        this.getContentPane().add(buttonExit, null);
        this.getContentPane().add(userNameText, null);
        this.getContentPane().add(passwordText, null);
        this.getContentPane().add(BuyerRadio, null);
        this.getContentPane().add(SellerRadio, null);
        buttonGroup1.add(BuyerRadio);
        buttonGroup1.add(SellerRadio);
    }

    void loginButton_actionPerformed(ActionEvent e) {
        Scanner scanner;
        mBExit = false;
        //On click log in button implement
        try {
            if (BuyerRadio.isSelected())  // Select to log in as a buyer
            {
                userType = user_type.Buyer; // 0 for Buyer
                File file = new File("AuctionHouse/BuyerInfo.txt");
                scanner = new Scanner(file);
                //Login as a buyer.
            } else
            {
                userType = user_type.Seller; // 1 for Seller
                File file = new File("AuctionHouse/SellerInfo.txt");
                scanner = new Scanner(file);
                //Login as a seller
            }

            userBox = userNameText.getText();
            String passwordBox = new String(passwordText.getPassword());
            String loginName = null;
            String UserName = null, Password = null;
            while (scanner.hasNextLine()) {
                String user = scanner.nextLine();
                UserName = GetUserName(user);
                Password = GetPassword(user);
                //System.out.println(userBox + "\n" + UserName);
                if (UserName.compareTo(userBox) == 0 && Password.compareTo(passwordBox) == 0)
                    loginName = UserName;
            }
            scanner.close();
            if (loginName != null) {
                this.setVisible(false);
            }
        } catch (Exception ee) {
            //System.out.println(ee.toString());
        }

    }
    private String GetUserName(String aline) {
        int Separator = aline.lastIndexOf(':');
        return aline.substring(0, Separator);
    }
    private String GetPassword(String aline) {
        int Separator = aline.lastIndexOf(':');
        return aline.substring(Separator + 1, aline.length());
    }
    public String GetUserName() {
        return userBox;
    }

    /* after login get the userType of the login interface */
    public user_type GetUserType() {
        return userType;
    }

    public boolean isExit() {
        return mBExit;
    }

    void buttonExit_actionPerformed(ActionEvent e) {
        mBExit = true;
        setVisible(false);
    }

}
