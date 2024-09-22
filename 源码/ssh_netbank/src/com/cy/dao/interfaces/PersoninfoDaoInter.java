package com.cy.dao.interfaces;

import java.util.List;

import com.cy.entity.Personinfo;
import com.cy.entity.Status;

public interface PersoninfoDaoInter {

	//�޸ĸ�����Ϣ
	public void modifyPersoninfo(Personinfo personinfo);
	
	//����Ա��ȡ�����û�����Ϣ
	public List getAllPersoninfo();
	//����Ա�����˻�״̬��ѯ�û���Ϣ������idΪ����Աҳ�泬���������idֵ
	public List searchPersoninfo(int id);
	//����Ա�����û���ʵ���ֲ�ѯ�û���Ϣ
	public List searchPersoninfo(Personinfo personinfo);
	
	//����Ա������������Ϣ��
	public boolean add(Personinfo personinfo);
	
}
