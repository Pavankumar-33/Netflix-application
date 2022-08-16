package epita.service;

import epita.datamodel.Movie;
import epita.datamodel.Role;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class Role_DAO extends JPADAO<Role>{
    public Role_DAO(SessionFactory sf) {

        super(sf);
    }

    @Override
    public Query<Role> getAll(Session session) {
        Query<Role> query = session.createQuery(
                "from Role r "
        );

        query.getQueryString();
        return query;
    }

    @Override
    public Query<Role> get(Long id, Session session) {

        Query<Role> query = session.createQuery(
                "from Role r " +
                        "where (:id is null or :id = r.id) "
        );

        query.setParameter("id", id);
        query.getQueryString();
        return query;

    }

    @Override
    public Query<Role> getCategory(String category, Session session) {
        return null;
    }

    @Override
    public Query<Role> getbyUsername(String username, String password, Session session) {
        return null;
    }



}
