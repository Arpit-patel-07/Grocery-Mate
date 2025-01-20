package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Product extends Category {

     private Integer productId;
     private String name;
     private Integer shelf_Life;
     private User user;
     private String brand_Name;
     private String storage_Info;
     private String packaging;
     private Category category;

     public Product() {

     }

     public Product(Category category) {
          this.category = category;
     }

     public Product(Integer productId, String name) {
          this.productId = productId;
          this.name = name;
     }

     public Product(Integer productId) {
          this.productId = productId;
     }

     public Product(String brand_Name, Integer productId, String name) {
          this.brand_Name = brand_Name;
          this.productId = productId;
          this.name = name;
     }

     public Product(String brand_Name, String storage_Info, String packaging, Integer productId, String name) {

          this.brand_Name = brand_Name;
          this.storage_Info = storage_Info;
          this.packaging = packaging;
          this.productId = productId;
          this.name = name;
     }

     public Product(String name, Integer shelf_Life, User user, String brand_Name, String storage_Info,
               String packaging, Category category) {

          this.name = name;
          this.shelf_Life = shelf_Life;
          this.user = user;
          this.brand_Name = brand_Name;
          this.storage_Info = storage_Info;
          this.packaging = packaging;
          this.category = category;
     }

     public Product(Integer shelf_Life, User user, String brand_Name, String storage_Info, String packaging,
               Category category) {

          this.shelf_Life = shelf_Life;
          this.user = user;
          this.brand_Name = brand_Name;
          this.storage_Info = storage_Info;
          this.packaging = packaging;
          this.category = category;
     }

     public Product(Integer productId, String name, Integer shelf_Life, User user, String brand_Name,
               String storage_Info, String packaging, Category category) {

          this.productId = productId;
          this.name = name;
          this.shelf_Life = shelf_Life;
          this.user = user;
          this.brand_Name = brand_Name;
          this.storage_Info = storage_Info;
          this.packaging = packaging;
          this.category = category;
     }

     public boolean saveProductDetails() {

          boolean flag = false;

          try {

               Class.forName("com.mysql.cj.jdbc.Driver");

               Connection con = DriverManager
                         .getConnection("jdbc:mysql://localhost:3306/gsmsdb?user=root&password=1234");

               String query = "insert into products (shelf_Life,user_id,brand_Name,storage_Info,packaging,catagory_id,name) value(?,?,?,?,?,?,?)";

               PreparedStatement ps = con.prepareStatement(query);

               ps.setInt(1, shelf_Life);
               ps.setInt(2, user.getUserId());
               ps.setString(3, brand_Name);
               ps.setString(4, storage_Info);
               ps.setString(5, packaging);
               ps.setInt(6, category.getCategoryId());
               ps.setString(7, name);

               int val = ps.executeUpdate();

               if (val == 1) {
                    flag = true;
               }

          } catch (SQLException | ClassNotFoundException e) {

               e.printStackTrace();
          }

          return flag;
     }

     public static ArrayList<Product> CollectAllProducts(Integer category_id) {

          ArrayList<Product> products = new ArrayList<>();

          try {

               Class.forName("com.mysql.cj.jdbc.Driver");

               Connection con = DriverManager
                         .getConnection("jdbc:mysql://localhost:3306/gsmsdb?user=root&password=1234");

               String query = "select * from products where catagory_id = ?";

               PreparedStatement ps = con.prepareStatement(query);

               ps.setInt(1, category_id);

               ResultSet rs = ps.executeQuery();

               while (rs.next()) {

                    products.add(new Product(rs.getInt("product_id"), rs.getString("name"), rs.getInt("shelf_life"),
                              new User(rs.getInt("user_id")),
                              rs.getString("brand_name"), rs.getString("storage_info"), rs.getString("packaging"),
                              new Category(rs.getInt("catagory_id"))));
               }

          } catch (SQLException | ClassNotFoundException e) {

               e.printStackTrace();
          }

          return products;
     }

     public Integer getProductId() {
          return productId;
     }

     public void setProductId(Integer productId) {
          this.productId = productId;
     }

     public Integer getShelf_Life() {
          return shelf_Life;
     }

     public void setShelf_Life(Integer shelf_Life) {
          this.shelf_Life = shelf_Life;
     }

     public User getUser() {
          return user;
     }

     public void setUser(User user) {
          this.user = user;
     }

     public String getBrand_Name() {
          return brand_Name;
     }

     public void setBrand_Name(String brand_Name) {
          this.brand_Name = brand_Name;
     }

     public String getName() {
          return name;
     }

     public void setName(String name) {
          this.name = name;
     }

     public String getStorage_Info() {
          return storage_Info;
     }

     public void setStorage_Info(String storage_Info) {
          this.storage_Info = storage_Info;
     }

     public String getPackaging() {
          return packaging;
     }

     public void setPackaging(String packaging) {
          this.packaging = packaging;
     }

     public Category getCategory() {
          return category;
     }

     public void setCategory(Category category) {
          this.category = category;
     }
}
