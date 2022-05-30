
public  class ExtentTestReport
{
    static  ExtentTest logger;
    static  ExtentReports report;
    @BeforeClass
    public  static void  startTest()
    {
        report = new ExtentReports(System.getProperty("user.dir")) + "extent/ExtentReportResult.html",true);
    }

    public  void  verifyPageTitle() {

    }
}