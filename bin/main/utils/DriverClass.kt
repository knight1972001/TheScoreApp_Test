package utils

import io.appium.java_client.AppiumBy
import io.appium.java_client.android.AndroidDriver
import org.junit.Before
import org.openqa.selenium.WebElement
import org.openqa.selenium.remote.DesiredCapabilities
import org.openqa.selenium.support.ui.WebDriverWait
import java.net.MalformedURLException
import java.net.URL
import java.time.Duration
import java.util.logging.Logger


open class DriverClass() {
    private lateinit var driver: AndroidDriver
    private var wait: WebDriverWait

    private val log: Logger
        get() = Logger.getLogger(DriverClass::class.java.name)

    private val PORT = "4723"
    private val HOST = "127.0.0.1"

    init{
        setUp()
        wait = WebDriverWait(driver, Duration.ofSeconds(10))
    }

    @Throws(MalformedURLException::class)
    fun setUp(){
        val desiredCapabilities = DesiredCapabilities()
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("appium:deviceName", "emulator-5554");
        desiredCapabilities.setCapability("appium:appPackage", "com.fivemobile.thescore");
        desiredCapabilities.setCapability("appium:appActivity", "com.fivemobile.thescore.ui.MainActivity");
        desiredCapabilities.setCapability("appium:ensureWebviewsHavePages", true);
        desiredCapabilities.setCapability("appium:nativeWebScreenshot", true);
        desiredCapabilities.setCapability("appium:newCommandTimeout", 3600);
        desiredCapabilities.setCapability("appium:connectHardwareKeyboard", true);

        driver = AndroidDriver(getUrl(HOST, PORT), desiredCapabilities)
    }

    fun getUrl(host: String, port: String): URL? {
        try {
            return URL("http://$host:$port/wd/hub")
        } catch (e: MalformedURLException) {
            e.printStackTrace();
        }
        return null;
    }

    fun tearDown() {
        driver.quit();
    }

    fun checkingInstalledApp(): Boolean {
        // Check if the app is installed
        return driver.isAppInstalled("com.fivemobile.thescore")
    }

    fun isVisibleById(id: String): Boolean {
        return try {
            wait.until { driver ->
                driver.findElement(AppiumBy.id(id))
            }
            true
        } catch (e: Exception) {
            log.severe("Not found id: ${id}")
            false
        }
    }

    fun isVisibleByXpath(xpath: String): Boolean {
        val wait = WebDriverWait(driver, Duration.ofSeconds(10))
        return try {
            wait.until { driver ->
                driver.findElement(AppiumBy.xpath(xpath))
            }
            true
        } catch (e: Exception) {
            log.severe("Not found Xpath: ${xpath}")
            false
        }
    }

    fun clickByAccessibilityId(accessibilityId: String): Boolean{
        return if (isVisibleByAccessibilityId(accessibilityId)){
            driver.findElement(AppiumBy.accessibilityId(accessibilityId)).click()
            true
        }else{
            log.severe("Not Found AccessibilityId $accessibilityId")
            false
        }
    }

    fun isVisibleByAccessibilityId(accessibilityId: String): Boolean {
        val wait = WebDriverWait(driver, Duration.ofSeconds(10))
        return try {
            wait.until { driver ->
                driver.findElement(AppiumBy.accessibilityId(accessibilityId))
            }
            true
        } catch (e: Exception) {
            log.severe("Not found accessibilityId: ${accessibilityId}")
            false
        }
    }

    fun findById(id: String): WebElement {
        return driver.findElement(AppiumBy.id(id))
    }

    fun findByXpath(xpath: String): WebElement {
        return driver.findElement(AppiumBy.xpath(xpath))
    }

    fun findByAccessibilityId(accessibilityId: String): WebElement {
        return driver.findElement(AppiumBy.accessibilityId(accessibilityId))
    }

    fun clickById(id: String): Boolean {
        return if (isVisibleById(id)) {
            driver.findElement(AppiumBy.id(id)).click();
            true
        } else {
            false
        }
    }

    fun clickByXpath(xpath: String): Boolean {
        return if (isVisibleByXpath(xpath)){
            driver.findElement(AppiumBy.xpath(xpath)).click()
            true
        }else{
            false
        }
    }

    fun getItemsArrayFromRecyclerViewById(id: String): List<WebElement> {
        if (isVisibleById(id)) {
            val recyclerView = findById(id)
            return recyclerView.findElements(AppiumBy.className("android.widget.TextView"))
        }
        return emptyList()
    }
}