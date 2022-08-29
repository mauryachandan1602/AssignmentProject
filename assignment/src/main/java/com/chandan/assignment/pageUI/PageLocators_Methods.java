package com.chandan.assignment.pageUI;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.chandan.assignment.basepage.BasePage;

public class PageLocators_Methods extends BasePage{

	public static final Logger log=Logger.getLogger(PageLocators_Methods.class.getName());

	@FindBy(xpath="(//td[@class='infobox-data'])[text()='India']") WebElement wkpCountryText;
	@FindBy(xpath="(//td[@class='infobox-data'])[position()=10]")WebElement wkpReleaseDateText;
	@FindBy(xpath = "(//a[@class='ipc-metadata-list-item__list-content-item ipc-metadata-list-item__list-content-item--link'])[text()='January 7, 2022 (United States)']")WebElement imdbReleaseDateText;
	@FindBy(xpath="(//a[@class='ipc-metadata-list-item__list-content-item ipc-metadata-list-item__list-content-item--link'])[text()='India']")WebElement imdbCountryText;

	public PageLocators_Methods(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public String wikipcountryName;
	public String wikipediaReleaseDate;
	public String imdbReleaseDate;
	public String imdbCountryName;

	public void getWikipediaMovieData() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", wkpCountryText);
		wikipcountryName = wkpCountryText.getText();
		System.out.println(wikipcountryName);
		wikipediaReleaseDate=wkpReleaseDateText.getText();
		System.out.println(wikipediaReleaseDate);
		driver.navigate().to("https://www.imdb.com/title/tt9389998/");

	}

	public void getImdbMovieData() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", imdbReleaseDateText);
		imdbReleaseDate = imdbReleaseDateText.getText();
		System.out.println(imdbReleaseDate);
		imdbCountryName=imdbCountryText.getText();
		System.out.println(imdbCountryName);

	}


}
