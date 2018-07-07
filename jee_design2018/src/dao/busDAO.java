package dao;

import java.util.List;
import domain.Bus;

public interface BusDAO {
boolean check(Long id) throws Exception;
List<String[]> getAllBus() throws Exception;
List<Bus> getAllBusByObj() throws Exception;
Bus findById(Long id) throws Exception;
Bus findByAr_city(String ar_city) throws Exception;
boolean save(Bus bus) throws Exception;
boolean update(Bus bus) throws Exception;
boolean delById(Long id) throws Exception;

}
