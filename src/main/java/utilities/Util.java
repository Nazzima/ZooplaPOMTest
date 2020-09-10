package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import base.Base;

public class Util extends Base{
	public static long PAGE_LOAD_TIMEOUT=20;
	public static long IMPLICITLY_WAIT=10;
	public static String TESTDATA_FILEPATH="C:\\MyWorkCenter\\codeExercises\\eclipseWorkspace\\ZooplaSiteTest\\src\\main\\java\\utilities\\zoopla.xlsx";
	
	public static XSSFWorkbook wbook;
	public static XSSFSheet sheet;
	
	public static Object[][] getTestData(String sheetName){
		File file=new File(TESTDATA_FILEPATH);
		FileInputStream fis=null;
		try {
			fis=new FileInputStream(file);
			wbook=new XSSFWorkbook(fis);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		sheet=wbook.getSheet(sheetName);
		int totRows=sheet.getLastRowNum();
		int totColumns=sheet.getRow(0).getLastCellNum();
		Object data[][]=new Object[totRows][totColumns];
		for(int i=0;i<totRows;i++) {
			for(int j=0;j<totColumns;j++) {
				data[i][j]=sheet.getRow(i+1).getCell(j).toString();
			}
		}
		return data;
	}
}
