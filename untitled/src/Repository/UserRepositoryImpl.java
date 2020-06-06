package Repository;

import Model.account;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class UserRepositoryImpl implements UserRepository{

    private List<account> users;
    private FileManager<account> fileManager;

    public UserRepositoryImpl() throws IOException, ClassNotFoundException {
        this.fileManager = new FileManager<account>("users");

        this.users = this.fileManager.read();
    }


    @Override
    public void add(account user) throws Exception{
        this.users.add(user);
        this.fileManager.write(this.users);

    }

    @Override
    public boolean loginSuccess(String username, String password) {
        account check =new account(username,password);
            for (account user : users) {
                System.out.println(user.getUsername()+ "==" + check.getUsername());
                System.out.println(user.getPassword()+ "==" + check.getPassword());
                if( Objects.equals(user.getUsername(), check.getUsername()) &&  Objects.equals(user.getPassword(), check.getPassword())  )

                    return  true;
            }
        return false;
        }
}
