package page_objects.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import static com.codeborne.selenide.Condition.*;

public class DifferentElementPage {
    @FindBy(css = ".label-checkbox")
    public ElementsCollection checkBoxes;

    @FindBy(css = ".label-radio")
    public  ElementsCollection radioButtons;

    @FindBy(css = "select.uui-form-element")
    public  SelenideElement dropDownList;

    @FindBy(css = "[value=\"Default Button\"]")
    public SelenideElement defaultButton;

    @FindBy(css = "[value=\"Button\"]")
    public SelenideElement button;

    @FindBy(css = "#mCSB_1")
    public SelenideElement leftSection;

    @FindBy(css = "#mCSB_2")
    public SelenideElement rightSection;

    @FindBy(css = ".panel-body-list.logs>li")
    public ElementsCollection log;

    @Step("Check interface on Service page, it contains all needed elements.")
    public void checkContainsElements() {
        checkBoxes.shouldHaveSize(4);
        radioButtons.shouldHaveSize(4);
        dropDownList.shouldBe(visible);
        button.shouldBe(visible);
        defaultButton.shouldBe(visible);
        leftSection.shouldBe(visible);
        rightSection.shouldBe(visible);
    }

    @Step("Select and assert checkboxes")
    public void selectAndAssertCheckbox(String checkBoxName) {
        checkBoxes.find(text(checkBoxName)).click();
        checkBoxes.find(text(checkBoxName)).find("input").shouldBe(checked);
    }

    @Step("Select radio")
    public void selectRadioButton(String radioBtn) {
        radioButtons.find(text(radioBtn)).setSelected(true);
    }

    @Step("Select in dropdown")
    public void selectValueFromDDList(String ddlValue) {
        dropDownList.selectOption(ddlValue);
    }

    @Step("Check in logs section selected values and status (true|false)")
    public void checkLog (String logValue) {
        log.contains(logValue);

    }
    @Step("Check in logs section unselected values and status (true|false)")
    public void unselectAndAssertCheckbox(String checkBoxName) {
        checkBoxes.find(text(checkBoxName)).click();
        checkBoxes.find(text(checkBoxName)).find("input").shouldNotBe(checked);
    }

}
