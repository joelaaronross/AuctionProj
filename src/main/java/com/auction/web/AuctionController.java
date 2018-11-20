package com.auction.web;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.auction.business.auction.Auction;
import com.auction.business.auction.AuctionRepository;
import com.auction.util.AuctionMaintenanceReturn;

@CrossOrigin
@Controller    
@RequestMapping(path="/Auctions") 
public class AuctionController extends BaseController {
	@Autowired 
	private AuctionRepository auctionRepository;


	@GetMapping(path="/List") 
	public @ResponseBody Iterable<Auction> getAllAuctions() {
		
		try  {
			return auctionRepository.findAll();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@GetMapping(path="/Get")
	public @ResponseBody List<Auction> getAuction (@RequestParam int id) {

		Optional<Auction> p =auctionRepository.findById(id);
		return getReturnArray(p.get());

	}
	
	@GetMapping(path="/Authenticate")
	public @ResponseBody List<Auction> getAuthenticate (@RequestParam Timestamp endDateTime) {
	
		Auction auction= auctionRepository.findByEndDateTime(endDateTime);
		return getReturnArray(auction);
	
	}
	
	@PostMapping(path="/Add") // Map ONLY GET Requests
	public @ResponseBody AuctionMaintenanceReturn addNewAuction (@RequestBody Auction auction) {
		try {
			auctionRepository.save(auction);
			System.out.println("Auction saved:  "+auction);
		}
		catch (Exception e) {
			auction = null;
		}
		return AuctionMaintenanceReturn.getMaintReturn(auction);
	}
	@PostMapping(path="/Change")
	public @ResponseBody AuctionMaintenanceReturn updateAuction (@RequestBody Auction auction) {

		try {
			auctionRepository.save(auction);
			System.out.println("Auction updated:  "+auction);
		}
		catch (Exception e) {
			auction = null;
		}

		return AuctionMaintenanceReturn.getMaintReturn(auction);
	}

	@GetMapping(path="/Remove")
	public @ResponseBody AuctionMaintenanceReturn deleteAuction (@RequestParam int id) {

		Optional<Auction> auction = auctionRepository.findById(id);
		try {
			Auction p = auction.get();
			auctionRepository.delete(p);
			System.out.println("Auction deleted:  "+p);
		}
		catch (Exception e) {
			auction = null;
		}
		return AuctionMaintenanceReturn.getMaintReturn(auction);
	}	
}
