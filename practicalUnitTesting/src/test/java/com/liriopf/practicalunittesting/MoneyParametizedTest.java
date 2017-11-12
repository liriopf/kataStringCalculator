package com.liriopf.practicalunittesting;

import org.junit.runner.RunWith;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

//import static junitparams.JUnitParamsRunner.$;

@RunWith(JUnitParamsRunner.class)
public class MoneyParametizedTest {
	private static final Object[] getMoney() {
		return new Object[] {
				new Object[] {10,"USD"},
				new Object[] {20,"EUR"}
		};
	}
	
//	private static final Object[] getMoney() {
//		return $(
//				$(10,"USD"),
//				$(20,"EUR"));
//	}
	
	@Test
	@Parameters(method="getMoney")
	public void constructorShouldSetAmountAndCurrency(
			int amount, String currency) {
		Money money = new Money(amount, currency);
		
		assertEquals(amount, money.getAmount());
		assertEquals(currency, money.getCurrency());
	}
	

}
