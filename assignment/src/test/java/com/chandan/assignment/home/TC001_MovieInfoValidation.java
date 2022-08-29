package com.chandan.assignment.home;

import org.testng.annotations.Test;

import com.chandan.assignment.basepage.BasePage;
import com.chandan.assignment.pageUI.PageLocators_Methods;

//import org.testng.annotations.BeforeTest;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterClass;
//import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

public class TC001_MovieInfoValidation extends BasePage{

	public static final Logger log=Logger.getLogger(TC001_MovieInfoValidation.class.getName());


	@Test(priority=0)
	public void wikipMovieInfo() {

		log.info("...TC001_MovieInfoValidation started....");

		PageLocators_Methods plm=new PageLocators_Methods(driver);
		plm.getWikipediaMovieData();
		plm.getImdbMovieData();
		assertEquals(plm.wikipcountryName, plm.imdbCountryName);
		assertEquals(plm.wikipediaReleaseDate, plm.imdbReleaseDate);
		log.info("...End of the TC001_MovieInfoValidation....");

	}


	@BeforeClass
	public void beforeTest() throws IOException {

		//browserLaunch("chrome","https://en.wikipedia.org/wiki/Pushpa%3A_The_Rise");
		browserLaunch(getData("browser"),getData("wikipediaUrl"));

	}

	@AfterClass
	public void endTest() {
		extent.endTest(test);
		extent.flush();
		driver.quit();
	}

}
