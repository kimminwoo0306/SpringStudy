package com.sist.spring3;
// Ŭ���� ������(�����̳�) => ���������� �̹� ���۵�
import java.util.*;
public class ApplicationContext {
	private Map clsMap=new HashMap();
	public ApplicationContext()
	{
		clsMap.put("Amodel",new AModel());
		clsMap.put("Bmodel",new BModel());
		clsMap.put("Cmodel",new CModel());
	}
	public Object getBean(String key)
	{
		return clsMap.get(key);
	}
}
