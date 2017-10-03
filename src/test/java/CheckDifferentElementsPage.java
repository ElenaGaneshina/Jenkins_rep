import enums.*;
import init_classes.ExtensionForTests;
import listeners.AllureAttachmentListener;
import org.testng.annotations.Listeners;
import page_objects.elements.Header;
import page_objects.elements.LeftSection;
import page_objects.pages.DifferentElementPage;
import page_objects.pages.IndexPage;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Attachment;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.allure.annotations.Title;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

@Listeners(AllureAttachmentListener.class)
public class CheckDifferentElementsPage extends ExtensionForTests {
      private IndexPage indexPage = page(IndexPage.class);
      private Header header = page(Header.class);
      private LeftSection leftSection = page(LeftSection.class);
      private DifferentElementPage differentElementPage = page(DifferentElementPage.class);

    @Test
    @Title("Test checks Different Element Page")
    @Description("To check Allure report")
    public void checkDifferentElementPage() {

        open(InputData.URL.inData);
        header.login(InputData.LOGIN.inData, InputData.PASSWORD.inData);
        header.checkDisplayedUserName();
        indexPage.checkContainsElements();
        header.checkServiceMenu();
        leftSection.checkLeftServiceMenu();
        header.openDifferentElementsPage();
        differentElementPage.checkContainsElements();
        differentElementPage.selectAndAssertCheckbox(CheckBoxes.WATER.checkBoxName);
        differentElementPage.selectAndAssertCheckbox(CheckBoxes.WIND.checkBoxName);
        differentElementPage.selectRadioButton(RadioButtons.SELEN.radioBtn);
        differentElementPage.selectValueFromDDList(DropDownListValues.YELLOW.ddlValue);
        differentElementPage.checkLog(Log.WATER_TRUE.log);
        differentElementPage.checkLog(Log.WIND_TRUE.log);
        differentElementPage.checkLog(Log.SELEN_SET.log);
        differentElementPage.checkLog(Log.YELLOW_SET.log);
        differentElementPage.unselectAndAssertCheckbox(CheckBoxes.WATER.checkBoxName);
        differentElementPage.unselectAndAssertCheckbox(CheckBoxes.WIND.checkBoxName);
        differentElementPage.checkLog(Log.WATER_FALSE.log);
        differentElementPage.checkLog(Log.WIND_FALSE.log);

    }
}
