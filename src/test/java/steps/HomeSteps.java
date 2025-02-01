package steps;

import connector.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Given;
import pages.HomePage;

public class HomeSteps {
    HomePage homePage = new HomePage(Hooks.driver);

    @Given("User is redirect to the Home Page")
    public void user_is_redirect_to_the_home_page() {
        homePage.assertThatHomePageIsDisplayed();
    }

    @Then("Choose round Trip")
    public void choose_round_trip() {
    homePage.chooseRoundTrip();
    }

    @When("Set the number of passengers")
    public void set_the_number_of_passengers()  {
    homePage.pickThePassenger();
    }

    @When("Choose the currency")
    public void choose_the_currency()  {
    homePage.chooseTheCurrency();
    }

    @Then("Click on Search Flight Button")
    public void click_on_search_flight_button() throws InterruptedException {
    homePage.clickOnSearchFlightButton();
    }

    @When("Choose the country")
    public void choose_the_country() {
        homePage.chooseTheCountry();
    }


    @And("set the Date")
    public void setTheDate() throws InterruptedException {
        homePage.setTheDate();
    }

    @Then("Verify that the Flight isn't displayed")
    public void verifyThatTheFlightIsnTDisplayed() {
        homePage.assertThatSearchFlightNotExist();
    }
}
