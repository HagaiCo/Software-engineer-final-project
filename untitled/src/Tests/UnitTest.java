package Tests;

import Model.IUserRepository;
import Model.UserRepositoryImpl;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class UnitTest extends TestFactory
{
    public UnitTest() throws IOException, ClassNotFoundException { }
    IUserRepository userRepository = new UserRepositoryImpl();

    @Test
    public void RegisterTest() throws Exception
    {
        boolean result = RegisterValidation();
        Assert.assertTrue(result);
    }

    @Test
    public void LoginTest() throws Exception
    {
        boolean result = LoginValidation();
        Assert.assertTrue(result);
    }

    @Test
    public void AddProductToMyListTest() throws Exception
    {
        boolean result = AddProductToMyListValidation();
        Assert.assertTrue(result);
    }
}
