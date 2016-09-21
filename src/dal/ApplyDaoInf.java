package dal;

import java.sql.SQLException;
import java.util.List;

import entity.Program;

public interface ApplyDaoInf {
    //���ʵ����Ŀ
    public void save(Program p) throws Exception;
    //ѧ���걨��Ŀ
    public void saveApply(Program p) throws Exception;
   //��ѯ������Ŀ����
	public List<Program> findAll() throws Exception;
	//����tname����������Ŀ
	public List<Program> findAll2(String tname) throws Exception;
	//���ҹ���Ա���ͨ������Ŀ
	public List<Program> findPassPro() throws Exception;
	//����id��ѧ��
	public Program findById(long id) throws Exception;
	//����
	public void updateResult(Program p) throws Exception;
	//���¹���Ա���
	public void updateResultadm(Program p) throws Exception;
	//����ѧ��д������
	public void updateContent(Program p) throws Exception;
	//�޸ķ���״̬
	public void updateProstate(Program p) throws Exception;
	//����ѧ�Ų���ѧ��
	public Program findByUsername(String username) throws Exception;
	//����ѧ��������״̬��ѯ��Ŀ
	public Program findByCondition(String username) throws Exception;
	//����finish״̬
	public void SetFinish(Program p) throws SQLException;
	//�������ʱ��
	public void SetFinishtime(Program p) throws SQLException;
	//��ʦ��������
	public void updateNeed(Program p) throws Exception;
	//���½�ʦ����ʱ��
	public void SetApplytime(Program p) throws SQLException;
}
