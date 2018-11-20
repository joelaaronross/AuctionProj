package com.auction.business.image;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Image {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int id;
	private String pictureUrl;
	private String item;
	
	public Image() {
		super();
	}

	public Image(int id, String pictureUrl, String item) {
		super();
		this.id = id;
		this.pictureUrl = pictureUrl;
		this.item = item;
	}
	
	public Image(String url, String item) {
		
		setPictureURL (url); 
		setItem (item);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPictureURL() {
		return pictureUrl;
	}

	public void setPictureURL(String pictureURL) {
		this.pictureUrl = pictureURL;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

		
	@Override
	public String toString() {
		return "Image [id=" + id + ", pictureUrl=" + pictureUrl + ", item=" + item + "]";
	}
	
}
