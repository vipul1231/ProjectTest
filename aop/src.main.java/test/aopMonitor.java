package test;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.wdtablesystems.common.logging.Logger;
import com.wdtablesystems.common.logging.LoggerImpl;

@Component
@Aspect
public class aopMonitor {
	
	Logger logger = new LoggerImpl(aopMonitor.class);
	
	public aopMonitor()
	{
		System.out.println("AOP monitor created");
	}
	
	@Pointcut("execution(* * test.App.setName(..))")
	private void doBeforeTask()
	{
		System.out.println("Inside");
	}
	
	@Before("execution(* * test.App.setName(..))")
	public void beforeAdvice(){
		System.out.println("Before Advice is called");
	}
	
	@After("doBeforeTask()")
	public void afterAdvice(){
		System.out.println("After Advice.");
	}
	
	@AfterReturning(pointcut="doBeforeTask()", returning="retVal")
	public void afterReturningAdvice(Object val)
	{
		System.out.println("Returning: "+val);
	}
	
	@AfterThrowing(pointcut="doBeforeTask()", throwing="ex")
	public void afterThrowingAdvice(Exception e)
	{
		System.out.println("There has been a exception.");
	}
}
