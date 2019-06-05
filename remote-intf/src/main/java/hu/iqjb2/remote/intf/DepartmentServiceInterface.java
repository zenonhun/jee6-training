/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.iqjb2.remote.intf;

import hu.iqjb2.domain.model.Department;
import java.util.List;

/**
 *
 * @author IQJB
 */
public interface DepartmentServiceInterface {

    void add(Department department);

    List<Department> getAll();
}
