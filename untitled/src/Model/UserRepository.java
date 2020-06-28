package Model;

import Model.account;

import java.util.List;

public interface UserRepository {

    void add(account user) throws Exception;

    boolean loginSuccess(String email,String password);

    String[] getUserList();



}
