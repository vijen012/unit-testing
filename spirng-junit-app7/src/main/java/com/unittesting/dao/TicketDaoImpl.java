package com.unittesting.dao;

import org.springframework.stereotype.Component;

import com.unittesting.domain.Ticket;

@Component
public class TicketDaoImpl implements TicketDao {

	public int createTicket(Ticket ticket) {
		return 1;
	}

}
