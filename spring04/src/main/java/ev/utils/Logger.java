package ev.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("logger")
@Aspect
public class Logger {

    @Autowired
    private ConnectionUtils connectionUtils;

    @Pointcut("execution(* ev.service.impl.*.*(..))")
    private void pt1() {
    }

    //@Before("pt1()")
    public void beginTransaction() {
        try {
            connectionUtils.getThreadConnection().setAutoCommit(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //@AfterReturning("pt1()")
    public void commit() {
        try {
            connectionUtils.getThreadConnection().commit();
            System.out.println("1");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //@AfterThrowing("pt1()")
    public void rollback() {
        try {
            connectionUtils.getThreadConnection().rollback();
            System.out.println("2");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //@After("pt1()")
    public void release() {
        try {
            connectionUtils.getThreadConnection().close();//还回连接池中
            connectionUtils.removeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Around("pt1()")
    public Object aroundAdvice(ProceedingJoinPoint pjp) {
        Object rtvalue = null;
        try {
            //1.获取参数
            Object[] args = pjp.getArgs();
            //2.开启事务
            this.beginTransaction();
            //3.执行方法
            rtvalue = pjp.proceed(args);
            //4.提交事务
            this.commit();
            //5.返回结果
            return rtvalue;
        } catch (Throwable t) {
            this.rollback();
            throw new RuntimeException(t);
        } finally {
            this.release();
        }

    }
}
