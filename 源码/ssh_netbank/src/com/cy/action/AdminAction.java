package com.cy.action;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.cy.entity.Account;
import com.cy.entity.Admin;
import com.cy.entity.Personinfo;
import com.cy.entity.Status;
import com.cy.service.interfaces.PersoninfoServiceInter;
import com.cy.service.interfaces.UserServiceInter;
import com.opensymphony.xwork2.ActionSupport;

public class AdminAction extends ActionSupport implements RequestAware,SessionAware {

	//ʹ��Resourceע��ע��UserServiceInter��PersoninfoServiceInter���ԣ�ʡȥset����
	@Resource private UserServiceInter userServiceInter;
	@Resource private PersoninfoServiceInter personinfoServiceInter; 
	Map<String, Object> request;
	Map<String, Object> session;
	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	//����Admin�������ڷ�װ����Ա��¼��ҳ��
	private Admin admin;
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	//����status����listUsers()����ʹ��
	private Status status;
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	//����personinfo����search()����ʹ��
	private Personinfo personinfo;
	public Personinfo getPersoninfo() {
		return personinfo;
	}
	public void setPersoninfo(Personinfo personinfo) {
		this.personinfo = personinfo;
	}
	
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	private Account account;
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	//�Ե�¼��ҳ�������֤���û����������Ƿ���ȷ
	public void validateLogin() {
		Admin a = userServiceInter.getAdmin(admin.getUsername());
		if(a == null) {
			this.addFieldError("username", "�û��������ڣ�");
		} else {
			if(!admin.getPassword().equals(a.getPassword())) {
				this.addFieldError("password", "���벻��ȷ��");
			}
		}
		admin = a;
	}
	//��¼
	public String login() {
		if(admin != null) {
			session.put("admin", admin);
			return "success";
		}
		return "login";
	}
	
	//����Ա��ѯ�˻�
	public String listUsers() {
		//System.out.println("���"+status.getId());
		List users = personinfoServiceInter.searchPersoninfo(status);
		request.put("users", users);
		return "users";
	}
	
	//������ʵ������ѯ�˻�
	public String search() {
		List users = personinfoServiceInter.searchPersoninfo(personinfo);
		request.put("users", users);
		return "users";
	}
	
	//�����˻�
	public String enabled() {
		userServiceInter.enabled(id);
		return "list";
	}
	//�����˻�
	public String locking() {
		userServiceInter.locking(id);
		return "list";
	}
	//ɾ���˻�
	public String del() {
		userServiceInter.delAccount(id);
		return "list";
	}
	
	//�Կ���ҳ�������֤����֤�û����Ƿ���ڡ�һ�����ֻ֤��ӵ��һ���˻�
	public void validateOpenAccount() {
		if(userServiceInter.getAccount(account.getUsername()) != null ) {
			request.put("message", "�û����Ѵ��ڣ�");
		}
		//
		
	}
	//����
	public String openAccount() {
		//��account��������˻�
		userServiceInter.addAccount(account);
		//��personinfo������Ӹ�����Ϣ
		account = userServiceInter.getAccount(account.getUsername());
		personinfo.setAccount(account);
		personinfoServiceInter.add(personinfo);
		request.put("message", "�����ɹ���");
		return "message";
	}
	
}
