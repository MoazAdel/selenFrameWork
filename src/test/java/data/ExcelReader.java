package data;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelReader {
    static FileInputStream FIS = null;
    public FileInputStream getFileInputStream() {

        String filePath = System.getProperty("user.dir" + "//src//test//java//data//userData.xlsx//");
        File src = new File(filePath);
        try {
            FIS = new FileInputStream(src);
        } catch (FileNotFoundException e) {
            System.out.println("Test Data File not found!! : Check file path for data");
            System.exit(0);
        }
        return FIS;
    }

    public Object[][] getExcelData() throws IOException {
        FIS = getFileInputStream();
        XSSFWorkbook wb = new XSSFWorkbook(FIS);
        XSSFSheet sheet = wb.getSheetAt(0);

        int totalNumberOfRows = (sheet.getLastRowNum()+1);
        int totalNumberOfCols = 4;

        String[][] arrayExcelData = new String[totalNumberOfRows][totalNumberOfCols];

        for(int i=0; i < totalNumberOfRows; i++) {
            for(int j=0; j < totalNumberOfCols; j++) {
                XSSFRow row = sheet.getRow(i);
                arrayExcelData[i][j] = row.getCell(j).toString();
            }
        }

        wb.close();
        return arrayExcelData;
    }
}
