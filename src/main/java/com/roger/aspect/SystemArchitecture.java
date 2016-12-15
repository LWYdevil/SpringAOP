package com.roger.aspect;

import com.roger.annotation.CalculateService;
import com.roger.util.CalculateUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

import com.roger.annotation.PrintTime;


@Aspect
public class SystemArchitecture {
	
	/**
	 * A join point is in the web layer if the method is defined
	 * in a type in the com.xyz.someapp.web package or any sub-package
	 * under that.
	 */
	@Pointcut(value="within(com.roger.web..*)")
	public void inWebLayer() {}
	
	
	/**
	 * A join point is in the service layer if the method is defined
	 * in a type in the com.xyz.someapp.service package or any sub-package
	 * under that.
	 */
	@Pointcut("within(com.roger.service..*)")
	public void inServiceLayer() {}
	
	/**
	 * A join point is in the data access layer if the method is defined
	 * in a type in the com.xyz.someapp.dao package or any sub-package
	 * under that.
	 */
	@Pointcut("within(com.roger.dao..*)")
	public void inDataAccessLayer() {}
	
	/**
	 * A business service is the execution of any method defined on a service
	 * interface. This definition assumes that interfaces are placed in the
	 * "service" package, and that implementation types are in sub-packages.
	 *
	 * If you group service interfaces by functional area (for example,
	 * in packages com.xyz.someapp.abc.service and com.xyz.def.service) then
	 * the pointcut expression "execution(* com.xyz.someapp..service.*.*(..))"
	 * could be used instead.
	 *
	 * Alternatively, you can write the expression using the 'bean'
	 * PCD, like so "bean(*Service)". (This assumes that you have
	 * named your Spring service beans in a consistent fashion.)
	 */
	@Pointcut("execution(* com.roger.service.*.*(..))")
	public void businessService() {}
	
	/**
	 * A data access operation is the execution of any method defined on a
	 * dao interface. This definition assumes that interfaces are placed in the
	 * "dao" package, and that implementation types are in sub-packages.
	 */
	@Pointcut("execution(* com.roger.dao.*.*(..))")
	public void dataAccessOperation() {}
	
	/**
	 * any join point (method execution only in Spring AOP) where 
	 * the executing method has an @Transactional annotation:
	 */
	@Pointcut("@annotation(org.springframework.transaction.annotation.Transactional)")
	public void annotation() {}
	
	@Pointcut("execution(* com.roger.service..*.setName(..))")
	public void setNameService() {}

//	@Before("execution(* com.roger.service.AnimalService.getName(..))")
//	public void doBeforeAnimalServiceGetName() {
//		System.out.println("do before AnimalService getName().");
//	}

	/*@Before("annotation() && "+"args(name,age)")
	public void doBeforeAnimalServiceAnnotation(String name,int age) {
		System.out.println("do before AnimalService Annotation name = "+name+"  age = "+age);
	}*/

    @After("execution(* com.roger.service..*.setName(..)) && "+"args(name,age)")
    public void doAfterAnimalServiceAnnotation(String name,int age) {
        System.out.println("do before AnimalService Annotation name = "+name+"  age = "+age);
    }
	
	@Around("execution(* com.roger.controller..*.*(..)) && @annotation(printTime)")
     public Object printControllerTime(ProceedingJoinPoint pjp,PrintTime printTime){
        Object retVal = null;
        Long start = System.currentTimeMillis();
        try {
            retVal = pjp.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        System.out.println(printTime.serviceName()+"###"+printTime.methodName()+"###"+(System.currentTimeMillis()-start)+"###");
        return retVal;
    }

    @Around("execution(* com.roger.service..*.*(..)) && @annotation(calculateService)")
    public Object printServiceTime(ProceedingJoinPoint pjp,CalculateService calculateService){
        Object retVal = null;
        Long start = System.currentTimeMillis();
        try {
            retVal = pjp.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        Long time = System.currentTimeMillis()-start;

        CalculateUtils.callService(pjp.getSignature().toString(),time);
        return retVal;
    }

}
