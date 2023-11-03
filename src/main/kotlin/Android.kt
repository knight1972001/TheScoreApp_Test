//import io.appium.java_client.AppiumBy
//import io.appium.java_client.android.AndroidDriver
//import org.junit.After
//import org.junit.Before
//import org.junit.Test
//import org.openqa.selenium.WebElement
//import org.openqa.selenium.remote.DesiredCapabilities
//import utils.CheckAssert
//import java.net.MalformedURLException
//import java.net.URL
//import java.util.logging.Logger
//
//class Android {
//    private lateinit var driver: AndroidDriver
//    private val PORT = "4723"
//    private val HOST = "127.0.0.1"
//    private val log: Logger
//        get() = Logger.getLogger(Android::class.java.name)
//
//
//    @Before
//    @Throws(MalformedURLException::class)
//    fun setUp() {
//        val desiredCapabilities = DesiredCapabilities()
//        desiredCapabilities.setCapability("platformName", "Android");
//        desiredCapabilities.setCapability("appium:deviceName", "emulator-5554");
//        desiredCapabilities.setCapability("appium:appPackage", "com.fivemobile.thescore");
//        desiredCapabilities.setCapability("appium:appActivity", "com.fivemobile.thescore.ui.MainActivity");
//        desiredCapabilities.setCapability("appium:ensureWebviewsHavePages", true);
//        desiredCapabilities.setCapability("appium:nativeWebScreenshot", true);
//        desiredCapabilities.setCapability("appium:newCommandTimeout", 3600);
//        desiredCapabilities.setCapability("appium:connectHardwareKeyboard", true);
//
//        driver = AndroidDriver(getUrl(HOST, PORT), desiredCapabilities)
//    }
//
//
//    fun getUrl(host: String, port: String): URL? {
//        try {
//            return URL("http://$host:$port/wd/hub")
//        } catch (e: MalformedURLException) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
////    fun isVisibleById(id: String): Boolean {
////        val wait = WebDriverWait(driver, Duration.ofSeconds(10))
////        return try {
////            wait.until { driver ->
////                driver.findElement(AppiumBy.id(id))
////            }
////            true
////        } catch (e: Exception) {
////            log.severe("Not found id: ${id}")
////            false
////        }
////    }
////
////    fun isVisibleByXpath(xpath: String): Boolean {
////        val wait = WebDriverWait(driver, Duration.ofSeconds(10))
////        return try {
////            wait.until { driver ->
////                driver.findElement(AppiumBy.xpath(xpath))
////            }
////            true
////        } catch (e: Exception) {
////            log.severe("Not found Xpath: ${xpath}")
////            false
////        }
////    }
////
////    fun isVisibleByAccessibilityId(accessibilityId: String): Boolean {
////        val wait = WebDriverWait(driver, Duration.ofSeconds(10))
////        return try {
////            wait.until { driver ->
////                driver.findElement(AppiumBy.accessibilityId(accessibilityId))
////            }
////            true
////        } catch (e: Exception) {
////            log.severe("Not found accessibilityId: ${accessibilityId}")
////            false
////        }
////    }
////
////    fun findById(id: String): WebElement {
////        return driver.findElement(AppiumBy.id(id))
////    }
////
////    fun findByXpath(xpath: String): WebElement {
////        return driver.findElement(AppiumBy.xpath(xpath))
////    }
////
////    fun findByAccessibilityId(accessibilityId: String): WebElement {
////        return driver.findElement(AppiumBy.accessibilityId(accessibilityId))
////    }
//
//    fun verifyWelcomePage(): Boolean {
//        return if (isVisibleById("com.fivemobile.thescore:id/txt_welcome")) {
//            CheckAssert.assertTrue(
//                "WELCOME",
//                findById("com.fivemobile.thescore:id/txt_welcome").text
//            )
//        } else {
//            false
//        }
//    }
//
////    fun clickById(id: String): Boolean {
////        return if (isVisibleById(id)) {
////            driver.findElement(AppiumBy.id(id)).click();
////            true
////        } else {
////            false
////        }
////    }
////
////    fun clickByXpath(xpath: String): Boolean {
////        return if (isVisibleByXpath(xpath)){
////            driver.findElement(AppiumBy.xpath(xpath)).click()
////            true
////        }else{
////            false
////        }
////    }
//
//    fun clickLeagues(): Boolean {
//        return clickByXpath("//android.widget.TextView[@resource-id=\"com.fivemobile.thescore:id/navigation_bar_item_small_label_view\" and @text=\"Leagues\"]")
//    }
//
//    fun selectLeagues(leagues: String): Boolean {
//        val leaguesXpath = "//android.widget.TextView[@resource-id=\"com.fivemobile.thescore:id/league_name_text\" and @text=\""+leagues+"\"]"
//        return if (isVisibleByXpath(leaguesXpath)){
//            clickByXpath(leaguesXpath)
//            true
//        }else{
//            log.severe("Leagues does NOT FOUND")
//            false
//        }
//    }
//
//    fun verifySelectedLeagues(league: String): Boolean {
//        if (isVisibleById("com.fivemobile.thescore:id/titleTextView")){
//            return CheckAssert.assertTrue(league, findById("com.fivemobile.thescore:id/titleTextView").text)
//        }else{
//            log.severe("User is not on Selected Leagues!")
//            return false
//        }
//    }
//
//    fun verifyLeaguesPage(): Boolean {
//        log.info("Verifying leagues page")
//        return if (isVisibleById("com.fivemobile.thescore:id/titleTextView")) {
//            CheckAssert.assertTrue(
//                "Leagues",
//                findById("com.fivemobile.thescore:id/titleTextView").text
//            )
//        } else {
//            log.severe("You are not in leagues page")
//            false
//        }
//    }
//
//    fun `verify Choose your favourite leagues page`(): Boolean {
//        log.info("Verifying favourite leagues page")
//        return if (isVisibleById("com.fivemobile.thescore:id/title_onboarding")) {
//            CheckAssert.assertTrue(
//                "Choose your favorite leagues",
//                findById("com.fivemobile.thescore:id/title_onboarding").text
//            )
//        } else {
//            log.severe("You are not in favourites leagues Pages")
//            false
//        }
//    }
//
//    fun verifyFavoritesTeamsPage(): Boolean {
//        log.info("Verifying favorites teams Page")
//        return if (isVisibleById("com.fivemobile.thescore:id/title_onboarding")) {
//            CheckAssert.assertTrue(
//                "Choose your favorite teams",
//                findById("com.fivemobile.thescore:id/title_onboarding").text
//            )
//        } else {
//            log.severe("You are not in favourites utils.Team Pages")
//            false
//        }
//    }
//
//    fun verifySettingPage(): Boolean {
//        log.info("Verifying setting page")
//        return if (isVisibleById("com.fivemobile.thescore:id/title_onboarding")) {
//            CheckAssert.assertTrue(
//                "Never miss a game",
//                findById("com.fivemobile.thescore:id/title_onboarding").text
//            )
//        } else {
//            log.severe("You are not in setting Page")
//            false
//        }
//    }
//
//    fun verifyMainMenuPage(): Boolean {
//        log.info("Verifying main menu Page")
//        return if (isVisibleByXpath("//android.widget.TextView[@resource-id=\"com.fivemobile.thescore:id/navigation_bar_item_small_label_view\" and @text=\"News\"]")) {
//            CheckAssert.assertTrue(
//                "News",
//                findByXpath("//android.widget.TextView[@resource-id=\"com.fivemobile.thescore:id/navigation_bar_item_small_label_view\" and @text=\"News\"]").text
//            )
//        } else {
//            log.severe("You are not in main menu Page")
//            false
//        }
//    }
//
//
//    fun getItemsArrayFromRecyclerViewById(id: String): List<WebElement> {
//        if (isVisibleById(id)) {
//            val recyclerView = findById(id)
//            return recyclerView.findElements(AppiumBy.className("android.widget.TextView"))
//        }
//        return emptyList()
//    }
//
//    fun selectFavoriteLeagues(): Boolean {
//        return if (isVisibleById("com.fivemobile.thescore:id/recyclerView")) {
//            val items = getItemsArrayFromRecyclerViewById("com.fivemobile.thescore:id/recyclerView")
//            var count = 0
//            for (item in items) {
//                findByXpath("//android.widget.TextView[@resource-id=\"com.fivemobile.thescore:id/txt_name\" and @text=\"" + item.text + "\"]").click()
//                count++
//                if (count == 2) break
//            }
//            log.info("Selected 2 Favorite Leagues")
//            findById("com.fivemobile.thescore:id/action_button_text").click()
//            true
//        } else {
//            log.severe("Cannot find recycler view")
//            false
//        }
//    }
//
//    fun selectFavoriteTeams(): Boolean {
//        return if (isVisibleById("com.fivemobile.thescore:id/recyclerView")) {
//            val items = getItemsArrayFromRecyclerViewById("com.fivemobile.thescore:id/recyclerView")
//            var count = 0
//            for (item in items) {
//                findByXpath("//android.widget.TextView[@resource-id=\"com.fivemobile.thescore:id/txt_name\" and @text=\"" + item.text + "\"]").click()
//                count++
//                if (count == 2) break
//            }
//            log.info("Selected 2 Favorite Teams")
//            findById("com.fivemobile.thescore:id/action_button_text").click()
//            true
//        } else {
//            log.severe("Cannot find recycler view")
//            false
//        }
//    }
//
//    fun denyLocationPermissionPopup() {
//        clickById("com.fivemobile.thescore:id/btn_disallow")
//    }
//
//    fun denyNotificationsPopUp() {
//        clickById("com.android.permissioncontroller:id/permission_deny_button")
//    }
//
//    fun closeScoreBetPopUp() {
//        clickById("com.fivemobile.thescore:id/dismiss_modal")
//    }
//
//    fun isLocationPermissionPopUpShowUp(): Boolean {
//        if (isVisibleById("com.fivemobile.thescore:id/location_title")) {
//            log.info("Location permission popup show up")
//            return true
//        } else {
//            log.info("Location Permission is not show up")
//            return false
//        }
//    }
//
//    fun isNotificationPopUpShowUp(): Boolean {
//        // Check if popup notifications show up
//        if (isVisibleById("com.android.permissioncontroller:id/permission_message")) {
//            log.info("notifications popup show up")
//            return true
//        } else {
//            log.info("notifications popup is not show up")
//            return false
//        }
//    }
//
//    fun isScoreBetPopUpShowUp(): Boolean {
//        if (isVisibleById("com.fivemobile.thescore:id/subtitle_text")) {
//            log.info("theScore BET show up")
//            return true
//        } else {
//            log.info("theScore BET is not show up")
//            return false
//        }
//    }
//
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
//
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
//
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
//
//    fun verifySelectedSubtab(tab: String): Boolean{
//        val tabXpath = "//android.widget.LinearLayout[@content-desc=\""+tab+"\"]"
//        return findByXpath(tabXpath).isSelected
//    }
//
//    fun selectSubtab(tab: String): Boolean {
//        val tabXpath = "//android.widget.LinearLayout[@content-desc=\""+tab+"\"]"
//
//        return if (isVisibleByXpath(tabXpath)){
//            clickByXpath(tabXpath)
//        }else{
//            false
//        }
//    }
//
//
//    @Test
//    fun getStartedToMainMenu() {
//        log.info("Get Started to Main Menu:")
//        if (`Navigate from getStarted to Choose your favourite leagues`()) {
//            if (`Navigate from Favourite Leagues to favourite teams`()) {
//                if (`Navigate from Favorite Teams To Main Menu`()) {
//                    log.info("Test Successful")
//                }
//            }
//        }
////        driver.getPageSource()
//    }
//
//
//    fun openLeague(league: String): Boolean {
//        log.info("Open League Test: ")
//        if(verifyMainMenuPage()){
//            if(clickLeagues()){
//                if(verifyLeaguesPage()){
//                    if(selectLeagues(league)){
//                        if (verifySelectedLeagues(league)){
//                            log.info("Correctly $league league selected")
//                            return true
//                        }
//                    }
//                }
//            }
//        }
//        log.severe("NOT FOUND league $league")
//        return false
//    }
//
//
//    fun selectLeaguesSubTab(tab: String): Boolean{
//        log.info("Select League Subtab: ")
//        if(selectSubtab(tab)){
//            if(verifySelectedSubtab(tab)){
//                log.info("Correctly selected $tab subtab")
//                return true
//            }
//        }
//        log.severe("NOT FOUND subtab $tab")
//        return false
//    }
//
//    fun selectTeam(teamShortName: String): Boolean{
//        log.info("Select utils.Team")
//        val items = getItemsArrayFromRecyclerViewById("com.fivemobile.thescore:id/recyclerView")
//        for (item in items){
//            if(item.text == teamShortName){
//                log.info("Found team $teamShortName")
//                val xpath = "//android.widget.TextView[@resource-id=\"com.fivemobile.thescore:id/txt_name\" and @text=\""+teamShortName+"\"]"
//                clickByXpath(xpath)
//                return true
//            }
//        }
//        log.severe("NOT FOUND team $teamShortName")
//        return false
//
//    }
//
//    fun verifySelectedTeam(teamLongName: String): Boolean{
//        log.info("Verify Selected utils.Team")
//        if (isVisibleById("com.fivemobile.thescore:id/team_name")){
//            log.info("Correct Selected utils.Team $teamLongName")
//            return CheckAssert.assertTrue(findById("com.fivemobile.thescore:id/team_name").text, teamLongName)
//        }else{
//            log.severe("Incorrect Selected utils.Team!")
//            return false
//        }
//    }
//
//    fun clickByAccessibilityId(accessibilityId: String): Boolean{
//        return if (isVisibleByAccessibilityId(accessibilityId)){
//            driver.findElement(AppiumBy.accessibilityId(accessibilityId)).click()
//            true
//        }else{
//            log.severe("Not Found AccessibilityId $accessibilityId")
//            false
//        }
//    }
//
//    fun clickOnBackNavigate(): Boolean{
//            return clickByAccessibilityId("Navigate up")
//    }
//
//    fun selectTeamOfLeagues(teamShortName: String, league: String, teamLongName: String){
//        log.info("Select utils.Team Of Leagues")
//        if(openLeague(league)){
//            if(selectLeaguesSubTab("Standings")){
//                if(selectTeam(teamShortName)){
//                    if(verifySelectedTeam(teamLongName)){
//                        log.info("Select utils.Team Of Leagues Successful")
//                    }
//                }
//            }
//        }
//    }
//
//
//
////
////    @Test
////    fun openTeam(team: String) {
////
////    }
////
////    @Test
////    fun openPlayer(player: String) {
////
////    }
//
//    @After
//    fun tearDown() {
////        driver.quit();
//    }
//}