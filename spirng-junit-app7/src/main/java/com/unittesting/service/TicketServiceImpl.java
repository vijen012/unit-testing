package com.unittesting.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.unittesting.dao.TicketDao;
import com.unittesting.domain.Ticket;

@Component
public class TicketServiceImpl implements TicketService {

	@Autowired
	private TicketDao ticketDao;
	
	public int buyTicket(String passangerName, String phone) {
		Ticket ticket = new Ticket();
		ticket.setPassangerName(passangerName);
		ticket.setPhone(phone);
		return getTicketDao().createTicket(ticket);
	}

	public TicketDao getTicketDao() {
		return ticketDao;
	}

	public void setTicketDao(TicketDao ticketDao) {
		this.ticketDao = ticketDao;
	}

}
