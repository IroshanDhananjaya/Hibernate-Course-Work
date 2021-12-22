package util;

/*import entity.Customer;*/
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
    private static SessionFactory sessionFactory = buildSessionFactory(); 

    private static SessionFactory buildSessionFactory() {
        StandardServiceRegistry sReg = new StandardServiceRegistryBuilder().loadProperties("application.properties").build();
        Metadata mData = new MetadataSources(sReg)
               /* .addAnnotatedClass(Customer.class)*/
                .getMetadataBuilder().build();
        return mData.getSessionFactoryBuilder().build();
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
