package AuctionHouse;

public class Demo {
    static Facade theFacade = new Facade();

    public Demo(){}

    public static void main(String[] args) {
        UserInfoItem userinfoitem = new UserInfoItem();
        theFacade.CreateProductList();
        while (true) {
            boolean bExit;                      ///==false
            bExit = Facade.Login(userinfoitem);
            if (bExit)
                break;

            theFacade.CreateUser(userinfoitem);
            theFacade.AttachProductToUser();
            if (userinfoitem.UserType == UserInfoItem.user_type.Buyer) // if is a Buyer remind him of the offer expiration
                theFacade.Remind();
            boolean bLogout = false;
            while (!bLogout) {
                bLogout = theFacade.SelectProduct();
                if (bLogout)
                    break;
                bLogout = theFacade.productOperation();
            }
        }
    }
}
