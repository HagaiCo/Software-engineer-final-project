package Tests;

import Controller.OrganizationController;
import Controller.RegisterController;
import DBUtils.FileManager;
import Model.IOrganizationModel;
import Model.Objects.Account;
import Model.Objects.Products;
import Model.OrganizationModel;
import Model.RegisterModel;
import Model.UserRepository.IUserRepository;
import Model.UserRepository.UserRepository;
import View.RegisterView;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;

import java.util.Arrays;

public class TestFactory {
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

        fileManager = new FileManager<Products>();
    }

    protected Boolean RegisterValidation() throws Exception {
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

    protected Boolean LoginValidation() throws Exception {
        String username = "yosi";
        String password = "Yeswecan";
        userRepository.add(new Account(1, username, password, "", "", "", "", ""));
        Boolean result = userRepository.loginSuccess(username, password);
        return result;
    }

    protected boolean AddedProductUpdateInDB() throws Exception
    {
        //mock data:
        String productName = "productName_Test";
        String productAmount = "productAmount_Test";
        String productExpirationDay = "productExpirationDay_Test";
        Products productTest = new Products(productName, productAmount, productExpirationDay);

        //write mock data to DB and validate it's indeed written:
        fileManager.WriteToCSV(productTest, "Products.csv");
        String[] allProductInDB = this.fileManager.ReadFromCSV(",", "Products.csv");

        Assert.assertTrue(Arrays.asList(allProductInDB).contains(productName));

        int numberBefore = organizationController.GetProductNumberInDB("Products.csv");

        //Add product to the user list and refresh the main products list:
        organizationController.AddProductToMyList(productTest, numberBefore-1);
        organizationController.RefreshList();

        int numberAfter= organizationController.GetProductNumberInDB("Products.csv");

        //validate that the product remove from db and added to user list:
        return numberBefore == numberAfter+1;
    }

    @AfterClass
    public static void tearDown() { }
}

