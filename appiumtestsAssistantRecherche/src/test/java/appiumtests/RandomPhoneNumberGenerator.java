package appiumtests;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class RandomPhoneNumberGenerator {
    public static void main(String[] args) {
        String[] prefixes = {"(819)", "(514)", "(438)"}; // Phone number prefixes
        int count = 60; // Total number of phone numbers to generate
        String filePath = "./data/"+ generateFilePath(); // Path to save the Excel file; // Path to save the Excel file

        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Phone Numbers");
        Row headerRow = sheet.createRow(0);
        Cell headerCell = headerRow.createCell(0);
        headerCell.setCellValue("Given Name");
        headerCell = headerRow.createCell(1);
        headerCell.setCellValue("Family Name");
        headerCell = headerRow.createCell(2);
        headerCell.setCellValue("E-mail 1 - Value");
        headerCell = headerRow.createCell(3);
        headerCell.setCellValue("Phone 1 - Value");

        FileOutputStream fos = null;
        try {
            for (int i = 1; i <= count; i++) {
                Row row = sheet.createRow(i);
                /*
                Cell firstNameCell = row.createCell(0);
                String firstName = generateFirstName();
                firstNameCell.setCellValue(firstName);

                Cell lastNameCell = row.createCell(1);
                String lastName = generateLastName();
                lastNameCell.setCellValue(lastName);

                Cell emailCell = row.createCell(2);
                String email = generateEmail(firstName, lastName);
                emailCell.setCellValue(email);
                 */
                Cell phoneCell = row.createCell(3);
                String phoneNumber = generatePhoneNumber(prefixes[(i - 1) % prefixes.length]);
                phoneCell.setCellValue(phoneNumber);
            }

            fos = new FileOutputStream(filePath);
            workbook.write(fos);
            System.out.println("Excel file generated successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            try {
                workbook.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static String generatePhoneNumber(String prefix) {
        StringBuilder phoneNumber = new StringBuilder(prefix);
        for (int i = 0; i < 7; i++) {
            int digit = (int) (Math.random() * 10);
            phoneNumber.append(digit);
        }
        return phoneNumber.toString();
    }

    private static String generateFirstName() {
        // Generate and return a random first name
        // Implement your logic here
        return "John";
    }

    private static String generateLastName() {
        // Generate and return a random last name
        // Implement your logic here
        return "Doe";
    }

    private static String generateEmail(String firstName, String lastName) {
        // Generate and return an email based on the first name and last name
        // Implement your logic here
        return "john.doe@example.com";
    }

    private static String generateFilePath() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
        String dateTime = dateFormat.format(new Date());
        return "phone_" + dateTime + ".xlsx";
    }
    
    
    	// Modify "Prenom/Nom" cell based on the target phone number
    private static void modifyPrenomNomCell(Sheet sheet, String targetPhoneNumber, String newName) {
        for (Row row : sheet) {
            Cell phoneCell = row.getCell(3);
            if (phoneCell != null && phoneCell.getCellType() == CellType.STRING) {
                String phoneNumber = phoneCell.getStringCellValue();
                if (phoneNumber.equals(targetPhoneNumber)) {
                    Cell nameCell = row.createCell(1);
                    nameCell.setCellValue(newName);
                    break; // Stop iterating after the match is found
                }
            }
        }
    }
    
    
}


