package Model;

public class retail_account extends account {


    private retail_org retail_org; //שייוך המשתמש לחברה


    public retail_account(String username, String password, String phone, String firstname, String lastname) {
        super(username, password, phone, firstname, lastname);

    }

    public Model.retail_org getRetail_org() {
        return retail_org;
    }

    public void setRetail_org(Model.retail_org retail_org) {
        this.retail_org = retail_org;
    }
}
