package test;

public class test {

	String testStr = "http://localhost:8081/AdminTest/controler/delete.do?checkedvalue=100&checkedvalue=99";
	String getStr = testStr.substring(testStr.lastIndexOf("/"),testStr.indexOf("?"));
	


public static void main(String[] args) {
	String testStr = "http://localhost:8081/AdminTest/controler/delete.do?checkedvalue=100&checkedvalue=99";
	String getStr = testStr.substring(testStr.lastIndexOf("/")+1,testStr.indexOf("?")+1);
	
	System.out.println(getStr);
}
}

