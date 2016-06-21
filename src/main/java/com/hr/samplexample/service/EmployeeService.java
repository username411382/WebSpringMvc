package com.hr.samplexample.service;

import java.util.List;

import com.hr.samplexample.model.Employee;

/**
 * @��������ӷ����
 * @author ruihe
 * @time   2016��6��21�� ����5:35:29
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
