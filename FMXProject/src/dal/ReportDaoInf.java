package dal;

import java.util.List;

import entity.Report1;
import entity.Report2;
import entity.Report3;

public interface ReportDaoInf {
    //添加季度报告
    public void save(Report1 r1) throws Exception;
    //根据用户名查找
    public Report1 findByUsername(String username) throws Exception ;
   //查询报告进度
	public List<Report1> findReport1() throws Exception;
	//根据id查找
	public Report1 findById(long id) throws Exception ;
	//根据guidetea查找
    public List<Report1> findByGuidetea(String tname) throws Exception;
	//更新审核结果
	public void updateResult1(Report1 r1) throws Exception;
	
	
	 //添加中期报告
    public void save(Report2 r2) throws Exception;
   //查询报告进度
	public List<Report2> findReport2() throws Exception;
	//根据id查找
	public Report2 findById2(long id) throws Exception ;
	//根据用户名查找
    public Report2 findByUsername2(String username) throws Exception ;
  //根据guidetea查找
    public List<Report2> findByGuidetea2(String tname) throws Exception;
	//更新审核结果
	public void updateResult2(Report2 r2) throws Exception;
	
	
	 //添加结题报告
    public void save(Report3 r3) throws Exception;
   //查询报告进度
	public List<Report3> findReport3() throws Exception;
	//根据id查找
	public Report3 findById3(long id) throws Exception ;
	//根据用户名查找
    public Report3 findByUsername3(String username) throws Exception ;
    //根据guidetea查找
    public List<Report3> findByGuidetea3(String tname) throws Exception;
	//更新审核结果
	public void updateResult3(Report3 r3) throws Exception;
	
	
}
