package org.demo;
import java.awt.AWTException;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class BrowserLaunch {
	public static void main(String[] args) throws IOException, InterruptedException, AWTException  {
	System.setProperty("webdriver.chrome.driver","C:\\Users\\hp\\eclipse-workspace\\BrowserLaunch\\Driver\\chromedriver.exe");
	 WebDriver driver=new ChromeDriver();
	 driver.get("https://www.amazon.in/");
		
	 WebElement searchbox = driver.findElement(By.id("twotabsearchtextbox"));
		searchbox.click();
	    searchbox.sendKeys("iphone 15promax");
	    WebElement search = driver.findElement(By.id("nav-search-submit-button"));
	    search.click();
	    WebElement last = driver.findElement(By.xpath("//span[@class='s-pagination-item s-pagination-disabled']"));
	    String lastpage = last.getText();
	    Integer n = Integer.valueOf(lastpage);
	    System.out.println("number of pages :"+n);
	    for(int j=0;j<n;j++)
	    {   
	      List<WebElement> iphonelist = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
	      List<WebElement> pricelist = driver.findElements(By.xpath("//span[@class='a-price-whole']"));
	      System.out.println("number of iphones :"+iphonelist.size());
	      for(int i=0;i<iphonelist.size();i++) {
	    	  WebElement name = iphonelist.get(i);
	    	  WebElement price = pricelist.get(i);
	    	  System.out.println(name.getText());
	    	  System.out.println(price.getText());
	    	
	          }
	   System.out.println("finish");  
	   WebElement nextpage = driver.findElement(By.xpath("//a[@class='s-pagination-item s-pagination-next s-pagination-button s-pagination-separator']"));
	   nextpage.click();
	   Thread.sleep(25000);
	    }
    }
	public static void tc01(){
		System.out.println("qa works fine");
	}
}