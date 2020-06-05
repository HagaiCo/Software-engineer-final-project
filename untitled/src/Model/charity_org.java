package Model;

public class charity_org
{

    private String Charity_name;//שם של ארגון הצדקה
    private String charity_address;
    private Integer charity_phone;


    public charity_org(String charity_name, String charity_address, Integer charity_phone) {
        Charity_name = charity_name;
        this.charity_address = charity_address;
        this.charity_phone = charity_phone;
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
