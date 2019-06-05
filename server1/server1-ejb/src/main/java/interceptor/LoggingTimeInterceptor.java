/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interceptor;

import hu.iqjb2.remote.intf.LoggingServiceInterface;
import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;
import javax.naming.InitialContext;

/**
 *
 * @author IQJB
 */
public class LoggingTimeInterceptor {

    @Resource
    private SessionContext sessionContext;

    @AroundInvoke
    public Object measureExecTime(InvocationContext ctx) throws Exception {
        String functionName = ctx.getTarget().getClass().getName() + ":" + ctx.getMethod().getName();
        String callerPrincipal = sessionContext.getCallerPrincipal().getName();

        Long elapsedTime = System.currentTimeMillis();
        Object obj = ctx.proceed();
        elapsedTime = System.currentTimeMillis() - elapsedTime;

        LoggingServiceInterface lsi = (LoggingServiceInterface) new InitialContext().lookup("hu.iqjb2.remote.intf.LoggingServiceInterface");
        lsi.save(functionName, elapsedTime, callerPrincipal);

        return obj;
    }
}
