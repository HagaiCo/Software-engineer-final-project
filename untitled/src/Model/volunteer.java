package Model;

public class volunteer extends account{
    private Integer age;
    private Integer Experience;
    private boolean driving_license;

    public volunteer(String username, String password, String phone, String firstname, String lastname) {
        super(username, password, phone, firstname, lastname);
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getExperience() {
        return Experience;
    }

    public void setExperience(Integer experience) {
        Experience = experience;
    }

    public boolean isDriving_license() {
        return driving_license;
    }

    public void setDriving_license(boolean driving_license) {
        this.driving_license = driving_license;
    }
}
