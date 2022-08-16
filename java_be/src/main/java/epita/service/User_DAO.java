package epita.service;

import epita.datamodel.Movie;
import epita.datamodel.Role;
import epita.datamodel.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class User_DAO extends JPADAO<User>{
    public User_DAO(SessionFactory sf) {

        super(sf);
    }

    @Override
    public Query<User> getAll(Session session) {
        Query<User> query = session.createQuery(
                "from User u "
        );

        query.getQueryString();
        return query;
    }

    @Override
    public Query<User> get(Long id, Session session) {
        return null;
    }

    @Override
    public Query<User> getCategory(String category, Session session) {
        return null;
    }

    @Override
    public Query<User> getbyUsername(String username, String password, Session session) {

        Query<User> query = session.createQuery(
                "from User u " +
                        "where (:username is null or (:username = u.username and :password = u.password)) "
        );

        query.setParameter("username", username);
        query.setParameter("password", password);
        query.getQueryString();
        return query;

    }

}
