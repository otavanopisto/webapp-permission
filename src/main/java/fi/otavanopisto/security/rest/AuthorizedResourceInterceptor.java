package fi.otavanopisto.security.rest;

import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

import fi.otavanopisto.security.AuthorizationException;

@AuthorizedResource
@Interceptor
public class AuthorizedResourceInterceptor {

  public AuthorizedResourceInterceptor() {
  }

  @AroundInvoke
  public Object aroundInvoke(InvocationContext ic) throws Exception {
    Object result = null;
    try {
      System.out.println("@AuthorizedResource " + ic.getMethod().getName());
      result = ic.proceed();
    } catch (Exception ex) {
      if (ex instanceof AuthorizationException ||
          ex.getCause() instanceof AuthorizationException) {
        result = Response.status(Status.FORBIDDEN).entity("401 Forbidden").build();
      } else {
        throw ex;
      }
    }
    
    return result;
  }
}
