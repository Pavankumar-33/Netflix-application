package epita;

import epita.repository.MovieRepository;
import epita.repository.RoleRepository;
import epita.repository.UserRepository;
import epita.service.Movie_DAO;
import epita.service.Role_DAO;
import epita.service.User_DAO;
import org.hibernate.SessionFactory;
import org.hibernate.dialect.PostgreSQL10Dialect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import javax.sql.DataSource;
import java.util.Properties;

@SpringBootApplication
public class NetflixBackendApplication {
	public static void main(String[] args) {
		SpringApplication.run(NetflixBackendApplication.class);
	}

	@Bean
	public DataSource dataSource() {
		return new DriverManagerDataSource("jdbc:postgresql://localhost:5432/netflix", "pavan", "pavan@12345");
	}

	@Bean
	public LocalSessionFactoryBean sessionFactoryBean(@Autowired DataSource dataSource){
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource);
		sessionFactory.setPackagesToScan("epita.datamodel");
		Properties properties = new Properties();
		properties.setProperty("hibernate.properties", PostgreSQL10Dialect.class.getName());
		properties.setProperty("hibernate.hbm2ddl.auto", "update");
		properties.setProperty("hibernate.show_sql","true");
		sessionFactory.setHibernateProperties(properties);
		return sessionFactory;
	}

	@Bean
	public Movie_DAO getMovieDAO(SessionFactory sf){
		return new Movie_DAO(sf);
	}
	@Bean
	public User_DAO getUserDAO(SessionFactory sf){
		return new User_DAO(sf);
	}
	@Bean
	public Role_DAO getRoleDAO(SessionFactory sf){
		return new Role_DAO(sf);
	}

	@Bean
	public RoleRepository getRoleRepository(SessionFactory sf,
											Role_DAO roleDAO
	){
		return new RoleRepository(sf, roleDAO);
	}

	@Bean
	public UserRepository getUserRepository(SessionFactory sf,
											User_DAO userDao
	){
		return new UserRepository(sf, userDao);
	}



	@Bean
	public MovieRepository getMovieRepository(SessionFactory sf,
											 Movie_DAO movieDAO
	){
		return new MovieRepository(sf, movieDAO);
	}


}