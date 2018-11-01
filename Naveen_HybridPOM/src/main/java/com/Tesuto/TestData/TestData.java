package com.Tesuto.TestData;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

import com.Tesuto.TestBase.TestBase;
//import com.sun.java.util.jar.pack.Package.Class.Method;

public class TestData extends TestBase {
	
	
	
	@DataProvider(name="TestData")
	public static Object[][] getTestData(Method m) {
		
		String name =m.getName();
	
		System.out.println(name);
		
		sheet = book.getSheet(name);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		// System.out.println(sheet.getLastRowNum() + "--------" +
		// sheet.getRow(0).getLastCellNum());
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
				// System.out.println(data[i][k]);
			}
		}
		return data;
}

}
