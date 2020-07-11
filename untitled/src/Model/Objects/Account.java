
package Model.Objects;

import java.io.Serializable;

public class Account implements Serializable
{
    private int id;
    private String username;//שם משתמש
    private String password;//סיסמא
    private String phone;//מספר טלפון
    private String firstname;//שם פרטי
    private String lastname;//שם משפחה
    private String email;
    private String type;

    public Account(int id, String username, String password, String phone, String firstName, String lastName, String type) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.firstname = firstName;
        this.lastname = lastName;
        this.type=type;
    }

    public Account(String username, String password, String type) {
        this.username = username;
        this.password = password;
        this.type=type;
    }

    public Account(Account newAccount)
    {
        this.id = newAccount.getId();
        this.username = newAccount.getUsername();
        this.password = newAccount.getPassword();
        this.phone = newAccount.getPhone();
        this.firstname = newAccount.getFirstName();
        this.lastname = newAccount.getLastName();
        this.type = newAccount.getType();
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() { return id; }

    public void setId(int id) {
        this.id = id;
    }
}
