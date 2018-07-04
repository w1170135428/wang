package dao;

import java.util.List;

import domain.bus;

public interface busDAO {
   boolean check(String username) throws Exception;
   List<String[]> getAllStus() throws Exception;
   List<bus> getAllStusByObj() throws Exception;
    bus findById(long id) throws Exception;
   boolean save(bus stu) throws Exception;
   boolean delById(long id) throws Exception;
   boolean update(bus stu) throws Exception;
}
