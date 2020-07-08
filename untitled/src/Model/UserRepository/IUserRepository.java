package Model.UserRepository;

import Model.Objects.Account;

public interface IUserRepository {

    void add(Account user) throws Exception;

    String GetType(String username);

    Boolean FindUser(String username);

    boolean loginSuccess(String email, String password);

    String[] getUserList();

}
