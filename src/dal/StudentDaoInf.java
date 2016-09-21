package dal;

import java.util.List;
import entity.Student;
public interface StudentDaoInf {
        //添加学生
        public void save(Student s) throws Exception;
        //删除学生
        public void delete(String username) throws Exception;
    	//更新学生信息
    	public void update(Student s) throws Exception;
    	//修改学生
    	public Student findById(long id) throws Exception;
    	//根据学号查找学生
    	public Student findByUsername(String username) throws Exception;
    	//查询所有学生
    	public List<Student> findAll() throws Exception;
}
