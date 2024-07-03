package calculator;

import pages.CalculatorPage;
import mobile.MobileFactory;
import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;

public class CalculatorTest {
    private AndroidDriver driver;
    private CalculatorPage calculatorPage;

    @BeforeEach
    public  void setUp() {
        driver = MobileFactory.getAndroidDriver();
        calculatorPage = new CalculatorPage(driver);
    }

    @AfterEach
    public  void tearDown() {
        if (driver != null)
            driver.quit();
    }

    @Test
    @DisplayName("Проверка функции сложение")
    public void additionTest() {
        calculatorPage.click_8()
                .click_add()
                .click_7()
                .click_eq();

        String result = driver.findElement(By.id("result_final")).getText();

        Assertions.assertEquals("15", result);
    }

    @Test
    @DisplayName("Проверка функции вычитание")
    public void subtractionTest() {
        calculatorPage.click_7()
                .click_sub()
                .click_6()
                .click_eq();

        String result = driver.findElement(By.className("android.widget.TextView")).getText();

        Assertions.assertEquals("1", result);
    }

    @Test
    @DisplayName("Проверка функции умножение")
    public void multiplicationTest() {
        calculatorPage.click_3()
                .click_6()
                .click_mult()
                .click_4()
                .click_eq();

        String result = driver.findElement(By.className("android.widget.TextView")).getText();

        Assertions.assertEquals("144", result);
    }

    @Test
    @DisplayName("Проверка функции деление")
    public void divisionTest() {
        calculatorPage.click_7()
                .click_8()
                .click_div()
                .click_6()
                .click_eq();

        String result = driver.findElement(By.className("android.widget.TextView")).getText();

        Assertions.assertEquals("13", result);
    }
}
