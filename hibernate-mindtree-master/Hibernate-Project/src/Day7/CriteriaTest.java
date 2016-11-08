package Day7;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class CriteriaTest {
	
	SessionFactory factory;

	public void setup(){
		Configuration configuration = new Configuration();
		configuration.configure();
		
		ServiceRegistryBuilder srb = new ServiceRegistryBuilder();
		srb.applySettings(configuration.getProperties());
		
		ServiceRegistry serviceRegistry = srb.buildServiceRegistry();
		factory = configuration.buildSessionFactory(serviceRegistry);		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CriteriaTest et = new CriteriaTest();
        et.setup();
		
		Session session = et.factory.openSession();
		Criteria cr = session.createCriteria(Employee.class);
		cr.add(Restrictions.eq("salary", 1000));
		cr.add(Restrictions.eq("name","Awantik"));
		List results = cr.list(); 
		
	}

}
