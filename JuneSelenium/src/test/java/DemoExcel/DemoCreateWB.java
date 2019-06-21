package DemoExcel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class DemoCreateWB {
  @Test
  public void f() throws IOException {

		XSSFWorkbook wb=new XSSFWorkbook();//create blank workbook
		
		FileOutputStream out=new FileOutputStream(new File("DemoWB.xlsx"));//create file system using specific name
		wb.write(out);//perform write operation
		out.close();
		System.out.println("demo.xlsx is created and written successfully");
	  
  }
}
