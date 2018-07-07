package controller;

import java.util.List;
import com.opensymphony.xwork2.ActionSupport;

import dao.CityDAO;
import dao.CityDAOImp;
import domain.City;

public class CityAction extends ActionSupport {
	private List<String[]> citys;
	private List<City> citysByObj;
	City city;
	
	public List<String[]> getCitys() {
		return citys;
	}
	public void setCitys(List<String[]> citys) {
		this.citys = citys;
	}
	public List<City> getCitysByObj() {
		return citysByObj;
	}
	public void setCitysByObj(List<City> citysByObj) {
		this.citysByObj = citysByObj;
	}
	public City getCity() {
		return city;
	}
	public void setCity(City city) {
		this.city = city;
	}
	public String execute() throws Exception {
		CityDAO dao = new CityDAOImp();
		city = (City) dao.getAllCitys();
		getAllCityByObj();
		return SUCCESS;
	}
    public void getAllCityByObj()throws Exception {
	  CityDAO dao=new CityDAOImp();
	  citysByObj=dao.getAllCitysByObj();	  
	}
}
