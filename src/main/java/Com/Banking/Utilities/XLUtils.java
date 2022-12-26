package Com.Banking.Utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLUtils {

	public static FileInputStream fi;
	public static XSSFWorkbook wb;
	public static XSSFSheet ws;
	public static XSSFRow row;
	public static XSSFCell Cell;

	public static int getRowCount(String Xfile, String Xshhet) throws IOException {

		fi = new FileInputStream(Xfile);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(Xshhet);
		int rowcount = ws.getLastRowNum();
		wb.close();
		fi.close();
		return rowcount;
	}

	public static int getCellCount(String Xfile, String Xshhet,int rownum) throws IOException {

		fi = new FileInputStream(Xfile);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(Xshhet);
		row=ws.getRow(rownum);
		int cellcount = row.getLastCellNum();
		wb.close();
		fi.close();
		return cellcount;
	}
	
	public static String getCellData(String Xfile, String Xshhet,int rownum,int colnum) throws IOException {
		
		fi = new FileInputStream(Xfile);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(Xshhet);
		row=ws.getRow(rownum);
        Cell=row.getCell(colnum);
		String data;
		
	try {
		DataFormatter formatter =new DataFormatter();
		String Celldata=formatter.formatCellValue(Cell);
		return Celldata;
	}
	catch (Exception e) {
		
		data="";
	}
	wb.close();
	fi.close();
		
		
	return data;
	}	
		
		
		
		
		
		
		
		
		
		
	
}
