package com.song.jsf.example;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

@SuppressWarnings("deprecation")
@ManagedBean
@SessionScoped
public class SimpleCrudBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private List<Student> list;
    private Student item = new Student();
    private Student beforeEditItem = null;
    private boolean edit;

	private SessionFactory sessionFactory;
	private Session session;

    @PostConstruct
    public void init() {
		sessionFactory = buildSessionFactory(Student.class);
		session = sessionFactory.openSession();
		list = session.createQuery("FROM Student").getResultList();
    }

    public void add() {
    	// DAO save the add
        item.setId(list.isEmpty() ? 1 : list.get(list.size() - 1).getId() + 1);
        list.add(item);
		Transaction txn = session.beginTransaction();
        session.save(item);
        txn.commit();
        item = new Student();
    }
    
    public void update() {
		list = session.createQuery("FROM Student").getResultList();
    }

    public void resetAdd() {
    	item = new Student();
    }

    public void edit(Student item) {
    	beforeEditItem = item.clone();
        this.item = item;
        edit = true;
    }

    public void cancelEdit() {
    	this.item.restore(beforeEditItem);
        this.item = new Student();
        edit = false;
    }

    public void saveEdit() {
		Transaction txn = session.beginTransaction();
		session.update(this.item);
		txn.commit();
    	// DAO save the edit
        this.item = new Student();
        edit = false;
    }

    public void delete(Student item) throws IOException {
    	// DAO save the delete
		list.remove(item);
		Transaction txn = session.beginTransaction();
        session.delete(item);
		txn.commit();

    }

    public List<Student> getList() {
        return list;
    }

    public Student getItem() {
        return this.item;
    }
    
    public boolean isEdit() {
        return this.edit;
    }
    
	private static SessionFactory buildSessionFactory(Class clazz) {
		return new Configuration()
				.configure()
				.addAnnotatedClass(clazz)
				.buildSessionFactory();
	}
}