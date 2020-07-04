package Model;

public interface IUserRepository {

    void add(account user) throws Exception;

    String GetType(String username);

    boolean loginSuccess(String email, String password);

    String[] getUserList();



}
