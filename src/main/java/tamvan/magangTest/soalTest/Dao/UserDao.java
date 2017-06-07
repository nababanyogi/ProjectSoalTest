package tamvan.magangTest.soalTest.Dao;
import java.util.List;

import tamvan.magangTest.soalTest.Model.User;


public interface UserDao {
	
	List <User> listUser();
    User saveOrUpdate(User user);
    void hapus (Integer id);

}
