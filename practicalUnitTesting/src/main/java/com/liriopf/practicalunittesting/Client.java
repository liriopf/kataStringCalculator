package com.liriopf.practicalunittesting;

import java.util.HashSet;
import java.util.Set;

public class Client {

	private final Set<Address> addresses = new HashSet<Address>();

	public Set<Address> getAddresses() {
		return addresses;
	}

	public void addAddress(final Address address) {
		this.addresses.add(address);
	}
}
