package Repository;

import Model.account;

import java.io.IOException;
import java.util.List;

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
}
