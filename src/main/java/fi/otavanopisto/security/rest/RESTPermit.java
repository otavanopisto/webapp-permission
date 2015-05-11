package fi.otavanopisto.security.rest;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.enterprise.util.Nonbinding;
import javax.interceptor.InterceptorBinding;

import fi.otavanopisto.security.Permit;

/**
 * Marks method as permission restricted method. Defines Permissions that allow access to method.
 * 
 * @author antti.viljakainen
 */
@InterceptorBinding
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface RESTPermit {
  /**
   * Permissions to check authorization against. 
   * 
   * @return permissions
   */
  @Nonbinding 
  String[] value() default {};
  
  /**
   * Style of check, default OR, optionally AND (all defined Permissions must apply)
   */
  Permit.Style style() default Permit.Style.OR;
  
  /**
   * How method permit checking is implemented. 
   *  - Method checks should be checked on method call
   *  - Inline checks should be performed by inline code
   *  - Unsecured are open methods  
   */
  Handling handling() default Handling.METHOD;

  enum Handling {
    METHOD,
    INLINE,
    UNSECURED
  }
}
