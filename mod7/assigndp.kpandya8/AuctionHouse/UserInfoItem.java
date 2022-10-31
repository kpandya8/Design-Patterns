package AuctionHouse;

public class UserInfoItem {

    public enum user_type {
        Buyer, Seller
    }

    String strUserName;
    user_type UserType; // 0 : Buyer, 1: Seller
}