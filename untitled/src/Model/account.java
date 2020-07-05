
package Model;

import java.io.Serializable;
import java.sql.*;

public class account implements Serializable
{
    private int id;
    private String username;//שם משתמש
    private String password;//סיסמא
    private String phone;//מספר טלפון
    private String firstname;//שם פרטי
    private String lastname;//שם משפחה
    private String email;
    private String type;



    public account(int id, String username, String password, String phone, String firstname, String lastname, String email,String type) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.type=type;
    }

    public account(String username, String password,String type) {
        this.username = username;
        this.password = password;
        this.type=type;
    }

    public String getType() { return type; }

    public void setType(String type) {
        this.type = type;
    }

    public String getUsername()
    {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        phone = phone;
    }

    public String getFirstName() {
        return this.firstname;
    }

    public void setFirstName(String firstname) {
        this.firstname = firstname;
    }

    public String getLastName() {
        return lastname;
    }

    public void setLastName(String lastname) {
        this.lastname = lastname;
    }




    public Boolean ValidateLoginRequest (String Username, String pass) throws SQLException
    {
        String windownsUserName = System.getProperty("user.name");
        try
        {
            System.out.println("Connecting to a selected database...");
            Connection connection = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\"+windownsUserName+"\\IdeaProjects\\Software-engineer-final-project\\untitled\\src\\DButills\\account.db");
            System.out.println("Connected database successfully...");
            String sqlQuary = "SELECT username FROM accounts WHERE username = '"+Username+"' AND pass = '"+pass+"'";
            PreparedStatement ps = connection.prepareStatement(sqlQuary);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                System.out.println("you have successfully logged in to " + rs.getString("username") + "\n");
                ps.close();
                connection.close();
                return true;
            }
            else {
                System.out.println("The user or the password doesn't match!");
                ps.close();
                connection.close();
                return false;
            }
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
