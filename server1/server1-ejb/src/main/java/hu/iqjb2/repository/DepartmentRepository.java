/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.iqjb2.repository;

import hu.iqjb2.domain.model.Department;
import java.util.List;

/**
 *
 * @author IQJB
 */
public interface DepartmentRepository {

    public void add(Department department);

    public List<Department> getAll();

}