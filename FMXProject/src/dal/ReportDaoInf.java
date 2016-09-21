package dal;

import java.util.List;

import entity.Report1;
import entity.Report2;
import entity.Report3;

public interface ReportDaoInf {
    //��Ӽ��ȱ���
    public void save(Report1 r1) throws Exception;
    //�����û�������
    public Report1 findByUsername(String username) throws Exception ;
   //��ѯ�������
	public List<Report1> findReport1() throws Exception;
	//����id����
	public Report1 findById(long id) throws Exception ;
	//����guidetea����
    public List<Report1> findByGuidetea(String tname) throws Exception;
	//������˽��
	public void updateResult1(Report1 r1) throws Exception;
	
	
	 //������ڱ���
    public void save(Report2 r2) throws Exception;
   //��ѯ�������
	public List<Report2> findReport2() throws Exception;
	//����id����
	public Report2 findById2(long id) throws Exception ;
	//�����û�������
    public Report2 findByUsername2(String username) throws Exception ;
  //����guidetea����
    public List<Report2> findByGuidetea2(String tname) throws Exception;
	//������˽��
	public void updateResult2(Report2 r2) throws Exception;
	
	
	 //��ӽ��ⱨ��
    public void save(Report3 r3) throws Exception;
   //��ѯ�������
	public List<Report3> findReport3() throws Exception;
	//����id����
	public Report3 findById3(long id) throws Exception ;
	//�����û�������
    public Report3 findByUsername3(String username) throws Exception ;
    //����guidetea����
    public List<Report3> findByGuidetea3(String tname) throws Exception;
	//������˽��
	public void updateResult3(Report3 r3) throws Exception;
	
	
}
