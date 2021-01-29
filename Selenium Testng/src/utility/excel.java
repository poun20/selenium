package utility;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excel extends testBase {
	excel() throws Exception{
		super();
	}
private static XSSFWorkbook ExcellBook;
private static XSSFSheet Excellsheet;
private static XSSFCell Cell;


public static  void setExcelFile(String path,String sheetName)throws Exception
{ try
{
	//open he Excel file
	FileInputStream Excellfile = new FileInputStream(path);
	ExcellBook =new XSSFWorkbook(Excellfile);
	Excellsheet = ExcellBook.getSheet(sheetName);
	
}
catch(Exception e)
{
	throw(e);
	
}
}
public static  int getRowcontains(String search_val)throws Exception
{ int i;
try
{
	int rowcount=Excellsheet.getLastRowNum();
	for(i=0;i<=rowcount;i++) {
		if(Excellsheet.getRow(i).getCell(0).getStringCellValue().equalsIgnoreCase(search_val))
		{
			System.out.println("Testcase name in sheet:"+Excellsheet.getRow(i).getCell(0).getStringCellValue());
			break;
		}
}
return i;

}catch(Exception e)
{
	throw(e);
}
}
public static String getCellData (int RowNum,String columName) throws Exception
{
	try 
	{
		for (int k=0; k<Excellsheet.getRow(0).getLastCellNum(); k++)
			
		{
			String cellvalue = Excellsheet.getRow(0).getCell(k).getStringCellValue();
			if(cellvalue.equalsIgnoreCase(columName))
			{
				
			DataFormatter formatter1= new DataFormatter();
            Cell =Excellsheet.getRow(RowNum).getCell(k);
            String strcell = formatter1.formatCellValue(Cell);
            return strcell;
		}
		}
	}
	catch(Exception e)
	{
		return"";
	}
	return "";
}
}