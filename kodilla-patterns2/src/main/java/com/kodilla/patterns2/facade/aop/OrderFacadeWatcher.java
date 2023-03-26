package com.kodilla.patterns2.facade.aop;

import com.kodilla.patterns2.facade.api.OrderDto;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class OrderFacadeWatcher {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderFacadeWatcher.class);

    @Around("execution(* com.kodilla.patterns2.facade.api.OrderFacade.processOrder(..))" +
            "&& args(order,userId)")
    public Object logEvent(final ProceedingJoinPoint proceedingJoinPoint, OrderDto order, Long userId)
            throws Throwable {
        Object result;
        try {
            Object target = proceedingJoinPoint.getTarget();
            LOGGER.info("STARTED processing order invoked by Class: " + target.getClass().getName()
                    + " with: " + order.getItems().size() + " items "
                    + " for UserId: " + userId);
            result = proceedingJoinPoint.proceed();
            LOGGER.info("COMPLETED processing order");
        } catch (Throwable throwable) {
            LOGGER.error(throwable.getMessage());
            throw throwable;
        }
        return result;
    }
}