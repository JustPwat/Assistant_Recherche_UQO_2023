package appiumtests;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
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
import utils.ExcelUtils;

public class Contact {

	
	private String prenomNom;
	private String numero;
	//private String address;
	//private String email;
	
	static AndroidDriver driver;
	static boolean _contactEnregistrer = false;
	
	static Scanner scan = new Scanner(System.in);
	
	public Contact() {
		super();
	}
	
	public Contact(String prenomNom, String numero) {
		super();
		this.prenomNom = prenomNom;
		this.numero = numero;
		//this.address = address;
		//this.email = email;
	}
	public String getPreNom() {
		return prenomNom;
	}
	public void setPreNom(String prenomNom) {
		this.prenomNom = prenomNom;
	}
	public String getNumber() {
		return numero;
	}
	public void setNumber(String numero) {
		this.numero = numero;
	}
	/*
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}*/
	@Override
	public String toString() {
		return "User [firstName=" + prenomNom + ", lastName=" + numero
				+ "]";
	}
	
	/*
	 * public String toString() {
		return "User [firstName=" + prenomNom + ", lastName=" + numero + ", address=" + address + ", email=" + email
				+ "]";
	}
	 * */
	
	// Enregistrer un nouveau contact
	public static void contactEnregistrer(){

		try {
			_contactEnregistrer = true ;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// Ajouter un Prénom
	public static String nouveauContactPrenom() {
		
		System.out.println("Entrer prénom");
		String info = scan.nextLine();
		
		return info;	
	}
	
	
	// Ajouter un Nom de Famille
	public static String nouveauContactNom() {
		
		System.out.println("Entrer Nom de famille");
		String info = scan.nextLine();
		
		return info;	
	}
	
	// Ajouter un numéro de Téléphone
	public static String nouveauContactTelephone() {
		
		System.out.println("Entrer Numero de Telephone");
		String info = scan.nextLine();
		
		return info;	
	}
	
	
	
	
		
	public static void openContact() throws Exception {
			
		DesiredCapabilities cap = new DesiredCapabilities();
		//	Appareil physique
		cap.setCapability("deviceName", "Pixel 2");
		cap.setCapability("udid", "FA8211A00763");
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "11");
		
		// 	Emulator Pixel 2
		/*cap.setCapability("deviceName", "Pixel 2");
		cap.setCapability("udid", "emulator-5554");
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "11");*/
		
		
		/*	Emulator Pixel 4				
		cap.setCapability("deviceName", "Pixel 4");
		cap.setCapability("udid", "emulator-5554");
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "12");
		*/
			
        // Application visé 
		cap.setCapability("appPackage", "com.google.android.contacts");
		cap.setCapability("appActivity", "com.android.contacts.activities.PeopleActivity");
			
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		driver = new AndroidDriver(url, cap);
			
		System.out.println("App Started...");

		/*
		
		Driver.waitTime(2000);
		//Cliquer sur Allow
        driver.findElement(By.id("com.android.permissioncontroller:id/permission_allow_button")).click();
		
        Driver.waitTime(2000);
        //Cliquer sur Allow
        driver.findElement(By.id("com.android.permissioncontroller:id/permission_allow_button")).click();
		
        */
        Driver.waitTime(2000);
        // #0.1 Cliquer sur le bouton + pour ajouter un contact com.google.android.contacts:id/floating_action_button
        driver.findElement(By.id("com.google.android.contacts:id/floating_action_button")).click();
        
        Driver.waitTime(3000);
        WebElement prenom = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout[2]/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.FrameLayout/android.widget.EditText"));
        											  // /hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout[2]/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.FrameLayout/android.widget.EditText
        prenom.click();
        Driver.waitTime(1500);
        prenom.sendKeys("ContactTest");
        Driver.waitTime(1000);
        driver.navigate().back();
        
        //Nom de famille
        WebElement nomFamille = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout[2]/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.FrameLayout/android.widget.EditText"));
        nomFamille.click();
        Driver.waitTime(1000);
        
        WebElement nomFam = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout[2]/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.FrameLayout/android.widget.EditText"));
        
        //WebElement nomFam1 = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout[2]/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.FrameLayout/android.widget.EditText"));
        nomFam.sendKeys("nomDeFamille");
        Driver.waitTime(1000);
        driver.navigate().back();
        
        
        Driver.waitTime(2000);
        // #0.2 Cliquer sur la case Phone 
        WebElement phone = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout[2]/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.EditText"));
        //         WebElement phone = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout[2]/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.EditText"));
    
        phone.click();
            
        Driver.waitTime(2000);
            
        phone.sendKeys("8197002149");
            
        Driver.waitTime(2000);
            
        WebElement enregistrer = driver.findElement(By.id("com.google.android.contacts:id/toolbar_button"));
		enregistrer.click();
            
        driver.navigate().back();
            
        Driver.waitTime(2000);
            
        driver.navigate().back();
            
            
            
            
        /*
        Driver.waitTime(2000);
    // #0.2 Cliquer sur la case Prénom 
        WebElement prenom = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout[2]/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.FrameLayout/android.widget.EditText"));
        prenom.click();
        
        String nPrenom = nouveauContactPrenom();
        Driver.waitTime(2000);;
    // #0.3 Insérer le prénom
        prenom.sendKeys(nPrenom);
      
        
        Driver.waitTime(2000);
    // #0.4 Cliquer sur la case Nom de Famille
        WebElement nomDeFamille = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout[2]/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.FrameLayout/android.widget.EditText"));
        nomDeFamille.click();
      
        String nNom = nouveauContactNom();
        Driver.waitTime(2000);
    // #0.5 Insérer le nom de famille
        nomDeFamille.sendKeys(nNom);
        //driver.navigate().back();

        Driver.waitTime(2000);
    // #0.6 Cliquer sur la case # Téléphone
        WebElement numeroTelephone = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout[2]/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.EditText"));
        numeroTelephone.click();
        
        
        String nNumero = nouveauContactTelephone();
        Driver.waitTime(2000);
    // #0.7 Insérer le # de Téléphone
        numeroTelephone.sendKeys(nNumero);
        //driver.navigate().back();

        Driver.waitTime(2000);
    // #0.8 Cliquer sur Enregistrer
        WebElement enregistrer = driver.findElement(By.id("com.google.android.contacts:id/toolbar_button"));
        enregistrer.click();

        Driver.waitTime(2000);
    // #0.9 Confirmation que le contact est bel et bien entrée pour démarrer la recherche de données
        contactEnregistrer();
        System.out.println(_contactEnregistrer);
        driver.navigate().back();
        Driver.waitTime(1000);
        driver.navigate().back();
        Driver.waitTime(2000);
       
        //Driver.openInstagram();        
    
*/

        


	}
	
	
	public static void openContactPhysique() throws Exception {
		
		DesiredCapabilities cap = new DesiredCapabilities();
		//	Appareil physique
		cap.setCapability("deviceName", "Pixel 2");
		cap.setCapability("udid", "FA8211A00763");
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "11");
		
		// 	Emulator Pixel 2
		/*cap.setCapability("deviceName", "Pixel 2");
		cap.setCapability("udid", "emulator-5554");
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "11");*/
		
		
		/*	Emulator Pixel 4				
		cap.setCapability("deviceName", "Pixel 4");
		cap.setCapability("udid", "emulator-5554");
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "12");
		*/
			
        // Application visé 
		cap.setCapability("appPackage", "com.google.android.contacts");
		cap.setCapability("appActivity", "com.android.contacts.activities.PeopleActivity");
			
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		driver = new AndroidDriver(url, cap);
			
		System.out.println("App Started...");
		
		Driver.waitTime(2000);
		
		List cinquanteContact = ExcelUtils.creer50Contacts();
		
		for(int i=0; i< cinquanteContact.size();i++) {
			
			 ajouterContact(cinquanteContact[i]);
		}
		
       
	
	}

	private static void ajouterContact(String numeroDeTelephone) {
		// TODO Auto-generated method stub
		
		// #0.1 Cliquer sur le bouton + pour ajouter un contact com.google.android.contacts:id/floating_action_button
        driver.findElement(By.id("com.google.android.contacts:id/floating_action_button")).click();
		
        //Prenom
        Driver.waitTime(3000);
        WebElement prenom = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout[2]/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.FrameLayout/android.widget.EditText"));

        prenom.click();
        Driver.waitTime(1500);
        prenom.sendKeys("ContactTest");
        Driver.waitTime(1000);
        
        //Nom de famille
        WebElement nomFamille = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout[2]/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.FrameLayout/android.widget.EditText"));
        
        nomFamille.click();
        Driver.waitTime(1000);
        nomFamille.sendKeys("nomDeFamille");

        Driver.waitTime(2000);
        // #0.2 Cliquer sur la case Phone 
        WebElement phone = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout[2]/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.EditText"));
    
        phone.click();  
        Driver.waitTime(2000);
        phone.sendKeys("8197002149"); 
        Driver.waitTime(2000);
            
        WebElement enregistrer = driver.findElement(By.id("com.google.android.contacts:id/toolbar_button"));
		enregistrer.click();
            
        driver.navigate().back();
            
        Driver.waitTime(2000);
            
        driver.navigate().back();
	}

	
	
}