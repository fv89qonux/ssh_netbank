package com.cy.dao.interfaces;

import com.cy.entity.Account;
import com.cy.entity.Admin;
import com.cy.entity.Status;

public interface UserDaoInter {

	//��ȡ�˻�����
	public Account getAccount(String username);
	//��ȡ�˻�����
	public Account getAccount(int accountid);
	//�޸��˻�
	public boolean updateAccount(Account account);
	//��session�����»�ȡ����account
	public void reflush(Account account);
	
	//����username��ȡ����Ա����
	public Admin getAdmin(String username);
	
	//�����˻�״̬���ƻ�ȡ�˻�״̬����
	public Status getStatus(String name);
	//�����˻�״̬id��ȡ�˻�״̬����	
	public Status getStatus(int id);
	
	//����Աɾ���˻�
	public boolean delAccount(Account account);
	//����
	public boolean addAccount(Account account);
}
