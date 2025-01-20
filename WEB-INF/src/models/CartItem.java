package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CartItem {
    
    private Integer cartItemId;
    private Cart cart;
    private SellerProducts sellerProduct;
    private String review;
    private Integer quantity;
    private Integer prise;
    private Integer discount;


    public CartItem(){
        
    }

    public CartItem(Cart cart , SellerProducts sellerProducts){

        this.cart = cart;
        this.sellerProduct = sellerProducts;
    }


    public void addcartItems(){

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gsmsdb?user=root&password=1234");

            String query = "insert into cart_items (cart_id,seller_product_id,quantity,price,discount) value(?,?,?,?,?)";

            PreparedStatement ps = con.prepareStatement(query);
            
            ps.setInt(1, cart.getCartId());
            ps.setInt(2,sellerProduct.getSellerProductId());
            ps.setInt(3,sellerProduct.getQuantity());
            ps.setInt(4,sellerProduct.getDinomination().getPrise());
            ps.setInt(5, sellerProduct.getDiscount());

            ps.executeUpdate();

        } catch (SQLException | ClassNotFoundException e) {

            e.printStackTrace();
        }
    }

    public Integer getCartItemId() {
        return cartItemId;
    }
    public void setCartItemId(Integer cartItemId) {
        this.cartItemId = cartItemId;
    }
    public Cart getCart() {
        return cart;
    }
    public void setCart(Cart cart) {
        this.cart = cart;
    }
    public SellerProducts getSellerProduct() {
        return sellerProduct;
    }
    public void setSellerProduct(SellerProducts sellerProduct) {
        this.sellerProduct = sellerProduct;
    }
    public String getReview() {
        return review;
    }
    public void setReview(String review) {
        this.review = review;
    }
    public Integer getQuantity() {
        return quantity;
    }
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
    public Integer getprise() {
        return prise;
    }
    public void setprise(Integer prise) {
        this.prise = prise;
    }
    public Integer getDiscount() {
        return discount;
    }
    public void setDiscount(Integer discount) {
        this.discount = discount;
    }
}
