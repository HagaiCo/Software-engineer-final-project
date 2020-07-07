package Tests;

import Model.UserRepository.IUserRepository;
import Model.UserRepository.UserRepository;
import org.junit.Assert;
import org.junit.Test;

public class UnitTest extends TestFactory
{
    public UnitTest() throws Exception { }
    IUserRepository userRepository = UserRepository.getInstance();

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
