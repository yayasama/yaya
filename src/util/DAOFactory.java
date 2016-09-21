package util;
//dao������Ϊ�������ṩdaoʵ�����ʵ��
public class DAOFactory {
	//�����ȡʵ���ķ���
	public static Object getInstance(String type){
		Object obj = null;
		//���ݽӿ����ҵ���Ӧ������
		String className = ConfigUtil.getValue(type);
		//ʹ�÷��� ����ʵ��
		try {
			obj = Class.forName(className).newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}
	
	/*
	public static void main(String[] args) {
		getInstance("StudentDaoInf");
	}
	*/
	public static void main(String[] args) {
		getInstance("PeixunDaoInf");
	}
}
