package com.hr.samplexample.dao;

import java.util.List;

import com.hr.samplexample.model.Employee;

/**
 * @描述：
 * 
 * @author ruihe
 * @time 2016年6月22日 上午10:42:37
 */
public interface EmployeeDao {
	Employee findById(int id);

	void saveEmployee(Employee employee);

	void deleteEmployeeBySsn(String ssn);

	List<Employee> findAllEmployees();

	Employee findEmployeeBySsn(String ssn);
}
