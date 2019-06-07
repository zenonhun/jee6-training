/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.iqjb2.beans;

import hu.iqjb2.domain.model.Department;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;
import message.AddDepartmentRequest;
import message.GetAllDepartmentsRequest;
import servicefacade.DepartmentServiceFacade;

/**
 *
 * @author IQJB
 */
@Named(value = "departmentController")
@ViewScoped
public class DepartmentController implements Serializable {

    @EJB
    private DepartmentServiceFacade departmentServiceFacade;

    private String newDepartmentName;
    private String result = "";

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getNewDepartmentName() {
        return newDepartmentName;
    }

    public void setNewDepartmentName(String newDepartmentName) {
        this.newDepartmentName = newDepartmentName;
    }

    /**
     * Creates a new instance of DepartmentController
     */
    public DepartmentController() {
    }

    public String addDepartment() {
        departmentServiceFacade.addDepartment(new AddDepartmentRequest(this.newDepartmentName));
        this.result = "Department is added";
        return "departmentList.jsf";
    }

    public List<Department> listDepartments() {
        return departmentServiceFacade.getAllDepartmentss(new GetAllDepartmentsRequest()).getDepartmentList();
    }

}
