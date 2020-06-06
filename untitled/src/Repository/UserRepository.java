package Repository;

import Model.account;
public interface UserRepository {

    void add(account user) throws Exception;

    boolean loginSuccess(String email,String password);




}
