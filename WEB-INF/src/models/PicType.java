package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PicType {
    
    private Integer picTypeId;
    private String type;


    public PicType(Integer picTypeId, String type){
        this.picTypeId = picTypeId;
        this.type = type;
    }

    public PicType(Integer picTypeId){
        this.picTypeId = picTypeId;
    }

    public static ArrayList<PicType> collectAllPicType(){

        ArrayList<PicType> list = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gsmsdb?user=root&password=1234");

            String query = "select pic_type_id, type from pic_types";
                                                             
            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                list.add(new PicType(rs.getInt(1), rs.getString(2)));
            }
            con.close();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
    
    public Integer getPicTypeId() {
        return picTypeId;
    }
    public void setPicTypeId(Integer picTypeId) {
        this.picTypeId = picTypeId;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
}
