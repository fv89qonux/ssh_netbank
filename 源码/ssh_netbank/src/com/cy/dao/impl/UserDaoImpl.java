package com.cy.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.cy.dao.interfaces.UserDaoInter;
import com.cy.entity.Account;
import com.cy.entity.Admin;
import com.cy.entity.Status;

@Transactional
public class UserDaoImpl implements UserDaoInter {

	private SessionFactory sessionFactory;
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Override
	public Account getAccount(String username) {
        //��ȡsession
		Session session = sessionFactory.getCurrentSession();
        String hql = "from Account where username = '" + username + "'";
        //����query����
        Query query = session.createQuery(hql);
        //����ʵ��ֻ��һ����Ϊnullʱ����uniqueResult()�������ж��ʱ����list()����
		return (Account) query.uniqueResult();
	}
	@Override
	public boolean updateAccount(Account account) {
        Session session = sessionFactory.getCurrentSession();
        session.merge(account);
		return true;
	}
	//��session�����»�ȡ����account
	public void reflush(Account account) {
		Session session = sessionFactory.getCurrentSession();
		session.refresh(account);
		System.out.println(account.getUsername());
	}
	//��ȡ�˻����󣬸����˻�ID
	@Override
	public Account getAccount(int accountid) {
        Session session = sessionFactory.getCurrentSession();
		return (Account) session.get(Account.class, accountid);
	}
	//����username��ȡ����Ա����
	@Override
	public Admin getAdmin(String username) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "from Admin as a where a.username='" + username + "'";
        Query query = session.createQuery(hql);
		return (Admin) query.uniqueResult();
	}
	//��ȡ�˻�״̬���󣬸����˻�ID
	@Override
	public Status getStatus(int id) {
        Session session = sessionFactory.getCurrentSession();
		return (Status) session.get(Status.class, id);
	}
	//��ȡ�˻�״̬���󣬸�������
	@Override
	public Status getStatus(String name) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "from Status as s where s.name='" + name + "'";
        Query query = session.createQuery(hql);
		return (Status) query.uniqueResult();
	}
	//����Աɾ���˻�
	@Override
	public boolean delAccount(Account account) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(account);
		return true;
	}
	//����
	@Override
	public boolean addAccount(Account account) {
        Session session = sessionFactory.getCurrentSession();
        session.save(account);
		return true;
	}

}
