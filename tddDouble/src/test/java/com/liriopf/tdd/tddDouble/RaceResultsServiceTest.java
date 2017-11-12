package com.liriopf.tdd.tddDouble;

import org.junit.Test;
import static org.mockito.Mockito.*;

public class RaceResultsServiceTest {
	
	RaceResultsService raceResults = new RaceResultsService();
	Client clientA = mock(Client.class, "clientA");
	Client clientB = mock(Client.class, "clientB");
	Message message = mock(Message.class);
	
	@Test
	public void notSubscribedClientShouldNotReceiveMessage() {
		raceResults.send(message);
		
		verify(clientA, never()).receive(message);
		verify(clientB, never()).receive(message);
	}
	
	@Test
	public void shouldSendOnlyOneMessageToMultiSubscriber() {
		raceResults.addSubscriber(clientA);
		raceResults.addSubscriber(clientA);
		raceResults.send(message);
		verify(clientA).receive(message);
	}
	
	@Test
	public void unsubscribedClientShouldNotReceivedMessages() {
		raceResults.addSubscriber(clientA);
		raceResults.removeSubscriber(clientA);
		
		raceResults.send(message);
		
		verify(clientA, never()).receive(message);
	}
	
	@Test
	public void subscribedClientShouldReceiveMessage() {
			
		raceResults.addSubscriber(clientA);
		raceResults.send(message);
		
		verify(clientA).receive(message);
	}
	
	@Test
	public void messageShouldBeSentToAllSubscribedClients() {
			
		raceResults.addSubscriber(clientA);
		raceResults.addSubscriber(clientB);
		raceResults.send(message);
		
		verify(clientA).receive(message);
		verify(clientB).receive(message);
	}

}
