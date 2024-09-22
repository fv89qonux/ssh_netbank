package com.cy.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.cy.dao.interfaces.TransactionDaoInter;
import com.cy.dao.interfaces.UserDaoInter;
import com.cy.entity.Account;
import com.cy.entity.Pager;
import com.cy.entity.TransactionLog;
import com.cy.entity.TransactionType;
import com.cy.service.interfaces.TransactionServiceInter;

@Transactional
public class TransactionServiceImpl implements TransactionServiceInter {

	private TransactionDaoInter transactionDaoInter;
	private UserDaoInter userDaoInter;
	public void setTransactionDaoInter(TransactionDaoInter transactionDaoInter) {
		this.transactionDaoInter = transactionDaoInter;
	}
	public void setUserDaoInter(UserDaoInter userDaoInter) {
		this.userDaoInter = userDaoInter;
	}
	//���
	@Override
	public boolean deposit(TransactionLog log) {
		//�ӽ��׶���log�л�ȡ�˻�����
        Account self = log.getAccount();
        //���˻�����������  
        //ʹ��log.getTr_money()���Ի�ȡ��������Ĵ���ԭ���Ƿ�װTransaction����ʵ��action���ձ�����
        self.setBalance(log.getTr_money()+log.getAccount().getBalance());
        //�����˻����޸����
        userDaoInter.updateAccount(self);
        //���ݽ������ͻ�ȡ���׶���
        TransactionType type = transactionDaoInter.getTranactionType("���");
        log.setTransactionType(type);
        log.setOtherid(self.getAccountid());
        log.setDatetime(log.getDatetime());
		//���ýӿ��е�addlog��������transaction_log����ӽ��׼�¼
        return transactionDaoInter.addLog(log);
	}
	//ȡ��
	@Override
	public boolean withdraw(TransactionLog log) {
		//�ӽ��׶���log�л�ȡ�˻�����
		Account self = log.getAccount();
		 //���˻�����������  
        //ʹ��log.getTr_money()���Ի�ȡ��������Ĵ���ԭ���Ƿ�װTransaction����ʵ��action���ձ�����
		self.setBalance(log.getAccount().getBalance()-log.getTr_money());
        //�����˻����޸����
		userDaoInter.updateAccount(self);
        //���ݽ������ͻ�ȡ���׶���
		TransactionType type = transactionDaoInter.getTranactionType("ȡ��");
		log.setTransactionType(type);
		log.setOtherid(self.getAccountid());
		log.setDatetime(log.getDatetime());
		//���ýӿ��е�addlog��������transaction_log����ӽ��׼�¼
		return transactionDaoInter.addLog(log);
	}
	//ת��
	@Override
	public boolean transfer(TransactionLog log) {
		//��ȡ�Է��˻�����
		Account other = userDaoInter.getAccount(log.getOtherid());
        //��ȡ�Լ��˻�����		
		Account self = log.getAccount();
		if(other!=null) {
			//�޸ĶԷ��˻����
			other.setBalance(other.getBalance()+log.getTr_money());
			//�޸��Լ��˻����
			self.setBalance(self.getBalance()-log.getTr_money());
			//���¶Է����Լ��˻������
			userDaoInter.updateAccount(other);
			userDaoInter.updateAccount(self);
			//���ݽ������ͻ�ȡ���׶���
			TransactionType type = transactionDaoInter.getTranactionType("ת��");
			log.setTransactionType(type);
			log.setOtherid(log.getOtherid());
			log.setDatetime(log.getDatetime());
			//���transaction_log����ӽ��׼�¼
			return transactionDaoInter.addLog(log);
		}
		return false;
	}
	
	@Override
	//��ȡ���׼�¼
	public List getLogs(Account account, int page) {
		return transactionDaoInter.getLogs(account, page);
	}
	@Override
	//����˻��Ľ��׼�¼������������ʼ����ҳ��Pager����
	//��������perPagerRows��rowCount����
	public Pager getPagerOfLogs(Account account) {
		//�ӱ�Transaction_Log�л�ȡ���˻���صĽ��׼�¼��
		int count = transactionDaoInter.getCountOfLogs(account);
		//
		Pager pager = new Pager();
		//����pager������PerPageRows���ԣ���ʾÿҳ��ʾ10����¼
		pager.setPerPageRows(5);
		//����rowCount���ԣ���ʾ��¼����
		pager.setRowCount(count);
		return pager;
	}
}
