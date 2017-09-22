package page_objects.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;

public class IndexPage {

    //IndexPage Elements

    @FindBy(css = ".main-title")
    private SelenideElement mainTitle;

    @FindBy(css = ".main-txt")
    private SelenideElement mainText;

    @FindBy(css = ".icons-benefit")
    private ElementsCollection benefitIcons;

    @FindBy(css = ".benefit-txt")
    private ElementsCollection benefitTexts;

  //Methods

    public void checkContainsElements(){
        mainTitle.should(visible);
        mainText.should(exist);
        benefitIcons.shouldHaveSize(4);
        benefitTexts.shouldHaveSize(4);
    }
}
