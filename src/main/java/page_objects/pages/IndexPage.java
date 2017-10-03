package page_objects.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;

public class IndexPage {

    //IndexPage Elements

    @FindBy(css = ".main-title")
    public SelenideElement mainTitle;

    @FindBy(css = ".main-txt")
    public SelenideElement mainText;

    @FindBy(css = ".icons-benefit")
    public ElementsCollection benefitIcons;

    @FindBy(css = ".benefit-txt")
    public ElementsCollection benefitTexts;

  //Methods
    @Step("Check interface on Home page, it contains all needed elements")
    public void checkContainsElements(){
        mainTitle.should(visible);
        mainText.should(exist);
        benefitIcons.shouldHaveSize(4);
        benefitTexts.shouldHaveSize(4);
    }
}
