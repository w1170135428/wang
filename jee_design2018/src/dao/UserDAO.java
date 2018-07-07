package dao;
import java.util.List;
import domain.User;
public interface UserDAO {
   boolean check(String username) throws Exception;
   List<User> getAllUsersByObj() throws Exception;
   List<String[]> getAllUsers() throws Exception;
   boolean save(User user) throws Exception;
   boolean update(User user) throws Exception;





}
