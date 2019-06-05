/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicefacade;

import hu.iqjb2.DepartmentService;
import hu.iqjb2.domain.model.Department;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import message.AddDepartmentRequest;
import message.AddDepartmentResponse;
import message.GetAllDepartmentsRequest;
import message.GetAllDepartmentsResponse;

/**
 *
 * @author IQJB
 */
@Stateless
@LocalBean
public class DepartmentServiceFacade {

    @EJB
    private DepartmentService departmentService;

    public AddDepartmentResponse addDepartment(AddDepartmentRequest request) {
        AddDepartmentResponse response = new AddDepartmentResponse();
        Department department = new Department(request.getDepartmentName());
        departmentService.add(department);
        response.setResult("Department is added.");
        return response;
    }

    public GetAllDepartmentsResponse getAllDepartmentss(GetAllDepartmentsRequest request) {
        GetAllDepartmentsResponse response = new GetAllDepartmentsResponse();
        response.getDepartmentList().addAll(departmentService.getAll());
        return response;
    }

}
