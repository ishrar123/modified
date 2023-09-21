import org.openqa.selenium.By;

public class reusuable_keyword{
    public static void fn_verifytitle() {
        String title = driver_script.driver.getTitle();
        try {
            if (title.equalsIgnoreCase(generic_methods.vtitle)) {
                reusablefunction.fgInsertResult(driver_script.htmlresultfile, driver_script.vtestcasename, "title should be present", "title is present", "PASSED");
            } else {
                reusablefunction.fgInsertResult(driver_script.htmlresultfile, driver_script.vtestcasename, "title should be present", "title is  not present", "FAILED");
            }
        } catch (Throwable e) {

        }
    }

       public static void fn_verifyobject(String object,String objectname){
            try {
                if (driver_script.driver.findElement(By.xpath(object)).isDisplayed())
                //  if(driver_script.driver.findElements(By.name(object)).size()==1)
                {

                    driver_script.driver.findElement(By.xpath(object)).isDisplayed();
                     reusablefunction.fgInsertResult(driver_script.htmlresultfile,driver_script.vtestcasename,objectname +"should be present",objectname+"is present","PASSED");

                }
                else {
                    reusablefunction.fgInsertResult(driver_script.htmlresultfile,driver_script.vtestcasename,objectname +"should be present",objectname+"is not  present","FAILED");

                }
            }
            catch(Throwable e){

            }
    }

    public static void fn_setvalue(String object,String val)
    {
        driver_script.driver.findElement(By.name(object)).clear();
        driver_script.driver.findElement(By.name(object)).sendKeys(val);
        try {
            if (driver_script.driver.findElement(By.name(object)).getAttribute("value").equals(val)) {
                reusablefunction.fgInsertResult(driver_script.htmlresultfile, driver_script.vtestcasename, "Value Should be enter as " + val, "Values enter successfuly as " + val, "PASSED");


            } else {
                reusablefunction.fgInsertResult(driver_script.htmlresultfile, driver_script.vtestcasename, "Value Should be enter as " + val, "Values not  enter successfuly as " + val, "FAILED");

            }
        }
        catch(Throwable e){

        }

    }
    public static void fn_clickbutton(String object, String buttonname){
        try {
            if (driver_script.driver.findElements(By.name(object)).size() == 1) {

                driver_script.driver.findElement(By.name(object)).click();
                reusablefunction.fgInsertResult(driver_script.htmlresultfile, driver_script.vtestcasename, "should be successfully click on the "+buttonname, "successfully click on the  " +buttonname, "PASSED");


            } else {
                reusablefunction.fgInsertResult(driver_script.htmlresultfile, driver_script.vtestcasename, "should be successfully click on the "+buttonname, "successfully  not click on the  " +buttonname, "FAILED");

            }
        }
        catch(Throwable e){

        }
    }


}