package com.cy.service.impl;

import com.cy.dao.interfaces.UserDaoInter;
import com.cy.entity.Account;
import com.cy.entity.Admin;
import com.cy.entity.Status;
import com.cy.service.interfaces.UserServiceInter;

public class UserServiceImpl implements UserServiceInter {

	UserDaoInter userDaoInter;
	public UserDaoInter getUserDaoInter() {
		return userDaoInter;
	}
	public void setUserDaoInter(UserDaoInter userDaoInter) {
		this.userDaoInter = userDaoInter;
	}
	@Override
	public Account getAccount(String username) {
		return userDaoInter.getAccount(username);
	}
	//�޸��˻���Ϣ
	@Override
	public Boolean modifyAccount(Account account) {
		return userDaoInter.updateAccount(account);
	}
	//��session�����»�ȡ����account
	@Override
    public void reflush(Account account) {
	    userDaoInter.reflush(account);		
    }
	//��ȡ�˻�����
	@Override
	public Account getAccount(int accountid) {
		return userDaoInter.getAccount(accountid);
	}
	//��ȡ����Ա����
	@Override
	public Admin getAdmin(String username) {
		return userDaoInter.getAdmin(username);
	}
	
	//�����˻�
	@Override
	public void enabled(int id) {
        Account account = userDaoInter.getAccount(id);
        //��ȡ���޸��˻������״̬���ԣ�����Ϊ����
        Status status = userDaoInter.getStatus("����");
        account.setStatus(status);
		userDaoInter.updateAccount(account);
	}
	//�����˻�
	@Override
	public void locking(int id) {
		Account account = userDaoInter.getAccount(id);
        //��ȡ���޸��˻������״̬���ԣ�����Ϊ����
        Status status = userDaoInter.getStatus("����");
        account.setStatus(status);
		userDaoInter.updateAccount(account);
		
	}
	//����Աɾ���˻�
	@Override
	public boolean delAccount(int id) {
        Account account = userDaoInter.getAccount(id);
		return userDaoInter.delAccount(account);
	}
	//����Ա����
	@Override
	public boolean addAccount(Account account) {
		Status status = userDaoInter.getStatus("����");
		account.setStatus(status);
		return userDaoInter.addAccount(account);
	}

}
