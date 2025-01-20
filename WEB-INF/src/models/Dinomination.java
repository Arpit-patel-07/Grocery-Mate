package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Dinomination {

    private Integer dinominationId;
    private Product product;
    private Integer prise;
    private Integer weight;
    private WeightType weightType;

    public Dinomination(Integer dinominationId, Integer prise, Product product){
        this.dinominationId = dinominationId;
        this.prise = prise;
        this.product = product;
    }

    public Dinomination(Product product , Integer prise , Integer weight , WeightType weightType){

        this.product = product;
        this.prise = prise;
        this.weight = weight;
        this.weightType = weightType;

    }

    public Dinomination(Integer prise , Integer weight , WeightType weightType,Product product){
        this.prise = prise;
        this.weight = weight;
        this.weightType = weightType;
        this.product = product;
    }

    public Dinomination(Integer dinominationId, Integer prise , Integer weight , WeightType weightType,Product product){
        this.dinominationId = dinominationId;
        this.prise = prise;
        this.weight = weight;
        this.weightType = weightType;
        this.product = product;
    }

    public Dinomination(Integer prise , Product product){
        this.prise = prise;
        this.product = product;
    }

    public Dinomination(Product product){
        this.product = product;
    }

    public Dinomination(Integer dinominationId){
        this.dinominationId = dinominationId;
    }


    public Dinomination(Integer dinominationId , Integer prise , Integer weight , WeightType weightType){

        this.dinominationId = dinominationId;
        this.prise = prise;
        this.weight = weight;
        this.weightType = weightType;
    }

    public Dinomination(Integer prise , Integer weight , WeightType weightType){

        this.prise = prise;
        this.weight = weight;
        this.weightType = weightType;

    }


    public Dinomination(){

    }

    //----------------------------------CollectAllDinominationDetails()------------------------------------------------------

    public ArrayList<Dinomination> CollectAllDinominationDetails(){

        ArrayList<Dinomination> list = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gsmsdb?user=root&password=1234");
                                                              
            String query = "select dinomination_id,price,weight,weight_type_id from Dinominations where product_id = ?";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, product.getProductId());

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                
                list.add(new Dinomination(rs.getInt(1),rs.getInt(2),rs.getInt(3), new WeightType(rs.getInt(4))));
            }

        } catch (SQLException | ClassNotFoundException e) {
            
            e.printStackTrace();
        }

        return list;
    }


    public boolean SaveDinominationDetails(){

        boolean flag = false;

        try {Class.forName("com.mysql.cj.jdbc.Driver"); } catch (ClassNotFoundException e) { e.printStackTrace();}
        
        try {

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gsmsdb?user=root&password=1234");
                                                           
            String query = "insert into dinominations (product_id,price,weight,weight_type_id) value(?,?,?,?)";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, product.getProductId());
            ps.setInt(2, prise);
            ps.setInt(3, weight);
            ps.setInt(4, weightType.getWeightTypeId());

            int val = ps.executeUpdate();

            if (val == 1) {
                flag = true;
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }
        return flag;
    }


    public Integer getDinominationId() {
        return dinominationId;
    }
    public void setDinominationId(Integer dinominationId) {
        this.dinominationId = dinominationId;
    }
    public Product getProduct() {
        return product;
    }
    public void setProduct(Product product) {
        this.product = product;
    }
    public Integer getPrise() {
        return prise;
    }
    public void setPrise(Integer prise) {
        this.prise = prise;
    }
    public Integer getWeight() {
        return weight;
    }
    public void setWeight(Integer weight) {
        this.weight = weight;
    }
    public WeightType getWeightType() {
        return weightType;
    }
    public void setWeightType(WeightType weightType) {
        this.weightType = weightType;
    }
}