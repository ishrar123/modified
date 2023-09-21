import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class reusablefunction{

    //function to launch the application
    public static void  fn_launchapplication(){
        WebDriverManager.chromedriver().setup();
        driver_script.driver=new ChromeDriver();
        driver_script.driver.get(driver_script.vprojecturl);
        driver_script.driver.manage().window().maximize();
    }

    //function for entering the values


    public static String CreateHTMLResultfile()
    {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date =new Date();
        String TempFileName =dateFormat.format(date);
        String NewFileName1 =TempFileName.replace("/","_");
        String NewFileName2 =NewFileName1.replace(" ","_");
        String NewFileName = NewFileName2.replace(":","_");
        String filename = System.getProperty("user.dir")+"\\src\\test\\Results\\vTiger_Result"+"_"+NewFileName+".html" ;
        File f = new File(filename);
        try
        {
            f.createNewFile();
        }
        catch(Throwable t)
        {

        }

        return filename;
    }

    public static void CreatecolumnHtmlResult(String filepath)
    {
        try
        {
            FileWriter w = new FileWriter(filepath);
            BufferedWriter ts = new BufferedWriter(w);
            ts.write ("<HTML>");
            ts.write ("<head><link href='Result_JS_CSS/tablecloth.css' rel='stylesheet' type='text/css' media='screen' />");
            ts.write ("<script type='text/javascript' src='https://www.gstatic.com/charts/loader.js'></script>");
            ts.write ("<script type='text/javascript' src='Result_JS_CSS/tablecloth.js'></script>");
            ts.write ("</head>");
            ts.write ("<BODY>");
            ts.write ("<TABLE>");
            ts.write ("<TBODY>");
            ts.write ("<TR>");
            ts.write ("<th colspan=8>Testing Experts Automation Result</th>");
            ts.write ("</TR>");
            ts.write ("<TR>");
            ts.write ("<TD colspan=8>");
            ts.write ("<TABLE>");
            ts.write ("<TBODY>");
            ts.write ("<TR>");
            ts.write ("<TD>");
            ts.write ("<TABLE BGCOLOR=WHITE>");
            ts.write ("<TBODY>");
            ts.write ("<TR>");
            ts.write ("<th>Project Name</th>");
            ts.write ("<th>"+"vTiger Test Automation"+"</th>");
            ts.write ("</TR>");
            ts.write ("<TR>");
            ts.write ("<th>Execution Start</th>");
            ts.write ("<th><div id='exestart'></div></th>");
            ts.write ("</TR>");
            ts.write ("<TR>");
            ts.write ("<th>Execution End</th>");
            ts.write ("<th><div id='exeend'></div></th>");
            ts.write ("</TR>");
            ts.write ("<TR>");
            ts.write ("<th>Total Execution Time(Sec)</th>");
            ts.write ("<th><div id='totexec'></div></th>");
            ts.write ("</TR>");
            ts.write ("</TBODY>");
            ts.write ("</TABLE>");
            ts.write ("</TD>");
            ts.write ("<TD style='width: 300px; height: 200px;'>");
            ts.write ("<TABLE BGCOLOR=WHITE>");
            ts.write ("<TBODY>");
            ts.write ("<TR>");
            ts.write ("<th colspan=2><div id=piechart style='width: 300px; height: 200px;'></th>");
            ts.write ("</TR>");
            ts.write ("</TBODY>");
            ts.write ("</TABLE>");
            ts.write ("</TD>");
            ts.write ("<TD>");
            ts.write ("<TABLE BGCOLOR=WHITE>");
            ts.write ("<TBODY>");
            ts.write ("<TR>");
            ts.write ("<th>Regression Pace</th>");
            ts.write ("<th>Mar 2022 Testing</th>");
            ts.write ("</TR>");
            ts.write ("<TR>");
            ts.write ("<th>Total Test Cases</th>");
            ts.write ("<th><div id=ttc></div></th>");
            ts.write ("</TR>");
            ts.write ("<TR>");
            ts.write ("<th>Total Passed Test Cases</th>");
            ts.write ("<th>");
            ts.write ("<div id=tpassed></div></th>");
            ts.write ("</TR>");
            ts.write ("<TR>");
            ts.write ("<th>Total Failed Test Cases</th>");
            ts.write ("<th><div id=tfailed></div></th>");
            ts.write ("</TR>");
            ts.write ("</TBODY>");
            ts.write ("</TABLE>");
            ts.write ("</TD>");
            ts.write ("</TR>");
            ts.write ("</TD>");
            ts.write ("</TBODY>");
            ts.write ("</TABLE>");
            ts.write ("<TABLE>");
            ts.write ("<TBODY>");
            ts.write ("<TR>");

            ts.write ("<th>TestCaseName</th>");

            ts.write ("<th>Expected</th>");
            ts.write ("<th>Actual</th>");
            ts.write("<th>Status</th>");
            ts.write("</TR>");
            ts.flush();
        }
        catch(Throwable t)
        {

        }



    }

    public static void fgInsertResult(String ResFilePath,String TCName,String Expected,String Actual,String Result) throws Throwable
    {
        FileWriter w = new FileWriter(ResFilePath,true);
        BufferedWriter ts = new BufferedWriter(w);
        ts.write ("<TR>");
        ts.write ("<TD>" +TCName+"</TD>");



        ts.write ("<TD>"+ Expected+"</TD>");
        ts.write ("<TD>"+Actual+"</TD>");
        if (Result.equals("PASSED"))
        {


            ts.write ("<TD><FONT FACE='VERDANA' COLOR='GREEN' SIZE=1><B>"+Result+"</B></Font></TD>");



        }
        else if (Result.equals("FAILED"))
        {


            ts.write ("<TD><FONT FACE='VERDANA' COLOR='RED' SIZE=1><B>"+Result+"</B></Font></TD>");


        }

        ts.write ("</TR>");
        ts.flush();
    }


}