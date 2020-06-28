package Model;

public interface IUserRepository {

    void add(account user) throws Exception;

    boolean loginSuccess(String email,String password);

    String[] getUserList();



}
