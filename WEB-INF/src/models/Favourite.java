package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Favourite {

    private Integer favouriteId;
    private User user;
    private SellerProducts sellerProducts;


    public Favourite(Integer favouriteId , User user , SellerProducts sellerProducts){
        this.favouriteId = favouriteId;
        this.user = user;
        this.sellerProducts = sellerProducts;
    }

    public Favourite(User user , SellerProducts sellerProducts){
        this.user = user;
        this.sellerProducts = sellerProducts;
    }

    public Favourite(User user){
        this.user = user;
    }


    //***********************  Save Favourite Records  ******************************************** */

    public boolean SaveFavouriteProducts(){
        
        boolean flag = false;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gsmsdb?user=root&password=1234");

            String query = "insert into favourites (user_id,seller_product_id) value(?,?)";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, user.getUserId());
            ps.setInt(2, sellerProducts.getSellerProductId());

            int val =  ps.executeUpdate();

            if (val == 1) {
                
                flag = true;
            }
        } catch (SQLException | ClassNotFoundException e) {
            
            e.printStackTrace();
        }
        return flag;
    }


    //*********************************** Delete product from the list************************************************/

    public boolean DleteFavouriteProducts(){
        
        boolean flag = false;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gsmsdb?user=root&password=1234");

            String query = "";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, user.getUserId());
            ps.setInt(2, sellerProducts.getSellerProductId());

            int val =  ps.executeUpdate();

            if (val == 1) {
                
                flag = true;
            }
        } catch (SQLException | ClassNotFoundException e) {
            
            e.printStackTrace();
        }
        return flag;
    }

    //*********************************** Collect favourites products Method **************************************** */


    public static ArrayList<Favourite> collectFavouriteProducts(Integer userId){
        
        ArrayList<Favourite> favourites = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gsmsdb?user=root&password=1234");

            String query = " select * from favourites where user_id = ?";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, userId);

            ResultSet rs =  ps.executeQuery();

            while (rs.next()) {

                favourites.add(new Favourite(rs.getInt(1),new User(rs.getInt(2)), new SellerProducts(rs.getInt(3))));
            }

        } catch (SQLException | ClassNotFoundException e) {
            
            e.printStackTrace();
        }

        return favourites;
    }


    public Integer getFavouriteId(){
        return favouriteId;
    }

    public void setFavouriteId( Integer favouriteId ){
        this.favouriteId = favouriteId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public SellerProducts getSellerProducts() {
        return sellerProducts;
    }

    public void setSellerProducts(SellerProducts sellerProducts) {
        this.sellerProducts = sellerProducts;
    }
}
