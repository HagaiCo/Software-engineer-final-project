package Tests;

import Model.UserRepository.IUserRepository;
import Model.UserRepository.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

public class UnitTest extends TestFactory
{
    public UnitTest() throws Exception { }
    IUserRepository userRepository = UserRepository.getInstance();

    @Test
    @DisplayName("Validate user registration functionality")
    public void RegisterTest() throws Exception
    {
        boolean result = RegisterValidation();
        Assert.assertTrue(result);
    }

    @Test
    @DisplayName("Validate user login functionality")
    public void LoginTest() throws Exception
    {
        boolean result = LoginValidation();
        Assert.assertTrue(result);
    }

    @Test
    @DisplayName("Validate that user can add product to his list, the product delete from DB and updated")
    public void AddProductToMyListTest() throws Exception
    {
        boolean result = AddedProductUpdateInDB();
        Assert.assertTrue(result);
    }
}