package appiumtests;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	public void main(String[] args) throws Exception {
		
		System.out.println(getFirstName(1));
	}
	
	public void getRowCount() {
		
		try {
		String excelPath ="./data/AllContactInfo.xlsx";
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
		
			String excelPath ="./data/AllContactInfo.xlsx";
			XSSFWorkbook workbook = new XSSFWorkbook(excelPath);
			XSSFSheet sheet = workbook.getSheetAt(0);
			
			String prenom = sheet.getRow(ligne).getCell(0).getStringCellValue();
			
			return prenom ;
			
	}
	
	public String getLastName(int ligne) throws IOException {
		
		String excelPath ="./data/AllContactInfo.xlsx";
		XSSFWorkbook workbook = new XSSFWorkbook(excelPath);
		XSSFSheet sheet = workbook.getSheetAt(0);
		
		String nom = sheet.getRow(ligne).getCell(1).getStringCellValue();
		
		return nom ;
		
}
	
	// Cette méthode est pour insérer les différentes données dans la feuille ContactData
	public void insererDonnees(int ligne, int colonne, String information) throws IOException {
		
		String excelPath ="./data/ContactData.xlsx";
		XSSFWorkbook workbook = new XSSFWorkbook(excelPath);
		XSSFSheet sheet = workbook.getSheetAt(0);
		
		//sheet.set
		
	}
	
	
}
