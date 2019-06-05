/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.iqjb2.domain.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 *
 * @author IQJB
 */
@Entity
public class Task extends IqjbEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    private String name;

    @OneToOne
    @JoinColumn(name = "particpant_fk")
    private Employee paticipant;

    public Task(String name, Employee paticipant) {
        this.name = name;
        this.paticipant = paticipant;
    }

    public Task() {
    }

    public Employee getPaticipant() {
        return paticipant;
    }

    public void setPaticipant(Employee paticipant) {
        this.paticipant = paticipant;
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
        if (!(object instanceof Task)) {
            return false;
        }
        Task other = (Task) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hu.iqjb2.domain.model.Task[ id=" + id + " ]";
    }

}
