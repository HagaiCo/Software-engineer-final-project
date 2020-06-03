import DButills.DBcollection;
import controller.Home_Page_FrameController;


public class runner
{

public static void main (String[] Args)
    {
        Home_Page_FrameController Home_Page_FrameController =new Home_Page_FrameController();
        Home_Page_FrameController.showHomeFrame();
        DBcollection DB = new DBcollection();
        DB.DBCreate();
    }
}

