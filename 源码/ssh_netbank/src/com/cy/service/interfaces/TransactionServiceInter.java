package com.cy.service.interfaces;

import java.util.List;

import com.cy.entity.Account;
import com.cy.entity.Pager;
import com.cy.entity.TransactionLog;

public interface TransactionServiceInter {

	//���
	public boolean deposit(TransactionLog log);
	//ȡ��
	public boolean withdraw(TransactionLog log);
	//ת��
	public boolean transfer(TransactionLog log);
	
	//��ȡ���׼�¼
	public List getLogs(Account account, int page);
	//����˻��Ľ��׼�¼������������ʼ����ҳ��Pager����
	//��������perPagerRows��rowCount����
	public Pager getPagerOfLogs(Account account);
}
