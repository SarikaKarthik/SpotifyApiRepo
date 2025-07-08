package spotifyRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
		features={"D:\\Maven and Cucumber Projects\\Amazon_Cucumber\\SpotifyAPI\\src\\test\\resources\\featurePackage\\SpotifyCreateUser.feature"},
		glue={"SpotifyStepDefination"},
		plugin={"pretty", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"}
		
		)

public class SpotifyRunnerClass extends AbstractTestNGCucumberTests{
	
}

