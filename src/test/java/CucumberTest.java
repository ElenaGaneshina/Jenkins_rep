import com.codeborne.selenide.Configuration;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import cucumber.api.testng.TestNGCucumberRunner;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Title;

import static com.codeborne.selenide.Selenide.close;


@CucumberOptions(
        plugin = {"json:target/cucumber-report.json", "html:target/cucumber-report"},
        features = "src/test/java/features",
        glue = "steps"
)

@Title("Test checks Different Element Page")
@Description("To check Allure report")
public class CucumberTest extends AbstractTestNGCucumberTests{

    @BeforeClass
    public void ExtensionForTests(){
        Configuration.browser = "CHROME";
        System.setProperty("webdriver.chrome", "chromedriver.exe");
    }

    @AfterClass
    public void tearDown(){
        close();
    }
}
