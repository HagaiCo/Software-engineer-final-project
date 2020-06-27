import Model.account;
import Repository.UserRepository;
import Repository.UserRepositoryImpl;
import org.junit.Test;

import java.io.IOException;


public class UnitTest {
    public UnitTest() throws IOException, ClassNotFoundException { }
    UserRepository userRepository = new UserRepositoryImpl();

    @Test
    public void LoginTest() throws Exception {
        String username = "yosi";
        String password = "Yeswecan";
        userRepository.add(new account(1, username, password, "", "", "", ""));

        Boolean result = userRepository.loginSuccess(username,password);
        assert result == true;
    }
}
