package com.hr.samplexample.service;

import java.util.List;

import com.hr.samplexample.model.Employee;

/**
 * @描述：添加服务层
 * @author ruihe
 * @time   2016年6月21日 下午5:35:29
 */
public interface EmployeeService {
	Employee findById(int id);  
    
    void saveEmployee(Employee employee);  
       
    void updateEmployee(Employee employee);  
       
    void deleteEmployeeBySsn(String ssn);  
   
    List<Employee> findAllEmployees();   
       
    Employee findEmployeeBySsn(String ssn);  
   
    boolean isEmployeeSsnUnique(Integer id, String ssn);  
}
