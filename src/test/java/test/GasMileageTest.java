package test;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;
import pages.GasMileageCalculatorPage;
import utilities.Driver;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.DecimalFormat;
import java.time.LocalDateTime;

public class GasMileageTest {

    XSSFWorkbook workbook;
    XSSFSheet sheet;
    FileInputStream fileInputStream;
    FileOutputStream fileOutputStream;
    GasMileageCalculatorPage gasMileageCalculatorPage = new GasMileageCalculatorPage();

    @Test
    public void gasMileageCalculatorTest() throws Exception{

        Driver.getDriver().get("https://www.calculator.net/gas-mileage-calculator.html");
        String path = "./src/test/resources/testdata/GasMileageTestData.xlsx";
        //loading the file to class
        fileInputStream = new FileInputStream(path);
        //loading the workbook to class
        workbook = new XSSFWorkbook(fileInputStream);
        sheet = workbook.getSheet("Sheet1");

        for (int rowNum = 1; rowNum<=sheet.getLastRowNum(); rowNum++) {

            XSSFRow currentRow = sheet.getRow(rowNum);

            if(!currentRow.getCell(0).toString().equals("Y")){
                if (currentRow.getCell(6) == null) {
                    currentRow.createCell(6);
                }

                currentRow.getCell(6).setCellValue("Skip Requested!");
                continue;
            }

            //double current = 123000;
            double current = currentRow.getCell(1).getNumericCellValue();
            gasMileageCalculatorPage.currentOdo.clear();
            gasMileageCalculatorPage.currentOdo.sendKeys(String.valueOf(current));

            //double previous = 122000;
            double previous = currentRow.getCell(2).getNumericCellValue();
            gasMileageCalculatorPage.previousOdo.clear();
            gasMileageCalculatorPage.previousOdo.sendKeys(String.valueOf(previous));

            //double gas = 70;
            double gas = currentRow.getCell(3).getNumericCellValue();
            gasMileageCalculatorPage.gasInput.clear();
            gasMileageCalculatorPage.gasInput.sendKeys(String.valueOf(gas));

            gasMileageCalculatorPage.calculateButton.click();

            double expectedResult = (current - previous) / gas;
            System.out.println("Expected result: " + expectedResult);

            String[] actualResult = gasMileageCalculatorPage.resultInGas.getText().split(" ");
            System.out.println("Actual result: " + actualResult[0]);

            DecimalFormat decimalFormat = new DecimalFormat("#0.00");
            System.out.println("Formatted version: " + decimalFormat.format(expectedResult));

            //basically creates the cell if the current cell is empty

            // sending the EXPECTED VALUE FROM OUR FORMULA
            if (currentRow.getCell(4) == null) {
                currentRow.createCell(4);
            }

            currentRow.getCell(4).setCellValue(decimalFormat.format(expectedResult));
            //===================================================================
            // sending the ACTUAL RESULT THAT WE GET FROM APP
            if (currentRow.getCell(5) == null) {
                currentRow.createCell(5);
            }

            currentRow.getCell(5).setCellValue(actualResult[0]);

            //=================================================


            // CHECKING AND COMPARING ACTUAL VS EXPECTED, AND PRINTING VALUES TO EXCEL

            if (String.valueOf(decimalFormat.format(expectedResult)).equals(actualResult[0])) {
                if (currentRow.getCell(6) == null) {
                    currentRow.createCell(6);
                }
                currentRow.getCell(6).setCellValue("PASS!");
                System.out.println("PASS!");
            } else {
                if (currentRow.getCell(6) == null) {
                    currentRow.createCell(6);
                }
                currentRow.getCell(6).setCellValue("FAIL!");
                System.out.println("FAIL!");
            }

            //=======================
            // GETTING LOCALDATETIME AND PASSING INTO EXCEL
            if (currentRow.getCell(7) == null) {
                currentRow.createCell(7);
            }

            currentRow.getCell(7).setCellValue(LocalDateTime.now().toString());
        }
        //=============================================

        fileOutputStream = new FileOutputStream(path);
        workbook.write(fileOutputStream);

        workbook.close();
        fileOutputStream.close();
        fileInputStream.close();

    }
}
