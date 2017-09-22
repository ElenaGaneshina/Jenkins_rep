package page_objects.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.actions;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class DatesPage {
        @FindBy (css = ".ui-slider-handle")
        private ElementsCollection sliders;
    @FindBy(css = ".uui-slider.blue a:nth-child(1)")
    private SelenideElement leftSliderHandle;

    @FindBy(css = ".uui-slider.blue a:nth-child(3)")
    private SelenideElement rightSliderHandle;

    @FindBy(css = ".uui-slider.blue")
    private SelenideElement slider;

    @FindBy(css = ".uui-slider.blue a:nth-child(1)>span")
    private SelenideElement leftSliderValue;

    @FindBy(css = ".uui-slider.blue a:nth-child(3)>span")
    private SelenideElement rightSliderValue;



        public  void moveSlider (int leftPosition, int rightPosition, char side){
            executeJavaScript("scroll(0, 250)");
            int widthSlider = slider.getSize().getWidth();
        if (side == 'R') {
                actions().clickAndHold(rightSliderHandle).moveByOffset((rightPosition - 1) * widthSlider / 100, 0).click().perform();
                actions().clickAndHold(leftSliderHandle).moveByOffset((leftPosition - 1) * widthSlider / 100, 0).click().perform();
            } else {
            actions().clickAndHold(leftSliderHandle).moveByOffset((leftPosition - 1) * widthSlider / 100, 0).click().perform();
            actions().clickAndHold(rightSliderHandle).moveByOffset((rightPosition - 1) * widthSlider / 100, 0).click().perform();
        }

            leftSliderValue.getText().compareTo(String.valueOf(leftPosition));
            rightSliderValue.getText().compareTo(String.valueOf(rightPosition));
        }



}
