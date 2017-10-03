package steps;

import com.codeborne.selenide.CollectionCondition;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import enums.InputData;
import enums.MainMenu;
import enums.ServiceMenu;
import init_classes.ExtensionForTests;
import page_objects.elements.Header;
import page_objects.elements.LeftSection;
import page_objects.pages.DifferentElementPage;
import page_objects.pages.IndexPage;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;


public class Steps {
    private Header header = page(Header.class);
    private IndexPage indexPage = page(IndexPage.class);
    private LeftSection leftSection = page(LeftSection.class);
    private DifferentElementPage differentElementPage = page(DifferentElementPage.class);

    @Step("Open test site by URL")
    @Given("I open \"([^\"]*)\"$")
    public void openSite(String url){
        open(url);
    }

    @Step("Perform login")
    @Given("I login as (.*)/(.*)")
    public void login(String user, String pass){
        header.userIcon.click();
        header.username.setValue(user);
        header.password.sendKeys(pass);
        header.submit.click();
    }

    @Step("Assert User name in the left-top side of screen that user is loggined")
    @Given("I check that dispalyed name in the right-top side of screen is \"([^\"]*)\"$")
    public void checkDisplayedUserName(String name){
        header.displayedName.shouldBe(text(name));
    }

    @Step("Check interface on Home page, it contains all needed elements.")
    @Given("I check that Home page contains 4 pictures, 4 texts under them, 2 text above")
    public void checkHomePageContainsElements(){
        indexPage.mainTitle.should(visible);
        indexPage.mainText.should(exist);
        indexPage.benefitIcons.shouldHaveSize(4);
        indexPage.benefitTexts.shouldHaveSize(4);
    }

    @Step("Click on \"Service\" subcategory in the header and check that drop down contains options")
    @Given("I check that header Service menu contains options: (.*)$")
    public void checkServiceMenu(List<String> args){
        header.headerItems.findBy(text(MainMenu.SERVICE.menuItem)).click();
        header.serviceMenuElements.shouldHave(
                texts(
                        args.get(0),
                        args.get(1),
                        args.get(2),
                        args.get(3),
                        args.get(4),
                        args.get(5)
                )
        );
    }

    @Step("Click on Service subcategory in the left section and check that drop down contains options\n")
    @Given("I check that left section Service subcategory contains options: (.*)$")
    public void checkLeftServiceMenu(List<String> args){
        leftSection.leftSectionItems.findBy(text("Service")).click();
        leftSection.serviceLeftMenuElements.shouldHave(CollectionCondition.texts(
                args.get(0),
                args.get(1),
                args.get(2),
                args.get(3),
                args.get(4),
                args.get(5)
        ));
    }

    @Step("Open through the header menu Service -> Different Elements Page")
    @Given("I open through the header menu Service page: \"([^\"]*)\"$")
    public void openDifferentElementsPageThroughHeader(String page){
        header.headerItems.findBy(text(MainMenu.SERVICE.menuItem)).click();
        header.serviceMenuElements.findBy(text(page)).click();
    }

    @Step("Check interface on Service page, it contains all needed elements.\n")
    @When("I check Different Elements page contains 4 - checkboxes, 4 radios, dropdown, 2 - buttons, left section, right section.")
    public void checkDifElementspageContainsElements(){
        differentElementPage.checkBoxes.shouldHaveSize(4);
        differentElementPage.radioButtons.shouldHaveSize(4);
        differentElementPage.dropDownList.shouldBe(visible);
        differentElementPage.button.shouldBe(visible);
        differentElementPage.defaultButton.shouldBe(visible);
        differentElementPage.leftSection.shouldBe(visible);
        differentElementPage.rightSection.shouldBe(visible);
    }

    @Step("Select and assert checkboxes")
    @When("I select (.*) checkbox and assert it")
    public void selectAndAssertCheckbox(String checkBoxName) {
        differentElementPage.checkBoxes.find(text(checkBoxName)).click();
        differentElementPage.checkBoxes.find(text(checkBoxName)).find("input").shouldBe(checked);
    }

    @Step("Select radio")
    @When("I select (.*) radio")
    public void selectRadioButton(String radioBtn) {
        differentElementPage.radioButtons.find(text(radioBtn)).setSelected(true);
    }

    @Step("Select in dropdown")
    @When("I select (.*) dropdown")
    public void selectValueFromDDList(String ddlValue) {
        differentElementPage.dropDownList.selectOption(ddlValue);
    }

    @Step("Unselect and assert checkboxes")
    @When("I unselect and assert checkbox (.*)$")
    public void unselectAndAssertCheckbox(String checkBoxName) {
        differentElementPage.checkBoxes.find(text(checkBoxName)).click();
        differentElementPage.checkBoxes.find(text(checkBoxName)).find("input").shouldNotBe(checked);
    }

    @Step("CheckLogs")
    @Then("Logs contains \"([^\"]*)\"$")
    public void checkLog (String logValue) {
        differentElementPage.log.contains(logValue);
    }
    }

