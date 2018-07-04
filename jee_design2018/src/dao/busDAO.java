package dao;

import java.util.List;

import domain.bus;

public interface busDAO {
   boolean check(String username) throws Exception;
   List<String[]> getAllbuss() throws Exception;
   List<bus> getAllbussByObj() throws Exception;
    bus findById(long id) throws Exception;
   boolean save(bus bus) throws Exception;
   boolean delById(long id) throws Exception;
   boolean update(bus bus) throws Exception;
}
