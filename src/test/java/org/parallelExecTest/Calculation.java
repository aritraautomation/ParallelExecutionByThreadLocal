package org.parallelExecTest;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Calculation {
	
	@Test
	public void sum(){
		int a=10;
		int b=30;
		
		Assert.assertEquals(a+b, 40);
	}

}
