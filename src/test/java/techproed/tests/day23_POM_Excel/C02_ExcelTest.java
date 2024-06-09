package techproed.tests.day23_POM_Excel;

import org.testng.annotations.Test;
import techproed.utilities.ExcelReader;

public class C02_ExcelTest {

    @Test
    public void test01() {

        String path = "src/test/java/techproed/resources/adminTestData.xlsx";
        String sheetName = "costumer_info";
        ExcelReader reader = new ExcelReader(path, sheetName);

        String email = reader.getCellData(1,0);
        String password = reader.getCellData(1,1);

        System.out.println(email +" = "+ password );
    }
}