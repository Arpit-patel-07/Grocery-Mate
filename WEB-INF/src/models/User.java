package models;

import java.sql.*;

import org.jasypt.util.password.StrongPasswordEncryptor;

public class User {
    private Integer userId;
    private String name;
    private Date registration_date;
    private String email;
    private String password;
    private City city;
    private String contact;
    private Date dob;
    private String gender;
    private String address;
    private String profilePic;
    private String verificationCode;
    private Status status;
    private UserType userType;

    private static StrongPasswordEncryptor spe = new StrongPasswordEncryptor();


    // ############################## Constructors ############################

    public User(String name, String email, String password, City city, String contact,
            UserType userType) {

        this.name = name;
        this.email = email;
        this.password = password;
        this.city = city;
        this.contact = contact;
        this.userType = userType;
    }



    public User(String name, String email, String password, City city, String contact,
         UserType userType,String verificationCode,String address,Date registration_date)
     {

        this.name = name;
        this.email = email;
        this.password = password;
        this.city = city;
        this.contact = contact;
        this.userType = userType;
        this.verificationCode = verificationCode;
        this.address = address;
        this.registration_date = registration_date;
    }

    public User(String name, String email, String password, City city, String contact,
         UserType userType,String verificationCode,String address,String gender,Date dob)
     {

        this.name = name;
        this.email = email;
        this.password = password;
        this.city = city;
        this.contact = contact;
        this.userType = userType;
        this.verificationCode = verificationCode;
        this.address = address;
        this.gender = gender;
        this.dob = dob;
    }

    public User(String email, String password, UserType userType) {
        this.email = email;
        this.password = password;
        this.userType = userType;
    }

    public User(Integer userId){
        this.userId = userId;
    }


    public User(){
        
    }

    // #################################  VERIFYEMAIL METHODS ####################################

    public static boolean verifyEmail(String email, String verificationCode, Integer userTypeId){

        boolean flag = true;

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection("jdbc:mySql://localhost:3306/gsmsdb?user=root&password=1234");
                                                            
            String query = "update users set verification_Code=null,status_Id=? where email=? and verification_Code=?";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, userTypeId != 3 ? Status.EMAIL_VERIFIED:Status.ACTIVE);
            ps.setString(2, email);
            ps.setString(3, verificationCode);
           
            int val = ps.executeUpdate();

            if (val == 1) {
                flag = true;
            }

            con.close();
            
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return flag;
    }

   


// #################################  SAVECUSTOMERRECORDS METHODS ####################################

    public boolean saveCustomerRecords(){

        boolean flag = false;

        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/gsmsdb?user=root&password=1234");
            String query = "insert into users (name, email, password, contact, city_id, user_type_id, verification_Code,address,gender,dob) value (?,?,?,?,?,?,?,?,?,?)";

            PreparedStatement ps = con.prepareStatement(query , Statement.RETURN_GENERATED_KEYS);
            System.out.println("control pane - 4");
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, spe.encryptPassword(password));
            ps.setString(4, contact);
            ps.setInt(5, city.getCityId());
            ps.setInt(6, userType.getUserTypeId());
            ps.setString(7, verificationCode);
            ps.setString(8, address);
            ps.setString(9,gender);
            ps.setDate(10, dob);
            
            int val = ps.executeUpdate();

            if (val == 1) {

                flag = true;
                
                ResultSet rs = ps.getGeneratedKeys();

                    if (rs.next()) {
                        
                        userId = rs.getInt(1);
                    }
            }
            
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } 

        return flag;
    }

// #################################  SAVEUSERSRECORDS METHODS ####################################


    public boolean saveUsersRecords() {

        boolean flag = false;

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/gsmsdb?user=root&password=1234");

            String query = "insert into users (name, email, password, contact, city_id, user_type_id, verification_Code,address, registration_date) value (?,?,?,?,?,?,?,?,?)";

            PreparedStatement ps = con.prepareStatement(query , Statement.RETURN_GENERATED_KEYS);
        
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, spe.encryptPassword(password));
            ps.setString(4, contact);
            ps.setInt(5, city.getCityId());
            ps.setInt(6, userType.getUserTypeId());
            ps.setString(7, verificationCode);
            ps.setString(8, address);
            ps.setDate(9,  registration_date);

            int val = ps.executeUpdate();

            if (val == 1) {
                flag = true;
                
                ResultSet rs = ps.getGeneratedKeys();

                    if (rs.next()) {
                        userId = rs.getInt(1);
                    }
            }
            
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }     
        return flag;
    }


    // ################################# LOGIN METHODS ####################################

    public int login(){

        int result = 0; // exception generatend
    
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gsmsdb?user=root&password=1234");

            String query = "select password,user_id,u.name,c.city_id,c.name,s.state_id,s.name,contact," + 
            "dob,gender,address,profile_pic,status_id,registration_date from users as u inner join cities as c inner join " + 
            "states as s where c.state_id=s.state_id and u.city_id=c.city_id and email=?";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, email);

            ResultSet rs = ps.executeQuery();

            if(rs.next()) {

                 if (spe.checkPassword(password, rs.getString(1)) ) {
                    
                    userId = rs.getInt(2);
                    name = rs.getString(3);
                    city = new City(rs.getInt(4), rs.getString(5), new State(rs.getInt(6), rs.getString(7)));
                    contact = rs.getString(8);
                    dob = rs.getDate(9);
                    gender = rs.getString(10);
                    address = rs.getString(11);
                    profilePic = rs.getString(12);
                    status = new Status(rs.getInt(13));
                    registration_date = rs.getDate(14);
                    
                    result = 3; // Login succces
                    
                }else{
                    result = 2; // Incorect Password
                }
            }else{
                result = 1; // account with the given email does not exist
            }
        } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
        }
        return result;
    }


    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getRegistration_date() {
        return registration_date;
    }

    public void setRegistration_date(Date registration_date) {
        this.registration_date = registration_date;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(String profilePic) {
        this.profilePic = profilePic;
    }

    public String getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;

    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

}