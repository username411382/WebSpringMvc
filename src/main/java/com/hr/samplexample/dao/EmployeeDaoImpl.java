package com.hr.samplexample.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.hr.samplexample.model.Employee;

/**
 * @描述：
 * 
 * @author ruihe
 * @time 2016年6月22日 上午10:44:21
 */
@Repository("employeeDao")
public class EmployeeDaoImpl extends AbstractDao<Integer, Employee> implements EmployeeDao {

	@Override
	public Employee findById(int id) {
		// TODO Auto-generated method stub
		return getByKey(id);
	}

	@Override
	public void saveEmployee(Employee employee) {
		persist(employee);
	}

	@Override
	public void deleteEmployeeBySsn(String ssn) {
		Query query = getSession().createSQLQuery("delete from Employee where ssn = :ssn");
		query.setString("ssn", ssn);
		query.executeUpdate();

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> findAllEmployees() {
		Criteria criteria = createEntityCriteria();
		return (List<Employee>) criteria.list();
	}

	@Override
	public Employee findEmployeeBySsn(String ssn) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("ssn", ssn));
		return (Employee) criteria.uniqueResult();
	}

}
