import com.codeborne.selenide.Configuration;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.codeborne.selenide.Selenide.screenshot;
import org.junit.*;
import org.openqa.selenium.*;
import utilities.Log;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;


public class SeleniumTest {
    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "/Users/andbilous/Downloads/chromedriver");
        Configuration.browser = "chrome";
        Configuration.timeout=5000;
        getWebDriver().manage().deleteAllCookies();
        open("http://knickerbocker-hotel-new-york.nochi.com/?btest=119");
    }
    @Test
    public  void bookingTest() throws InterruptedException {
        Log.startLog("test starts");
        // Locators
        String opisanieTabLocator="//*[@id=\"container\"]/div/div/div/div[4]/ul/li[1]/a";
        String udobstvaTabLocator="//*[@id=\"container\"]/div/div/div/div[4]/ul/li[2]/a";
        String nomeraTabLocator="//*[@id=\"container\"]/div/div/div/div[4]/ul/li[3]/a";
        String raspologenieTabLocator="//*[@id=\"container\"]/div/div/div/div[4]/ul/li[4]/a";
        String otzyvyTabLocator="//*[@id=\"container\"]/div/div/div/div[4]/ul/li[5]/a";
        String datesSectionLocator="//*[@id=\"container\"]/div/div/div/div[3]/form/div[1]/div[3]/div[1]/div";
        String rightArrowLocator="//*[@id=\"container\"]/div/div/div/div[3]/form/div[2]/div[2]/table[2]/thead/tr[1]/th[3]";
        String dateFromLocator="//*[@id=\"container\"]/div/div/div/div[3]/form/div[2]/div[2]/table[2]/tbody/tr[4]/td[5]/div";
        String dateToLocator="//*[@id=\"container\"]/div/div/div/div[3]/form/div[2]/div[2]/table[2]/tbody/tr[4]/td[6]/div";
        String guestSectionLocator="//*[@id=\"container\"]/div/div/div/div[3]/form/div[1]/div[3]/div[3]/div[1]";
        String addParentsLocator="//*[@id=\"container\"]/div/div/div/div[3]/form/div[1]/div[3]/div[3]/div[2]/div/div[1]/div/div[2]/div[1]/div[1]/div[2]/div[3]";
        String addChildrenLocator="//*[@id=\"container\"]/div/div/div/div[3]/form/div[1]/div[3]/div[3]/div[2]/div/div[1]/div/div[2]/div[1]/div[2]/div[2]/div[3]";
        String childrenAgeFromLocator="//*[@id=\"container\"]/div/div/div/div[3]/form/div[1]/div[3]/div[3]/div[2]/div/div[1]/div/div[2]/div[2]/div[2]/select[1]";
        String childrenAgeToLocator="//*[@id=\"container\"]/div/div/div/div[3]/form/div[1]/div[3]/div[3]/div[2]/div/div[1]/div/div[2]/div[2]/div[2]/select[2]";
        String viewPricesLocator ="//*[@id=\"container\"]/div/div/div/div[3]/form/div[1]/div[2]/div/div[2]/button[1]" ;
        String bookRoomLocator="//*[@id=\"hotel-608662\"]/div[3]/div[2]/div/div/div/div[2]/div[2]/div[4]/button";
        String guestsCountLocator="//*[@id=\"container\"]/div/div/div/div[3]/form/div[1]/div[3]/div[3]/div[1]/span[1]";
        String roomCountLocator ="//*[@id=\"container\"]/div/div/div/div[3]/form/div[1]/div[3]/div[3]/div[1]/span[2]/span[2]";
        String bookingSectionLocator="//*[@id=\"container\"]/div[3]/div[1]/div[1]/div[3]";
        String dateInLocator = "//*[@id=\"container\"]/div[3]/div[1]/div[1]/div[3]/div[1]/div[1]/span[2]";
        String dateOutLocator="//*[@id=\"container\"]/div[3]/div[1]/div[1]/div[3]/div[1]/div[2]/span[2]";
        String resultGuestsNumberLocator="//*[@id=\"container\"]/div[3]/div[1]/div[1]/div[3]/div[2]/div[1]/span[2]";
        String bookingPopupCloseLocator="//*[@id=\"container\"]/div/div/div/div[5]/div[3]/div[2]/div/form/div[1]/span";
        // Data
        String numberOfGuests="5";
        String numberOfRooms="1";
        String dateInVerification="2019-01-24";
        String dateOutVerification="2019-01-25";
        String guestCountVerification="3 Взрослых,\n" +
                "2 Детей";

        getWebDriver().findElement(By.tagName("body")).sendKeys("Keys.ESCAPE");

        Log.info("Click on Tabs");
        $($x(opisanieTabLocator)).click();
        screenshot("opisanieTab.png");
        $($x(udobstvaTabLocator)).shouldBe(visible);
        $($x(udobstvaTabLocator)).click();
        $(By.xpath(bookingPopupCloseLocator)).click();
        screenshot("udobstvaTab.png");
        $($x(nomeraTabLocator)).shouldBe(visible);
        $($x(nomeraTabLocator)).click();
        screenshot("nomeraTab.png");
        $($x(raspologenieTabLocator)).shouldBe(visible);
        $($x(raspologenieTabLocator)).click();
        screenshot("raspologenieTab.png");
        $($x(otzyvyTabLocator)).shouldBe(visible);
        $($x(otzyvyTabLocator)).click();
        screenshot("otzyvyTab.png");


        Log.info("Click on DatePicker");
        $($x(datesSectionLocator)).shouldBe(visible);
        $($x(datesSectionLocator)).click();


       // Right Arrow
        Log.info("Choose date");
        for(int i =0;i<4;i++){
            $($x(rightArrowLocator)).shouldBe(appear);
            $($x(rightArrowLocator)).click();
        }
        Log.info("Choose dates");
        // dateFrom
        $($x(dateFromLocator)).click();
        // dateTo
        $($x(dateToLocator)).click();

        Log.info("Click guest section to close popup");
        $($x(guestSectionLocator)).click();


        Log.info("Set Parents Count");
            $($x(addParentsLocator)).click();

        Log.info("Set Children Count");
        for(int i=0;i<2;i++){
            $($x(addChildrenLocator)).click();
        }

        Log.info("Choose children age");
        $($x(childrenAgeFromLocator)).selectOption(3);

        $($x(childrenAgeToLocator)).selectOption(11);

        $($x(guestSectionLocator)).click();
        Log.info("View prices");
            $($x(viewPricesLocator)).click();
            Assert.assertEquals($(By.xpath(guestsCountLocator)).text(),numberOfGuests);
        Assert.assertEquals($(By.xpath(roomCountLocator)).text(),numberOfRooms);


        for(String winHandle : getWebDriver().getWindowHandles()){
            getWebDriver().switchTo().window(winHandle);
        }
        $(By.xpath(bookRoomLocator)).shouldBe(visible);
        if(!$(By.xpath(bookRoomLocator)).is(visible)){
            Log.fatal("Result page Error");
        }
        $(By.xpath(bookRoomLocator)).click();
        $(By.xpath(bookingSectionLocator)).shouldBe(visible);
        screenshot("bookresult.png");
        Assert.assertEquals(dateInVerification,$(By.xpath(dateInLocator)).getText());
        Assert.assertEquals(dateOutVerification,$(By.xpath(dateOutLocator)).getText());
        Assert.assertEquals(guestCountVerification,$(By.xpath(resultGuestsNumberLocator)).getText());
    }

    @AfterClass

    public static void finishTest()
    {
        Log.endLog("Test ends");
        getWebDriver().close();
    }

}
