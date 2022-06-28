package application.util;

import application.model.Cliente;
import application.model.Produto;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;

public class HibernateUtil {

	private static SessionFactory sessionFactory;
	
	public static SessionFactory getSessionFactory() {
		if(sessionFactory == null) {
			try {
				Configuration configuration = new Configuration();
				
				// Connection Properties ***
				Properties prop = new Properties();
				prop.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
				prop.put(Environment.URL, "jdbc:mysql://localhost:3306/PlayMusic?createDatabaseIfNotExist=true");
				prop.put(Environment.USER, "jed");
				prop.put(Environment.PASS, "321321");
				prop.put(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");
				prop.put(Environment.SHOW_SQL, "true");
				prop.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
				prop.put(Environment.HBM2DDL_AUTO, "update"); //create, create-drop, validate, update\\
				
				// Imported Classes ***
				configuration.setProperties(prop);
				configuration.addAnnotatedClass(Produto.class);
				configuration.addAnnotatedClass(Cliente.class);

				// Properties ***
				ServiceRegistry registry = new StandardServiceRegistryBuilder()
					.applySettings(configuration.getProperties())
					.build();
	
				sessionFactory = configuration.buildSessionFactory(registry);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return sessionFactory;
	}
}
