package appiumtests;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import java.time.Duration;
import java.util.Arrays;

public class Swipe {

	 private AppiumDriver driver;

	    private WebElement ele = null;

	    public Swipe(AppiumDriver driver) {
	        this.driver = driver;
	    }

	   //Code to perform Swipe Up Action
	   public void swipeToUp() {

	        //Open your app in inspector and find your generic layout locator
	        if (driver instanceof AndroidDriver) {
	            ele = driver.findElement(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup"));
	        } //else {
	          //  ele = driver.findElement(AppiumBy.accessibilityId(WebElement.IOS_GEN_LOCATOR));
	       // }

	        int X = ele.getRect().x + (ele.getSize().width / 2);
	        int StartY = ele.getRect().y + (ele.getSize().height * 3 / 4);
	        int EndY = ele.getRect().y + (ele.getSize().height / 4);

	        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
	        Sequence dragNDrop = new Sequence(finger, 1);
	        dragNDrop.addAction(finger.createPointerMove(Duration.ofSeconds(0),
	                PointerInput.Origin.viewport(), X, StartY));
	        dragNDrop.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
	        dragNDrop.addAction(finger.createPointerMove(Duration.ofMillis(700),
	                PointerInput.Origin.viewport(), X, EndY));
	        dragNDrop.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
	        driver.perform(Arrays.asList(dragNDrop));
	    }

	    //Code to perform Swipe Down Action
	    public void swipeToDown() {

	        if (driver instanceof AndroidDriver) {
	            ele = driver.findElement(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup"));
	        } //else {
	          //  ele = driver.findElement(AppiumBy.accessibilityId(WebElement.IOS_GEN_LOCATOR));
	        //}

	        int X = ele.getRect().x + (ele.getSize().width / 2);
	        int StartY = ele.getRect().y + (ele.getSize().height / 4);
	        int EndY = ele.getRect().y + (ele.getSize().height * 3 / 4);

	        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
	        Sequence dragNDrop = new Sequence(finger, 1);
	        dragNDrop.addAction(finger.createPointerMove(Duration.ofSeconds(0),
	                PointerInput.Origin.viewport(), X, StartY));
	        dragNDrop.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
	        dragNDrop.addAction(finger.createPointerMove(Duration.ofMillis(700),
	                PointerInput.Origin.viewport(), X, EndY));
	        dragNDrop.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
	        driver.perform(Arrays.asList(dragNDrop));
	    }

	    //Code to perform Swipe Left Action
	    public void swipeToLeft() {

	        if (driver instanceof AndroidDriver) {
	            ele = driver.findElement(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup"));
	        } 

	        int X = ele.getRect().x + (ele.getSize().width * 3 / 4);
	        int EndX = ele.getRect().x + (ele.getSize().width / 4);
	        int StartY = ele.getRect().y + (ele.getSize().height / 2);

	        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
	        Sequence dragNDrop = new Sequence(finger, 1);
	        dragNDrop.addAction(finger.createPointerMove(Duration.ofSeconds(0),
	                PointerInput.Origin.viewport(), X, StartY));
	        dragNDrop.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
	        dragNDrop.addAction(finger.createPointerMove(Duration.ofMillis(700),
	                PointerInput.Origin.viewport(), EndX, StartY));
	        dragNDrop.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
	        driver.perform(Arrays.asList(dragNDrop));
	    }

	    //Code to perform Swipe Right Action
	    public void swipeToRight() {


	        if (driver instanceof AndroidDriver) {
	            ele = driver.findElement(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup"));
	        } 

	        int X = ele.getRect().x + (ele.getSize().width / 4);
	        int EndX = ele.getRect().x + (ele.getSize().width * 3 / 4);
	        int StartY = ele.getRect().y + (ele.getSize().height / 2);

	        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
	        Sequence dragNDrop = new Sequence(finger, 1);
	        dragNDrop.addAction(finger.createPointerMove(Duration.ofSeconds(0),
	                PointerInput.Origin.viewport(), X, StartY));
	        dragNDrop.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
	        dragNDrop.addAction(finger.createPointerMove(Duration.ofMillis(700),
	                PointerInput.Origin.viewport(), EndX, StartY));
	        dragNDrop.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
	        driver.perform(Arrays.asList(dragNDrop));
	    }

	    //Code to perform Tap Action
	    public void tap(int x, int y){

	        PointerInput input = new PointerInput(PointerInput.Kind.TOUCH, "finger");
	        Sequence tap = new Sequence(input, 0);
	        tap.addAction(input.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), x, y));
	        tap.addAction(input.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
	        driver.perform(Arrays.asList(tap));
	    }
}
