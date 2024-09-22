package com.cy.service.interfaces;

import com.cy.entity.Account;
import com.cy.entity.Admin;
import com.cy.entity.Personinfo;
import com.cy.entity.Status;

public interface UserServiceInter {

	//��ȡ�˻�����
	public Account getAccount(String username);
	//��ȡ�˻�����
	public Account getAccount(int accountid);
	//�޸��˻�
	public Boolean modifyAccount(Account account);
	//��session�����»�ȡ����account
	public void reflush(Account account);
	
	//����username��ȡ����Ա����
	public Admin getAdmin(String username);
	
	//�����˻�
	public void enabled(int id);
	//�����˻�
	public void locking(int id);
	//ɾ���˻�
	public boolean delAccount(int id);
	//����Ա����
	public boolean addAccount(Account account);
	
}
