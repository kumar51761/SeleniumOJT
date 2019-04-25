package seleniumdemo;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadExcel {
	public static void main(String[] args) throws IOException {
		//specify the path of the file
		//File src =new File("D:\\eciworkspace\\seleniumdemo\\ss.xlsx");
		//load the file
		FileInputStream f = new FileInputStream("ss.xlsx");
		//new WorkbookFactory();
		//load workbook
		Workbook wb= WorkbookFactory.create(f);
		//load sheet
		Sheet sh1 =wb.getSheetAt(0);
		System.out.println(sh1.getRow(0).getCell(0).getStringCellValue());
		
		
	}

}
