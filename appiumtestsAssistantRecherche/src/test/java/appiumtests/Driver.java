package appiumtests;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v110.indexeddb.model.Key;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.interactions.PointerInput.Kind;
import org.openqa.selenium.interactions.PointerInput.MouseButton;
import org.openqa.selenium.interactions.PointerInput.Origin;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import utils.ExcelUtils;

public class Driver {

	
	static AndroidDriver driver;
	private Duration STEP_DURATION = Duration.ofMillis(20);
    private static Duration NO_TIME = Duration.ofMillis(0);
    private static Origin VIEW = Origin.viewport();
    static String excelPath = "./data/AllContactInfo21.xlsx";
	static String sheetName = "contacts";
	static ExcelUtils excelUtils = new ExcelUtils(excelPath,sheetName);
    
	
	
	public Driver() {
		
		
	}
	
	public static void main(String[] args) {
		
		String excelPath = "./data/AllContactInfo21.xlsx";
		String sheetName = "contacts";
		ExcelUtils excelUtils = new ExcelUtils(excelPath,sheetName);
	       
		try {
		
					/* Appareil Physique */
			
			//Driver.openInstagram();
			//Contact.openContactPhysique();
			ChromeTwoPointO.openChromePixel2();
			
					/* Emulateur */
			
			//Chrome.openChromePixel4();
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getCause());
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	
	
	public static void openLinkedIn() throws Exception {
		
		/*
		 * cap.setCapability("deviceName", "Pixel 2");
		cap.setCapability("udid", "FA8211A00763");
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "11");
		 * 
		 * */
		
		DesiredCapabilities cap = new DesiredCapabilities();
			// Information sur l'appareil
		cap.setCapability("deviceName", "Pixel 2");
		cap.setCapability("udid", "emulator-5554");
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "11");
			//Application à lancer
		cap.setCapability("appPackage", "com.linkedin.android");
		cap.setCapability("appActivity", "com.linkedin.android.authenticator.LaunchActivity");
		
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		driver = new AndroidDriver(url, cap);
		
		System.out.println("App Started...");

		waitTime(3000);
		//#0.1 Continuer avec Google (id) = com.linkedin.android:id/growth_prereg_fragment_join_with_google_button
		driver.findElement(By.id("com.linkedin.android:id/growth_prereg_fragment_join_with_google_button")).click();
		
		waitTime(3000);
		//#0.2 Cliquer sur le nom d'utilisateur (id)= com.google.android.gms:id/account_name
		driver.findElement(By.id("com.google.android.gms:id/account_name")).click();
		
		
		/*
        waitTime(3000);
        // #1 Après ouverture - Cliquer sur "Continuer en tant que (User)"
        driver.findElement(By.id("com.google.android.gms:id/continue_button"));
        */
        waitTime(4000);
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
        
        waitTime(2500);
     // #4.2 Importer des contacts 
        driver.findElement(By.id("com.android.permissioncontroller:id/permission_allow_button")).click();

        waitTime(3500);
        // #4.3 Trouver le xpath des Prénom et Nom des contacts (La seule différence ici est l'index du dernier ViewGroup[] qui change. 
	    //(Celui-ci commence toujours à [1] et NON à [0])
        driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup[2]/androidx.recyclerview.widget.RecyclerView/"
        							+ "android.view.ViewGroup[1]/android.widget.TextView[1]"));
        
        driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup[2]/androidx.recyclerview.widget.RecyclerView/"
				+ "android.view.ViewGroup[1]"));
       // #4.4 Loop pour parcourir le nombre exact de contact de la liste et récuprer les Prénoms/Noms et travail des contacts
        int nombreDeContact = 6;
        int baseAmount = 1;
        
        		
        for (int i =2; i < nombreDeContact; i++) {
        	String contactNom	=	driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup[2]/androidx.recyclerview.widget.RecyclerView/"
    				+ "android.view.ViewGroup["+baseAmount+"]/android.widget.TextView[1]")).getText();
        	
        	String contactTravail =	driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup[2]/androidx.recyclerview.widget.RecyclerView/"
    				+ "android.view.ViewGroup["+baseAmount+"]/android.widget.TextView[2]")).getText(); 
        	
        	System.out.println(contactNom);
        	System.out.println(contactTravail);
        	
        	//ExcelUtils.createUserData(contactNom, contactTravail, contactNom, contactTravail);
        	
        	
        	baseAmount ++;
        }
		
	}
	
	// Faire un retour arrière (Useful to close the keyboard)
	public static void retour() {
		
		driver.navigate().back();
	}
	
	
	
	public static void cliquerLinkedIn() {
		
		Point iconeAmi = new Point(350,200);
		PointerInput finger = new PointerInput(Kind.TOUCH,"finger");
		Sequence clickIconeAmi = new Sequence(finger,0);
		
		clickIconeAmi.addAction(finger.createPointerMove(NO_TIME, VIEW, iconeAmi));
		clickIconeAmi.addAction(finger.createPointerDown(MouseButton.LEFT.asArg()));
		clickIconeAmi.addAction(finger.createPointerUp(MouseButton.LEFT.asArg()));
		
		driver.perform(Arrays.asList(clickIconeAmi));
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
    
    public static WebElement findByID(String _id){

        return driver.findElement(By.id(_id));
    }

    public static WebElement findByXPATH(String _xpath){

        return driver.findElement(By.xpath(_xpath));
    }
	
    
    
    	// *************** INSTAGRAM ********************
    
	public static void openInstagram() throws Exception {
		
		DesiredCapabilities cap = new DesiredCapabilities();
		
		cap.setCapability("deviceName", "Pixel 2");
		cap.setCapability("udid", "FA8211A00763");
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "11");
		
		cap.setCapability("appPackage", "com.instagram.android");
		cap.setCapability("appActivity", "com.instagram.mainactivity.LauncherActivity");
		
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		driver = new AndroidDriver(url, cap);
		
		System.out.println("App Started...");
		
		connectToInstagram();
	}
	
	public static void connectToInstagram() throws IOException {
		
		String nomUtilisateur ;
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
		//myProfileOnInstagram();
		
		contactTrouver();
		
		
		
		
		
		
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
		
		int textView = 1;
		 int linearLayout = 2;
		 String nom ;
		 String userName ;
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
		
		waitTime(2000);
		
		
			//Avant le premier Scroll
		if(linearLayout == 2) {
		
		for (linearLayout= 2; linearLayout < 3 ; linearLayout++) {
			
			String suggestionsPourVous = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.FrameLayout[1]/android.widget.LinearLayout/android.widget.FrameLayout/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/"
					+ "android.widget.LinearLayout["+linearLayout+"]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView")).getText(); 
		
		if(suggestionsPourVous=="Suggestions pour vous") {
		
		userName = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.FrameLayout[1]/android.widget.LinearLayout/android.widget.FrameLayout/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout["+linearLayout+"]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView["+textView+"]")).getText();
		nom = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.FrameLayout[1]/android.widget.LinearLayout/android.widget.FrameLayout/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout["+linearLayout+"]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView["+textView+1+"]")).getText();
		
		//list.add("Nom :"+ nom + "// UserName = "+ userName);
		System.out.println(userName);
		System.out.println(nom);
		
		waitTime(1000);


		}
		
		
		List contactInstagram = checkInstagramUser();
		
		for (int i = 0 ; i < contactInstagram.size() ; i++) {
			
			System.out.println(contactInstagram.get(i));
			
		}
		
		System.out.println("Done");
		
	}

}
	}
	
	
	
		// Obtenir le nom complet de l'utilisateur
	public static String checkNameFromHomePageINSTA() {
		String nom ;
		
		if(driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout[1]/android.widget.LinearLayout/android.widget.TextView[2]")).isDisplayed()) {
			
			nom = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout[1]/android.widget.LinearLayout/android.widget.TextView[2]")).getText();

			return nom;
		}
		return null;
	}
	
		// Obtenir le nom d'utilisateur Instagram
	public static String getInstagramUsernameFromHomePageINSTA() {
		
		String username;
		username = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout[1]/android.widget.LinearLayout/android.widget.TextView[1]")).getText();
		
		return username;
	}
	
	
	
		// S'assurer d'avoir trouver le contact sur l'application
	public static void contactTrouver() throws IOException {
		waitTime(8000);
		//Trouver le nom complet
		String vraiNom, vraiUsername;
		boolean foundOrNot = false;
		
		
		while(foundOrNot==false) {
			vraiNom = checkNameFromHomePageINSTA();
			vraiNom = ExcelUtils.enleverLesCaracteresEtEspace(vraiNom);
			vraiNom = ExcelUtils.mettreEnMajuscules(vraiNom);
			System.out.println(vraiNom);
			foundOrNot = ExcelUtils.comparerNom(vraiNom, excelUtils);
			System.out.println(vraiNom);
			System.out.println(foundOrNot);
			
			if(foundOrNot == true) {
				
				vraiNom = checkNameFromHomePageINSTA();
				vraiUsername = getInstagramUsernameFromHomePageINSTA();
				
				//ExcelUtils.updateFeuilleContactINSTA(vraiNom,vraiUsername);	
				System.out.println("Contact trouver, Nom complet : "+ vraiNom + " Nom d'utilisateur : "+ vraiUsername);
				
				if(foundOrNot == true) {
					
					vraiNom = checkNameFromHomePageINSTA();
					vraiUsername = getInstagramUsernameFromHomePageINSTA();
					
					ExcelUtils.updateFeuilleContact(vraiNom,vraiUsername);	
					driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/"
							+ "android.widget.FrameLayout[1]/android.widget.FrameLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout[1]/android.widget.LinearLayout/android.widget.TextView[1]")).click();
					 waitTime(4000);
					 getUserInfoINSTA(vraiNom,vraiUsername);
					System.out.println("Contact trouver, Nom complet : "+ vraiNom + " Nom d'utilisateur : "+ vraiUsername);
					driver.navigate().back();
				}
			}
			
			
			waitTime(2000);
			swipeLeft();
			
		}
		
		foundOrNot = true;
		/*
		if(foundOrNot == true) {
			
			vraiNom = checkNameFromHomePageINSTA();
			vraiUsername = getInstagramUsernameFromHomePageINSTA();
			
			ExcelUtils.updateFeuilleContact(vraiNom,vraiUsername);	
			driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/"
					+ "android.widget.FrameLayout[1]/android.widget.FrameLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout[1]/android.widget.LinearLayout/android.widget.TextView[1]")).click();
			 waitTime(4000);
			 getUserInfoINSTA(vraiNom,vraiUsername);
			System.out.println("Contact trouver, Nom complet : "+ vraiNom + " Nom d'utilisateur : "+ vraiUsername);
		}*/

		
	}
	
	/*
	 * Bio (id) = driver.findElement(By.Id("com.instagram.android:id/profile_header_bio_text").getText();
	 * 
	 * postCount(id) =  driver.findElement(By.Id("com.instagram.android:id/row_profile_header_textview_post_count").getText();
	 * 
	 * followersCount (id) = driver.findElement(By.Id("com.instagram.android:id/row_profile_header_textview_followers_count").getText();
	 * 
	 * followingCount (id) =  driver.findElement(By.Id("com.instagram.android:id/row_profile_header_textview_following_count").getText();
	 * 
	 * returnButton (id) =  driver.findElement(By.Id("com.instagram.android:id/action_bar_button_back").click();
	 * 
	 * 
	 * */
	
	 // Obtenir la bio, le nombre de publications, abonnées et abonnement de l'utilisateur
	public static void getUserInfoINSTA(String nom,String username) throws IOException {
		 waitTime(2000);
		 String bio = "N/A";
		 
		 try {
			 if(driver.findElement(By.id("com.instagram.android:id/profile_header_bio_text")).isDisplayed()) {
				 bio  = driver.findElement(By.id("com.instagram.android:id/profile_header_bio_text")).getText();
			 } else {
				 bio = bio ;
			 }
		    } catch (Exception e) {
		      System.out.println("Aucune Bio");
		    }
		  
		 
			 
		 String postCount =  driver.findElement(By.id("com.instagram.android:id/row_profile_header_textview_post_count")).getText();
		 String followersCount = driver.findElement(By.id("com.instagram.android:id/row_profile_header_textview_followers_count")).getText();
		 String followingCount =  driver.findElement(By.id("com.instagram.android:id/row_profile_header_textview_following_count")).getText();
		 //returnButton 
		 waitTime(2000);
		 System.out.println(bio + " "+ postCount + " "+ followersCount + " "+ followingCount  );
		 driver.findElement(By.id("com.instagram.android:id/action_bar_button_back")).click();
		 ExcelUtils.updateFeuilleContactINSTA(nom,username,bio,postCount,followersCount, followingCount);	
		 
		 waitTime(2500);
		 swipeLeft();
		 contactTrouver();

		
	}
	
	public static List<String> checkInstagramUser() {
		
		List<String> list=new ArrayList<String>();  
		
		//Regarder les 2 premiers utilisateurs
		// android.widget.LinearLayout[] commence à 2 avant le scroll
		 int textView = 1;
		 int linearLayout = 2;
		 String nom ;
		 String userName ;
		 
		 waitTime(1500);
		 
		WebElement suggestionsPourVous = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.FrameLayout[1]/android.widget.LinearLayout/android.widget.FrameLayout/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/"
																	+ "android.widget.LinearLayout["+linearLayout+"]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView")); 
		//Avant le premier Scroll
		if(linearLayout == 2) {
			
			for (linearLayout= 2; linearLayout < 3 ; linearLayout++) {
				
				if(suggestionsPourVous.getText()=="Suggestions pour vous") {
					
					userName = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.FrameLayout[1]/android.widget.LinearLayout/android.widget.FrameLayout/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView["+textView+"]")).getText();
					nom = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.FrameLayout[1]/android.widget.LinearLayout/android.widget.FrameLayout/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView["+textView+1+"]")).getText();
					
					list.add("Nom :"+ nom + "// UserName = "+ userName);
					System.out.println(userName);
					System.out.println(nom);
					
					waitTime(1000);
					
					
				}
				
			}
			
			// Scroll de l'écran
			
			swipeToUp();
			waitTime(3000);
			
			linearLayout = 1 ;
			
			
			for (linearLayout= 1; linearLayout < 6 ; linearLayout++) {
				
				if(suggestionsPourVous.getText()=="Suggestions pour vous") {
					
					userName = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.FrameLayout[1]/android.widget.LinearLayout/android.widget.FrameLayout/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView["+textView+"]")).getText();
					nom = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.FrameLayout[1]/android.widget.LinearLayout/android.widget.FrameLayout/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView["+textView+1+"]")).getText();
					
					list.add("Nom :"+ nom + "// UserName = "+ userName);
					
					System.out.println(userName);
					System.out.println(nom);
					
				}
				
			}
			
			
		}
		
		
		return list ;
		
		
	}
	
		/*
		 * SNAPCHAT 
		 * 
		 * #0.3 Cliquer sur Ajouter des amis (id)= com.snapchat.android:id/hova_header_add_friend_icon
		 * 
		 * #0.4 CLiquer sur tout les contact (xpath)= //android.widget.Button[@content-desc="Tous les contacts"] (access-id)= Tous les contacts
		 * 
		 * */
	
		
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
	
	/*
		
		public static void openLinkedIn() throws Exception {
			
			DesiredCapabilities cap = new DesiredCapabilities();
			
			cap.setCapability("deviceName", "Pixel 2");
			cap.setCapability("udid", "FA8211A00763");
			cap.setCapability("platformName", "Android");
			cap.setCapability("platformVersion", "11");
			
			cap.setCapability("appPackage", "com.linkedin.android");
			cap.setCapability("appActivity", "com.linkedin.android.authenticator.LaunchActivity");
			
			URL url = new URL("http://127.0.0.1:4723/wd/hub");
			driver = new AndroidDriver(url, cap);
			
			System.out.println("App Started...");
	}
	
		*/
		
		/* FACEBOOK   appPackage = com.facebook.katana
		 * 
		 * #0 xpath des 3 lignes à droite en haut
		 * 
		 * (xpath) = /hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.widget.LinearLayout[2]/android.widget.FrameLayout[5]
		 * 
		 * #0.1 Cliquer sur le bouton RETROUVER DES AMIS 
		 * (xpath) = /hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.viewpager.widget.ViewPager/android.widget.FrameLayout/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[4]/android.view.ViewGroup
		 * 
		 * 
		 * #0.1.1 Cliquer le bouton rechercher en haut à droite 
		 * 
		 * accessibility id) = Rechercher
		 * (xpath) = //android.widget.Button[@content-desc="Rechercher"]
		 * 
		 * #0.1.2 Cliquer sur la flèche retour en haut à gauche
		 * (accessibility id) = Retour
		 * (xpath) = //android.widget.ImageView[@content-desc="Retour"]
		 * 
		 * #0.1.3 Cliquer sur la barre de Recherche 
		 * 
		 * (xpath) = /hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.EditText
		 * 
		 * 
		 * 
		 * */
		
		/* FACEBOOK LITE 
		 * 
		 * #0.1 Cliquer sur le bouton des Amis en haut à gauche
		 * (xpath) = /hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup[2]/android.view.ViewGroup[4]/android.view.View
		 * 
		 * #0.2 xpath des Prénom et nom de liste des utilisateurs VOUS CONNAISSEZ PEUT-ÊTRE (Ceux-ci commence au dernier ViewGroup[3] MAIS parfois [2] si on scroll)
		 * (xpath) = /hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup[2]/android.view.ViewGroup[8]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[3]/android.view.View
		 * 
		 * #0.3 xpath pour Cliquer sur la section PLUS D'INFORMATIONS SUR (user) 
		 * (xpath) = /hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup[3]/android.view.ViewGroup[3]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[4]/android.view.ViewGroup[1]
		 * (xpath) si 5 options = /hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup[3]/android.view.ViewGroup[3]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[4]/android.view.ViewGroup[5]/android.view.View[2]
		 *  
		 * 
		 * 
		 * 
		 * */
		
		/* TIKTOK appPackage = com.zhiliaoapp.musically appActivity= com.ss.android.ugc.aweme.main.MainActivity
		 * 
		 * #0.0 Ouvrir l'app et Cliquer sur connexion
		 * (id) = com.zhiliaoapp.musically:id/eew
		 * (xpath) = /hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/androidx.viewpager.widget.ViewPager/android.view.ViewGroup/android.widget.TextView[2]
		 * 
		 * 
		 * #0.1 Cliquer sur Utiliser téléphone/Email/Nom d'utilisateur
		 * (xpath) = /hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/androidx.viewpager.widget.ViewPager/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]
		 * 		#0.1.1 Cliquer sur AUCUNE DE CES RÉPONSES
		 * 		(id) = com.google.android.gms:id/cancel
		 * 		(xpath) = //android.widget.LinearLayout[@content-desc="Choisissez un compte"]/android.widget.LinearLayout/android.widget.Button
		 * 				#0.1.1 Cliquer sur ADRESSE EMAIL/NOM D'UTILISATEUR (HEADER)
		 * 				(xpath) = /hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.HorizontalScrollView/android.widget.LinearLayout/androidx.appcompat.app.a.b[2]
		 * 		#0.1.2 Cliquer sur la ligne d'entrée du EMAIL OU NOM D'UTILISATEUR
		 * 		(id) = com.zhiliaoapp.musically:id/da5
		 * 		(xpath) = /hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/androidx.viewpager.widget.ViewPager/android.widget.LinearLayout/android.view.ViewGroup/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.EditText
		 * 		#0.1.3 Cliquer sur la ligne d'entrée du MOT DE PASSE
		 * 		(id) = com.zhiliaoapp.musically:id/byp
		 * 		(xpath) = /hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/androidx.viewpager.widget.ViewPager/android.widget.LinearLayout/android.view.ViewGroup/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.EditText
		 * 		#0.1.4 = Cliquer sur le bouton CONNEXION
		 * 		(id) = com.zhiliaoapp.musically:id/eho
		 * 		(xpath) = /hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/androidx.viewpager.widget.ViewPager/android.widget.LinearLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.TextView
		 * 
		 * 		#0.1.5 Cliquer sur IGNORER numéro de téléphone
		 * 		(id) = com.zhiliaoapp.musically:id/d_z
		 * 		(xpath) = /hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView
		 * 
		 * 		#0.1.6 Cliquer sur IGNORER LES INTÉRETS 
		 * 		(id) = com.zhiliaoapp.musically:id/hdq
		 * 		(xpath) = /hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.TextView
		 * 
		 * 		#0.1.7 Cliquer sur COMMENCER À REGARDER 
		 * 		(id) = com.zhiliaoapp.musically:id/hkw
		 * 		(xpath) = /hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.TextView
		 * 
		 * 		#0.1.8 Autoriser l'accès aux contacts 
		 * 		(id) com.android.permissioncontroller:id/permission_allow_button
		 * 		(xpath) /hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.Button[1]
		 * 
		 * 		#0.1.9 Fermer l'onglet SUIS TES AMIS 
		 * 		(id) = com.zhiliaoapp.musically:id/atc
		 * 		(xpath) = /hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.ImageView[2]
		 * 
		 * 		#0.1.10 Cliquer sur l'onglet AMIS en bas à gauche
		 * 		(id) = com.zhiliaoapp.musically:id/elb
		 * 		(xpath) = /hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/X.cUY/android.widget.TabHost/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]
		 * 
		 * 		#0.1.11 Cliquer pour fermer l'onglet DÉCOUVRE LES PUBLICATIONS DE TES AMIS
		 * 		(id) = 	com.zhiliaoapp.musically:id/ci5
		 * 		(xpath) = /hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.ImageView[1]
		 * 		
		 * 		#0.1.12 Cliquer sur L'INCONE AJOUTER DES AMIS
		 * 		(id) = com.zhiliaoapp.musically:id/doq
		 * 		(xpath) = /hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/X.cUY/android.widget.TabHost/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.LinearLayout[1]/android.view.ViewGroup
		 * 
		 * 
		 * 		#0.1.13 Cliquer sur MA LISTE DE CONTACT SYNCRONISÉ
		 * 		(id) = com.zhiliaoapp.musically:id/b6q
		 * 		(xpath) = /hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[1]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.TextView
		 * 
		 * 
		 * 		#0.1.15 Cliquer sur le premier utilisateur 
		 * 		(xpath) = /hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/X.cUY/android.widget.TabHost/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout[2]/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.TextView
		 * 
		 * 
		 * 
		 * 
		 * 
		 * #0.2 Cliquer sur CONTINUER AVEC FACEBOOK
		 * (xpath) = /hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/androidx.viewpager.widget.ViewPager/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]
		 * 
		 * #0.3 Cliquer sur CONTINUER AVEC GOOGLE
		 * (xpath) = /hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/androidx.viewpager.widget.ViewPager/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[3]
		 * 			#0.3.1 Cliquer sur le Compte 
		 * 			(xpath) = /hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.LinearLayout
		 * 
		 * 		
		 * #0.4 Cliquer sur CONTINUER AVEC TWITTER
		 * (xpath) = /hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/androidx.viewpager.widget.ViewPager/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[4]
		 * 
		 * #0.5 Cliquer sur CONTINUER AVEC INSTAGRAM 
		 * (xpath) = /hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/androidx.viewpager.widget.ViewPager/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[5]

		 * 
		 * 
		 * #1.0 Récupérer le pseudo de la personne
		 * (id) = com.zhiliaoapp.musically:id/eyz
		 * (xpath) = /hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.HorizontalScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout[2]/android.widget.TextView
		 * 
		 * #2.0 Récupérer le pseaudo @ de la personne
		 * (id) = com.zhiliaoapp.musically:id/jij
		 * (xpath) = /hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.HorizontalScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.TextView
		 * 
		 * #3.0 Récupérer le nombre de personnes suivis (FOLLOWING)
		 * (id) = com.zhiliaoapp.musically:id/cfv
		 * (xpath) = /hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.HorizontalScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView[1]
		 * 
		 * #4.0 Récupérer le nombre de FOLLOWERS
		 * (id) = com.zhiliaoapp.musically:id/cfl
		 * (xpath) = /hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.HorizontalScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.TextView[1]
		 * 
		 * #5.0 Récupérer le nombre de JAIME 
		 * (id) = com.zhiliaoapp.musically:id/bfj
		 * (xpath) = /hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.HorizontalScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[3]/android.widget.TextView[1]
		 * 
		 * #6.0 Récupérer les informations de la BIO 
		 * (id) = com.zhiliaoapp.musically:id/jk1
		 * (xpath) = /hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.HorizontalScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.TextView
		 * 
		 * #7.0 Nom d'utilisateur (Parfois nom) (CHANGER LE RelativeLayout[i])
		 * (id) =
		 * (xpath) = /hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[1]/android.widget.LinearLayout/android.widget.TextView[1]
		 * 
		 * #8.0
		 * (id) =
		 * (xpath) = /hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[1]/android.widget.LinearLayout/android.widget.TextView[2]
		 * 
		 * 
		 * 
		 */
		
	
	
		
	// Cliquer sur Afficher tout ()id=com.instagram.android:id/netego_carousel_cta
	
	// cliquer sur autouriser l'acces au contacts (id)= com.instagram.android:id/primary_button
	
	// Autoriser (Google) id = com.android.permissioncontroller:id/permission_allow_button
	
	// Scroll jusqua la fin 
	
	// Cliquer sur Afficher tout id ()=com.instagram.android:id/see_all_button
		
		
		public static void searchBarInChrome() {
			
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			driver.findElement(By.id("com.android.chrome:id/search_box_text")).sendKeys("facebook.com");
			
			
			
		}
		
		
		// Scroller vers le haut (Voir plus bas)
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
	
	// Swiper vers la gauche (Voir plus à droite)
	public static void swipeLeft() {
					//Pixel 2
		try {
			Thread.sleep(8000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        //generic layout locator
        WebElement ele = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup"));
            
        int startX = ele.getRect().x + (ele.getSize().width * 3 / 4);
        int startY = ele.getRect().y + (ele.getSize().height / 2);
        int endX = ele.getRect().x + (ele.getSize().width / 4);
        int endY = ele.getRect().y + (ele.getSize().height / 2);

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence dragNDrop = new Sequence(finger, 1);
        dragNDrop.addAction(finger.createPointerMove(Duration.ofSeconds(0),
                PointerInput.Origin.viewport(), startX, startY));
        dragNDrop.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        dragNDrop.addAction(finger.createPointerMove(Duration.ofMillis(700),
                PointerInput.Origin.viewport(), endX, endY));
        dragNDrop.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Arrays.asList(dragNDrop));
        
        System.out.println("Swipe fait");
    }
	
}
