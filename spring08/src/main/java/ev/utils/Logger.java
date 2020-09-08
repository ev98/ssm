package ev.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

//记录日志的工具类，它里面提供了公共的代码
@Component("logger")
@Aspect //表示当前类是一个切面类
public class Logger {

    @Pointcut("execution(* ev.service.impl.*.*(..))")
    private void pti(){}

    //前置通知
    @Before("pti()")
    public void beforePrintLog(){
        System.out.println("前置通知Logger类中的beforePrintLog方法开始记录日志了");
    }

    //后置通知
    @AfterReturning("pti()")
    public void afterReturningPrintLog(){
        System.out.println("后置通知Logger类中的afterReturningPrintLog方法开始记录日志了");
    }

    //异常通知
    @AfterThrowing("pti()")
    public void afterThrowingPrintLog(){
        System.out.println("异常通知Logger类中的afterThrowingPrintLog方法开始记录日志了");
    }

    //最终通知
    @After("pti()")
    public void afterPrintLog(){
        System.out.println("最终通知Logger类中的afterPrintLog方法开始记录日志了");
    }


   /* public Object aroundPrintLog(ProceedingJoinPoint pjp){
        Object rtValue = null;
        try {
            Object[] args = pjp.getArgs(); //得到方法执行所需的参数

            System.out.println("环绕通知Logger类中的aroundPrintLog方法开始记录日志了。。。前置");
            rtValue = pjp.proceed(args); //切入点方法
            System.out.println("环绕通知Logger类中的aroundPrintLog方法开始记录日志了。。。后置");

            return rtValue;
        } catch (Throwable throwable) {
            System.out.println("环绕通知Logger类中的aroundPrintLog方法开始记录日志了。。。异常");
            throw new RuntimeException(throwable);
        } finally {
            System.out.println("环绕通知Logger类中的aroundPrintLog方法开始记录日志了。。。最终");
        }
    }*/
}
