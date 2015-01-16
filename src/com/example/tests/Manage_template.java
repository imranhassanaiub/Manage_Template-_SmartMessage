package com.example.tests;

import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Manage_template {
  private WebDriver driver;
  private String baseUrl;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "https://apptest.smartmessage.me";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testFullManageTemplateModule() throws Exception {
    
	//Login  
	  
	driver.get(baseUrl + "/");
    driver.findElement(By.id("username")).clear();
    driver.findElement(By.id("username")).sendKeys("superimran");
    driver.findElement(By.id("password")).clear();
    driver.findElement(By.id("password")).sendKeys("superimran123456");
    driver.findElement(By.cssSelector("button.btn.btn-primary")).click();
    
    //Goto Account Settings->Manage Templates
    
    driver.findElement(By.linkText("Account Settings")).click();
    driver.findElement(By.linkText("Manage Templates")).click();
    
	
    //Add New Template
    
    driver.findElement(By.linkText("Add A New Template")).click();
    driver.findElement(By.id("template_name")).click();
    driver.findElement(By.id("template_name")).clear();
    driver.findElement(By.id("template_name")).sendKeys("AsT");
    driver.findElement(By.id("description")).clear();
    driver.findElement(By.id("description")).sendKeys("ast");
    driver.findElement(By.id("content")).clear();
    driver.findElement(By.id("content")).sendKeys("ast");
    driver.findElement(By.cssSelector("button.btn.btn-primary")).click();
    driver.findElement(By.cssSelector("div.modal-footer > button.btn.btn-primary")).click();
    driver.findElement(By.cssSelector("div.modal-footer > button.btn.btn-primary")).click();
    
    //Edit Added Template
    driver.findElement(By.xpath("(//a[contains(text(),'Edit')])[5]")).click();
    driver.findElement(By.id("visibility-0")).click();
    driver.findElement(By.id("description")).clear();
    driver.findElement(By.id("description")).sendKeys("astssd");
    driver.findElement(By.id("content")).clear();
    driver.findElement(By.id("content")).sendKeys("astssd");
    driver.findElement(By.id("visibility-1")).click();
    driver.findElement(By.xpath("//div[@id='visibility-control']/div/label[2]")).click();
    new Select(driver.findElement(By.id("company_id"))).selectByVisibleText("apptest_jmeter_imran");
    driver.findElement(By.cssSelector("option[value=\"15\"]")).click();
    driver.findElement(By.linkText("Save Changes")).click();
    driver.findElement(By.cssSelector("button.btn.btn-primary")).click();
    driver.findElement(By.cssSelector("button.btn.btn-primary")).click();
    
    // Delete Added Template
    driver.findElement(By.xpath("(//a[contains(text(),'Delete')])[5]")).click();
    driver.findElement(By.cssSelector("button.btn.btn-danger")).click();
    driver.findElement(By.cssSelector("button.btn.btn-primary")).click();
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }
}
