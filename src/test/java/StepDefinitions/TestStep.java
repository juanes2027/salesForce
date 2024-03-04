package StepDefinitions;

import PageObjects.Test;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.io.IOException;

public class TestStep {
    private Test testInstance;


    public TestStep() {
        this.testInstance = Test.getInstance(Hooks.driver, Hooks.wait);

    }

    @Given("The user Login in the website")
    public void the_user_login_in_the_website() throws IOException, InterruptedException {

        testInstance.signin();
    }

    @When("The user goes to the account and creates a new one")
    public void the_user_goes_to_the_account_and_creates_a_new_one() throws InterruptedException, IOException {

        testInstance.account();

    }
    @Then("The user validate the new account")
    public void the_user_validate_the_new_account() throws IOException, InterruptedException {

        testInstance.validateAccount();
    }

    @And("Edit account that the user just created")
    public void edit_account_that_the_user_just_created()  {
        testInstance.editAccount();

    }



    @Then("The user validate the update")
    public void the_user_validate_the_update() throws IOException, InterruptedException {
        testInstance.validateUpdate();

    }

}
