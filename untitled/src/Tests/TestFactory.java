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

import java.io.IOException;
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

    protected static void AddNewUser(Account newAccount) throws Exception
    {
        registerController.NewUserRegistration(newAccount);
    }

    protected Boolean LoginValidation(Account account) throws Exception
    {
        Boolean result = userRepository.loginSuccess(account.getUsername(), account.getPassword());
        return result;
    }

    protected void AddedProductToDB(Products productTest) throws Exception
    {
        //Insert new product to DB:
        fileManager.WriteToCSV(productTest, "Products.csv");

        //Get all products from DB:
        String[] allProductInDB = this.fileManager.ReadFromCSV(",", "Products.csv");

        //Validate that the new product added:
        Assert.assertTrue(Arrays.asList(allProductInDB).contains(productTest.product_name));
    }

    protected int GetProductNumberFromDB() throws IOException
    {
        int numberOfProducts = organizationController.GetProductNumberFromDB("Products.csv");
        return numberOfProducts;
    }

    protected void AddProductToMyList(Products product, int index) throws IOException, ClassNotFoundException
    {
        organizationController.AddProductToMyList(product, index);
    }

    protected void RefreshList()
    {
        organizationController.RefreshList();
    }


    @AfterClass
    public static void tearDown() { }
}

