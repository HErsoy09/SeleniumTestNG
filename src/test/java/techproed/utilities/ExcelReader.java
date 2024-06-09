package techproed.utilities;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelReader {

    Workbook workbook;
    Sheet sheet;

    public ExcelReader(String path, String sheetName) {

        try {
            FileInputStream fis = new FileInputStream(path);
            workbook = WorkbookFactory.create(fis);
            sheet = workbook.getSheet(sheetName);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

/* ---------------- METHODS ---------------- */

    public String getCellData(int row, int column) {
        Cell cell = sheet.getRow(row).getCell(column);
        return cell.toString();
    }

    public int rowCount() {
        return sheet.getLastRowNum();
    }
}