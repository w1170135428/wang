package dao;

import java.util.List;
import domain.City;

public interface CityDAO {

	boolean check(String name) throws Exception;
	List<String[]> getAllCitys() throws Exception;
	List<City> getAllCitysByObj() throws Exception;

}
