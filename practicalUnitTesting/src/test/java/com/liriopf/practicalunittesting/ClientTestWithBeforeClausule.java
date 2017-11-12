package com.liriopf.practicalunittesting;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ClientTestWithBeforeClausule {
	
	private Address addressA = new Address("street A");
	private Address addressB = new Address("street B");
	
	private Client client = null;
	
	@Before
	public void setup() {
		client = new Client();
	}
	
	@Test
	public void afterCreationShouldHaveNoAddress() {
		assertEquals(0, client.getAddresses().size());
	}
	
	@Test
	public void shouldAllowToAddress() {
		client.addAddress(addressA);
		assertEquals(1, client.getAddresses().size());
		assertTrue(client.getAddresses().contains(addressA));
	}
	
	@Test
	public void shouldAllToAddManyAddresses() {
		client.addAddress(addressA);
		client.addAddress(addressB);
		
		assertEquals(2, client.getAddresses().size());
		assertTrue(client.getAddresses().contains(addressA));
		assertTrue(client.getAddresses().contains(addressB));
	}

}
