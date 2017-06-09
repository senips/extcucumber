import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Created by senips on 6/8/17.
 */
public class Hello {

    @Given("^numbers (\\d+) and (\\d+)$")
    public void numbers_and(int a, int b) throws Throwable {
        System.out.println();
    }

    @When("^we add them$")
    public void we_add_them() throws Throwable {

    }

    @Then("^the value should (\\d+)$")
    public void the_value_should(int arg1) throws Throwable {

    }

}
