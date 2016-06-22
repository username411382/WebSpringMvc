package com.hr.samplexample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hr.samplexample.dao.EmployeeDao;
import com.hr.samplexample.model.Employee;

/**
 * 上面最有意思的地方就是 @Transactional注解了。它将在每个方法调用的时候开启事务。
 * 在每个方法结束的时候提交事务（或者在方法执行失败并产生错误的时候回滚他）。
 * 请注意，由于transaction注解是基于方法领域的。在方法里面我们使用DAO对象。
 *  dao方法将在同一个事务当中执行。
 * @author ruihe
 *
 */
@Service("employeeService")
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao dao;

	@Override
	public Employee findById(int id) {
		return dao.findById(id);
	}

	@Override
	public void saveEmployee(Employee employee) {
		dao.saveEmployee(employee);
	}

	/*
	 * Since the method is running with Transaction, No need to call hibernate
	 * update explicitly. Just fetch the entity from db and update it with
	 * proper values within transaction. It will be updated in db once
	 * transaction ends.
	 */
	@Override
	public void updateEmployee(Employee employee) {
		Employee entity = dao.findById(employee.getId());
		if (entity != null) {
			entity.setName(employee.getName());
			entity.setJoiningDate(employee.getJoiningDate());
			entity.setSalary(employee.getSalary());
			entity.setSsn(employee.getSsn());
		}

	}

	@Override
	public void deleteEmployeeBySsn(String ssn) {
		dao.deleteEmployeeBySsn(ssn);
	}

	@Override
	public List<Employee> findAllEmployees() {
		return dao.findAllEmployees();
	}

	@Override
	public Employee findEmployeeBySsn(String ssn) {
		// TODO Auto-generated method stub
		return dao.findEmployeeBySsn(ssn);
	}

	@Override
	public boolean isEmployeeSsnUnique(Integer id, String ssn) {
		Employee employee = findEmployeeBySsn(ssn);
		return (employee == null || ((id != null) && (employee.getId() == id)));
	}

}
