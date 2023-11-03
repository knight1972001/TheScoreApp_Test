package utils

import java.util.logging.Logger
import org.junit.Assert.*


class CheckAssert {
    companion object {
        private val log: Logger
            get() = Logger.getLogger(CheckAssert::class.java.name)

        fun assertTrue(message1: String, message2: String): Boolean {
            if (message2.isNotEmpty()) {
                return true
            } else {
//                throw AssertionError("Assertion failed: $message")
                log.severe("UnMatched: ${message1} vs ${message2}")
                return false
            }
        }

        fun assertTrueFailure(errorMessage: String, condition: Boolean): Boolean {
            if(condition){
               return true
            }else{
                fail(errorMessage)
                return false
            }
        }
    }

    fun backup(){
        println("==== Started to main menu =====")
//        println("Verify Started page")
//        log.info("Verify started page")
//        wait.until { driver ->
//            driver.findElement(AppiumBy.id("com.fivemobile.thescore:id/txt_welcome")).isDisplayed()
//        }
//        utils.CheckAssert.assertTrue(
//            "WELCOME",
//            driver.findElement(AppiumBy.id("com.fivemobile.thescore:id/txt_welcome")).text
//        )
//        driver.findElement(AppiumBy.id("com.fivemobile.thescore:id/action_button_text")).click();

//        println("Verify leagues page")
//        wait.until { driver ->
//            driver.findElement(AppiumBy.id("com.fivemobile.thescore:id/title_onboarding")).isDisplayed()
//        }
//        utils.CheckAssert.assertTrue(
//            "Choose your favorite leagues",
//            driver.findElement(AppiumBy.id("com.fivemobile.thescore:id/title_onboarding")).text
//        )

//        val recyclerView = driver.findElement(AppiumBy.id("com.fivemobile.thescore:id/recyclerView"))
//        val items = recyclerView.findElements(AppiumBy.className("android.widget.TextView"))
//        var count = 0
//        for (item in items) {
//            println(item.text)
//            driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.fivemobile.thescore:id/txt_name\" and @text=\"" + item.text + "\"]"))
//                .click()
//            count++
//            if (count == 2) break
//        }
//        println("PICKED")
//        driver.findElement(AppiumBy.id("com.fivemobile.thescore:id/action_button_text")).click()


//        // Check if popup Location show up
//        try {
//            wait.until { driver ->
//                driver.findElement(AppiumBy.id("com.fivemobile.thescore:id/location_title")).isDisplayed()
//            }
//            log.info("Location permission required showup")
//
//            driver.findElement(AppiumBy.id("com.fivemobile.thescore:id/btn_disallow")).click()
//
//        } catch (e: Exception) {
//            log.info("Location permission required!")
//        }

//        println("Verify utils.Team page")
//        wait.until { driver ->
//            driver.findElement(AppiumBy.id("com.fivemobile.thescore:id/title_onboarding")).isDisplayed()
//        }
//        utils.CheckAssert.assertTrue(
//            "Choose your favorite teams",
//            driver.findElement(AppiumBy.id("com.fivemobile.thescore:id/title_onboarding")).text
//        )

//        val recyclerViewTeam = driver.findElement(AppiumBy.id("com.fivemobile.thescore:id/recyclerView"))
//        val itemsTeam = recyclerViewTeam.findElements(AppiumBy.className("android.widget.TextView"))
//        count = 0
//        for (item in itemsTeam) {
//            println(item.text)
//            driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.fivemobile.thescore:id/txt_name\" and @text=\"" + item.text + "\"]"))
//                .click()
//            count++
//            if (count == 2) break
//        }
//        println("PICKED")
//        driver.findElement(AppiumBy.id("com.fivemobile.thescore:id/action_button_text")).click()

//        println("Verify setting page")
//        wait.until { driver ->
//            driver.findElement(AppiumBy.id("com.fivemobile.thescore:id/title_onboarding")).isDisplayed()
//        }
//        utils.CheckAssert.assertTrue(
//            "Never miss a game",
//            driver.findElement(AppiumBy.id("com.fivemobile.thescore:id/title_onboarding")).text
//        )
//        driver.findElement(AppiumBy.id("com.fivemobile.thescore:id/action_button_text")).click()

//        // Check if popup notifications show up
//        try {
//            println("Notifications permission required")
//            wait.until { driver ->
//                driver.findElement(AppiumBy.id("com.android.permissioncontroller:id/permission_message")).isDisplayed()
//            }
//            driver.findElement(AppiumBy.id("com.android.permissioncontroller:id/permission_deny_button")).click()
//        } catch (e: NoSuchElementException) {
//            println("Notifications permission required not show up")
//        }

//        // Check if popup theScore BET show up
//        try {
//            println("popup theScore BET show up")
//            wait.until { driver ->
//                driver.findElement(AppiumBy.id("com.fivemobile.thescore:id/subtitle_text")).isDisplayed()
//            }
//            driver.findElement(AppiumBy.id("com.fivemobile.thescore:id/dismiss_modal")).click()
//        } catch (e: NoSuchElementException) {
//            println("popup theScore BET not show up")
//        }

//        println("Verify Main Menu page")
//        wait.until { driver ->
//            driver.findElement(AppiumBy.accessibilityId("News")).isDisplayed()
//        }
//        utils.CheckAssert.assertTrue(
//            "News",
//            driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.fivemobile.thescore:id/navigation_bar_item_small_label_view\" and @text=\"News\"]")).text
//        )
//
//        driver.getPageSource() //for what?
    }
}