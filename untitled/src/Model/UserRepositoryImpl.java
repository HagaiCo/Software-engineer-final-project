package Model;

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
        //account check =new account(username,password);
            for (account user : users) {
                System.out.println(user.getUsername()+ "==" + username);
                System.out.println(user.getPassword()+ "==" + password);
                if( Objects.equals(user.getUsername(), username) &&  Objects.equals(user.getPassword(), password)  )
                    return  true;
            }
        return false;
        }

    @Override
    public String[] getUserList() {
        int i=0;
        String[] UserArr=new String[users.size()];
        for (account user : users) {
            UserArr[i++]="User:" +user.getUsername()+ ", Name:"+ user.getFirstname()+" "+user.getLastname()
            +", Phone: " +user.getPhone();
        }
        return UserArr;
        }

}