package theScore
import utils.CheckAssert
import utils.DriverClass;
import java.util.logging.Logger

open class TheScore : DriverClass() {

    private val log: Logger
        get() = Logger.getLogger(TheScore::class.java.name)

    fun verifySelectedSubtab(tab: String): Boolean{
        log.info("Verifying selected sub tab $tab")
        val tabXpath = "//android.widget.LinearLayout[@content-desc=\""+tab+"\"]"
        return findByXpath(tabXpath).isSelected
    }

    fun selectSubtab(tab: String): Boolean {
        log.info("Selected sub tab $tab")
        val tabXpath = "//android.widget.LinearLayout[@content-desc=\""+tab+"\"]"
        return if (isVisibleByXpath(tabXpath)){
            clickByXpath(tabXpath)
        }else{
            false
        }
    }

    fun verifyWelcomePage(): Boolean {
        log.info("Verifying Welcome page")
        return if (isVisibleById("com.fivemobile.thescore:id/txt_welcome")) {
            CheckAssert.assertTrue(
                "WELCOME",
                findById("com.fivemobile.thescore:id/txt_welcome").text
            )
        } else {
            false
        }
    }

    fun clickLeagues(): Boolean {
        log.info("Click to Leagues tab")
        return clickByXpath("//android.widget.TextView[@resource-id=\"com.fivemobile.thescore:id/navigation_bar_item_small_label_view\" and @text=\"Leagues\"]")
    }

    fun selectLeagues(leagues: String): Boolean {
        log.info("Select leagues $leagues")
        val leaguesXpath = "//android.widget.TextView[@resource-id=\"com.fivemobile.thescore:id/league_name_text\" and @text=\""+leagues+"\"]"
        return if (isVisibleByXpath(leaguesXpath)){
            clickByXpath(leaguesXpath)
            true
        }else{
            log.severe("Leagues does NOT FOUND")
            false
        }
    }

    fun verifySelectedLeagues(league: String): Boolean {
        log.info("Verifying selected $league leagues")
        if (isVisibleById("com.fivemobile.thescore:id/titleTextView")){
            return CheckAssert.assertTrue(league, findById("com.fivemobile.thescore:id/titleTextView").text)
        }else{
            log.severe("User is not on Selected Leagues!")
            return false
        }
    }

    fun verifyLeaguesPage(): Boolean {
        log.info("Verifying leagues page")
        return if (isVisibleById("com.fivemobile.thescore:id/titleTextView")) {
            CheckAssert.assertTrue(
                "Leagues",
                findById("com.fivemobile.thescore:id/titleTextView").text
            )
        } else {
            log.severe("You are not in leagues page")
            false
        }
    }

    fun `verify Choose your favourite leagues page`(): Boolean {
        log.info("Verifying favourite leagues page")
        return if (isVisibleById("com.fivemobile.thescore:id/title_onboarding")) {
            CheckAssert.assertTrue(
                "Choose your favorite leagues",
                findById("com.fivemobile.thescore:id/title_onboarding").text
            )
        } else {
            log.severe("You are not in favourites leagues Pages")
            false
        }
    }

    fun verifyFavoritesTeamsPage(): Boolean {
        log.info("Verifying favorites teams Page")
        return if (isVisibleById("com.fivemobile.thescore:id/title_onboarding")) {
            CheckAssert.assertTrue(
                "Choose your favorite teams",
                findById("com.fivemobile.thescore:id/title_onboarding").text
            )
        } else {
            log.severe("You are not in favourites utils.Team Pages")
            false
        }
    }

    fun verifySettingPage(): Boolean {
        log.info("Verifying setting page")
        return if (isVisibleById("com.fivemobile.thescore:id/title_onboarding")) {
            CheckAssert.assertTrue(
                "Never miss a game",
                findById("com.fivemobile.thescore:id/title_onboarding").text
            )
        } else {
            log.severe("You are not in setting Page")
            false
        }
    }

    fun verifyMainMenuPage(): Boolean {
        log.info("Verifying main menu Page")
        return if (isVisibleByXpath("//android.widget.TextView[@resource-id=\"com.fivemobile.thescore:id/navigation_bar_item_small_label_view\" and @text=\"News\"]")) {
            CheckAssert.assertTrue(
                "News",
                findByXpath("//android.widget.TextView[@resource-id=\"com.fivemobile.thescore:id/navigation_bar_item_small_label_view\" and @text=\"News\"]").text
            )
        } else {
            log.severe("You are not in main menu Page")
            false
        }
    }

    fun clickOnContinueButton(): Boolean {
        log.info("Click on Continue button")
        return clickById("com.fivemobile.thescore:id/action_button_text")
    }

    fun selectFavoriteLeagues(): Boolean {
        log.info("Select Favorite leagues")
        return if (isVisibleById("com.fivemobile.thescore:id/recyclerView")) {
            val items = getItemsArrayFromRecyclerViewById("com.fivemobile.thescore:id/recyclerView")
            var count = 0
            for (item in items) {
                clickByXpath("//android.widget.TextView[@resource-id=\"com.fivemobile.thescore:id/txt_name\" and @text=\"" + item.text + "\"]")
                count++
                if (count == 2) break
            }
            log.info("Selected 2 Favorite Leagues")
            true
        } else {
            log.severe("Cannot find recycler view")
            false
        }
    }

    fun selectFavoriteTeams(): Boolean {
        log.info("Select Favorite Teams")
        return if (isVisibleById("com.fivemobile.thescore:id/recyclerView")) {
            val items = getItemsArrayFromRecyclerViewById("com.fivemobile.thescore:id/recyclerView")
            var count = 0
            for (item in items) {
                clickByXpath("//android.widget.TextView[@resource-id=\"com.fivemobile.thescore:id/txt_name\" and @text=\"" + item.text + "\"]")
                count++
                if (count == 2) break
            }
            log.info("Selected 2 Favorite Teams")
            true
        } else {
            log.severe("Cannot find recycler view")
            false
        }
    }

    fun denyLocationPermissionPopup():Boolean {
        log.info("Deny Location Permission pop up")
        return clickById("com.fivemobile.thescore:id/btn_disallow")
    }

    fun denyNotificationsPopUp():Boolean {
        log.info("Deny Notification Pop Up")
        return clickById("com.android.permissioncontroller:id/permission_deny_button")
    }

    fun closeScoreBetPopUp(): Boolean {
        log.info("Close Score Bet Pop up")
        return clickById("com.fivemobile.thescore:id/dismiss_modal")
    }

    fun isLocationPermissionPopUpShowUp(): Boolean {
        log.info("Check if Location permission pop up show up")
        return isVisibleById("com.fivemobile.thescore:id/location_title")
    }

    fun isNotificationPopUpShowUp(): Boolean {
        log.info("Check if notification pop up show up")
        // Check if popup notifications show up
        if (isVisibleById("com.android.permissioncontroller:id/permission_message")) {
            log.info("notifications popup show up")
            return true
        } else {
            log.info("notifications popup is not show up")
            return false
        }
    }

    fun isScoreBetPopUpShowUp(): Boolean {
        log.info("Check if Score Bet Popup show up")
        if (isVisibleById("com.fivemobile.thescore:id/subtitle_text")) {
            log.info("theScore BET show up")
            return true
        } else {
            log.info("theScore BET is not show up")
            return false
        }
    }

    // Testing navigate from Get Started to Choose your favourite leagues
//    fun `Navigate from getStarted to Choose your favourite leagues`(): Boolean {
//        log.info("navigate from getStarted to Choose your favourite leagues")
//        if (verifyWelcomePage()) {
//            if (clickById("com.fivemobile.thescore:id/action_button_text")) {
//                if (`verify Choose your favourite leagues page`()) {
//                    return true
//                }
//            }
//        }
//        return false;
//    }

    //testing Navigate from Favourite Leagues to favourite teams
//    fun `Navigate from Favourite Leagues to favourite teams`(): Boolean {
//        log.info("Navigate from Favourite Leagues to favourite teams")
//        if (`verify Choose your favourite leagues page`()) {
//            if (selectFavoriteLeagues()) {
//                if (isLocationPermissionPopUpShowUp()) {
//                    denyLocationPermissionPopup()
//                }
//                return verifyFavoritesTeamsPage()
//            }
//        }
//        return false
//    }

    fun tapOnDone(): Boolean {
        log.info("Tap on Done button")
        return clickById("com.fivemobile.thescore:id/action_button_text")
    }

    // Test Navigate from Favorite Teams To Main Menu
//    fun `Navigate from Favorite Teams To Main Menu`(): Boolean {
//        log.info("Navigate from Favorite Teams To Main Menu")
//        if (verifyFavoritesTeamsPage()) {
//            if (selectFavoriteTeams()) {
//                if (verifySettingPage()) {
//                    clickById("com.fivemobile.thescore:id/action_button_text")
//                    if (isNotificationPopUpShowUp()) {
//                        denyNotificationsPopUp()
//                        if (isScoreBetPopUpShowUp()) {
//                            closeScoreBetPopUp()
//                            return verifyMainMenuPage()
//                        }
//                    }
//                }
//            }
//        }
//        return false
//    }

    fun openLeague(league: String): Boolean {
        log.info("Open League Test: ")
        if(verifyMainMenuPage()){
            if(clickLeagues()){
                if(verifyLeaguesPage()){
                    if(selectLeagues(league)){
                        if (verifySelectedLeagues(league)){
                            log.info("Correctly $league league selected")
                            return true
                        }
                    }
                }
            }
        }
        log.severe("NOT FOUND league $league")
        return false
    }


    fun selectLeaguesSubTab(tab: String): Boolean{
        log.info("Select League Subtab: ")
        if(selectSubtab(tab)){
            if(verifySelectedSubtab(tab)){
                log.info("Correctly selected $tab subtab")
                return true
            }
        }
        log.severe("NOT FOUND subtab $tab")
        return false
    }

    fun selectTeam(teamShortName: String): Boolean{
        log.info("Select utils.Team")
        val items = getItemsArrayFromRecyclerViewById("com.fivemobile.thescore:id/recyclerView")
        for (item in items){
            if(item.text == teamShortName){
                log.info("Found team $teamShortName")
                val xpath = "//android.widget.TextView[@resource-id=\"com.fivemobile.thescore:id/txt_name\" and @text=\""+teamShortName+"\"]"
                clickByXpath(xpath)
                return true
            }
        }
        log.severe("NOT FOUND team $teamShortName")
        return false

    }

    fun verifySelectedTeam(teamLongName: String): Boolean{
        log.info("Verify Selected utils.Team")
        if (isVisibleById("com.fivemobile.thescore:id/team_name")){
            log.info("Correct Selected utils.Team $teamLongName")
            return CheckAssert.assertTrue(findById("com.fivemobile.thescore:id/team_name").text, teamLongName)
        }else{
            log.severe("Incorrect Selected utils.Team!")
            return false
        }
    }

    fun selectTeamOfLeagues(teamShortName: String, league: String, teamLongName: String){
        log.info("Select utils.Team Of Leagues")
        if(openLeague(league)){
            if(selectLeaguesSubTab("Standings")){
                if(selectTeam(teamShortName)){
                    if(verifySelectedTeam(teamLongName)){
                        log.info("Select utils.Team Of Leagues Successful")
                    }
                }
            }
        }
    }

    fun clickOnBackNavigate(): Boolean{
        log.info("Click on Back Navigate")
        return clickByAccessibilityId("Navigate up")
    }

    fun clickOnEdit(): Boolean{
        log.info("Click on Edit")
        return clickById("com.fivemobile.thescore:id/header_right_text")
    }

    fun clickOnDoneToCloseEdit(): Boolean{
        log.info("Click on Done")
        return clickById("com.fivemobile.thescore:id/header_right_text")
    }

    fun doubleClickOnEditToAvoidPopup(): Boolean{
        log.info("Double click on Edit/Done to avoid pop up")
        if(clickOnEdit() && clickOnDoneToCloseEdit()){
            return true
        }
        return false
    }
    fun checkingTheScoreAppInstalled(): Boolean{
        return checkingInstalledApp()
    }
}