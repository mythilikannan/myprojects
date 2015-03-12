package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entities.Expenses;

public class ExpensesDao {
	
public static void save(Expenses expenses)
{
	SessionFactory sf = HibernateUtil.getSessionFactory();
	Session session = sf.openSession();
	session.beginTransaction();
	
	Integer id = (Integer) session.save(expenses);
	expenses.setId(id);
	
	session.getTransaction().commit();
	session.close();	
	
}

@SuppressWarnings("unchecked")
public static List<Expenses> list() {
    SessionFactory sf = HibernateUtil.getSessionFactory();
    Session session = sf.openSession();
 
    Query query = session.createQuery(" from Expenses");
    List<Expenses> expenses = (List<Expenses>) 	query.list();
    session.close();
    return expenses;
}

public Expenses update(Expenses expenses) {
	
    SessionFactory sf = HibernateUtil.getSessionFactory();
    Session session = sf.openSession();
 
    session.beginTransaction();
 
    session.merge(expenses);
 
    session.getTransaction().commit();
 
    session.close();
    return expenses;
 
}

public void delete(Expenses expenses) {
	
    SessionFactory sf = HibernateUtil.getSessionFactory();
    Session session = sf.openSession();
 
    session.beginTransaction();
 
    session.delete(expenses);
 
    session.getTransaction().commit();
 
    session.close();
}

}
