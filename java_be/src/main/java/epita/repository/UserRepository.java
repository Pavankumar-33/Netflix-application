package epita.repository;

import epita.datamodel.Movie;
import epita.datamodel.User;
import epita.service.User_DAO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.transaction.Transactional;
import java.util.List;

public class UserRepository {
    private final SessionFactory sessionFactory;
    private final User_DAO userJPADAO;


    public UserRepository(SessionFactory sf,
                          User_DAO userDAO
    ) {
        this.sessionFactory = sf;
        this.userJPADAO = userDAO;
    }

    public User getByUsername(String username, String password){
        Session session = getSession();
        List<User> searchResult = this.userJPADAO.searchbyUsername(username, password);
        try {
            return searchResult.get(0);
        } catch (Exception e) {
            return null;
        }

    }


    public List<User> getUsers(){
        Session session = getSession();
        List<User> searchResult = this.userJPADAO.search();
        return searchResult;
    }

    @Transactional
    public User createUser(User user){
        this.userJPADAO.create(user);
        return getUsers().get(0);
    }

    @Transactional
    public void deleteByName(String name){
        this.userJPADAO.delete(name);
    }


    private Session getSession() {
        Session currentSession = null;
        try {
            currentSession = this.sessionFactory.getCurrentSession();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        if (currentSession != null && currentSession.isOpen()) {
            return currentSession;
        } else {
            return this.sessionFactory.openSession();
        }
    }

}
