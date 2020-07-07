package Tests;

import DBUtils.FileManager;
import Model.Objects.Account;
import Model.Objects.Products;
import Model.UserRepository.IUserRepository;
import Model.UserRepository.UserRepository;
import Model.*;
import controller.OrganizationController;
import controller.RegisterController;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import view.RegisterView;

public class TestFactory
{
    static IUserRepository userRepository;
    static IOrganizationModel organizationModel;
    static OrganizationController organizationController;

    static RegisterController registerController;
    static RegisterModel registerModel;
    static RegisterView registerView;

    static FileManager<Products> fileManager;

    public TestFactory() throws Exception {
        oneTimeSetUp();
    }

    @BeforeClass
    public static void oneTimeSetUp() throws Exception {
        //one-time initialization code:
        userRepository = UserRepository.getInstance();
        organizationModel = new OrganizationModel();
        organizationController = new OrganizationController();
        registerModel = new RegisterModel();
        registerView = new RegisterView();
        registerController = new RegisterController(registerModel, registerView);

    }

    protected Boolean RegisterValidation() throws Exception
    {
        String userName = "userName_Test";
        String password = "password_Test";
        String Mobile = "Mobile_Test";
        String firstName = "firstName_Test";
        String lastName = "lastName_Test";
        String address = "address_Test";
        String userType = "Charity";
        registerController.NewUserRegistration(userName, password, Mobile, firstName, lastName, address, userType);
        Boolean result = userRepository.loginSuccess(userName, password);
        return result;
    }

    protected Boolean LoginValidation() throws Exception
    {
        String username = "yosi";
        String password = "Yeswecan";
        userRepository.add(new Account(1, username, password, "", "", "", "", ""));
        Boolean result = userRepository.loginSuccess(username, password);
        return result;
    }

    protected boolean AddProductToMyListValidation() throws Exception
    {
        String productName = "productName_Test";
        String productAmount = "productAmount_Test";
        String productExpirationDay = "productExpirationDay_Test";
        Products productTest = new Products(productName, productAmount, productExpirationDay);

        organizationModel.AddProduct(productTest);
        String[] ProductList = organizationModel.getAddedList();
        boolean result = ProductList[0].contains(productName);
        return result;
    }

    @AfterClass
    public static void tearDown() { }
}

