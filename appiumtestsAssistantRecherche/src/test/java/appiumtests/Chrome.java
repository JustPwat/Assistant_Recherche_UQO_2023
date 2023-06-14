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
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.PointerInput.Kind;
import org.openqa.selenium.interactions.PointerInput.MouseButton;
import org.openqa.selenium.interactions.PointerInput.Origin;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import utils.ExcelUtils;

public class Chrome {

	static AndroidDriver driver;
	
     Duration STEP_DURATION = Duration.ofMillis(20);
     static Duration NO_TIME = Duration.ofMillis(0);
     static Origin VIEW = Origin.viewport();
    
    
	public Chrome() {
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String excelPath = "./data/AllContactInfo.xlsx";
		String sheetName = "contacts";
		ExcelUtils excelUtils = new ExcelUtils(excelPath,sheetName);
		try {
			System.out.println(excelUtils.getFirstName(1));
			//openCalculator();
			openChromePixel4();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getCause());
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	

        // Temps d'attente pour éviter la détection d'automatisation
        public static void waitTime(int miliseconds){

            try {
				Thread.sleep(miliseconds);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }

        /*
         * email = session_key (id)
         * passwaord = session_password (id)
         * 
         * 
         * Profil Cliquable = /hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[2]/android.webkit.WebView/android.view.View/android.view.View/android.view.View[3]/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.widget.ListView/android.view.View[4]/android.widget.Button
         * Bouton Cliquable = /hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[2]/android.webkit.WebView/android.view.View/android.view.View/android.view.View[3]/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.widget.ListView/android.view.View[4]/android.view.View[2]/android.widget.Button

         * 
         * */


	
    // Ouvrir l'application Chrome
		public static void openChromePixel2() throws Exception {
			
			DesiredCapabilities cap = new DesiredCapabilities();
			
			cap.setCapability("deviceName", "Pixel 2");
			cap.setCapability("udid", "FA8211A00763");
			cap.setCapability("platformName", "Android");
			cap.setCapability("platformVersion", "11");
			
			// Pour utiliser le clavier = ((AndroidDriver)driver).pressKeyCode(AndroidKeyCode.ENTER);
			cap.setCapability("unicodeKeyboard", false);
			cap.setCapability("resetKeyboard", false);
			
			cap.setCapability("appPackage", "com.android.chrome");
			cap.setCapability("appActivity", "com.google.android.apps.chrome.Main");
			
			URL url = new URL("http://127.0.0.1:4723/wd/hub");
			driver = new AndroidDriver(url, cap);
			
			System.out.println("App Started...");
			
            waitTime(3000);
			
			// #0.1 Cliquer sur CONTINUER COMME (nom d'utilisateur)
			driver.findElement(By.id("com.android.chrome:id/signin_fre_continue_button")).click();
			
			waitTime(4000);

			// #0.2 Cliquer sur OUI J'accepte (Synchronisation des données)
			driver.findElement(By.id("com.android.chrome:id/positive_button")).click();
			
			searchBarInChrome("facebook.com");
			
	}
		
		public static void openChromePixel4() throws Exception {
			
			DesiredCapabilities cap = new DesiredCapabilities();
			
			cap.setCapability("deviceName", "Pixel 4");
			cap.setCapability("udid", "emulator-5554");
			cap.setCapability("platformName", "Android");
			cap.setCapability("platformVersion", "12");
			
			cap.setCapability("appPackage", "com.android.chrome");
			cap.setCapability("appActivity", "com.google.android.apps.chrome.Main");
			
			URL url = new URL("http://127.0.0.1:4723/wd/hub");
			driver = new AndroidDriver(url, cap);
			
			System.out.println("App Started...");
			
            waitTime(3000);
            settingUpChrome();
			
	
			
	}
		public static void settingUpChrome() {
			waitTime(4000);
			
			driver.findElement(By.id("com.android.chrome:id/terms_accept")).click();
			
			waitTime(4000);
			
			driver.findElement(By.id("com.android.chrome:id/positive_button")).click();
			
			waitTime(4000);
			
			setUpDesktopMode();
			
		}
		

        // Utiliser la barre de recherche 
		public static void searchBarInChrome(String website) {
			
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			driver.findElement(By.id("com.android.chrome:id/search_box_text")).sendKeys(website);
			waitTime(1000);
			driver.findElement(By.id("com.android.chrome:id/url_bar")).sendKeys(Keys.ENTER);
			
		}
		
		
		
		public static void setUpDesktopMode(){
			
        
      

     // searchbox to send keys
        driver.findElement(By.id("com.android.chrome:id/menu_button")).click();
        waitTime(2000);
        
        // 
        driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Bookmarks\"]")).click();
        waitTime(2000);
       // sendKeys(Keys.ENTER);
        
        driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout")).click();
        waitTime(15000);
        
        // username/ ermailsome
        
        driver.findElement(By.id("email-address")).click();
    	waitTime(2000);
    	driver.findElement(By.id("email-address")).click();
    	waitTime(2000);
    	driver.findElement(By.id("email-address")).sendKeys("someuniversitydude@gmail.com");
    
    
    
    	driver.findElement(By.id("password")).click();
    	waitTime(2000);
    	driver.findElement(By.id("password")).sendKeys("Only@Thesis");
    
    
    	driver.findElement(By.id("join-form-submit")).click();
    	waitTime(10000);
       
        driver.findElement(By.id("continue-as")).click();
        waitTime(5000);
        
     // 3 dot
        driver.findElement(By.id("com.android.chrome:id/menu_button")).click();
        waitTime(2000);
        
     // checkbox
        driver.findElement(By.id("com.android.chrome:id/checkbox")).click();
        waitTime(2000);
        
        
        
        //container
        
        	driver.findElement(By.id("email-address")).click();
        	waitTime(2000);
        	driver.findElement(By.id("email-address")).sendKeys("someuniversitydude@gmail.com");
        
        
        
        	driver.findElement(By.id("password")).click();
        	waitTime(2000);
        	driver.findElement(By.id("password")).sendKeys("Only@Thesis");
        
        
        	driver.findElement(By.id("join-form-submit")).click();
        	waitTime(10000);
        	
        
        
        
        
        // join-form-submit
        driver.findElement(By.id("email-address")).sendKeys("someuniversitydude@gmail.com");
        // 
        driver.findElement(By.id("password")).click();
        // 
        driver.findElement(By.id("password")).sendKeys("Only@Thesis");
        
        // connect with google
        driver.findElement(By.id("container")).click();
        
        // connect via google
        driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[2]/android.webkit.WebView/android.view.View[1]/android.view.View[4]/android.view.View/android.view.View[1]/android.view.View[3]")).click();
        
        driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[2]/android.webkit.WebView/android.view.View[1]/android.view.View[4]/android.view.View/android.view.View[1]/android.view.View[3]")).sendKeys("someuniversitydude@gmail.com");

        driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[2]/android.webkit.WebView/android.view.View[1]/android.view.View[6]/android.view.View/android.widget.Button")).click();
        
        driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[2]/android.webkit.WebView/android.view.View[1]/android.view.View[4]/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View[2]")).sendKeys("Only@Thesis939");
        
        

    }
		
		
		// SCREEN-ROOT ID = screen-root
		
		public static void connectToFacebook() {
			
			driver.findElement(By.id("m_login_email")).click();
			
			Driver.waitTime(2000);
			
			driver.findElement(By.id("com.android.chrome:id/touch_to_fill_button_title")).click();
			
			Driver.waitTime(5000);
			
			//driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[2]/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View[2]/android.view.View[3]/android.widget.Button")).click();
			
			bloquerNotif();
			
			//Cliquer sur l'icone mes amis (Bounds = [177,336][360,492])
			driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.FrameLayout[2]/android.webkit.WebView/android.view.View/android.view.View[2]/android.view.View/android.view.View/android.view.View[1]/android.view.View[2]/android.widget.Button[2]"));
			//
			
			
			WebElement ajouterAccueil = driver.findElement(By.id("com.android.chrome:id/infobar_close_button"));
			
			if(ajouterAccueil.isDisplayed()) {
				
				ajouterAccueil.click();
			}
			
			
			
			Point iconeAmi = new Point(998,288);
			PointerInput finger = new PointerInput(Kind.TOUCH,"finger");
			Sequence clickIconeAmi = new Sequence(finger,0);
			
			clickIconeAmi.addAction(finger.createPointerMove(NO_TIME, VIEW, iconeAmi));
			clickIconeAmi.addAction(finger.createPointerDown(MouseButton.LEFT.asArg()));
			clickIconeAmi.addAction(finger.createPointerUp(MouseButton.LEFT.asArg()));
			
			driver.perform(Arrays.asList(clickIconeAmi));

		}
		
		//Bloquer les notifications 
		public static void bloquerNotif() {
			
			driver.findElement(By.id("com.android.chrome:id/negative_button")).click();
			Driver.waitTime(1500);
			
			
		}
		
		//com.android.chrome:id/infobar_close_button
		
		
		
		
		
		
		
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