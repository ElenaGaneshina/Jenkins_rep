import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class AnnotationTest {

    private WebDriver driver;

    @BeforeSuite
    public void setSystemProperties(){

        System.setProperty("webdriver.chrome.driver","chromedriver.exe");
    }
    @AfterMethod
    public void  getTitle(){

        System.out.println(driver.getTitle());
    }
    @BeforeClass
    public void initDriver(){
       driver = new ChromeDriver();}

    @BeforeTest
    public void checkTime(){
        System.out.println(System.currentTimeMillis());}

    @AfterTest
    public void tearDown(){
        driver.close();
    }
    @AfterSuite
    public void quitDriver(){

        if(driver.toString().contains("null")) {  driver.quit(); }
    }
    @Test
    public void simpleTest1() {
        driver.navigate().to("https://www.epam.com");
        Assert.assertEquals(driver.getTitle(),
                "EPAM | Software Product Development Services");

    }
}
