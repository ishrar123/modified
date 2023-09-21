import org.openqa.selenium.WebElement;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

public class generic_methods {
    public static String vObjString;
    public static List<WebElement> elem;
    public static String vtitle,vobject,vusername,vpassword,vlogin,username,password;
    public static String username1,password1;

    public void keyworddriver(String Keyword, Xls_Reader xscenariofile, int m) throws IOException {
        //username
        username1 = driver_script.xmodfile.getCellData("Login", "username", driver_script.k);
        System.out.println(username1);
        //password
        //password1 = xl.getCellData("Login", "password", i);

        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\ObjectRepository\\or.properties");
        prop.load(fis);

        switch (Keyword) {
            case "fn_launchapplication":
                reusablefunction.fn_launchapplication();

                break;

            case "fn_verifytitle":
                vtitle= xscenariofile.getCellData("sheet1","Parameters",m);
                System.out.println(vtitle);
                reusuable_keyword.fn_verifytitle();
                break;

            case "fn_verifyobject":
                vobject=prop.getProperty(xscenariofile.getCellData("sheet1","objectsname",m));
                System.out.println(vobject);
                reusuable_keyword.fn_verifyobject(vobject,"app logo");
                reusuable_keyword.fn_verifyobject(vobject,"keymodule");
                 break;

            case "fn_setvalue":
                vusername=prop.getProperty(xscenariofile.getCellData("sheet1","objectsname",m));
                vpassword=prop.getProperty(xscenariofile.getCellData("sheet1","objectsname2",m));
//                username=driver_script.xmodfile.getCellData(driver_script.vmodulename,"username",m);
//                System.out.println(username);
                password=driver_script.xmodfile.getCellData("Login","password",driver_script.k);
                System.out.println(password);

                reusuable_keyword.fn_setvalue(vusername,username1);
                reusuable_keyword.fn_setvalue(vpassword,password);

            case "fn_clickbutton":
                vobject=prop.getProperty(xscenariofile.getCellData("sheet1","objectsname",m));
                System.out.println(vobject);
                reusuable_keyword.fn_clickbutton(vobject,"login button");




                break;




        }


    }
}
