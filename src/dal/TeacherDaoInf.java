package dal;

import java.util.List;
import entity.Teacher;

public interface TeacherDaoInf {
    //��ӽ�ʦ
    public void save(Teacher t) throws Exception;
    //ɾ����ʦ
    public void delete(String  username) throws Exception;
	//���½�ʦ��Ϣ
	public void update(Teacher t) throws Exception;
	//�޸Ľ�ʦ
	public Teacher findById(long id) throws Exception;
	//����ѧ�Ų��ҽ�ʦ
	public Teacher findByUsername(String username) throws Exception;
	//��ѯ���н�ʦ
	public List<Teacher> findAll() throws Exception;
}
