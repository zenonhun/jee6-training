/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package message;

import hu.iqjb2.domain.model.Department;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author IQJB
 */
public class GetAllDepartmentsResponse {

    private List<Department> departmentList;

    public GetAllDepartmentsResponse() {
        this.departmentList = new ArrayList<>();
    }

    public List<Department> getDepartmentList() {
        return departmentList;
    }

    public void setDepartmentList(List<Department> departmentList) {
        this.departmentList = departmentList;
    }

}
