package TheScoreTest

import io.cucumber.java.en.And
import io.cucumber.java.en.Given
import io.cucumber.java.en.Then
import io.cucumber.java.en.When
import org.junit.Assert.*
import theScore.TheScore
import utils.CheckAssert

import java.util.logging.Logger


class TheScoreStep {
    private val log: Logger
        get() = Logger.getLogger(TheScoreStep::class.java.name)

    private val theScore: TheScore = TheScore()

    //SCENARIO 1
    @Given("Check if theScore app is installed correcly")
    fun setUpNew() {
        CheckAssert.assertTrueFailure("The Score app is not installed correctly", theScore.checkingTheScoreAppInstalled())
    }

    @When("Tap on Get Started to open favorite leagues page")
    fun `Tap on Get Started to open favorite leagues page`() {
        if (CheckAssert.assertTrueFailure("Welcome Page not found", theScore.verifyWelcomePage())) {
            CheckAssert.assertTrueFailure(
                "Cannot find GetStarted Button",
                theScore.clickById("com.fivemobile.thescore:id/action_button_text")
            )
        }
    }

    @Then("favorite leagues page open corectly")
    fun `favorite leagues page open corectly`() {
        CheckAssert.assertTrueFailure(
            "User are not in favourites leagues Pages",
            theScore.`verify Choose your favourite leagues page`()
        )
    }

    @When("Select first 2 leagues")
    fun `Select first 2 leagues`() {
        if (CheckAssert.assertTrueFailure("Cannot find recycler view", theScore.selectFavoriteLeagues())) {
            log.info("Selected 2 first League")
        }
    }

    @And("tap on Continue")
    fun `tap on Continue`() {
        if (CheckAssert.assertTrueFailure("Cannot find Continue Button", theScore.clickOnContinueButton())) {
            log.info("Tap on Continue")
        }
    }

    var isLocationPopUp = false

    @Then("Check if Allow Location Popup show up")
    fun `Check if Allow Location Popup show up`() {
        if (theScore.isLocationPermissionPopUpShowUp()) {
            log.info("Location permission popup show up")
            isLocationPopUp = true
        } else {
            log.info("Location Permission is not show up")
            isLocationPopUp = false
        }
    }

    @When("Tap on Maybe Later to close popup or Do nothing")
    fun denyLocationPermissionPopUp() {
        if (isLocationPopUp) {
            CheckAssert.assertTrueFailure(
                "Cannot click on deny Location Permission",
                theScore.denyLocationPermissionPopup()
            )
            log.info("location popup is closed")

        }
    }

    @Then("Choose your favorite teams page open")
    fun `Choose your favorite teams page open`() {
        if (CheckAssert.assertTrueFailure(
                "User is not in favourites Team Pages",
                theScore.verifyFavoritesTeamsPage()
            )
        ) {
            log.info("Choose your favorite teams page open correctly")
        }
    }

    @When("Select first 2 Teams")
    fun `Select first 2 Teams and then tap on continue`() {
        if (CheckAssert.assertTrueFailure("Cannot find recycler view", theScore.selectFavoriteTeams())) {
            log.info("Selected first 2 Teams.")
        }
    }

    @Then("Page setting customize notification open")
    fun `Page setting customize notification open`() {
        if (CheckAssert.assertTrueFailure("Cannot find recycler view", theScore.verifySettingPage())) {
            log.info("Page setting customize notification open correctly")
        }
    }

    @When("Tap on Done")
    fun `Tap on Done`() {
        CheckAssert.assertTrueFailure("Cannot click on Done", theScore.tapOnDone())
    }

    var isNotificationPopUp = false

    @Then("Check if Notification permission popup show up")
    fun `Check if Notification permission popup show up`() {
        // Check if popup notifications show up
        if (theScore.isNotificationPopUpShowUp()) {
            log.info("notifications popup show up")
            isNotificationPopUp = true
        } else {
            log.info("notifications popup is not show up")
            isNotificationPopUp = false
        }
    }

    @When("Tap on Don't Allow to close popup or Do nothing")
    fun `Tap on Don't Allow to close popup or Do nothing`() {
        if (isNotificationPopUp) {
            if (CheckAssert.assertTrueFailure(
                    "Notification popup cannot close",
                    theScore.denyNotificationsPopUp()
                )
            ) {
                log.info("notifications popup is closed")
            }
        }
    }

    var isScoreBetPopUp = false

    @Then("Check if TheScore Bet App popup show up")
    fun `Check if TheScore Bet App popup show up`() {
        if (theScore.isScoreBetPopUpShowUp()) {
            log.info("theScore BET show up")
            isScoreBetPopUp = true
        } else {
            log.info("theScore BET is not show up")
            isScoreBetPopUp = false
        }
    }

    @When("Tap on close button or Do nothing")
    fun `Tap on close button or Do nothing`() {
        if (isScoreBetPopUp) {
            if (CheckAssert.assertTrueFailure("ScoreBet popup cannot closed", theScore.closeScoreBetPopUp())) {
                log.info("Closed Score Bet Popup")
            }
        }
    }

    @Then("Main Menu page open correctly")
    @Given("Main Menu page open")
    fun `Main Menu page open correctly`() {
        if (CheckAssert.assertTrueFailure("User is not in main menu Page", theScore.verifyMainMenuPage())) {
            log.info("Main Menu page open correctly")
        }
    }

    //    SCENARIO 2
    @When("User tap on League Page")
    fun `User tap on League Page`() {
        CheckAssert.assertTrueFailure("Do not found League Page", theScore.clickLeagues())
    }

    @Then("League Page open corectly")
    fun `League Page open corectly`() {
        CheckAssert.assertTrueFailure("League Page does not open correctly", theScore.verifyLeaguesPage())
    }

    @And("Double Click on edit to avoid popup")
    fun `Double Click on edit to avoid popup`() {
        CheckAssert.assertTrueFailure(
            "Double Click on edit to avoid popup failed",
            theScore.doubleClickOnEditToAvoidPopup()
        )
    }

    @When("^User tap on the (.+) league page$")
    fun userTapOnLeaguePage(league: String) {
        CheckAssert.assertTrueFailure("$league league does not exist", theScore.selectLeagues(league))
    }

    @Then("^the (.+) page opens correctly$")
    @Then("^User back to (.+) league page$")
    fun `the selected league page opens correctly`(league: String) {
        CheckAssert.assertTrueFailure(
            "$league page does not open correctly",
            theScore.verifySelectedLeagues(league)
        )
    }

    @When("^User tap on the (.+) tab$")
    fun `User tap on the selected sub tab`(subtab: String) {
        CheckAssert.assertTrueFailure("$subtab does not exist", theScore.selectSubtab(subtab))
    }

    @Then("^User is on the (.+) tab with correct data$")
    fun `User is on the selected sub tab with correct data`(subtab: String) {
        CheckAssert.assertTrueFailure("$subtab does not selected", theScore.verifySelectedSubtab(subtab))
    }

    @When("^User tap on (.+) Team$")
    fun `User tap on selected Team`(teamShortName: String) {
        CheckAssert.assertTrueFailure("$teamShortName does not exist", theScore.selectTeam(teamShortName))
    }

    @Then("^(.+)Team information open correctly$")
    fun `selected Team information open correctly`(teamLongName: String) {
        CheckAssert.assertTrueFailure(
            "$teamLongName page does not open correctly",
            theScore.verifySelectedTeam(teamLongName)
        )
    }

    @When("User navigate back")
    fun `User navigate back`() {
        CheckAssert.assertTrueFailure("Do not found navigate back button", theScore.clickOnBackNavigate())
    }
}