package page_objects.elements;

import enums.InputData;
import enums.MainMenu;
import enums.ServiceMenu;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;

public class Header {
    //Header Items
    @FindBy(css = ".uui-navigation.nav.navbar-nav.m-l8>li>a")
    private ElementsCollection headerItems;

    //Login
    @FindBy(css= ".fa-user")
    private SelenideElement userIcon;

    @FindBy(css = "#Login")
    private  SelenideElement username;

    @FindBy(css = "#Password")
    private  SelenideElement password;

    @FindBy(css = ".fa-sign-in")
    private  SelenideElement submit;

    @FindBy(css = ".profile-photo")
    private SelenideElement displayedName;

    //Service menu
    @FindBy(css = "ul[class=dropdown-menu]>li")
    private ElementsCollection serviceMenuElements;



    //Methods
    public void login(String user, String pass){
        userIcon.click();
        username.setValue(user);
        password.sendKeys(pass);
        submit.click();
    }
    public  void  openDifferentElementsPage(){
        headerItems.findBy(text(MainMenu.SERVICE.menuItem)).click();
        serviceMenuElements.findBy(text(ServiceMenu.DIFFERENT_ELEMENTS.serviceItem)).click();
            }
    public  void  openDatesPage(){
        headerItems.findBy(text(MainMenu.SERVICE.menuItem)).click();
        serviceMenuElements.findBy(text(ServiceMenu.DATES.serviceItem)).click();
    }

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
    public void checkDisplayedUserName(){
        displayedName.shouldBe(text(InputData.USER_NAME.inData));
    }
}
