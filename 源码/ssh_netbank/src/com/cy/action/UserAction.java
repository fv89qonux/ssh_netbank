package com.cy.action;

import java.util.Map;

import javax.annotation.Resource;
import javax.swing.JOptionPane;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.cy.entity.*;
import com.cy.service.interfaces.UserServiceInter;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport implements RequestAware,SessionAware{

	//ͨ��@Resourceע��ע��userServiceInter������ʡ��set����
	@Resource private UserServiceInter userServiceInter;
	Map<String, Object> request;
	Map<String, Object> session;
	private Account account;
	private Personinfo personinfo;
	private String oldpwd;
	private String newpwd;
	
	public String getOldpwd() {
		return oldpwd;
	}
	public void setOldpwd(String oldpwd) {
		this.oldpwd = oldpwd;
	}
	public String getNewpwd() {
		return newpwd;
	}
	public void setNewpwd(String newpwd) {
		this.newpwd = newpwd;
	}
	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public Personinfo getPersoninfo() {
		return personinfo;
	}
	public void setPersoninfo(Personinfo personinfo) {
		this.personinfo = personinfo;
	}
	
	//ʹ��validate*���������е�¼(login)��У�顣 �����û�����ȡ�û�����
	public void validateLogin() {
		Account a = userServiceInter.getAccount(account.getUsername());	
		System.out.println(account.getUsername());
	    if(a == null) {
	    	this.addFieldError("username", "�û��������ڣ�");
	    } else {
	    	if(!account.getPassword().equals(a.getPassword())) {
	    		this.addFieldError("password", "�������");
	    	}
	    }
	    account = a;
	}
	//ִ��ҳ���¼���󣬲����û������л�ȡ������Ϣ���󣬲����浽session��
	public String login() {
		personinfo = (Personinfo)account.getPersoninfos().iterator().next();
		session.put("user", account);
		session.put("personinfo", personinfo);
		return "success";
	}
	
	//ʹ��validate*�����������޸�����(changepwd)��У��
	public void validateChangepwd() {
		account = (Account) session.get("user");
		if(!oldpwd.equals(account.getPassword())) {
			this.addFieldError("pwderror", "���벻��ȷ��");
		}
//		if(!pwd.getNewpwd().equals(pwd.getConfirmpwd())) {
//			this.addFieldError("confirmpwd", "�������벻һ�£�");
//		}
		
	}
	
	//ִ���޸���������
	public String changepwd() {
		//System.out.println("���룺"+oldpwd);
		account = (Account) session.get("user");
		//System.out.println("�û���"+account.getPassword());
		account.setPassword(newpwd);
		if(userServiceInter.modifyAccount(account)) {
			session.put("user", account);
			request.put("message", "�����޸ĳɹ���");
			return "message";
		} else {
			request.put("message", "�����޸�ʧ�ܣ�");
			return "message";
		}
	}
	
	//ע��
	public String logout() {
        	session.remove("user");
    		session.remove("personinfo");
    		return "input";  
	}
	
}
