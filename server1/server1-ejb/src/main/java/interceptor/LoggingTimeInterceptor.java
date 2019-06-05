/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interceptor;

import hu.iqjb2.remote.intf.LoggingServiceInterface;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

/**
 *
 * @author IQJB
 */
public class LoggingTimeInterceptor {

    @Resource
    private SessionContext sessionContext;

    @EJB(lookup = "hu.iqjb2.remote.intf.LoggingServiceInterface")
    private LoggingServiceInterface loggingServiceInterface;

    @AroundInvoke
    public Object measureExecTime(InvocationContext ctx) throws Exception {
        String functionName = ctx.getTarget().getClass().getName() + ":" + ctx.getMethod().getName();
        String callerPrincipal = sessionContext.getCallerPrincipal().getName();

        Long elapsedTime = System.currentTimeMillis();
        Object obj = ctx.proceed();
        elapsedTime = System.currentTimeMillis() - elapsedTime;

        loggingServiceInterface.save(functionName, elapsedTime, callerPrincipal);

        return obj;
    }
}
