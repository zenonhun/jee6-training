/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.iqjb2;

import hu.iqjb2.domain.model.IqjbLog;
import hu.iqjb2.remote.intf.LoggingServiceInterface;
import hu.iqjb2.repository.LoggingRepository;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Remote;
import javax.ejb.Stateless;

/**
 *
 * @author IQJB
 */
@Stateless
@LocalBean
@Remote(LoggingServiceInterface.class)
public class LoggingService implements LoggingServiceInterface {

    @EJB
    private LoggingRepository loggingRepository;

    @Override
    public void save(String functionName, Long execTime, String callerPrincipal) {
        loggingRepository.add(new IqjbLog(functionName, execTime, callerPrincipal));
    }

    public List<IqjbLog> listLog() {
        return loggingRepository.getLogs();
    }
}
