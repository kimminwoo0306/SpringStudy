package com.sist.spring3;
// ���������� ��� => Ŭ���� ����(���丮 ����, �̱��� ����) => �޸� ������ �����ϴ�, ������ �ܼ��ϴ�, ǥ��ȭ(��� �����ڰ� ������ �������� ���)
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext app=new ApplicationContext();
		AModel a=(AModel)app.getBean("Amodel");
		a.display();
		System.out.println("a="+a);
		AModel a1=(AModel)app.getBean("Amodel");
		a.display();
		System.out.println("a1="+a1);
		BModel b=(BModel)app.getBean("Bmodel");
		b.display();
		CModel c=(CModel)app.getBean("Cmodel");
		c.display();
	}

}
