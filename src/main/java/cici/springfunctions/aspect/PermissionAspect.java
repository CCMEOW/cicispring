package cici.springfunctions.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @Description TODO
 */
@Aspect
@Component
public class PermissionAspect {

    @Pointcut("execution(* cici.springfunctions.services.OrderService.*(..))")
    private void order() {
    }

    @Before(value = "order()")
    public String beforeOrder() {
        System.out.println("before test");
        return "test";
    }
}
