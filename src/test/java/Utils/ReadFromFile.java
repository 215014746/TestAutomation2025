package Utils;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;

public class ReadFromFile {
    private  static  String testData = System.getProperty("user.dir") + "/src/test/java/Utils/TestData/testData.xlsx";
    public static DataFormatter dataFormatter = new DataFormatter();
    static FileInputStream fs;

    static {
        try {
            fs = new FileInputStream(testData);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static XSSFWorkbook workbook;
    static {
        try {
            workbook = new XSSFWorkbook(fs);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static XSSFSheet sheet = workbook.getSheet("LoginInfo");
    public static String username = sheet.getRow(1).getCell(0).getStringCellValue();
    public static String password = dataFormatter.formatCellValue(sheet.getRow(1).getCell(1));


}
