package Model;

public class charity_org extends account
{

    private String Charity_name;//שם של ארגון הצדקה
    private String charity_address;
    private Integer charity_phone;


    public charity_org(String username, String password, String phone, String firstname, String lastname) {
        super(username, password, phone, firstname, lastname);
    }

    public String getCharity_name() {
        return Charity_name;
    }

    public void setCharity_name(String charity_name) {
        Charity_name = charity_name;
    }

    public String getCharity_address() {
        return charity_address;
    }

    public void setCharity_address(String charity_address) {
        this.charity_address = charity_address;
    }

    public Integer getCharity_phone() {
        return charity_phone;
    }

    public void setCharity_phone(Integer charity_phone) {
        this.charity_phone = charity_phone;
    }
}
