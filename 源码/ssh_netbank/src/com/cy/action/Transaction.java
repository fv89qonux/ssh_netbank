package com.cy.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.cy.entity.Account;
import com.cy.entity.Pager;
import com.cy.entity.TransactionLog;
import com.cy.service.interfaces.TransactionServiceInter;
import com.cy.service.interfaces.UserServiceInter;
import com.opensymphony.xwork2.ActionSupport;

public class Transaction extends ActionSupport implements RequestAware, SessionAware {

	//�������ԣ����set������ʵ������ע��
	private UserServiceInter userServiceInter;
	private TransactionServiceInter transactionServiceInter;
	private Map<String, Object> request;
	private Map<String, Object> session;
	public UserServiceInter getUserServiceInter() {
		return userServiceInter;
	}
	public void setUserServiceInter(UserServiceInter userServiceInter) {
		this.userServiceInter = userServiceInter;
	}
	public TransactionServiceInter getTransactionServiceInter() {
		return transactionServiceInter;
	}
	public void setTransactionServiceInter(TransactionServiceInter transactionServiceInter) {
		this.transactionServiceInter = transactionServiceInter;
	}
	public Map<String, Object> getRequest() {
		return request;
	}
	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}
	public Map<String, Object> getSession() {
		return session;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	private Account account;
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	//����TransactionLog�������get��set�������û���װҳ�������
	private TransactionLog log;
	public TransactionLog getLog() {
		return log;
	}
	public void setLog(TransactionLog log) {
		this.log = log;
	}
	
	//�����ҳʵ����
	private Pager pager;
	
	public Pager getPager() {
		return pager;
	}
	public void setPager(Pager pager) {
		this.pager = pager;
	}
	//���
	public String deposit() {
		//����isEnable�����ж��˻��Ƿ񶳽�
		if(isEnable()) {
			//System.out.println(log.getTr_money());
			//�����׶���log�й������˻��������Ը�ֵ
			log.setAccount(account);
			session.put("user", account);
			//����ҵ�񷽷��������˻���account�е����
			//���ڽ�����Ϣ��transaction_log������Ӽ�¼
			return isSuccess(transactionServiceInter.deposit(log));
		}
		return "message";
	}
	
	//��ȡ��ҳ�������֤���ж��˻�����Ƿ����
	public void validateWithdraw() {
		account = (Account) session.get("user");
		//System.out.println(log.getTr_money());
		//System.out.println(account.getBalance());
		if(log.getTr_money()>account.getBalance()) {
			this.addFieldError("log.tr_money", "�����˻����㣡");
		}
	}
	
	//ȡ��
	public String withdraw() {
		//����isEnable�����ж��˻��Ƿ񶳽�
		if(isEnable()) {
			//�����׶���log�й������˻��������Ը�ֵ
			log.setAccount(account);
			session.put("user", account);
			//����ҵ�񷽷��������˻���account�е����
			//���ڽ�����Ϣ��transaction_log������Ӽ�¼
			return isSuccess(transactionServiceInter.withdraw(log));
		}
		return "message";
	}
	
	//��ת��ҳ���������֤
	public void validateTransfer() {
		account = (Account) session.get("user");
		if(log.getOtherid().intValue() == account.getAccountid().intValue()) {
			this.addFieldError("log.otherid", "������ת���Լ���");
		}
		if(userServiceInter.getAccount(log.getOtherid()) == null) {
			this.addFieldError("log.otherid", "���˻������ڣ�");
		}
		if(log.getTr_money()>account.getBalance()) {
			this.addFieldError("log.tr_money", "�����˻����㣡");
		}
	}
	//ת��
	public String transfer() {
		//�ж��˻��Ƿ񶳽�
		if(isEnable()) {
			//�����׶���log�й������˻��������Ը�ֵ
			log.setAccount(account);
			session.put("user", account);
			//����ҵ�񷽷��������˻���account�е����
			//���ڽ�����Ϣ��transaction_log������Ӽ�¼
			return isSuccess(transactionServiceInter.transfer(log));
		}
		return "message";
	}
	
	//�ж��˻��Ƿ񶳽�
	public boolean isEnable() {
		//userServiceInter.reflush(account);
		account = (Account) session.get("user");
		//System.out.println(account.getUsername());
		if(account.getStatus().getName().equals("����")) {
			request.put("message", "��Ǹ�����˻��ѱ����ᣬ�޷�������ز�����<br>");
			return false;
		}
		return true;
	}
	//
	public String isSuccess(boolean flag) {
		if(flag) {
			request.put("message", "�����ɹ���");
			return "message";
		}
		request.put("message", "����ʧ�ܣ�<a href='javascript:history.go(-1)'>����</a>");
		return "message";
	}
	
	//��ʾ���׼�¼
	public String list() {
		account = (Account) session.get("user");
		//��ȡ����ʾҳҳ��
		int curPage = pager.getCurPage();
		//���ݴ���ʾҳҳ����˻������ȡ���׼�¼
		List<TransactionLog> logs = transactionServiceInter.getLogs(account, curPage);
		//����˻��Ľ��׼�¼������������ʼ��pager����
		//��������perPageRows��rowCount����
		pager = transactionServiceInter.getPagerOfLogs(account);
		//����pager�����д���ʾҳҳ��
		pager.setCurPage(curPage);
		request.put("logs", logs);
		return "success";
	}
	
}
