package com.udemy.ems.service.impl;

import com.udemy.ems.dto.EmployeeDto;
import com.udemy.ems.entity.Department;
import com.udemy.ems.entity.Employee;
import com.udemy.ems.exception.ResourceNotFoundException;
import com.udemy.ems.mapper.EmployeeMapper;
import com.udemy.ems.repository.DepartmentRepository;
import com.udemy.ems.repository.EmployeeRepository;
import com.udemy.ems.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    private DepartmentRepository departmentRepository;
    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {

        Employee employee= EmployeeMapper.mapToEmployee(employeeDto);
        Department department=departmentRepository.findById(employeeDto.getDepartmentId())
                .orElseThrow(()-> new ResourceNotFoundException("Department with given id not found:"+employeeDto.getDepartmentId()));

        employee.setDepartment(department);
        Employee savedEmployee =employeeRepository.save(employee);

        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {

        Employee employee=employeeRepository.findById(employeeId)
                .orElseThrow(()-> new ResourceNotFoundException("Employee with given id doesn't exists :"+employeeId));

        return  EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {

        List<Employee>employees=employeeRepository.findAll();
        return employees.stream().map((employee) -> EmployeeMapper.mapToEmployeeDto(employee))
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployee) {

        Employee employee=employeeRepository.findById(employeeId).orElseThrow(
                ()-> new ResourceNotFoundException("Employee with given id doesn't exists "+employeeId)
        );

        employee.setFirstName(updatedEmployee.getFirstName());
        employee.setLastName(updatedEmployee.getLastName());
        employee.setEmail(updatedEmployee.getEmail());

        Department department=departmentRepository.findById(updatedEmployee.getDepartmentId())
                .orElseThrow(()-> new ResourceNotFoundException("Department with given id not found:"+updatedEmployee.getDepartmentId()));

        employee.setDepartment(department);

        Employee updatedEmployeeObj=employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(updatedEmployeeObj);
    }

    @Override
    public void deleteEmployee(Long employeeId) {
        Employee employee=employeeRepository.findById(employeeId).orElseThrow(
                ()-> new ResourceNotFoundException("Employee with given id doesn't exists "+employeeId)
        );

        employeeRepository.deleteById(employeeId);
    }
}
