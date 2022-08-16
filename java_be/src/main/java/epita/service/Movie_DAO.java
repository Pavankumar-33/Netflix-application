package epita.service;

import epita.datamodel.Movie;
import epita.datamodel.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class Movie_DAO extends JPADAO<Movie> {

    public Movie_DAO(SessionFactory sf) {

        super(sf);
    }

    @Override
    public Query<Movie> getAll(Session session) {
        Query<Movie> query = session.createQuery(
                "from Movie m "
        );

        query.getQueryString();
        return query;
    }

    @Override
    public Query<Movie> get(Long id, Session session) {

        Query<Movie> query = session.createQuery(
                "from Movie m " +
                        "where (:id is null or :id = m.id) "
        );

        query.setParameter("id", id);
        query.getQueryString();
        return query;

    }

    @Override
    public Query<Movie> getCategory(String category, Session session) {

        Query<Movie> query = session.createQuery(
                "from Movie m " +
                        "where (:category is null or :category = m.category) "
        );

        query.setParameter("category", category);
        query.getQueryString();
        return query;

    }


    @Override
    public Query<Movie> getbyUsername(String username, String password, Session session) {
        return null;
    }
}
