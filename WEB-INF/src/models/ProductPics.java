package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductPics {
    
    private Integer productPicId;
    private Product product;
    private String picPath;
    private PicType picType;

    public ProductPics(Product product , String picPath, PicType picType){

        this.product = product;
        this.picPath = picPath;
        this.picType = picType;
    }
    
    public boolean SaveProductPics(){

        boolean flag = false;

         try {
               Class.forName("com.mysql.cj.jdbc.Driver");

               Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gsmsdb?user=root&password=1234");

               String query = "insert into product_pics (product_id,pic_path,pic_type_id) value(?,?,?)";

               PreparedStatement ps = con.prepareStatement(query);

                ps.setInt(1, product.getProductId());
                ps.setString(2, picPath);
                ps.setInt(3, picType.getPicTypeId());
               
               int val = ps.executeUpdate();

               if(val == 1){
                    flag = true;
               }
            
        }catch(SQLException | ClassNotFoundException e){

            e.printStackTrace();
        }
        return flag;
    }

    public static String getProductPicPath(Integer productId){

            String productPicPath = null;
    
            try { Class.forName("com.mysql.cj.jdbc.Driver"); } catch(ClassNotFoundException e ) { e.printStackTrace(); }
        
            try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gsmsdb?user=root&password=1234")) { 
                
                String query = "select pic_path from product_pics where product_id=?";
                
                PreparedStatement ps = con.prepareStatement(query);
                
                ps.setInt(1, productId);
    
                ResultSet rs =   ps.executeQuery();
    
                if(rs.next()) {
                    productPicPath = rs.getString(1);
                }

            } catch(SQLException e) {
                e.printStackTrace();
            }
    
            return productPicPath;    
    }


    public Integer getproductPicId() {
        return productPicId;
    }
    public void setproductPicId(Integer productPicId) {
        this.productPicId = productPicId;
    }
    public Product getProduct() {
        return product;
    }
    public void setProduct(Product product) {
        this.product = product;
    }
    public String getPicPath() {
        return picPath;
    }
    public void setPicPath(String picPath) {
        this.picPath = picPath;
    }
    public PicType getPicType() {
        return picType;
    }
    public void setPicType(PicType picType) {
        this.picType = picType;
    }
}
