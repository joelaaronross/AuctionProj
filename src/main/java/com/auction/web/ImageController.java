package com.auction.web;

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

import com.auction.business.image.Image;
import com.auction.business.image.ImageRepository;
import com.auction.util.AuctionMaintenanceReturn;

@CrossOrigin
@Controller    
@RequestMapping(path="/Images") 
public class ImageController extends BaseController {
	@Autowired 
	private ImageRepository imageRepository;

	@GetMapping(path="/List") 
	public @ResponseBody Iterable<Image> getAllImages() {
		return imageRepository.findAll();
	}
	
	@GetMapping(path="/Get")
	public @ResponseBody List<Image> getImage (@RequestParam int id) {
		
		Optional<Image> i=imageRepository.findById(id);
		return getReturnArray(i.get());
	}
	
	@PostMapping(path="/Add") 
	public @ResponseBody AuctionMaintenanceReturn addNewImage (@RequestBody Image image) {
			try {
		imageRepository.save(image);
		return AuctionMaintenanceReturn.getMaintReturn(image);
	}
	catch (Exception e) {
		image = null;
	}
return AuctionMaintenanceReturn.getMaintReturn(image);
}
	@GetMapping(path="/Remove") 
	public @ResponseBody AuctionMaintenanceReturn deleteImage (@RequestParam int id) {
		Optional<Image> image = imageRepository.findById(id);
		try {
			Image i = image.get();
			imageRepository.delete(i);
			System.out.println("Image deleted:  "+i);
		}
		catch (Exception e) {
			image = null;
		}
		return AuctionMaintenanceReturn.getMaintReturn(image);
	}
	
	@PostMapping(path="/Change") 
	public @ResponseBody AuctionMaintenanceReturn updateImage (@RequestBody Image image) {
		try {
			imageRepository.save(image);
			System.out.println("Image updated:  "+image);
		}
		catch (Exception e) {
			image = null;
		}
		return AuctionMaintenanceReturn.getMaintReturn(image);
	}
}
