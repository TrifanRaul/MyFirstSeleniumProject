package com.herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeLogin {
    @Test
    public void NegativeLoginTest ()
    {
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        String url = "https://the-internet.herokuapp.com/login";
        driver.get(url);
        driver.manage().window().maximize();
        //enter username
        WebElement usernameInput = driver.findElement(By.id("username"));
        usernameInput.sendKeys("tomsmith");
        //enter password
        WebElement passwordInput = driver.findElement(By.name("password"));
        passwordInput.sendKeys("incorect");
        //click login

        WebElement loginButton = driver.findElement(By.tagName("Button"));
        loginButton.click();
        //verificare
        String secureURL = "https://the-internet.herokuapp.com/login";
        Assert.assertEquals(secureURL,driver.getCurrentUrl());
        String ErrorMessage = "Your password is invalid";
        WebElement ErrorAlert = driver.findElement(By.id("flash"));
        Assert.assertTrue(ErrorAlert.getText().contains(ErrorMessage));

        driver.close();

    }
}
