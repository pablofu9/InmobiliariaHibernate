package pablo.ExamenPabloFuertesHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import pablo.ExamenPabloFuertesHibernate.*;

public class HibernateUtil {
	static SessionFactory factory = null;
	static {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(Piso.class);
		cfg.addAnnotatedClass(Zona.class);
		// Se registran las clases que hay que mapear con cada tabla de la base de datos
	         //configuration.addAnnotatedClass(Clase1.class);
	         //configuration.addAnnotatedClass(Clase2.class);
	         //configuration.addAnnotatedClass(Clase3.class);

		factory = cfg.buildSessionFactory();
	}
	
	public static SessionFactory getSessionFactory() {
		return factory;
	}
	
	public static Session getSession() {
		return factory.openSession();
	}
}

