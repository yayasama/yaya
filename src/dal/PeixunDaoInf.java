package dal;

import java.util.List;

import entity.Peixun;

public interface PeixunDaoInf {
    //�����ѵ��ʦ
    public void save(Peixun p) throws Exception;
    //ɾ����ѵ��ʦ
    public void delete(long id) throws Exception;
	//������ѵ��ʦ��Ϣ
	public void update(Peixun p) throws Exception;
	//����id����
	public Peixun findById(long id) throws Exception;
	//���ݱ�Ų�����ѵ��ʦ
	public Peixun findByUsername(String username) throws Exception;
	//����ȫ����ѵ��ʦ
	public List<Peixun> findAll() throws Exception;
}
