package init_classes;

import com.codeborne.selenide.Configuration;

public abstract class ExtensionForTests {
    public ExtensionForTests(){
        Configuration.browser = "CHROME";
        System.setProperty("webdriver.chrome", "chromedriver.exe");
        //Configuration.holdBrowserOpen = true;
    }
}
