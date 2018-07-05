package dao;

import java.util.List;

import domain.Bus;

public interface BusDAO {
   boolean check(String username) throws Exception;
List<String[]> getAllBus() throws Exception;
List<Bus> getAllBusByObj() throws Exception;
Bus findById(long id) throws Exception;
}
