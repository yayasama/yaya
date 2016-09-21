package dal;

import java.util.List;

import entity.Peixun;

public interface PeixunDaoInf {
    //添加培训教师
    public void save(Peixun p) throws Exception;
    //删除培训教师
    public void delete(long id) throws Exception;
	//更新培训教师信息
	public void update(Peixun p) throws Exception;
	//根据id查找
	public Peixun findById(long id) throws Exception;
	//根据编号查找培训教师
	public Peixun findByUsername(String username) throws Exception;
	//查找全部培训教师
	public List<Peixun> findAll() throws Exception;
}
