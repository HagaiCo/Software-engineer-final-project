package Tests;

import Model.Objects.Account;
import Model.Objects.Products;
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
        String userName = "userName_Test";
        String password = "password_Test";
        String Mobile = "Mobile_Test";
        String firstName = "firstName_Test";
        String lastName = "lastName_Test";
        String userType = "Charity";
        Account newAccount = new Account(1, userName, password, Mobile, firstName, lastName, userType);
        AddNewUser(newAccount);

        Boolean result = userRepository.FindUser(newAccount.getUsername());
        Assert.assertTrue(result);
    }

    @Test
    @DisplayName("Validate user login functionality")
    public void LoginTest() throws Exception
    {
        String userName = "yosi";
        String password = "Yeswecan";
        String phone = "Mobile_Test";
        String firstName = "firstName_Test";
        String lastName = "lastName_Test";
        String userType = "Charity";
        Account newAccount = new Account(1, userName, password, phone, firstName, lastName, userType);
        AddNewUser(newAccount);

        boolean result = LoginValidation(newAccount);
        Assert.assertTrue(result);
    }

    @Test
    @DisplayName("Validate that user can add product to his list, the product delete from DB and updated")
    public void AddProductToMyListTest() throws Exception
    {
        String productName = "productName_Test";
        String productAmount = "productAmount_Test";
        String productExpirationDay = "productExpirationDay_Test";
        Products productTest = new Products(productName, productAmount, productExpirationDay);

        AddedProductToDB(productTest);
        int numberBefore = GetProductNumberFromDB();
        AddProductToMyList(productTest, numberBefore-1);
        RefreshList();
        int numberAfter = GetProductNumberFromDB();

        Assert.assertTrue(numberBefore == numberAfter+1);
    }
}