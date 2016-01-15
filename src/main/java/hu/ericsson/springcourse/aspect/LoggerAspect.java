package hu.ericsson.springcourse.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggerAspect
{
  
  
  @Pointcut("within(hu.ericsson.springcourse.service..*) && args(java.lang.Object)")
  public void serviceMethodCalls(){}
    
  
  @Before(value="serviceMethodCalls()", argNames = "jp")
  public void beforeServiceMethodCalled(JoinPoint jp) throws Throwable{
      
     System.out.println("Before service method called with name : "+jp.getSignature());
  }
  
  @After(value="serviceMethodCalls()", argNames = "jp")
  public void afterServiceMethodCalled(JoinPoint jp) throws Throwable{
      
     System.out.println("After service method called with name : "+jp.getSignature());
  }
  
  @AfterThrowing(pointcut = "serviceMethodCalls()", throwing = "ex", argNames = "jp,ex")
  public void afterTransactionalMethodsThrowsError(JoinPoint jp, Exception ex){
    System.out.println("Error while called service method with name: "+jp.getSignature() +" exception: "+ex);
  }
  
  @Around(value = "serviceMethodCalls()")
  public void aroundServiceMethods(ProceedingJoinPoint pjp) throws Throwable{
    
    System.out.println("In Around advice before service method call with name: "+pjp.getSignature());
    
    pjp.proceed();
    
    System.out.println("In Around advice after service method call with name: "+pjp.getSignature());

    
  }
   
}
