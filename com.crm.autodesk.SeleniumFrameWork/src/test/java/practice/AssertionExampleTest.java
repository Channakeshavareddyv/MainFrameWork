package practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AssertionExampleTest {
	
	@Test
	public void AssertionTest() {
		
		String laptop="Dell";
		String laptop1="Dell";
		
		boolean value=true;
		boolean value1=false;
				
		Assert.assertEquals(laptop, laptop1);
		Assert.assertTrue(value);
		Assert.assertFalse(value1);	
		//Assert.assertTrue(value1);
		Assert.assertTrue(value, "boolean value is correct");
		Assert.assertFalse(value1, "boolean value is correct");
		
		List<Integer> ls=new ArrayList<Integer>();
		ls.add(10);
		ls.add(20);
		ls.add(10);
		ls.add(40);
		
		List<Integer> ls1=new ArrayList<Integer>();
		ls1.add(10);
		ls1.add(20);
		ls1.add(10);
		ls1.add(40);
		
		Assert.assertEquals(ls, ls1);
		
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
		
		//Assert.assertEquals(obj, obj1);
		
		Set<String> titles=new TreeSet<String>();
		titles.add("google");
		titles.add("amazon");
		titles.add("flipkart");
		
		Set<String> titles1=new TreeSet<String>();
		titles1.add("google");
		titles1.add("amazon");
		titles1.add("flipkart");
		
		Assert.assertEquals(titles, titles1);
		Assert.assertEquals(titles, titles1,"Titles are correct");
		
		//Assert.fail();
		//Assert.fail("We only calling assertFail method");
	}

}
