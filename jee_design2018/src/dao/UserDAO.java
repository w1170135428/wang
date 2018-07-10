package dao;
import java.util.List;
import domain.User;
public interface UserDAO {
   List<User> getAllUsersByObj() throws Exception;
   boolean save(User user) throws Exception;
   boolean update(User user) throws Exception;
}
