package pl.btbw.logger;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Logged
@Interceptor
public class LoggedInterceptor {

    public LoggedInterceptor() {
    }

    @AroundInvoke
    public Object logMethodEntry(InvocationContext invocationContext) throws Exception {

        Object[] parameters = invocationContext.getParameters();
        String params = "";
        for (Object parameter : parameters) {
            params += " " + parameter.toString();
        }

        System.out.println(
                String.format(
                        "User invoke method %s with parameters %s",
                        invocationContext.getMethod().getName(),
                        params
                )
        );

        return invocationContext.proceed();
    }
}
