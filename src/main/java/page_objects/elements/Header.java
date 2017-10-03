package page_objects.elements;

import enums.InputData;
import enums.MainMenu;
import enums.ServiceMenu;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;

public class Header {
    //Header Items
    @FindBy(css = ".uui-navigation.nav.navbar-nav.m-l8>li>a")
    public ElementsCollection headerItems;

    //Login
    @FindBy(css= ".fa-user")
    public SelenideElement userIcon;

    @FindBy(css = "#Login")
    public  SelenideElement username;

    @FindBy(css = "#Password")
    public  SelenideElement password;

    @FindBy(css = ".fa-sign-in")
    public  SelenideElement submit;

    @FindBy(css = ".profile-photo")
    public SelenideElement displayedName;

    //Service menu
    @FindBy(css = "ul[class=dropdown-menu]>li")
    public ElementsCollection serviceMenuElements;



    //Methods
    @Step("Perform login")
    public void login(String user, String pass){
        userIcon.click();
        username.setValue(user);
        password.sendKeys(pass);
        submit.click();
    }

    @Step("Open through the header menu Service -> Different Elements Page")
    public  void  openDifferentElementsPage(){
        headerItems.findBy(text(MainMenu.SERVICE.menuItem)).click();
        serviceMenuElements.findBy(text(ServiceMenu.DIFFERENT_ELEMENTS.serviceItem)).click();
            }

    public  void  openDatesPage(){
        headerItems.findBy(text(MainMenu.SERVICE.menuItem)).click();
        serviceMenuElements.findBy(text(ServiceMenu.DATES.serviceItem)).click();
    }

    @Step("Click on \"Service\" subcategory in the header and check that drop down contains options")
    public void checkServiceMenu(){
        headerItems.findBy(text(MainMenu.SERVICE.menuItem)).click();
        serviceMenuElements.shouldHave(
               texts(
                       ServiceMenu.SUPPORT.serviceItem,
                       ServiceMenu.DATES.serviceItem,
                       ServiceMenu.COMPLEX_TABLE.serviceItem,
                       ServiceMenu.SIMPLE_TABLE.serviceItem,
                       ServiceMenu.TABLE_WITH_PAGES.serviceItem,
                       ServiceMenu.DIFFERENT_ELEMENTS.serviceItem
               )
       );

    }

    //Asserts
    @Step("Assert User name in the right-top side of screen that user is loggined")
    public void checkDisplayedUserName(){
        displayedName.shouldBe(text(InputData.USER_NAME.inData));
    }
}
