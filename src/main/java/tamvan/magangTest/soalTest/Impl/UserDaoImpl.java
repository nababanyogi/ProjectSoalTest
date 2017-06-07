package tamvan.magangTest.soalTest.Impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import tamvan.magangTest.soalTest.Dao.UserDao;
import tamvan.magangTest.soalTest.Model.User;

@Service
public class UserDaoImpl implements UserDao{

	private EntityManagerFactory emf;
	
	@Autowired
	public void setEmf(EntityManagerFactory emf) {
		this.emf = emf;
	}


	@Override
	public List<User> listUser() {
		EntityManager em = emf.createEntityManager();
        return em.createQuery("from User", User.class).getResultList();
	
	}

	@Override
	public void hapus(Integer id) {
			EntityManager em  = emf.createEntityManager();
			em.getTransaction().begin();
			em.remove(em.find(User.class, id));
			em.getTransaction().commit(); 		
	}
	
	@Override
	public User saveOrUpdate(User user) {
		EntityManager em  = emf.createEntityManager();
		em.getTransaction().begin();
		User saved = em.merge(user);
		em.getTransaction().commit();
		return saved; 
	}
}
