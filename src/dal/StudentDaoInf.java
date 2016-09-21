package dal;

import java.util.List;
import entity.Student;
public interface StudentDaoInf {
        //���ѧ��
        public void save(Student s) throws Exception;
        //ɾ��ѧ��
        public void delete(String username) throws Exception;
    	//����ѧ����Ϣ
    	public void update(Student s) throws Exception;
    	//�޸�ѧ��
    	public Student findById(long id) throws Exception;
    	//����ѧ�Ų���ѧ��
    	public Student findByUsername(String username) throws Exception;
    	//��ѯ����ѧ��
    	public List<Student> findAll() throws Exception;
}
