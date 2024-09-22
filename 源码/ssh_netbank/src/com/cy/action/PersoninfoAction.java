package com.cy.action;

import java.util.Map;
import java.util.regex.Pattern;

import javax.annotation.Resource;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.cy.entity.Personinfo;
import com.cy.service.interfaces.PersoninfoServiceInter;
import com.opensymphony.xwork2.ActionSupport;

public class PersoninfoAction extends ActionSupport implements RequestAware,SessionAware {

	@Resource private PersoninfoServiceInter personinfoServiceInter;
	private Personinfo personinfo;
	Map<String, Object> request;
	Map<String, Object> session;
	public Personinfo getPersoninfo() {
		return personinfo;
	}
	public void setPersoninfo(Personinfo personinfo) {
		this.personinfo = personinfo;
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
	
	//�޸ĸ�����Ϣ
	public String modify() {
		//��session�л�ȡ����ĸ�����Ϣ����
		//System.out.println("sfa");
		Personinfo per = (Personinfo) session.get("personinfo");
		per.setAddress(personinfo.getAddress());
		per.setAge(personinfo.getAge());
		per.setCardid(personinfo.getCardid());
		per.setRealname(personinfo.getRealname());
		per.setSex(personinfo.getSex());
		per.setTelephone(personinfo.getTelephone());
		//��������Ϣ�������ݿ�
		if(personinfoServiceInter.modifyPersoninfo(per)) {
			//���³ɹ������浽session
			session.put("personinfo", per);
			request.put("message", "�޸ĳɹ���");
			return "message";
		}
		request.put("message", "�޸�ʧ�ܣ�");
		return "message";
	}
	
	//�޸ĸ�����Ϣҳ��У��
	public void validateModify() {
		if(!(personinfo.getAge()>18 && personinfo.getAge()<100)) {
			addFieldError("personinfo.age", "���䲻����");
		}
		if(!(Pattern.compile("^\\d{17}(\\d|x)$")
			.matcher(personinfo.getCardid().toString()).matches())) {
			addFieldError("personinfo.cardID", "���֤��ʽ����ȷ��");
		}
		if(!(Pattern.compile("^(?:1[358]\\d{9}|\\d{3,4}-\\d{8,9})$")
				.matcher(personinfo.getTelephone()).matches())) {
			addFieldError("personinfo.telephone", "�绰�Ÿ�ʽ����ȷ��");
		}
	}
	
}
