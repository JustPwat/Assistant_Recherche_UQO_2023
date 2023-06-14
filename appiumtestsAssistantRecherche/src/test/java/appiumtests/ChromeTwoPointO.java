package appiumtests;

import java.net.URL;
import java.time.Duration;
import java.util.Arrays;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;


import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.PointerInput.Origin;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;

public class ChromeTwoPointO {
	
	static AndroidDriver driver;
	
    Duration STEP_DURATION = Duration.ofMillis(20);
    static Duration NO_TIME = Duration.ofMillis(0);
    static Origin VIEW = Origin.viewport();
   
   
	public ChromeTwoPointO() {
		
	}

	
				// Ouvrir l'application Chrome
			@SuppressWarnings({ "deprecation", "rawtypes" })
			public static void openChromePixel2() throws Exception {
				
				DesiredCapabilities cap = new DesiredCapabilities();
				
				cap.setCapability("deviceName", "Pixel 2");
				cap.setCapability("udid", "FA8211A00763");
				cap.setCapability("platformName", "Android");
				cap.setCapability("platformVersion", "11");
				
						/*		 Application to Open 		*/
				cap.setCapability("appPackage", "com.android.chrome");
				cap.setCapability("appActivity", "com.google.android.apps.chrome.Main");
				
				URL url = new URL("http://127.0.0.1:4723/wd/hub");
				driver = new AndroidDriver(url, cap);
				
				System.out.println("App Started...");
				
						/*    Login To Chrome to acces LinkedIn via Favoris      */	
				
	            waitTime(3000);
					// #0.1 Cliquer sur CONTINUER COMME (nom d'utilisateur)
						driver.findElement(By.id("com.android.chrome:id/signin_fre_continue_button")).click();
				
				waitTime(5000);
					// #0.2 Cliquer sur OUI J'accepte (Synchronisation des données)
						driver.findElement(By.id("com.android.chrome:id/button_primary")).click();
				
				waitTime(4000);
					//0.3 Menu 3 petits points
						driver.findElement(By.id("com.android.chrome:id/menu_button")).click();
				
				waitTime(4000);
					// 0.4 Cliquer sur "Favoris"
						driver.findElement(By.id("com.android.chrome:id/all_bookmarks_menu_id")).click();
				
				waitTime(3500);
		        	// 0.5 Favoris d'appareil mobile
		        		driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/"
		        		+ "android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[2]/android.widget.LinearLayout")).click();

		        waitTime(3500);
		        	// 0.6 Cliquer sur LinkedIN 
		        		driver.findElement(By.id("com.android.chrome:id/title")).click();
		        
		        waitTime(6500);
		        	//0.7 Menu 3 petits points
						driver.findElement(By.id("com.android.chrome:id/menu_button")).click();
				
				waitTime(6500);
					// 0.8 Liste deroulante
	
						// Create a PointerInput object
							PointerInput pointer = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
							
						// Create a Sequence object
							Sequence sequence = new Sequence(pointer, 0);
							
						// Specify the action to press at the initial coordinates
							sequence.addAction(pointer.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), 743, 1327));
							sequence.addAction(pointer.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
							
						// Specify the action to move to the target coordinates
							sequence.addAction(pointer.createPointerMove(Duration.ofMillis(1000), PointerInput.Origin.viewport(), 750, 781));
							
						// Specify the action to release at the final coordinates
							sequence.addAction(pointer.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
							
						// Perform the sequence of actions
							driver.perform(Arrays.asList(sequence));
				
				
				waitTime(6500);
					// 0.9 Version Desktop com.android.chrome:id/request_desktop_site_id
						driver.findElement(By.id("com.android.chrome:id/request_desktop_site_id")).click();
				
				
				waitTime(8000);
					// 0.10 continue-as
						
						// Create a PointerInput object
							PointerInput pointer2 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
							
						// Create a Sequence object
							Sequence sequence2 = new Sequence(pointer2, 0);
							
						// Specify the action to tap at the desired coordinates
							sequence2.addAction(pointer2.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), 873, 393));
							sequence2.addAction(pointer2.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
							sequence2.addAction(pointer2.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
			
						// Perform the sequence of actions
							driver.perform(Arrays.asList(sequence2));

				
				//waitTime(10000);
					// 0.11 "Passer" numéro de téléphone (NOT ALWAYS ASKING FOR IT)
		        	/*	driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/"
		        		+ "android.widget.FrameLayout[2]/android.webkit.WebView/android.view.View/android.view.View/android.view.View/"
		        		+ "android.view.View/android.view.View[2]/android.view.View/android.view.View[2]/android.view.View[2]/android.view.View/android.widget.Button")).click();
		        */
				
		        waitTime(10000);
		        	//0.12 CLICK sur mes relations
						driver.findElement(By.xpath("//android.view.View[@content-desc=\"My Network\"]/android.widget.TextView")).click();
		        
		       // clickHereXandY(285, 245);
						
								/* FACULTATIF -- 
				waitTime(6500);
					// Importer les nouveaux contacts
						driver.findElement(By.id("start-abi")).click();
				
				waitTime(6500);
					// RETURN to home page
						driver.navigate().back();*/
				
				waitTime(6500);
				
				// Click on CONTACTS
					PointerInput pointer1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");

					Sequence sequence1 = new Sequence(pointer1, 0);

					sequence1.addAction(pointer1.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), 249, 404));
					sequence1.addAction(pointer1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
					sequence1.addAction(pointer1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
					
					driver.perform(Arrays.asList(sequence1));
				
				// At this point we are on the page where all our contacts are listed
					
					waitTime(10000);
					
					//clickFiche();
					
					int y = 1; // starting value of y

					while (true) {
				        
				        try {
							 
				        	
				        if (driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/"
							  		+ "android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout[2]/android.webkit.WebView/android.view.View/"
							  		+ "android.view.View/android.view.View[3]/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.widget.ListView/"
							  		+ "android.view.View["+ y + "]/android.widget.Button")).getText().contains("(")){
				        	
				        	y++;

				        }
				        
				        }catch (NoSuchElementException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							
							try {
								
								System.out.println(driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/"
								  		+ "android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout[2]/android.webkit.WebView/android.view.View/"
								  		+ "android.view.View/android.view.View[3]/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.widget.ListView/"
								  		+ "android.view.View["+ y + "]/android.widget.Button[1]")).getText());
								
							} catch (NoSuchElementException e2) {
								// TODO Auto-generated catch block
								e2.printStackTrace();
								
								y++;
								 
							}
							 
						}
 
					 } 
			}
				        
				        

					  

					  // Check if the element with the XPath containing "android.widget.Button[2]" exists
					/*  if (driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/"
					  		+ "android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout[2]/android.webkit.WebView/android.view.View/"
					  		+ "android.view.View/android.view.View[3]/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.widget.ListView/"
					  		+ "android.view.View["+ y + "]/android.widget.Button[2]")).isDisplayed()) 
					  		
					  */
						
						/*
					  
						  
						// Perform click action on the new XPath (Button[1] = Fiche du contact)
						  driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/"
							  		+ "android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout[2]/android.webkit.WebView/android.view.View/"
							  		+ "android.view.View/android.view.View[3]/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.widget.ListView/"
							  		+ "android.view.View["+ y + "]/android.widget.Button[1]")).click();
						  
						  
						  */


					    // Break the loop since we found and clicked the element
					    
						  
					  
						


			
					// TODO --------------------- Developper la logique pour explorer la liste des contacts ----------------------
			
								// xpath pour Cliquer sur une fiche
						// /hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout[2]/android.webkit.WebView/android.view.View/android.view.View/android.view.View[3]/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.widget.ListView/android.view.View[13]/android.widget.Button[1]
								
								// xpath du bouton Connect
						// "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout[2]/android.webkit.WebView/android.view.View/android.view.View/android.view.View[3]/android.view.View/android.view.View/android.view.View/android.view.View[1]/" 
						// + "android.view.View/android.widget.ListView/android.view.View[13]/android.widget.Button[2]"				
			
			
			
			public static void clickFiche() {

						int y = 1; // starting value of y

						while (true) {
					        
					        try {
								 
					        if(driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/"
					        		+ "android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/"
					        		+ "android.widget.FrameLayout[2]/android.webkit.WebView/android.view.View/android.view.View/android.view.View[3]/"
					        		+ "android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.widget.ListView/"
					        		+ "android.view.View["+ y + "]")).isDisplayed()) {
					        	
					        	if (driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/"
								  		+ "android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout[2]/android.webkit.WebView/android.view.View/"
								  		+ "android.view.View/android.view.View[3]/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.widget.ListView/"
								  		+ "android.view.View["+ y + "]/android.widget.Button")).getText().contains("(")){
								  
								  y++; // Increment y for the next iteration
	 
							  } else {
								  
								  System.out.println(driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/"
									  		+ "android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout[2]/android.webkit.WebView/android.view.View/"
									  		+ "android.view.View/android.view.View[3]/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.widget.ListView/"
									  		+ "android.view.View["+ y + "]/android.widget.Button[1]")).getText());
								  
							  }
								  

					        }
					        
					        
					        
					        } catch (NoSuchElementException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}

						  

						  // Check if the element with the XPath containing "android.widget.Button[2]" exists
						/*  if (driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/"
						  		+ "android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout[2]/android.webkit.WebView/android.view.View/"
						  		+ "android.view.View/android.view.View[3]/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.widget.ListView/"
						  		+ "android.view.View["+ y + "]/android.widget.Button[2]")).isDisplayed()) 
						  		
						  */
							
							/*
						  
							  
							// Perform click action on the new XPath (Button[1] = Fiche du contact)
							  driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/"
								  		+ "android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout[2]/android.webkit.WebView/android.view.View/"
								  		+ "android.view.View/android.view.View[3]/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.widget.ListView/"
								  		+ "android.view.View["+ y + "]/android.widget.Button[1]")).click();
							  
							  
							  */


						    // Break the loop since we found and clicked the element
						    break;
							  
						  }

						
					
					
				}
				
		    
			
			
			
	        public static void waitTime(int miliseconds){

	            try {
					Thread.sleep(miliseconds);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        }
	        
	        public static void clickHereXandY(int x, int y) {
	        	
	        	PointerInput pointer1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");

				Sequence sequence1 = new Sequence(pointer1, 0);

				sequence1.addAction(pointer1.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), x, y));
				sequence1.addAction(pointer1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
				sequence1.addAction(pointer1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
				
				driver.perform(Arrays.asList(sequence1));
			
	        }
	        
	        /* NOTE 
	         
	          	// xpath : EXIT la fiche de contact 
					//hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[2]/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.app.Dialog/android.widget.Button

				
				// xpath : pour cliquer sur une fiche
					// /hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout[2]/android.webkit.WebView/android.view.View/android.view.View/android.view.View[3]/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.widget.ListView/android.view.View[13]/android.widget.Button[1]
				
				// xpath : du bouton Connect
					// /hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout[2]/android.webkit.WebView/android.view.View/android.view.View/android.view.View[3]/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.widget.ListView/android.view.View[13]/android.widget.Button[2]

	         
	         */
	        
	        // CLiquer sur Sort By : 
	        		// clickHereXandY(281, 440) 
	        
	        //Cliquer sur First Name
	        
	        		// clickHereXandY(285, 521) 
	        
	        
	        
	        
	        
			
}
