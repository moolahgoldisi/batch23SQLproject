package utils;


import pages.AddEmployeePage;
import pages.loginPage;
import pages.searchEmployeePage;

public class PageInitialiser {


    public static loginPage loginPage;
    public static AddEmployeePage addEmployeePage;
    public static searchEmployeePage searchEmployeePage;


    public static void initializePageObjects(){
        loginPage = new loginPage();
        addEmployeePage = new AddEmployeePage();
        searchEmployeePage = new searchEmployeePage();
    }

}
