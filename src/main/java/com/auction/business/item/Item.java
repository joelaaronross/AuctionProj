package com.auction.business.item;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Item {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int lotterId;
	private int auctionId;
	private String imageItem;
	private String itemBrand;
	private String description;
	private double msrp;
	private String model;
	private int loadNumber;
	
	public Item() {
		super();
	}

	public Item(int id, int lotterId, int auctionId, String imageItem, String itemBrand, String description, double msrp,
			String model, int loadNumber) {
		super();
		this.id = id;
		this.lotterId = lotterId;
		this.auctionId = auctionId;
		this.imageItem = imageItem;
		this.itemBrand = itemBrand;
		this.description = description;
		this.msrp = msrp;
		this.model = model;
		this.loadNumber = loadNumber;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getLotterId() {
		return lotterId;
	}

	public void setLotterId(int lotterId) {
		this.lotterId = lotterId;
	}

	public int getAuctionId() {
		return auctionId;
	}

	public void setAuctionId(int auctionId) {
		this.auctionId = auctionId;
	}

	public String getImageItem() {
		return imageItem;
	}

	public void setImageItem(String imageItem) {
		this.imageItem = imageItem;
	}

	public String getItemBrand() {
		return itemBrand;
	}

	public void setItemBrand(String itemBrand) {
		this.itemBrand = itemBrand;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getMsrp() {
		return msrp;
	}

	public void setMsrp(double msrp) {
		this.msrp = msrp;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getLoadNumber() {
		return loadNumber;
	}

	public void setLoadNumber(int loadNumber) {
		this.loadNumber = loadNumber;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", lotterId=" + lotterId + ", auctionId=" + auctionId + ", imageItem=" + imageItem
				+ ", itemBrand=" + itemBrand + ", description=" + description + ", msrp=" + msrp + ", model="
				+ model + ", loadNumber=" + loadNumber + "]"; 
	}
}
