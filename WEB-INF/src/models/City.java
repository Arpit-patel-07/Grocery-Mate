package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class City {
    
    private Integer cityId;
    private String name;
    private State state;


    public City(){

    }

    public City(Integer cityId, String name, State state){

        this.cityId = cityId;
        this.name = name;
        this.state = state;
    }

    public City(Integer cityId){
        this.cityId = cityId;
    }

    // ###################### METHODS ############################

    public static ArrayList<City> collectAllCities(){

        ArrayList<City> list = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gsmsdb?user=root&password=1234");

            String query = "select city_id,c.name,s.name from cities as c inner join states as s where c.state_id=s.state_id";
                                                             
            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                list.add(new City(rs.getInt(1), rs.getString(2), new State(rs.getString(3))));
            }
            con.close();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return list;
    }


    public Integer getCityId(){
        return cityId;
    }

    public void setCityId(Integer cityId){
        this.cityId = cityId;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public State getState() {
        return state;
    }
    public void setState(State state) {
        this.state = state;
    }
}
