package hibernatedemo;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import util.HibernateUtil;

public class Tester {
	public static void main(String[] args) {
		Configuration cfg = new Configuration().configure();

		SchemaExport ex = new SchemaExport(cfg);
		ex.create(true, true);

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();

		Message msg1 = new Message("De eerste demo-tekst.");
		Long id = (Long) session.save(msg1);
		System.out.println("Bericht met id " + id + " is toegevoegd.");
		
		Message msg2 = new Message("En nog een fraaie demo-tekst.");
		id = (Long) session.save(msg2);
		System.out.println("Bericht met id " + id + " is toegevoegd.");

		tx.commit();
		session.close();

		HibernateUtil.shutDown();
	}
}
