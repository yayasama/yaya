package dal;

import java.util.List;
import entity.Teacher;

public interface TeacherDaoInf {
    //添加教师
    public void save(Teacher t) throws Exception;
    //删除教师
    public void delete(String  username) throws Exception;
	//更新教师信息
	public void update(Teacher t) throws Exception;
	//修改教师
	public Teacher findById(long id) throws Exception;
	//根据学号查找教师
	public Teacher findByUsername(String username) throws Exception;
	//查询所有教师
	public List<Teacher> findAll() throws Exception;
}
