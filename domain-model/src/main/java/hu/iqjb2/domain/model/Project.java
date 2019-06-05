/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.iqjb2.domain.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author IQJB
 */
@Entity
public class Project extends IqjbEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    private String name;
    @Temporal(TemporalType.DATE)
    private Date fromDate;
    @Temporal(TemporalType.DATE)
    private Date toDate;
    @OneToOne
    @JoinColumn(name = "owner_fk")
    private Employee owner;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "task_fk")
    private List<Task> tasks;

    public Project(String name, Date fromDate, Date toDate, Employee owner, List<Task> tasks) {
        this.name = name;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.owner = owner;
        this.tasks = tasks;
    }

    public Project(String name, Date fromDate, Date toDate, Employee owner) {
        this.name = name;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.owner = owner;
    }

    public Project() {
    }

    public Employee getOwner() {
        return owner;
    }

    public void setOwner(Employee owner) {
        this.owner = owner;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Project)) {
            return false;
        }
        Project other = (Project) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hu.iqjb2.domain.model.Project[ id=" + id + " ]";
    }

}
