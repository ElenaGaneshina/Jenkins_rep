package page_objects.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.*;

public class DifferentElementPage {
    @FindBy(css = ".label-checkbox")
    private ElementsCollection checkBoxes;

    @FindBy(css = ".label-radio")
    private  ElementsCollection radioButtons;

    @FindBy(css = "select.uui-form-element")
    private  SelenideElement dropDownList;

    @FindBy(css = "[value=\"Default Button\"]")
    private SelenideElement defaultButton;

    @FindBy(css = "[value=\"Button\"]")
    private SelenideElement button;

    @FindBy(css = "#mCSB_1")
    private SelenideElement leftSection;

    @FindBy(css = "#mCSB_2")
    private SelenideElement rightSection;

    @FindBy(css = ".panel-body-list.logs>li")
    private ElementsCollection log;

    public void checkContainsElements() {
        checkBoxes.shouldHaveSize(4);
        radioButtons.shouldHaveSize(4);
        dropDownList.shouldBe(visible);
        button.shouldBe(visible);
        defaultButton.shouldBe(visible);
        leftSection.shouldBe(visible);
        rightSection.shouldBe(visible);
    }

    public void selectAndAssertCheckbox(String checkBoxName) {
        checkBoxes.find(text(checkBoxName)).click();
        checkBoxes.find(text(checkBoxName)).find("input").shouldBe(checked);
    }

    public void selectRadioButton(String radioBtn) {
        radioButtons.find(text(radioBtn)).setSelected(true);
    }

    public void selectValueFromDDList(String ddlValue) {
        dropDownList.selectOption(ddlValue);
    }

    public void checkLog (String logValue) {
        log.contains(logValue);

    }

    public void unselectAndAssertCheckbox(String checkBoxName) {
        checkBoxes.find(text(checkBoxName)).click();
        checkBoxes.find(text(checkBoxName)).find("input").shouldNotBe(checked);
    }

}
