/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.iqjb2.domain.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author IQJB
 */
@Entity
public class IqjbLog extends IqjbEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    private String functionName;
    private Long execTime;
    private String callerPrincipal;
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;

    public IqjbLog() {
    }

    public IqjbLog(String functionName, Long execTime, String callerPrincipal) {
        this.functionName = functionName;
        this.execTime = execTime;
        this.callerPrincipal = callerPrincipal;
        this.created = new Date();
    }

    public String getFunctionName() {
        return functionName;
    }

    public void setFunctionName(String functionName) {
        this.functionName = functionName;
    }

    public Long getExecTime() {
        return execTime;
    }

    public void setExecTime(Long execTime) {
        this.execTime = execTime;
    }

    public String getCallerPrincipal() {
        return callerPrincipal;
    }

    public void setCallerPrincipal(String callerPrincipal) {
        this.callerPrincipal = callerPrincipal;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
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
        if (!(object instanceof IqjbLog)) {
            return false;
        }
        IqjbLog other = (IqjbLog) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hu.iqjb2.domain.model.IqjbLog[ id=" + id + " ]";
    }

}
