package com.liriopf.practicalunittesting;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

@RunWith(JUnitParamsRunner.class)
public class HasMapTest {
	
	public static final Object [] getItemWithNullKey(){
		return new Object[][]{{null, "valor"}};
	}
	
	public static final Object [] getItem(){
		return new Object[][]{{"clave", "valor"}};
	}
	
	public static final Object [] getItems(){
		return new Object[][]{{"clave1", "valor1"},{"clave2", "valor2"},{"clave1", "valor3"}};
	}
	
	private Map<Object,Object> map = null;
	
	@Before
	public void setUp() {
		map = new HashMap<Object,Object>();
	}
	
	@Test
	@Parameters(method="getItem")
	public void checkPut(Object key, Object value) {
		assertTrue(map.size()==0);
		map.put(key, value);
		assertTrue(map.size()==1);
		assertEquals(value, map.get(key));
	}
	
	@Test
	@Parameters(method="getItems")
	public void checkPutSameKey(Object key, Object value) {
		map.put(key,value);
		assertEquals(value, map.get(key));
	}
	
	@Test
	@Parameters(method="getItem")
	public void checkClearMap(Object key, Object value) {
		map.put(key, value);
		assertTrue("Tamaño del mapa = 1",map.size()==1);
		map.clear();
		assertTrue("Tamaño del mapa = 0",map.size()==0);
	}
	
	@Test
	@Parameters(method="getItemWithNullKey")
	public void checkPutNullKey(Object key, Object value) {
		assertTrue(map.size()==0);
		map.put(key, value);
		assertTrue(map.size()==1);
		assertEquals(value, map.get(null));
	}
}
