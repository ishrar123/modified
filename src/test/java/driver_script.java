import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class driver_script {
    public static int rowcount, i;
    public static String vprojectname, vprojecturl, vmodulefile, vscenariofile, vobjectfile, vmodulerun, vmodulename, vtestcaserun, vtestcasename, vDescription,htmlresultfile;
    public static int m;
    public static WebDriver driver;
    public static Xls_Reader xmodfile;
    public static int k;

    public static void main(String[] args) throws IOException {

        //html result file
        htmlresultfile=reusablefunction.CreateHTMLResultfile();

        //calling the html result file
        reusablefunction.CreatecolumnHtmlResult(htmlresultfile);






        //fetching the first excel file i.e project driver
        Xls_Reader xr = new Xls_Reader(System.getProperty("user.dir") + "\\src\\test\\drivers\\af_projectdrivers.xlsx");

        //geting the rows of the project driver excel file
        rowcount = xr.getRowCount("projects");

        //System.out.println(rowcount);

        //starting the first for loop for the project name
        for (i = 2; i <= rowcount; i++) {

            //getting the project name for the excel file
            vprojectname = xr.getCellData("projects", "projectname", i);
            System.out.println(vprojectname);

            //getting the project url for the excel file
            vprojecturl = xr.getCellData("projects", "projecturl", i);

            //getting the module file

            vmodulefile = xr.getCellData("projects", "Modulefile", i);


            //getting the scenario file

            vscenariofile = xr.getCellData("projects", "Scenariofile", i);


            //getting the objectfile

            vobjectfile = xr.getCellData("projects", "Objectsfile", i);


            //fetching the modules file
             xmodfile = new Xls_Reader(System.getProperty("user.dir") + "\\src\\test\\drivers\\af_vtigermodules.xlsx");


            //fetching the scenario file
            Xls_Reader xscenariofile = new Xls_Reader(System.getProperty("user.dir") + "\\src\\test\\scenarios\\vtigerscenario.xlsx");


            //getting the row count of the modules file
            int rmodulecount = xr.getRowCount(vprojectname);

            //second loop for the modules file

            for (int j = 2; j <= rmodulecount; j++) {
                //fetching the modules which are on
                vmodulerun = xr.getCellData(vprojectname, "Run", j);

                if (vmodulerun.equalsIgnoreCase("on")) {
                    vmodulename = xr.getCellData(vprojectname, "Modules", j);
                    System.out.println(vmodulename);


                    //getting the rows of the af_vtigermodules file
                    int rtestcasecount = xmodfile.getRowCount(vmodulename);
                    System.out.println("the rows are" +rtestcasecount);

                    // System.out.println(rtestcasecount);

                    //starrting the third loop for the test casees i.e modulefile
                    for (int k = 2; k <= rtestcasecount; k++) {
                        vtestcaserun = xmodfile.getCellData(vmodulename, "Run", k);
                        if (vtestcaserun.equalsIgnoreCase("on")) {
                            vtestcasename = xmodfile.getCellData(vmodulename, "TCName", k);
                            System.out.println(vtestcasename);

                            int flag = 0;
                            int rownum = 0;

                            //getting the rowcount of the scenarios file
                            int rscount = xscenariofile.getRowCount("sheet1");
                           // System.out.println(rscount);

                            //starting the fourth loop for the scenarios file
                            for (m = 2; m <= rscount; m++) {
                                String vKeytext = xscenariofile.getCellData("sheet1", "Keywords", m);
                                System.out.println(vKeytext);
                                if (vKeytext.equals(vtestcasename)) {
                                    vDescription = xscenariofile.getCellData("sheet1", "Keywords", m - 1);
                                    flag = 1;
                                    rownum = m;
                                }
                                if ((flag == 1) && (m > rownum)) {
                                    if (vKeytext.contains("//")) {
                                        break;
                                    } else {
                                        String vKeyword = vKeytext.trim();
                                        System.out.println(vKeyword);
                                         generic_methods gm=new generic_methods();
                                        gm.keyworddriver(vKeyword,xscenariofile,m);


                                    }
                                }


                            }
                        }


                    }
                }

            }
        }
    }
}