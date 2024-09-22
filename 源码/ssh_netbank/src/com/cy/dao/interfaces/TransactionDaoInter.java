package com.cy.dao.interfaces;

import java.util.List;

import com.cy.entity.Account;
import com.cy.entity.TransactionLog;
import com.cy.entity.TransactionType;

public interface TransactionDaoInter {

	//���ݽ����������ƻ�ȡ�������Ͷ���
	public TransactionType getTranactionType(String name);
	//��Transaction_log������ӽ��׼�¼
	public boolean addLog(TransactionLog log);
	//���ݴ���ʾҳҳ����˻������ȡ���׼�¼
	public List getLogs(Account account, int page);
	//��ȡ���׼�¼��
	public Integer getCountOfLogs(Account account);
}
