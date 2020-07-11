package Model.UserRepository;

import DBUtils.FileManager;
import Model.Objects.Account;
import java.util.List;
import java.util.Objects;

public class UserRepository implements IUserRepository {

    private List<Account> users;
    private FileManager<Account> fileManager;

    //Singleton creation of this class(Lazy initialization):
    private static UserRepository SoleInstance;
    public static UserRepository getInstance() throws Exception
    {
        if (SoleInstance == null)
        {
            //if there is no instance available, create new one:
            SoleInstance = new UserRepository();
        }
        return SoleInstance;
    }
    //private constructor for singleton purpose.
    private UserRepository() throws Exception
    {
        this.fileManager = new FileManager<Account>();
        this.users = this.fileManager.read("Users");
    }

    @Override
    public void add(Account user) throws Exception
    {
        this.users.add(user);
        this.fileManager.write(this.users, "Users");
    }

    @Override
    public String GetType(String username) {
        for (Account user : users)
        {
            String userNameInFile = user.getUsername();
            if( Objects.equals(userNameInFile, username))
                return user.getType();
        }
        return null;
    }

    @Override
    public Boolean FindUser(String username)
    {
        for (Account user : users)
        {
            String userNameInDB = user.getUsername();
            if( Objects.equals(userNameInDB, username))
                return true;
        }
        return false;
    }

    @Override
    public boolean loginSuccess(String username, String password) {
        //account check =new account(username,password);
            for (Account user : users)
            {
                if( Objects.equals(user.getUsername(), username) &&  Objects.equals(user.getPassword(), password)  )
                    return  true;
            }
        return false;
        }

    @Override
    public String[] getUserList()
    {
        int i=0;
        String[] UserArr=new String[users.size()];
        for (Account user : users)
        {
            UserArr[i++]="User:" +user.getUsername()+ ", Name:"+ user.getFirstName()+" "+user.getLastName()
            +", Phone: " +user.getPhone();
        }
        return UserArr;
    }
}
