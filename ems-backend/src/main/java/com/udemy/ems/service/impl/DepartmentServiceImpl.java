package com.udemy.ems.service.impl;

import com.udemy.ems.dto.DepartmentDto;
import com.udemy.ems.entity.Department;
import com.udemy.ems.exception.ResourceNotFoundException;
import com.udemy.ems.mapper.DepartmentMapper;
import com.udemy.ems.repository.DepartmentRepository;
import com.udemy.ems.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;
    @Override
    public DepartmentDto createDepartment(DepartmentDto departmentDto) {
        Department department= DepartmentMapper.mapToDepartment(departmentDto);
        Department savedDepartment=departmentRepository.save(department);
        return DepartmentMapper.mapToDepartmentDto(savedDepartment);
    }

    @Override
    public DepartmentDto getDepartmentById(Long departmentId) {
        Department department=departmentRepository.findById(departmentId).orElseThrow(
                ()-> new ResourceNotFoundException("Department with given id does not exists "+departmentId)
        );
        return DepartmentMapper.mapToDepartmentDto(department);
    }

    @Override
    public List<DepartmentDto> getAllDepartments() {

        List<Department>departments=departmentRepository.findAll();
        return departments.stream().map((department)->DepartmentMapper.mapToDepartmentDto(department))
                .collect(Collectors.toList());
    }

    @Override
    public DepartmentDto updateDepartment(Long departmentId, DepartmentDto updatedDepartment) {
        Department department=departmentRepository.findById(departmentId).orElseThrow(
                ()->new ResourceNotFoundException("Department with given id not found "+departmentId)
        );

        department.setDepartmentName(updatedDepartment.getDepartmentName());
        department.setDepartmentDescription(updatedDepartment.getDepartmentDescription());
        Department savedDepartment=departmentRepository.save(department);
        return DepartmentMapper.mapToDepartmentDto(savedDepartment);
    }

    @Override
    public void deleteDepartment(Long departmentId) {
        Department department=departmentRepository.findById(departmentId).orElseThrow(
                ()->new ResourceNotFoundException("Department with given id not found "+departmentId)
        );
        departmentRepository.deleteById(departmentId);
    }


}
