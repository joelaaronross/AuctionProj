package com.auction.business.auction;

import java.security.Timestamp;

import org.springframework.data.repository.CrudRepository;


public interface AuctionRepository extends CrudRepository<Auction, Integer> {
	
	Auction findByEndDateTime (Timestamp endDateTime); 
}