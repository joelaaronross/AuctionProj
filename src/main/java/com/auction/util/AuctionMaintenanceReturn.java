package com.auction.util;

public class AuctionMaintenanceReturn {
	private String result;
	private String message;
	public static final String SUCCESS="success";
	public static final String FAILURE="failure";
	
	public AuctionMaintenanceReturn() {
		result = "Initialized result, not yet set.";
		message = "Initialized message, not yet set.";
	}
	public AuctionMaintenanceReturn(String result, String message) {
		super();
		this.result = result;
		this.message = message;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public static AuctionMaintenanceReturn getMaintReturn(Object obj) {
		AuctionMaintenanceReturn r = new AuctionMaintenanceReturn();
		if (obj!=null) {
			r.setResult(SUCCESS);
			r.setMessage(obj.getClass().getSimpleName()+" maintenance success");
		}
		else {
			r.setResult(FAILURE);
			r.setMessage("Not found");
		}
		return r;

	}

	/*
	 * Get a maintenance return obj and include a message
	 */
	public static AuctionMaintenanceReturn getMaintReturn(Object obj, String msg) {
		AuctionMaintenanceReturn r = new AuctionMaintenanceReturn();
		if (obj!=null) {
			r.setResult(SUCCESS);
			r.setMessage(obj.getClass().getSimpleName()+" maintenance success");
		}
		else {
			r.setResult(FAILURE);
			// Can't use obj.getClass() because obj is null
			r.setMessage("msg");
		}
		return r;

	}
	
	
}
