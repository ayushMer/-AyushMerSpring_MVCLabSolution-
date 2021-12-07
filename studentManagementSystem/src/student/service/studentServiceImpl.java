package student.service;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import student.entity.student;

@Service
public class studentServiceImpl implements StudentService{

	private SessionFactory sessionFactory;
	private Session session;
	
	public studentServiceImpl()
	{
		super();
	}
	@Autowired
	public studentServiceImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
		try {
			session=sessionFactory.getCurrentSession();
		}
		catch(HibernateException ex)
		{
			session=sessionFactory.openSession();
		}
		
	}
	@Override
	public List<student> findAll() {
		// TODO Auto-generated method stub
		Transaction tx=session.beginTransaction();
		List<student> students=session.createQuery("from student").list();
		tx.commit();
		return students;
	}

	@Transactional
	@Override
	public student findById(int studentId) {
		// TODO Auto-generated method stub
		Transaction tx=session.beginTransaction();
		student stud=session.get(student.class, studentId);
		tx.commit();
		return stud;

	}

	@Override
	public void saveStudentInfo(student theStudent) {
		// TODO Auto-generated method stub
		Transaction tx=session.beginTransaction();
		session.saveOrUpdate(theStudent);
		tx.commit();
	}

	@Override
	public void deleteByStudentId(int studentId) {
		// TODO Auto-generated method stub
		Transaction tx=session.beginTransaction();
		student stud=session.get(student.class, studentId);
		if(stud==null)
			session.delete(stud);
		tx.commit();
	}
	
	@Transactional
	@Override
	public List<student> searchBy(String department) {
		// TODO Auto-generated method stub
		Transaction tx=session.beginTransaction();
		String query="";
		if(department.length()!=0)
		{
			query="from student where department like '%"+department+"%'";
		}
		List<student> students=session.createQuery(query).list();
		tx.commit();
		return students;
	}


}
