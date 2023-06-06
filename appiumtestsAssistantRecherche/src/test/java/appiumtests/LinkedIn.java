package appiumtests;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.checkerframework.checker.units.qual.Length;
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
import utils.ExcelUtils;

public class LinkedIn {

	static AndroidDriver driver;


	public LinkedIn(AndroidDriver driver) {
		
		
		this.driver = driver;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String excelPath = "./data/AllContactInfo.xlsx";
		String sheetName = "contacts";
		ExcelUtils excelUtils = new ExcelUtils(excelPath,sheetName);
		try {
			System.out.println(excelUtils.getFirstName(1));
			//openCalculator();
			openLinkedIn();
			
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


        public static void findByID(String _id){

            driver.findElement(By.id(_id));
        }

        public static void findByXPATH(String _xpath){

            driver.findElement(By.xpath(_xpath));
        }

            

		
		/*
		 * #1 LinkedIn Après ouvrir pour cliquer sur "Continuer en tant que Patrick : com.google.android.gms:id/continue_button (id)"
		 * (xpath) /hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.Button
		 * 
		 * #2 App ouvert, Cliquer sur l'icone MON RÉSEAU 
		 * (accessibility id) = 2 Mon réseau(s) sur 5
		 * (id) = com.linkedin.android:id/tab_relationships
		 * (xpath) = //Tab[@content-desc="2 Mon réseau(s) sur 5"]
		 * 
		 * 
		 * #3 Aller cliquer sur GÉRER MON RÉSEAU 
		 * (accessibility id) = Gérer mon réseau
		 * (id) = com.linkedin.android:id/mynetwork_my_communitities_entry_point_container
		 * (xpath) = //android.widget.Button[@content-desc="Gérer mon réseau"]
		 *
		 * #4 Cliquer sur Ajouter des contacts 
		 * (accessibility id) = Gérer mon réseau
		 * (id) = com.linkedin.android:id/mynetwork_entity_entry_empty_state_button
		 * (xpath) = /hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup[2]/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[2]/android.widget.Button
		 * 
		 * 
		 * #4.1 Cliquer sur importer des contacts 
		 * (id) = com.linkedin.android:id/abi_splash_continue_button
		 * (xpath) = //android.widget.LinearLayout[@content-desc="Découvrez qui parmi vos connaissances est sur LinkedIn"]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.Button[2]
		 * 
		 * #4.2 Autoriser l'accès au contact
		 * (id) = com.android.permissioncontroller:id/permission_allow_button
		 * (xpath) = /hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.Button[1]
		 * 
		 * #4.3 Trouver le xpath des Prénom et Nom des contacts (La seule différence ici est l'index du dernier ViewGroup[] qui change. 
		 *                                                                  (Celui-ci commence toujours à [1] et NON à [0])
		 * (xpath) = /hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup[2]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.widget.TextView[1]
		 * 
		 * 
		 * 
		 * 
		 * */
		
		public static void openLinkedIn() throws Exception {
			
			DesiredCapabilities cap = new DesiredCapabilities();
			
			// Appareil Physique
			
			cap.setCapability("deviceName", "Pixel 2");
			cap.setCapability("udid", "FA8211A00763");
			cap.setCapability("platformName", "Android");
			cap.setCapability("platformVersion", "11");
			
			// Emulateur
			/* 
			cap.setCapability("deviceName", "Pixel 2");
			cap.setCapability("udid", "emulator-5554");
			cap.setCapability("platformName", "Android");
			cap.setCapability("platformVersion", "11");*/
			
			cap.setCapability("appPackage", "com.linkedin.android");
			cap.setCapability("appActivity", "com.linkedin.android.authenticator.LaunchActivity");
			
			URL url = new URL("http://127.0.0.1:4723/wd/hub");
			driver = new AndroidDriver(url, cap);
			
			System.out.println("App Started...");
			
			

			waitTime(5000);
			
            //Cliquer sur "Continuer en tant que (User)"
            if(driver.findElement(By.id("com.google.android.gms:id/continue_button")).isDisplayed()) {
            	driver.findElement(By.id("com.google.android.gms:id/continue_button")).click();
            }else {
                driver.findElement(By.id("com.linkedin.android:id/growth_prereg_fragment_join_with_google_button")).click();

            }
            
            
            
			//waitTime(5000);
            //#0.1 Continuer avec Google 
            //driver.findElement(By.id("com.linkedin.android:id/growth_prereg_fragment_join_with_google_button")).click();
            	
           // waitTime(3000);
            //#0.2 Cliquer sur le nom d'utilisateur
           // driver.findElement(By.id("com.google.android.gms:id/account_name")).click();
            	
            waitTime(7000);
            // #2 App ouvert, Cliquer sur l'icone MON RÉSEAU 
            driver.findElement(By.id("com.linkedin.android:id/tab_relationships")).click();

            waitTime(4000);
            // #3 Aller cliquer sur GÉRER MON RÉSEAU 
            driver.findElement(By.id("com.linkedin.android:id/mynetwork_my_communitities_entry_point_container")).click();

            waitTime(3000);
            // #4 Cliquer sur Ajouter des contacts 
            driver.findElement(By.id("com.linkedin.android:id/mynetwork_entity_entry_empty_state_button")).click();

            waitTime(3500);
            // #4.1 Cliquer sur importer des contacts 
            driver.findElement(By.id("com.linkedin.android:id/abi_splash_continue_button")).click();
            
            waitTime(3500);
         // #4.2 Importer des contacts 
            driver.findElement(By.id("com.android.permissioncontroller:id/permission_allow_button")).click();

            waitTime(2500);
            // #4.3 Trouver le xpath des Prénom et Nom des contacts (La seule différence ici est l'index du dernier ViewGroup[] qui change. 
		    //(Celui-ci commence toujours à [1] et NON à [0])
            driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup[2]/androidx.recyclerview.widget.RecyclerView/"
            							+ "android.view.ViewGroup[1]/android.widget.TextView[1]"));
            // TODO : faire une loop pour parcourir le nombre exact de contact de la liste.
            int nombreDeContact = 10;
            int baseAmount = 1;
            
            		
            for (int i =2; i < nombreDeContact; i++) {
            	
            	String contactNom	=	driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup[2]/androidx.recyclerview.widget.RecyclerView/"
    					+ "android.view.ViewGroup["+baseAmount+"]/android.widget.TextView[1]")).getText();
                String contactEmploi = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup[2]/androidx.recyclerview.widget.RecyclerView/"
                		+ "android.view.ViewGroup["+baseAmount+"]/android.widget.TextView[2]")).getText();
            	
            	System.out.println(contactNom + " // Emploi : " + contactEmploi);
            	
            	baseAmount++;
            }
            
            
            
            
            
            
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