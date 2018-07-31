package com.pathway.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Dictionary;
import java.util.Hashtable;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
//import org.apache.poi.HSSF.usermodel.HSSFSheet;
//import org.apache.poi.HSSF.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel {
    
    public   Dictionary<String, String> readfromExcelinDict(String filePath,String SheetName, int RowNumber) 
    {
        try
        {
        
                    String sDataFile=    filePath;
                    //test file is located in your project path         
                    FileInputStream fileIn = new FileInputStream(sDataFile);
                    //read file 
                   
                    POIFSFileSystem fs = new POIFSFileSystem(fileIn);
                   
                    HSSFWorkbook filename = new HSSFWorkbook(fs);
                   
                    //open sheet 0 which is first sheet of your worksheet
                    HSSFSheet sheet = filename.getSheet(SheetName);
                    
                 // create a new hashtable
                    Dictionary<String, String> dict = new Hashtable();
                       
                    // add elements in the hashtable
                    
                    int noOfColumns = sheet.getRow(0).getLastCellNum();
                    
                    System.out.println(noOfColumns);
                    
                    int icount;
                    for (icount=0 ; icount < noOfColumns ;icount++)
                    {
                        //dict.put(sheet.getRow(0).getCell(icount).getStringCellValue().toString(),sheet.getRow(RowNumber).getCell(icount).getStringCellValue().toString());
                        dict.put(sheet.getRow(0).getCell(icount).toString(),sheet.getRow(RowNumber).getCell(icount).toString());                 
                    }  
                    return dict;
        }
        catch(Exception e)
        {
            return null;
        
        }
        
        
    }

    public  Dictionary<String, String> readfromExcelinDict(String sSheet) throws Exception
    {
        try
        {
        
        String sDataFile=    "D:\\Selenium\\Selenium Session\\TestData\\TestData.xls";
        
        //test file is located in your project path         
        FileInputStream fileIn = new FileInputStream(sDataFile);
        //read file 
       
        POIFSFileSystem fs = new POIFSFileSystem(fileIn);
       
        HSSFWorkbook filename = new HSSFWorkbook(fs);
       
        //open sheet 0 which is first sheet of your worksheet
        HSSFSheet sheet = filename.getSheet(sSheet);
       
        
        
     // create a new hashtable
        Dictionary<String, String> dict = new Hashtable();
        int noOfColumns = sheet.getRow(0).getLastCellNum();
        
        System.out.println("totla column is" + noOfColumns);
        // add elements in the hashtable
        int icount;
        
        for (icount=0 ; icount<noOfColumns-1;icount++)
        {
            /*
            System.out.println(sheet.getRow(1).getCell(icount).toString());
        if(sheet.getRow(1).getCell(icount).toString().length()!=0){
            dict.put(sheet.getRow(0).getCell(icount).toString(),sheet.getRow(1).getCell(icount).toString());
        }
        */
        
        dict.put(sheet.getRow(0).getCell(icount).toString(),sheet.getRow(1).getCell(icount).toString());
            
        }
      //  System.out.println(dict.get("URL"));
        
        
        return dict;
        }
        catch(Exception e)
        {
            return null;
        
        }
        
        
    }
    

    public static String readFromExcel(String filePath,String sheetName,int row,int col) 
    {
         String sdata;
     try {

         File src=new File(filePath);
         FileInputStream fis=null;
        
         
	         try{
	        	  fis=new FileInputStream(src);
	        	  HSSFWorkbook wb=new HSSFWorkbook(fis);
		          HSSFSheet sh1= wb.getSheet(sheetName);
		          sdata=sh1.getRow(row).getCell(col).getStringCellValue();
		       
	        	 
	          }catch(Exception e){
	        	 fis=new FileInputStream(src);
	        	 XSSFWorkbook wb= new XSSFWorkbook(fis);
	        	 XSSFSheet sh1= wb.getSheet(sheetName);
	        	 sdata=sh1.getRow(row).getCell(col).getStringCellValue();
	        	 
	        	 
	         }
        
         } 
     catch (Exception e) {
         System.out.println(e.getMessage());
         sdata=null;
         }
        return sdata;
}
    
    public static  String ReadExcelUsingSheetIndex(String filePath,int sheetIndex,int row,int col) 
    {
         String sdata;
     try {

         File src=new File(filePath);
         FileInputStream fis=new FileInputStream(src);
         HSSFWorkbook wb=new HSSFWorkbook(fis);
         HSSFSheet sh1= wb.getSheetAt(sheetIndex);
         sdata=sh1.getRow(row).getCell(col).getStringCellValue();
         } 
     catch (Exception e) {
         System.out.println(e.getMessage());
         sdata=null;
         }
        return sdata;
}
    
    public static String readFromExcel(String filePath,int row,int col) 
    {
         String sdata;
        
     try {

         File src=new File(filePath);
        
         FileInputStream fis=new FileInputStream(src);
         HSSFWorkbook wb=new HSSFWorkbook(fis);
         //HSSFWorkbook wb=new HSSFWorkbook(fis);
         HSSFSheet sh1= wb.getSheetAt(0);
        
         sdata=sh1.getRow(row).getCell(col).getStringCellValue();
         } 
     catch (Exception e) {
        
         sdata=null;
         }
        return sdata;
}
    
    public static Workbook getWorkbook(FileInputStream inputStream, String excelFilePath)
            throws IOException {
        Workbook workbook = null;
     
        if (excelFilePath.endsWith("xlsx")) {
            workbook = new XSSFWorkbook(inputStream);
        } else if (excelFilePath.endsWith("xls")) {
            workbook = new HSSFWorkbook(inputStream);
        } else {
            throw new IllegalArgumentException("The specified file is not Excel file");
        }
     
        return workbook;
    }
}

