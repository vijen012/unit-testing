package com.unittesting.service;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.unittesting.dao.TicketDao;
import com.unittesting.domain.Ticket;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:application-context.xml")
public class TicketServiceImplTest {
	
	private static final int EXPECTED_RESULT = 1;
	private static final String PHONE = "9980323232";
	private static final String PASSANGER = "Mayank";
	
	@Mock
	private TicketDao ticketDao;
	
	@Autowired
	@InjectMocks
	private TicketServiceImpl ticketServiceImpl;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@After
	public void tearDown() throws Exception {
	}

	
	@Test
	public void buyTicketShouldReturnAValidValue() {
		when(ticketDao.createTicket(any(Ticket.class))).thenReturn(new Integer(1));
		int result = ticketServiceImpl.buyTicket(PASSANGER, PHONE);
		assertEquals(EXPECTED_RESULT, result);
//		verify(ticketDao).createTicket(new Ticket());
	}

}
