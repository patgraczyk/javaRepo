package db;

import models.Farm;
import models.Product;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class DBFarm {
    private static Session session;

    public static List<Product> allProductsFrom(Farm farm) {
        session = HibernateUtil.getSessionFactory().openSession();
        List<Product> results = null;
        try{
            Criteria cr = session.createCriteria(Product.class);
            cr.add(Restrictions.eq("farm.id", farm.getId()));
            results =  cr.list();

        }catch(HibernateException ex){
            ex.printStackTrace();
        }finally {
            session.close();
        }
        return results;
    }



}
