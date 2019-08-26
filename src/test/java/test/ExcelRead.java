package test;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;

public class ExcelRead {

    public static void main(String[] args) throws Exception{

        //Creating a file
        //Import from java.io
        File file = new File("src/SampleData.xlsx");

        //file.exists() method checks the given path
        //if finds the file, will return true, if not returns false
        System.out.println(file.exists());

        //loads our file to java memory so that we can read and write
        FileInputStream fileInputStream = new FileInputStream(file);

        //Workbook --> Sheet --> Rows --> Cells

        //Loading the workbook to our class
        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);

        //Pass the sheet name
        XSSFSheet sheet  = workbook.getSheet("Employees");

        //This line is getting Sandler from Employees sheet
        //
        System.out.println(sheet.getRow(2).getCell(1));

        int usedRows = sheet.getPhysicalNumberOfRows();
        System.out.println("getPhysicalNumberOfRows: "+usedRows);

        int lastUsedRow = sheet.getLastRowNum();
        System.out.println("getLastRowNum: "+lastUsedRow);

        //TODO: CREATE A LOGIC THAT PRINTS OUT "NEENA" NAME DYNAMICALLY

        for (int rowNum=0; rowNum<usedRows; rowNum++){
            if(sheet.getRow(rowNum).getCell(0).toString().equals("Neena")){
                System.out.println(sheet.getRow(rowNum).getCell(0));
            }
        }

        //TODO: CREATE A LOGIC THAT PRINTS OUT "ADAMS" JOB_ID DYNAMICALLY

        for(int rowNum=0; rowNum<usedRows; rowNum++){
            if (sheet.getRow(rowNum).getCell(0).toString().equals("Adam")){
                System.out.println("JOB_ID of Adam: "+ sheet.getRow(rowNum).getCell(2));
            }
        }


        workbook.close();
        fileInputStream.close();


    }
}
