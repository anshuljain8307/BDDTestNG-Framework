package com.qa.util;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.qa.base.TestBase;

import cucumber.api.Scenario;

public class TestUtil extends TestBase{

	
	public static long Page_Load_Timeout = 60;
	public static long Implicit_WAIT = 20;
	public static Scenario scenario;
	
	
	
	public static void takeScreenshot(String fileName) throws IOException, InvalidFormatException 
	{
		
		XWPFDocument doc=new XWPFDocument();
		XWPFParagraph p=doc.createParagraph();
		XWPFRun r=p.createRun();
		String dirpath="D:\\BDDTestNG\\src\\main\\java\\Screenshot\\" +fileName+ ".jpg";
		FileOutputStream out = new FileOutputStream(dirpath+"doc1.docx");
		
		File file=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File(dirpath));
		FileInputStream pic = new FileInputStream(dirpath);
		r.addBreak();
		//r.setText(fileName);
		r.addPicture(pic, XWPFDocument.PICTURE_TYPE_JPEG, dirpath, Units.toEMU(500), Units.toEMU(500));
		pic.close();
		doc.write(out);
		out.flush();
        out.close();
        doc.close();
				
	}
	
		
	
}
