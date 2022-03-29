package practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertionExamplesTest {
	
	@Test
	public void AssertionTest() {
		
		String laptop="Dell Abc";
		String laptop1="Dell";
		
		boolean value=true;
		boolean value1=false;
		SoftAssert sa = new SoftAssert();		
		sa.assertEquals(laptop, laptop1);
		sa.assertTrue(value1);
		sa.assertTrue(value, "boolean value is correct");
		
		List<Integer> ls=new ArrayList<Integer>();
		ls.add(10);
		ls.add(20);
		ls.add(10);
		ls.add(40);
		
		List<Integer> ls1=new ArrayList<Integer>();
		ls1.add(10);
		ls1.add(20);
		ls1.add(10);
		ls1.add(30);
		
		sa.assertEquals(ls, ls1);
		
		List<Object> obj=new ArrayList<Object>();
		obj.add("channa");
		obj.add(20);
		obj.add(10);
		obj.add("reddy");
		
		List<Object> obj1=new ArrayList<Object>();
		obj1.add(10);
		obj1.add("false");
		obj1.add(10);
		obj1.add("true");
		
		sa.assertEquals(obj, obj1);
		
		Set<String> titles=new TreeSet<String>();
		titles.add("google");
		titles.add("amazon");
		titles.add("flipkart");
		
		Set<String> titles1=new TreeSet<String>();
		titles1.add("google");
		titles1.add("amazon");
		titles1.add("flip");
		
		sa.assertEquals(titles, titles1);
		sa.assertEquals(titles, titles1,"Titles are correct");		
		
		//sa.assertAll();
	}

}
