package com.computermart.projectbackend;



import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.computermart.projectbackend.model.Cart;
import com.computermart.projectbackend.model.Category;
import com.computermart.projectbackend.model.Customer;
import com.computermart.projectbackend.model.CustomerOrder;
import com.computermart.projectbackend.model.Product;
import com.computermart.projectbackend.model.ShipAddress;
import com.computermart.projectbackend.model.UserCredentials;
import com.computermart.projectbackend.model.Wish;

@Configuration
@EnableTransactionManagement
public class Config {

	@Bean(name="dataSource")
	public DataSource getDataSource() {
	    BasicDataSource dataSource = new BasicDataSource();
	    dataSource.setDriverClassName("org.h2.Driver");
	    dataSource.setUrl("jdbc:h2:tcp://localhost/~/s190032");
	    dataSource.setUsername("sa");
	    dataSource.setPassword("sa");
	    return dataSource;
	}
	
	@Bean //SessionFactory - factory of session objects
	public SessionFactory sessionFactory() {
		System.out.println("Entering sessionFactory creation method");
		LocalSessionFactoryBuilder lsf=
				new LocalSessionFactoryBuilder(getDataSource());
		Properties hibernateProperties=new Properties();
		hibernateProperties.setProperty(
				"hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		hibernateProperties.setProperty("hibernate.hbm2ddl.auto", "update");
		hibernateProperties.setProperty("hibernate.show_sql", "true");
		lsf.addProperties(hibernateProperties);
		Class classes[]=new Class[]{Product.class,Category.class,Customer.class,UserCredentials.class,Cart.class,ShipAddress.class,CustomerOrder.class,Wish.class};
		System.out.println("SessionFactory bean " + lsf);
	    return lsf.addAnnotatedClasses(classes).buildSessionFactory();
	}
	@Bean
	public HibernateTransactionManager hibTransManagement(){
		return new HibernateTransactionManager(sessionFactory());
	}

}
