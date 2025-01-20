package models;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class WeightType {
    
    private Integer weightTypeId;
    private String type;


    public WeightType(Integer weightTypeId , String type){
        this.weightTypeId = weightTypeId;
        this.type = type;
    }

    public WeightType(Integer wightTypeId){
        this.weightTypeId = wightTypeId;
    }

    public WeightType(String type){
        this.type = type;
    }

    public static ArrayList<WeightType> collectAllWeightTypes(){

        ArrayList<WeightType> list =  new ArrayList<>();
        
         try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gsmsdb?user=root&password=1234");

            String query = "select weight_type_id, type from weight_types";
                                                             
            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                list.add(new WeightType(rs.getInt(1), rs.getString(2)));
            }

            con.close();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return list;
    }


    public Integer getWeightTypeId() {
        return weightTypeId;
    }
    public void setWeightTypeId(Integer weightTypeId) {
        this.weightTypeId = weightTypeId;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
}
