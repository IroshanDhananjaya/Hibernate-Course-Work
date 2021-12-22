package util;

/*import entity.Customer;*/
import entity.Programme;
import entity.Student;
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
               .addAnnotatedClass(Student.class).addAnnotatedClass(Programme.class)
                .getMetadataBuilder().build();
        return mData.getSessionFactoryBuilder().build();
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
