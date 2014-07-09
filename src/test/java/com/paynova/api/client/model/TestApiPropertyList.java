package com.paynova.api.client.model;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class TestApiPropertyList {

	@Test
	public void testCollectionConstruction() {
		Address a = new Address();
		a.setStreet1("Foo street");
		
		
		ApiPropertyList<Address> tickets = new ApiPropertyList<Address>(Arrays.asList(new Address[]{a}));
		
		assertEquals("Foo street", tickets.get(0).getStreet1());
	}
}
