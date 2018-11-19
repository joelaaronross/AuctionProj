package com.auction.web;

import java.util.List;

import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.auction.business.lotter.Lotter;
import com.auction.business.lotter.LotterRepository;

@CrossOrigin
@Controller    
@RequestMapping(path="/Lotters") 
public class LotterController extends BaseController {
	@Autowired 
	private LotterRepository lotterRepository;

	@GetMapping(path="/List") 
	public @ResponseBody Iterable<Lotter> getAllLotters() {
		return lotterRepository.findAll();
	}
	
	@GetMapping(path="/Get")
	public @ResponseBody List<Lotter> getLotter (@RequestParam int id) {
		
		Optional<Lotter> l =lotterRepository.findById(id);
		return getReturnArray(l.get());

	}
	
	@PostMapping(path="/Add") 
	public @ResponseBody AuctionMaintenanceReturn addNewLotter (@RequestBody Lotter lotter) {
			try {
		lotterRepository.save(lotter);
		return AuctionMaintenanceReturn.getMaintReturn(lotter);
	}
			catch (Exception e) {
		lotter = null;
	}
return AuctionMaintenanceReturn.getMaintReturn(lotter);
}
	
	@GetMapping(path="/Remove") 
	public @ResponseBody AuctionMaintenanceReturn deleteLotter (@RequestParam int id) {
	
	Optional <Lotter> lotter = lotterRepository.findById(id);
		try {
	lotterRepository.delete(lotter.get());

}
catch (Exception e) {
	lotter = null;
}
return AuctionMaintenanceReturn.getMaintReturn(lotter);
}
	
	@PostMapping(path="/Change") 
	public @ResponseBody AuctionMaintenanceReturn updateLotter (@RequestBody Lotter lotter) {
		try {
			lotterRepository.save(lotter);
			System.out.println("Lotter updated:  "+lotter);
		}
		catch (Exception e) {
			lotter = null;
		}
	return AuctionMaintenanceReturn.getMaintReturn(lotter);
	}
}
