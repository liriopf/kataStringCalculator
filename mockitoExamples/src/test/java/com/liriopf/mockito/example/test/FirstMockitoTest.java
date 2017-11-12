package com.liriopf.mockito.example.test;

import com.liriopf.mockito.example.Car;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Test;

public class FirstMockitoTest {

	private Car myFerrari = mock(Car.class);
	
	@Test
	public void testIfCarIsACar() {
		assertTrue(myFerrari instanceof Car);
	}
	
//    @Test    
//    public void testDefaultBehaviourOfTestDouble() {
//    	assertFalse("new test double should return false as boolean",
//    			myFerrari.needsFuel());        
//    	assertEquals("new test double should return 0.0 as double",
//    			0.0, myFerrari.getEngineTemperature());
//    } 
	
	 @Test    
	 public void testStubbing() {        
		 assertFalse("new test double should return false as boolean",
	            myFerrari.needsFuel()); 
	     when(myFerrari.needsFuel()).thenReturn(true); 
	     assertTrue("after instructed test double should return what we want",
	            myFerrari.needsFuel());     
	 } 
	 
	 @Test(expected = RuntimeException.class)     
	 public void throwException() {        
		 when(myFerrari.needsFuel()).thenThrow(new RuntimeException()); 
		 myFerrari.needsFuel();     
     } 
	
}
