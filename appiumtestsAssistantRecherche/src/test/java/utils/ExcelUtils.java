package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Random;

import org.apache.commons.lang3.StringUtils ;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import appiumtests.Contact;

public class ExcelUtils {
	XSSFWorkbook workbook ;
	XSSFSheet sheet ;
	
	
	public ExcelUtils(String excelPath, String sheetName) {
		
		try {
		 workbook = new XSSFWorkbook(excelPath);
		 sheet = workbook.getSheet(sheetName);
		} catch (Exception exp) {
			
			System.out.println(exp.getCause());
			System.out.println(exp.getMessage());
			exp.printStackTrace();

			}
	}
	
    public static void main(String[] args) {
        String filePath = "path/to/your/excel/file.xlsx";
        FileInputStream fis = null;
        FileOutputStream fos = null;
        Workbook workbook = null;
        
        try {
            fis = new FileInputStream(new File(filePath));
            workbook = new XSSFWorkbook(fis);
            
            // Get the first sheet in the workbook
            Sheet sheet = workbook.getSheetAt(0);
            
            // Modify cell value at row 1, column 1
            Row row = sheet.getRow(1);
            Cell cell = row.getCell(1);
            cell.setCellValue("Modified Value");
            
            // Save the modified workbook to a new file
            String modifiedFilePath = "path/to/save/modified/file.xlsx";
            fos = new FileOutputStream(new File(modifiedFilePath));
            workbook.write(fos);
            System.out.println("Excel file modified successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // Close input/output streams and workbook
            try {
                if (fis != null)
                    fis.close();
                if (fos != null)
                    fos.close();
                if (workbook != null)
                    workbook.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

	
	public void getRowCount() {
		
		try {
		String excelPath ="./data/AllContactInfo21.xlsx";
		XSSFWorkbook workbook = new XSSFWorkbook(excelPath);
		XSSFSheet sheet = workbook.getSheetAt(0);
		int rowCount = sheet.getPhysicalNumberOfRows();	
		System.out.println("Nombre de lignes" + rowCount);
		
	} catch (Exception exp) {
		
		System.out.println(exp.getCause());
		System.out.println(exp.getMessage());
		exp.printStackTrace();

		}
	}
	
	public String getFirstName(int ligne) throws IOException {
		
			String excelPath ="./data/AllContactInfo21.xlsx";
			XSSFWorkbook workbook = new XSSFWorkbook(excelPath);
			XSSFSheet sheet = workbook.getSheetAt(0);
			
			String prenom = sheet.getRow(ligne).getCell(0).getStringCellValue();
			
			return prenom ;
			
	}
	
	
	//"C:\\Users\\JustPwat\\eclipse-workspace\\appiumtestsAssistantRecherche\\data"
	public String getLastName(int ligne) throws IOException {
		
		String excelPath ="./data/AllContactInfo.xlsx";
		XSSFWorkbook workbook = new XSSFWorkbook(excelPath);
		XSSFSheet sheet = workbook.getSheetAt(0);
		
		String nom = sheet.getRow(ligne).getCell(1).getStringCellValue();
		
		return nom ;
		
}
	
	// Cette méthode est pour insérer les différentes données dans la feuille ContactData
	public static void insererDonnees(int ligne, String prenom, String numero) throws IOException {
		
		String excelPath ="./data/ContactData.xlsx";
		XSSFWorkbook workbook = new XSSFWorkbook(excelPath);
		XSSFSheet sheet = workbook.getSheetAt(0);
		
		String[] row_heading = {"Nom Complet","# de Telephone"};
       
			Row headerRow = sheet.createRow(0);

       // Creating header
	        for (int i = 0; i < row_heading.length; i++) {
				Cell cell = headerRow.createCell(i);
				cell.setCellValue(row_heading[i]);
			}
	     // Creating data rows for each user
	        
	        Row dataRow = sheet.createRow(ligne+1);
	        	dataRow.createCell(0).setCellValue(prenom);
	        	dataRow.createCell(1).setCellValue(numero);
	        	
	        	/*FileOutputStream out;
				try {
					out = new FileOutputStream( new File("D:/writeToExcelSheet/user.xlsx"));
					 
			        workbook.write(out);
			        out.close();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}*/
	        	
	        
		
		//sheet.set
		
	}
	
	public static String getRandomNumberString() {
	    // It will generate 6 digit random Number.
	    // from 0 to 999999
	    Random rnd = new Random();
	    int number = rnd.nextInt(999999);

	    // this will convert any number sequence into 6 character.
	    return String.format("%06d", number);
	}
	
	//Créer 50 contacts
	public static String[] creer50Contacts() {
		String[] numero = new String[49];
		
		for(int i=0; i<49;i++) {
			
			if(i < 25 ) {
				numero[i]=("819"+getRandomNumberString());
			} else {
				numero[i]=("873"+getRandomNumberString());
			}				
		}
		
		return numero;
	}
	
	public void creerFeuilleDeDonnees() {
			XSSFSheet donneesContact = workbook.createSheet("Information des Contact");
			//Création des colonnes
			String[] nomDesColonnes = {"Prenom","Nom","Age","Instagram_ID","Instagram_Post","Instagram_Followers","Instagram_Following",
										"Instagram_Bio","LinkedIn_ID","LinkedIn_Relation","LinkedIn_Work", "LinkedIn_Formation","LinkedIn_City"};
			Font headerFont = workbook.createFont();
			headerFont.setBold(true);
			headerFont.setFontHeightInPoints((short)12);
			headerFont.setColor(IndexedColors.BLACK.index);
			//Creer un CellStyle avec le headerFont
			CellStyle headerStyle = workbook.createCellStyle();
			headerStyle.setFont(headerFont);
			
			//Création de la headerRow
			Row headerRow = donneesContact.createRow(0);
			
			for(int i=0; i<nomDesColonnes.length;i++) {
				Cell cell = headerRow.createCell(i);
				cell.setCellValue(nomDesColonnes[i]);
				cell.setCellStyle(headerStyle);
			}
			
			FileOutputStream out;
			try {
				out = new FileOutputStream( new File("D:/writeToExcelSheet/user.xlsx"));
				 
		        workbook.write(out);
		        out.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
	
					
	}
	
	public static void updateFeuilleContact(String prenomNom ,String numero) throws EncryptedDocumentException, IOException {
		
		 String excelFilePath = "./data/CollectingNameFromNumber.xlsx";
         
	       
	            FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
	            Workbook workbook = WorkbookFactory.create(inputStream);
	 
	            org.apache.poi.ss.usermodel.Sheet sheet = workbook.getSheetAt(0);
	 
	            Object[][] bookData = {
	                    {prenomNom, numero},           
	            };
	 
	            int rowCount = sheet.getLastRowNum();
	 
	            for (Object[] aBook : bookData) {
	                Row row = sheet.createRow(++rowCount);
	                	
	                int columnCount = 0;
	                 
	               Cell cell = row.createCell(columnCount);
	               cell.setCellValue(rowCount);
	                 
	                for (Object field : aBook) {
	                    cell = row.createCell(++columnCount);
	                    if (field instanceof String) {
	                        cell.setCellValue((String) field);
	                    } else if (field instanceof Integer) {
	                        cell.setCellValue((Integer) field);
	                    }
	                }
	 
	            }
	 
	            inputStream.close();
	 
	            FileOutputStream outputStream = new FileOutputStream("./data/ContactData.xlsx");
	            workbook.write(outputStream);
	            workbook.close();
	            outputStream.close();
	            
	            System.out.println("done");
	        
	      
	}
	
	public static void updateFeuilleContactINSTA(String prenomNom ,String username,String bio, String publications, String followers, String following) throws EncryptedDocumentException, IOException {
		
		 String excelFilePath = "./data/ContactOnInstagram.xlsx";
        
	       
	            FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
	            Workbook workbook = WorkbookFactory.create(inputStream);
	 
	            org.apache.poi.ss.usermodel.Sheet sheet = workbook.getSheetAt(0);
	 
	            Object[][] bookData = {
	                    {prenomNom, username,bio,publications,followers,following},           
	            };
	 
	            int rowCount = sheet.getLastRowNum();
	 
	            for (Object[] aBook : bookData) {
	                Row row = sheet.createRow(++rowCount);
	                	
	                int columnCount = 0;
	                 
	               Cell cell = row.createCell(columnCount);
	               cell.setCellValue(rowCount);
	                 
	                for (Object field : aBook) {
	                    cell = row.createCell(++columnCount);
	                    if (field instanceof String) {
	                        cell.setCellValue((String) field);
	                    } else if (field instanceof Integer) {
	                        cell.setCellValue((Integer) field);
	                    }
	                }
	 
	            }
	 
	            inputStream.close();
	 
	            FileOutputStream outputStream = new FileOutputStream("./data/ContactOnInstagram.xlsx");
	            workbook.write(outputStream);
	            workbook.close();
	            outputStream.close();
	            
	            System.out.println("done");
	        
	      
	}
	
	public static void writeToExcelSheet() {
    	
		  String[] row_heading = {"Nom Complet","# de Telephone"};
		  
		// List<Contact> users = createUserData();
		 int userAmount ;

  	 XSSFWorkbook workbook = new XSSFWorkbook();
       
       XSSFSheet spreadsheet = workbook.createSheet( "User Details ");
			Row headerRow = spreadsheet.createRow(0);

       // Creating header
	        for (int i = 0; i < row_heading.length; i++) {
				Cell cell = headerRow.createCell(i);
				cell.setCellValue(row_heading[i]);
			}
	        /*
	     // Creating data rows for each user
	        for(int i = 0; i < users.size(); i++) {
	        	Row dataRow = spreadsheet.createRow(i + 1);
	        	dataRow.createCell(0).setCellValue(users.get(i).getFirstName());
	        	dataRow.createCell(1).setCellValue(users.get(i).getLastName());
	        	dataRow.createCell(2).setCellValue(users.get(i).getAddress());
	        	dataRow.createCell(3).setCellValue(users.get(i).getEmail());
	        } 
	        
	        */
	        
	      //Write the workbook in file system
	        FileOutputStream out;
			try {
				out = new FileOutputStream( new File("D:/writeToExcelSheet/user.xlsx"));
				 
		        workbook.write(out);
		        out.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

	       
	        System.out.println("Write to excel sheet done  successfully...........");
	        
  }
	
	public static  List<Contact> createUserData(String prenomNom, String numero ) {
		
		//Contact contact = new Contact(prenomNom, numero);
		
		
    	return null;
	}
	
	
		//Retirer les accents des noms et mettre en majuscules
	public static String enleverLesCaracteresEtEspace(String nom) {
		
		String result = nom.replaceAll("[^a-zA-Z]", "");
	 
	    return result; 
	}
	
	
		//Retirer les accents des noms et mettre en majuscules
	public static String mettreEnMajuscules(String nom) {
		
		nom = nom.toUpperCase();
		nom = StringUtils.stripAccents(nom);
		
		return nom;
	}
	
		// Trouver si le contact est bel et bien là
	public static boolean comparerNom(String nom1,ExcelUtils excelUtils) throws IOException {
		
		int nbLignes = excelUtils.sheet.getPhysicalNumberOfRows();	
		String nom2 ;
		
		for(int i =1; i < nbLignes; i++) {
			
				//Nom sur l'application
			//nom1 = mettreEnMajuscules(nom1);
			//nom1 = enleverLesCaracteresEtEspace(nom1);
			
				//Nom dans la liste de contact
			nom2 = excelUtils.getFirstName(i);
			nom2 = mettreEnMajuscules(nom2);
			nom2 = enleverLesCaracteresEtEspace(nom2);
			System.out.println(nom1 + "  "+ nom2);
			
			if(nom1.equals(nom2)) {
				return true;
			}
		}
		  return false;
	}
	
	
}
