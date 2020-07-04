package Tests;

import Model.IUserRepository;
import Model.UserRepositoryImpl;
import Model.account;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;


public class UnitTest {
    public UnitTest() throws IOException, ClassNotFoundException { }
    IUserRepository userRepository = new UserRepositoryImpl();

    @Test
    public void LoginTest() throws Exception {
        String username = "yosi";
        String password = "Yeswecan";
        userRepository.add(new account(1, username, password, "", "", "", "",""));

        Boolean result = userRepository.loginSuccess(username,password);
        Assert.assertTrue(result);
    }
}
