package com.cy.service.interfaces;

import java.util.List;

import com.cy.entity.Personinfo;
import com.cy.entity.Status;

public interface PersoninfoServiceInter {

	//�޸ĸ�����Ϣ
	public boolean modifyPersoninfo(Personinfo personinfo);
	
	
    //����Ա�����˻�״̬��ѯ�û���Ϣ
	public List searchPersoninfo(Status status);
	//����Ա�����û���ʵ���ֲ�ѯ�û���Ϣ
	public List searchPersoninfo(Personinfo personinfo);
	
	//����Ա������������Ϣ��
	public boolean add(Personinfo personinfo);
	
}
