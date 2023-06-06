package appiumtests;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public class AppiumTikTok {

	static AndroidDriver driver;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			
			openTikTok();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getCause());
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	public static void openTikTok() throws Exception {
		
		DesiredCapabilities cap = new DesiredCapabilities();
		
		cap.setCapability("deviceName", "Pixel 2");
		cap.setCapability("udid", "FA8211A00763");
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "11");
		
		cap.setCapability("appPackage", "com.zhiliaoapp.musically");
		cap.setCapability("appActivity", "com.ss.android.ugc.aweme.main.MainActivity");
		
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		driver = new AndroidDriver(url, cap);
		
		System.out.println("App Started...");
		
		//connectToInstagram();
	}
	
	public static void connectToInstagram() {
		//Connecter à l'application Instagram
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement seConnecter = driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"Se connecter\"]"));
		
		seConnecter.click();
		System.out.println("Connecter au compte");
		myProfileOnInstagram();
		
		
	}
	
	public static void myProfileOnInstagram() {
		//Aller sur notre profil Instagram
		try {
			Thread.sleep(8000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement allerSurProfile = driver.findElement(By.id("com.instagram.android:id/tab_avatar"));
		
		allerSurProfile.click();
		//tap((int)811.360,(int)1038.411);
		System.out.println("Click sur mon profil");
		myFollowingOnInstagram();
	}
	
	public static void myFollowingOnInstagram() {
		//Aller mes "Abonnements" Instagram
		try {
			Thread.sleep(8000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		WebElement allerSurFollowing = driver.findElement(By.xpath("//android.view.View[@content-desc=\"0Abonnements\"]/android.widget.TextView[2]")); 
		
		allerSurFollowing.click();
		System.out.println("Click Abonnement fait");
		//scrollOnMyRecommendedInstagram();
		
		swipeToUp();
	}
	
	
	
	public static void swipeToUp() {
		
		try {
			Thread.sleep(8000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        //generic layout locator
        WebElement ele = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup"));
            
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
        
        System.out.println("Scroll fait");
    }
}