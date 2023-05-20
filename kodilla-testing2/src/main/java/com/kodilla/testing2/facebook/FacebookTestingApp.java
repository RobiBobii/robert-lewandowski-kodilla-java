package com.kodilla.testing2.facebook;

import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class FacebookTestingApp {
    public static final String XPATH_COOKIES = "//div[contains(@class, \"_9xo5\")]/button[2]";
    public static final String XPATH_REGISTRATIONFORM = "//div[contains(@class, \"_6ltg\")]/a[1]";
    public static final String XPATH_BIRTHDATEDAY = "//select[@name=\"birthday_day\"]";
    public static final String XPATH_BIRTHDATEMONTH = "//select[@name=\"birthday_month\"]";
    public static final String XPATH_BIRTHDATEYEAR = "//select[@name=\"birthday_year\"]";

    public static void main(String[] args) {
        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driver.get("https://www.facebook.com/");

        driver.findElement(By.xpath(XPATH_COOKIES)).click();
        driver.findElement(By.xpath(XPATH_REGISTRATIONFORM)).click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            //do nothing
        }

        WebElement dayElement = driver.findElement(By.xpath(XPATH_BIRTHDATEDAY));
        Select selectDay = new Select(dayElement);
        selectDay.selectByIndex(9);

        WebElement monthElement = driver.findElement(By.xpath(XPATH_BIRTHDATEMONTH));
        Select selectMonth = new Select(monthElement);
        selectMonth.selectByIndex(4);

        WebElement yearElement = driver.findElement(By.xpath(XPATH_BIRTHDATEYEAR));
        Select selectYear = new Select(yearElement);
        selectYear.selectByIndex(20);
    }
}
