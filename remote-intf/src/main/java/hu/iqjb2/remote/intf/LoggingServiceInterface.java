/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.iqjb2.remote.intf;

/**
 *
 * @author IQJB
 */
public interface LoggingServiceInterface {

    public void save(String functionName, Long execTime, String callerPrincipal);
}
