package Model;

public interface ILoginModel
{
    boolean validateUser(String username, String password);

    String GetUserType(String username);
}
