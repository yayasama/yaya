package dal;

import java.sql.SQLException;
import java.util.List;

import entity.Program;

public interface ApplyDaoInf {
    //添加实践项目
    public void save(Program p) throws Exception;
    //学生申报项目
    public void saveApply(Program p) throws Exception;
   //查询所有项目进度
	public List<Program> findAll() throws Exception;
	//根据tname查找所有项目
	public List<Program> findAll2(String tname) throws Exception;
	//查找管理员审核通过的项目
	public List<Program> findPassPro() throws Exception;
	//根据id找学生
	public Program findById(long id) throws Exception;
	//更新
	public void updateResult(Program p) throws Exception;
	//更新管理员审核
	public void updateResultadm(Program p) throws Exception;
	//更改学生写的内容
	public void updateContent(Program p) throws Exception;
	//修改发布状态
	public void updateProstate(Program p) throws Exception;
	//根据学号查找学生
	public Program findByUsername(String username) throws Exception;
	//根据学生姓名和状态查询项目
	public Program findByCondition(String username) throws Exception;
	//更新finish状态
	public void SetFinish(Program p) throws SQLException;
	//更新完成时间
	public void SetFinishtime(Program p) throws SQLException;
	//教师更改需求
	public void updateNeed(Program p) throws Exception;
	//更新教师申请时间
	public void SetApplytime(Program p) throws SQLException;
}
