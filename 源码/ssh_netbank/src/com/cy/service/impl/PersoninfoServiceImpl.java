package com.cy.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.cy.dao.interfaces.PersoninfoDaoInter;
import com.cy.dao.interfaces.UserDaoInter;
import com.cy.entity.Personinfo;
import com.cy.entity.Status;
import com.cy.service.interfaces.PersoninfoServiceInter;
import com.cy.service.interfaces.UserServiceInter;

@Transactional
public class PersoninfoServiceImpl implements PersoninfoServiceInter {

	//ʹ��PersoninfoDaoInter�ӿڶ�����󣬲����set������ʵ������ע��
	private PersoninfoDaoInter personinfoDaoInter;
	//ʹ��UserDAOInter�ӿڶ�����󣬲����set������ʵ������ע��
	private UserDaoInter userDaoInter;
	public void setPersoninfoDaoInter(PersoninfoDaoInter personinfoDaoInter) {
		this.personinfoDaoInter = personinfoDaoInter;
	}
	public void setUserDaoInter(UserDaoInter userDaointer) {
		this.userDaoInter = userDaointer;
	}
	
	//�޸ĸ�����Ϣ
	@Override
	public boolean modifyPersoninfo(Personinfo personinfo) {
		personinfoDaoInter.modifyPersoninfo(personinfo);
		return true;
	}
	
    //����Ա�����˻�״̬��ѯ�û���Ϣ,״̬Ϊ0��ʾ��ȡ�����û�
	@Override
	public List searchPersoninfo(Status status) {
        List users = new ArrayList();
        //System.out.println(status.getId());
        if(status.getId() != 0) {
        	//���˻�״̬��Ų�Ϊ0������ݱ�Ż�ȡ��Ӧ�Ŀͻ���¼
        	//status = userDaoInter.getStatus(status.getId());
        	//System.out.println("���a"+status.getId());
        	users = personinfoDaoInter.searchPersoninfo(status.getId());
        } else {
        	//���Ϊ0�����ȡ���пͻ��ļ�¼
        	users = personinfoDaoInter.getAllPersoninfo();
        }
		return users;
	}
	//����Ա�����û���ʵ���ֲ�ѯ�û���Ϣ
	@Override
	public List searchPersoninfo(Personinfo personinfo) {
		return personinfoDaoInter.searchPersoninfo(personinfo);
	}
	//����Ա��������Ӹ�����Ϣ��
	@Override
	public boolean add(Personinfo personinfo) {
		return personinfoDaoInter.add(personinfo);
	}

}
