package main

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory

class KotlinlangPage(private val driver: WebDriver) {

    // @FindBy is a helper, so that we can use more declarative style
    @FindBy(className = "global-header-logo")
    private lateinit var logoElement: WebElement

    init {
        // Initialize all lateinit @FindBy elements
        initElements()
    }

    public fun open() {
        // Open kotlinlang.org page in browser
        driver.get("https://kotlinlang.org")
    }

    public fun getLogoText(): String {
        return logoElement.text
    }

    /**
     * Use in constructor to initialize @FindBy elements.
     * Optionally, timeout can be passed to override default.
     */
    private fun initElements(timeoutInSeconds: Int = 5) {
        PageFactory.initElements(AjaxElementLocatorFactory(driver, timeoutInSeconds), this)
    }
}
