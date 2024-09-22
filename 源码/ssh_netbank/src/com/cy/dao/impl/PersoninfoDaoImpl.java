package com.cy.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

import com.cy.dao.interfaces.PersoninfoDaoInter;
import com.cy.entity.Personinfo;
import com.cy.entity.Status;

@Transactional
public class PersoninfoDaoImpl implements PersoninfoDaoInter {

	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	//ʵ���޸ĸ�����Ϣ
	@Override
	public void modifyPersoninfo(Personinfo personinfo) {

		Session session = sessionFactory.getCurrentSession();
		session.update(personinfo);
	}

	//����Ա��ȡ�����û���Ϣ
	@Override
	public List getAllPersoninfo() {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from Personinfo";
		Query query = session.createQuery(hql);
		return query.list();
	}

	//����Ա�����˻�״̬��ѯ�û���Ϣ������idΪ����Աҳ�泬���������idֵ
	@Override
	public List searchPersoninfo(int id) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from Personinfo p where p.account.status.id = "+id;
		Query query = session.createQuery(hql);
		return query.list();
	}

	//������ʵ������ѯ������Ϣ
	@Override
	public List searchPersoninfo(Personinfo personinfo) {
        Session session = sessionFactory.getCurrentSession();
        //ʹ��hibernate��criteria�������в�ѯ
        Criteria c = session.createCriteria(Personinfo.class);
        //System.out.println(personinfo.getAddress());
        if(personinfo.getRealname() != null && !"".equals(personinfo.getRealname())) {
        	//System.out.println(personinfo.getCardid());
        	if(personinfo.getCardid() != null) {
        		c.add(Restrictions.or(Restrictions.eq("realname", personinfo.getRealname()), Restrictions.eq("cardid", personinfo.getCardid())));
        	} else {
        		//MatchMode.ANYWHERE��ʾģ��ƥ��     "realname"Ϊ���ݿ��е��ֶ�
        		c.add(Restrictions.like("realname", personinfo.getRealname(), MatchMode.ANYWHERE));
        	}
        }
        //��ѯ�������idֵ������������
        c.addOrder(Order.asc("id"));
        return c.list();
	}

	//����Ա����
	@Override
	public boolean add(Personinfo personinfo) {
        Session session = sessionFactory.getCurrentSession();
        session.save(personinfo);
		return true;
	}

}
