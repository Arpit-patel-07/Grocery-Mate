package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;

public class SellerProducts {
    
    private Integer sellerProductId;
    private User user;
    private Dinomination dinomination;
    private Integer quantity;
    private Integer discount;
    private Integer sold;
    private Date recordDate;

    public SellerProducts(Integer sellerProductId , User user , Dinomination dinomination , Integer quantity ,
    Integer discount , Integer sold , Date recordDate){

        this.sellerProductId = sellerProductId;
        this.user = user;
        this.dinomination = dinomination;
        this.quantity = quantity;
        this.discount = discount;
        this.sold = sold;
        this.recordDate = recordDate;
    }

    public SellerProducts(Integer sellerProductId,Integer quantity,Integer discount, Dinomination dinomination){
        this.sellerProductId = sellerProductId;
        this.quantity = quantity;
        this.discount = discount;
        this.dinomination = dinomination;
    }

    public SellerProducts(User user , Dinomination dinomination , Integer quantity ,
    Integer discount , Integer sold, Date recordDate){

        this.user = user;
        this.dinomination = dinomination;
        this.quantity = quantity;
        this.discount = discount;
        this.sold = sold;
        this.recordDate = recordDate;
    }

    public SellerProducts(Integer sellerProductId, Integer quantity ,
    Integer discount , Integer sold, Date recordDate,Dinomination dinomination ){

        this.sellerProductId = sellerProductId;
        this.dinomination = dinomination;
        this.quantity = quantity;
        this.discount = discount;
        this.sold = sold;
        this.recordDate = recordDate;
    }


    public SellerProducts(Integer quantity ,
    Integer discount , Integer sold, Date recordDate,Dinomination dinomination ){

        this.dinomination = dinomination;
        this.quantity = quantity;
        this.discount = discount;
        this.sold = sold;
        this.recordDate = recordDate;
    }

    public SellerProducts(Integer quantity,
    Integer discount , Integer sold, Date recordDate){

        this.quantity = quantity;
        this.discount = discount;
        this.sold = sold;
        this.recordDate = recordDate;
    }

    public SellerProducts(Integer sellerProductId,Dinomination dinomination){
        this.sellerProductId = sellerProductId;
        this.dinomination = dinomination;
    }



    public SellerProducts(User user){
        this.user = user;
    }

    public SellerProducts(){

    }

    public SellerProducts(Integer sellerProductId){
        this.sellerProductId = sellerProductId;
    }

    public SellerProducts(Integer sellerProductId , Integer discount, Dinomination dinomination){
        this.sellerProductId = sellerProductId;
        this.discount = discount;
        this.dinomination = dinomination;
    }

     //**************************************SaveSellerProductDetails Method********************************************** 


    public static SellerProducts collectProductInformation(Integer product_id){

        try {Class.forName("com.mysql.cj.jdbc.Driver"); } catch (ClassNotFoundException e) { e.printStackTrace();}
        
        try {

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gsmsdb?user=root&password=1234");
                                                             
            String query = "select s.seller_product_id,s.discount,d.dinomination_id,d.price,p.product_id,p.name from seller_products as s inner join dinominations as d inner join products as p  where s.dinomination_id = d.dinomination_id and d.product_id = p.product_id and p.product_id =?";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, product_id);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                
                return new SellerProducts(rs.getInt(1),rs.getInt(2),new Dinomination(rs.getInt(3),rs.getInt(4),new Product(rs.getInt(5),rs.getString(6))));
            }
        }
        catch(SQLException e){

            e.printStackTrace();
        }
        return null;
    }


    // **************************************SaveSellerProductDetails Method********************************************** 

     public boolean SaveSellerProductDetails(){

        boolean flag = false;
                                     
        try {Class.forName("com.mysql.cj.jdbc.Driver"); } catch (ClassNotFoundException e) { e.printStackTrace();}
        
        try {

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gsmsdb?user=root&password=1234");
                                                             
            String query = "insert into seller_products (user_id,dinomination_id,quantity,discount,sold ,record_date) value(?,?,?,?,?,?)";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, user.getUserId());
            ps.setInt(2, dinomination.getDinominationId());
            ps.setInt(3, quantity);
            ps.setInt(4, discount);
            ps.setInt(5, sold);
            ps.setDate(6, recordDate);

            int val = ps.executeUpdate();

            if (val == 1) {
                flag = true;
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }
        
        return flag;
    }

     //************************************** collectAllSellerProductDetails Method********************************************** 

    public  ArrayList<SellerProducts> collectAllSellerProductDetails(Integer user_id){

        ArrayList<SellerProducts> list = new ArrayList<>();

        try {Class.forName("com.mysql.cj.jdbc.Driver"); } catch (ClassNotFoundException e) { e.printStackTrace();}
        
        try {

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gsmsdb?user=root&password=1234");
                                                             
            String query = "select s.quantity,s.discount,s.sold,s.record_date,d.dinomination_id,d.price,d.weight,d.weight_type_id,p.brand_name,p.storage_info,p.packaging,p.product_id,p.name from seller_products as s inner join dinominations as d inner join products as p  where s.dinomination_id = d.dinomination_id and d.product_id = p.product_id and s.user_id =?";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, user_id);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                
                list.add(new SellerProducts(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getDate(4),new Dinomination(rs.getInt(5),rs.getInt(6),rs.getInt(7),new WeightType(rs.getInt(8)),new Product(rs.getString(9),rs.getString(10),rs.getString(11),rs.getInt(12),rs.getString(13)))));
            }
        }
        catch(SQLException e){

            e.printStackTrace();
        }
        return list;
    }

   // ************************************** collectAllProductDetails Method********************************************** 

    public static  SellerProducts collectAllProductDetails (Integer product_id){

        try {Class.forName("com.mysql.cj.jdbc.Driver"); } catch (ClassNotFoundException e) { e.printStackTrace();}
        
        try {

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gsmsdb?user=root&password=1234");
                                                             
            String query = "select s.quantity,s.discount,s.sold,s.record_date,d.dinomination_id,d.price,d.weight,d.weight_type_id,p.brand_name,p.storage_info,p.packaging,p.product_id,p.name from seller_products as s inner join dinominations as d inner join products as p  where s.dinomination_id = d.dinomination_id and d.product_id = p.product_id and p.product_id =?";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, product_id);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                
                return new SellerProducts(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getDate(4),new Dinomination(rs.getInt(5),rs.getInt(6),rs.getInt(7),new WeightType(rs.getInt(8)),new Product(rs.getString(9),rs.getString(10),rs.getString(11),rs.getInt(12),rs.getString(13))));
            }
        }
        catch(SQLException e){

            e.printStackTrace();
        }
        return null;
    }


     //************************************** collectAllSellerProduct Method********************************************** 


    public  ArrayList<SellerProducts> collectAllSellerProduct(Integer start){


        ArrayList<SellerProducts> list = new ArrayList<>();

        try {Class.forName("com.mysql.cj.jdbc.Driver"); } catch (ClassNotFoundException e) { e.printStackTrace();}
        
        try {

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gsmsdb?user=root&password=1234");
                                                             
            String query = "select s.seller_product_id,s.quantity,s.discount,s.sold,s.record_date,d.price,d.weight,d.weight_type_id,p.brand_name,p.storage_info,p.packaging,p.product_id,p.name from seller_products as s inner join dinominations as d inner join products as p  where s.dinomination_id = d.dinomination_id and d.product_id = p.product_id limit ?,4";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, start);

          //  ps.setInt(1 ,start);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                
                list.add(new SellerProducts(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getInt(4),rs.getDate(5),new Dinomination(rs.getInt(6),rs.getInt(7),new WeightType(rs.getInt(8)),new Product(rs.getString(9),rs.getString(10),rs.getString(11),rs.getInt(12) ,rs.getString(13)))));
            }
        }

        catch(SQLException e){

            e.printStackTrace();
        }
        return list;
    }



    public static ArrayList<SellerProducts> CollectAllProducts(Integer category_id){

        ArrayList<SellerProducts> list = new ArrayList<>();

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gsmsdb?user=root&password=1234");

            String query = "select s.seller_product_id,s.quantity,s.discount,s.sold,s.record_date,d.price,d.weight,d.weight_type_id,p.brand_name,p.storage_info,p.packaging,p.product_id,p.name from seller_products as s inner join dinominations as d inner join products as p  where s.dinomination_id = d.dinomination_id and d.product_id = p.product_id and p.catagory_id = ?";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, category_id);

            ResultSet rs  = ps.executeQuery();

            while (rs.next()) {

                list.add(new SellerProducts(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getInt(4),rs.getDate(5),new Dinomination(rs.getInt(6),rs.getInt(7),new WeightType(rs.getInt(8)),new Product(rs.getString(9),rs.getString(10),rs.getString(11),rs.getInt(12),rs.getString(13)))));

            } 
                                                         
        } catch (SQLException | ClassNotFoundException e) {
            
            e.printStackTrace();
        }
        
        return list;
    }


    public Integer getSellerProductId() {
        return sellerProductId;
    }
    public void setSellerProductId(Integer sellerProductId) {
        this.sellerProductId = sellerProductId;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public Dinomination getDinomination() {
        return dinomination;
    }
    public void setDinomination(Dinomination dinomination) {
        this.dinomination = dinomination;
    }
    public Integer getQuantity() {
        return quantity;
    }
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
    public Integer getDiscount() {
        return discount;
    }
    public void setDiscount(Integer discount) {
        this.discount = discount;
    }
    public Integer getSold() {
        return sold;
    }
    public void setSold(Integer sold) {
        this.sold = sold;
    }
    public Date getRecordDate() {
        return recordDate;
    }
    public void setRecordDate(Date recordDate) {
        this.recordDate = recordDate;
    }    
}
