package Model;

public class charity_account extends account
{
    private charity_org charity;

    public charity_account(String username, String password, String phone, String firstname, String lastname) {
        super(username, password, phone, firstname, lastname);

    }

    public charity_org getCharity() {
        return charity;
    }

    public void setCharity(charity_org charity) {
        this.charity = charity;
    }
}
