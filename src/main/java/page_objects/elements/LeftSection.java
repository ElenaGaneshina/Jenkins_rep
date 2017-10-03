package page_objects.elements;

import enums.MainMenu;
import enums.ServiceMenu;
import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Step;

import static com.codeborne.selenide.Condition.text;

public class LeftSection {

    @FindBy(css = ".sidebar-menu>li>a")
    public ElementsCollection leftSectionItems;


    @FindBy(css = ".sub>li>a")
    public ElementsCollection serviceLeftMenuElements;

    @Step("Click on Service subcategory in the left section and check that drop down contains options")
    public void checkLeftServiceMenu(){
        leftSectionItems.findBy(text("Service")).click();
        serviceLeftMenuElements.shouldHave(CollectionCondition.texts(
                ServiceMenu.SUPPORT.serviceItem,
                ServiceMenu.DATES.serviceItem,
                ServiceMenu.COMPLEX_TABLE.serviceItem,
                ServiceMenu.SIMPLE_TABLE.serviceItem,
                ServiceMenu.TABLE_WITH_PAGES.serviceItem,
                ServiceMenu.DIFFERENT_ELEMENTS.serviceItem
        ));
    }

    //
    public void clickServiceSubMenu() {
        leftSectionItems.findBy(text(MainMenu.SERVICE.menuItem)).click();
        serviceLeftMenuElements.findBy(text(ServiceMenu.DATES.serviceItem)).click();
    }

}
