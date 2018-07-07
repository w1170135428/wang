package domain;

public class Bus {
	private String st_city,ar_city,st_time,ar_time,st_station;
	private Long passenger_num,id;
	private Double price;

	public String getSt_city() {
		return st_city;
	}

	public void setSt_city(String st_city) {
		this.st_city = st_city;
	}

	public String getAr_city() {
		return ar_city;
	}

	public void setAr_city(String ar_city) {
		this.ar_city = ar_city;
	}

	public String getSt_time() {
		return st_time;
	}

	public void setSt_time(String st_time) {
		this.st_time = st_time;
	}

	public String getSt_station() {
		return st_station;
	}

	public void setSt_station(String st_station) {
		this.st_station = st_station;
	}

	public double getPassenger_num() {
		return passenger_num;
	}

	public void setPassenger_num(long passenger_num) {
		this.passenger_num = passenger_num;
	}

	public double getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getAr_time() {
		return ar_time;
	}

	public void setAr_time(String ar_time) {
		this.ar_time = ar_time;
	}

}

