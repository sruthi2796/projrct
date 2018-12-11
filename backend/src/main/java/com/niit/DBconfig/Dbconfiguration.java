package com.niit.DBconfig;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.model.Authorities;
import com.niit.model.Billingaddress;
import com.niit.model.Cartitems;
import com.niit.model.Category;
import com.niit.model.Customer;
import com.niit.model.CustomerOrder;
import com.niit.model.Product;
import com.niit.model.Shippingaddress;
import com.niit.model.User;

@Configuration
@EnableTransactionManagement
public class Dbconfiguration {
	public Dbconfiguration()
	{
		System.out.println("DBconfiguration is created");
	}
	@Bean(value="dataSource")
	public DataSource getDatasource()
	{
		BasicDataSource datasource =new BasicDataSource();
		datasource.setDriverClassName("org.h2.Driver");
		datasource.setUrl("jdbc:h2:tcp://localhost/~/test");
		datasource.setUsername("sruthi v");
		datasource.setPassword("sruthikavin");
		System.out.println("datasource is created");
		return datasource;
		
	}
	@Bean
	public SessionFactory sessionfactory()
	{
		System.out.println("Sessinfactory is created");
		LocalSessionFactoryBuilder builder=new LocalSessionFactoryBuilder(getDatasource());
		Properties hibernateproperties =new Properties();
		hibernateproperties.setProperty("hibernate.dialect","org.hibernate.dialect.H2Dialect");
		hibernateproperties.setProperty("hibernate.hbm2ddl.auto","update");
		hibernateproperties.setProperty("hibernate.show_sql","true");
		builder.addProperties(hibernateproperties);
		Class classes[]=new Class[] {Product.class,Category.class,User.class,Authorities.class,Customer.class,Billingaddress.class,CustomerOrder.class,Shippingaddress.class,Cartitems.class};
		System.out.println("sessinofactorybean"+builder);
		return builder.addAnnotatedClasses(classes).buildSessionFactory();
		
	}
	@Bean
	public HibernateTransactionManager hibernatetransactionmanager()
	{ 
		System.out.println("transaction manager can be created");
		return new HibernateTransactionManager(sessionfactory());
	}
	

}
