package models;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Cart {

    private Integer cartId;
    private User user;
    private Date cartDate;
    private Integer totalAmount;
    private Integer itemCount;
    private Integer totalDiscount;
    private Status status;


    public Cart(User user){
        this.user = user;
    }

    public Cart(Integer cartId , User user){
        this.cartId = cartId;
        this.user = user;
    }

    public Cart (Integer totalAmount , Integer itemCount , Status status,  Integer cartId){
        this.totalAmount = totalAmount;
        this.itemCount = itemCount;
        this.status = status;
        this.cartId = cartId;
    }

    public Cart(){

    }

    public void updateCart(){

        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gsmsdb?user=root&password=1234");

            String query = "update Cart set total_amount=?,item_count=?,status_id=? where cart_id =?";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, totalAmount);
            ps.setInt(2, itemCount);
            ps.setInt(3,Status.COMPLETED);
            ps.setInt(4, cartId);

            ps.executeUpdate();

        } catch (SQLException | ClassNotFoundException e) {

            e.printStackTrace();
        }
    }

    public boolean creteCart(){

        boolean flag = false;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gsmsdb?user=root&password=1234");

            String query = "insert into carts (user_id,cart_date,total_amount,item_count,status_id) value(?,?,?,?,?)";

            PreparedStatement ps = con.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
            
            ps.setInt(1, user.getUserId());
            ps.setDate(2, cartDate);
            ps.setInt(3, totalAmount);
            ps.setInt(4, itemCount);
            ps.setInt(5, status.getStatusId());

            int val = ps.executeUpdate();

            if (val == 1) {
                ResultSet rs = ps.getGeneratedKeys();

                if (rs.next()) {
                    cartId = rs.getInt(1);
                }
                flag = true;
            }

        } catch (SQLException | ClassNotFoundException e) {

            e.printStackTrace();
        }
        return flag;
    }

        public Cart checkCartStatus(Integer userId){

         try {

             Class.forName("com.mysql.cj.jdbc.Driver");

             Connection con = DriverManager.getConnection("jdbc:mysql:localhost:3306/gsmsdb?uset=root&password=1234");

             String query = "select * from carts where user_id = ? and status = ?";

             PreparedStatement ps = con.prepareStatement(query);
            
             ps.setInt(1, userId);
             ps.setInt(2, Status.PENDING);

             ResultSet rs = ps.executeQuery();

             while (rs.next()) {

                new Cart(rs.getInt(1),new User(rs.getInt(2)));
            } 

         } catch (SQLException | ClassNotFoundException e) {

             e.printStackTrace();
         }

         return new Cart();
     }
    
    
    public Integer getCartId() {
        return cartId;
    }
    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public Date getCartDate() {
        return cartDate;
    }
    public void setCartDate(Date cartDate) {
        this.cartDate = cartDate;
    }
    public Integer getTotalAmount() {
        return totalAmount;
    }
    public void setTotalAmount(Integer totalAmount) {
        this.totalAmount = totalAmount;
    }
    public Integer getItemCount() {
        return itemCount;
    }
    public void setItemCount(Integer itemCount) {
        this.itemCount = itemCount;
    }
    public Integer getTotalDiscount() {
        return totalDiscount;
    }
    public void setTotalDiscount(Integer totalDiscount) {
        this.totalDiscount = totalDiscount;
    }
    public Status getStatus() {
        return status;
    }
    public void setStatus(Status status) {
        this.status = status;
    }
}
