package com.herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Logout {
    @Test
    public void LogOut(){
        //open page
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
        WebElement loginButton = driver.findElement(By.tagName("Button"));
        loginButton.click();



        //click LogOut
        WebElement LogoutButton = driver.findElement(By.className("icon-signout"));
        Assert.assertTrue(LogoutButton.isDisplayed());
        LogoutButton.click();
        String logoutURL = "https://the-internet.herokuapp.com/login";
        Assert.assertEquals(logoutURL,driver.getCurrentUrl());

        String successMessage = "You logged out of the secure area!";
        WebElement successAlert = driver.findElement(By.id("flash"));
        Assert.assertTrue(successAlert.getText().contains(successMessage));


        //inchidere pagina
        driver.close();
    }
    }

