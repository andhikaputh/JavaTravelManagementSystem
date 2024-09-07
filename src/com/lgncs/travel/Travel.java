package com.lgncs.travel;

public class Travel {
	private String travelCode;
	private String cityName;
	private String flight;
	private int travelType;
	private int maxPeople;
	private int resvPeople;
	public static final int INDIVIDUAL = 0;
	public static final int PACKAGE = 1;
	
	public Travel (String travelCode, String cityName, String flight, int travelType,int maxPeople) {
		this.travelCode=travelCode;
		this.cityName=cityName;
		this.flight=flight;
		this.travelType=travelType;
		this.maxPeople=maxPeople;
	}
	
	public String getTravelCode() {
		return travelCode;
	}
	
	public int getTravelType() {
		return travelType;
	}
	public int getMaxPeople() {
		return maxPeople;
	}
	public int getResvPeople() {
		return resvPeople;
	}
	public void setResvPeople(int resvPeople) {
		this.resvPeople = resvPeople;
	}
	public void setMaxPeople(int maxPeople) {
//		if(maxPeople<resvPeople) {
//			System.out.println("Jumlah maksimal reservasi diubah menjadi "+getResvPeople());
//			this.maxPeople=resvPeople;
//			
//		}
//		else if (resvPeople<0) {
//			System.out.println("[Error] Jumlah maksimal peserta tidak boleh lebih kecil dari 0");
//		}
//		else {
//			this.maxPeople=maxPeople;
//		}
		this.maxPeople=maxPeople;
	}
	
	public void printTravelInfo() {
		if(travelType == Travel.INDIVIDUAL) {
			System.out.printf("%-12s %-15s %-20s %-10s %-20d %-20d\n",
	                travelCode, cityName, flight, "Individu", maxPeople, resvPeople);
		}
		else {
			System.out.printf("%-12s %-15s %-20s %-10s %-20d %-20d\n",
	                travelCode, cityName, flight, "Paket", maxPeople, resvPeople);
		}
		
	}
}
