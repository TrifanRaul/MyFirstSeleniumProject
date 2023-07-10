package com.herokuapp;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Login {
    @Test
    public void LoginTest ()
    {   //open page
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
        passwordInput.sendKeys("SuperSecretPassword!");
        //click login
       // WebElement LoginButton = driver.findElement(By.xpath("//*[@id=\"login\"]/button/i"));
       // WebElement LoginButton = driver.findElement(By.classname("radius"));
         WebElement loginButton = driver.findElement(By.tagName("Button"));
        loginButton.click();
        //verificare
        String secureURL = "https://the-internet.herokuapp.com/secure";
        Assert.assertEquals(secureURL,driver.getCurrentUrl());


        String successMessage = "You logged into a secure area!";
        WebElement successAlert = driver.findElement(By.id("flash"));
        Assert.assertTrue(successAlert.getText().contains(successMessage));


        //click LogOut
        //WebElement LogoutButton = driver.findElement(By.xpath("//*[@id=\"content\"]/div/a/i"));
        WebElement LogoutButton = driver.findElement(By.className("icon-signout"));
        Assert.assertTrue(LogoutButton.isDisplayed());
        /*
        LogoutButton.click();
        String logoutURL = "https://the-internet.herokuapp.com/login";
        Assert.assertEquals(logoutURL,driver.getCurrentUrl());*/

        //inchidere pagina
        driver.close();
    }

}
