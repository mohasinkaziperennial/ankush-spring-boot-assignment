package com.perennialsys.aop;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {
    Logger logger = LoggerFactory.getLogger(MyAspect.class);

    @Pointcut(value = "execution(* com.perennialsys.*.*.*(..) )")
    public void myPointCut() {

    }

    @Around("myPointCut()")
    public Object applicationLogger(ProceedingJoinPoint pjp) throws Throwable {
        ObjectMapper objectMapper = new ObjectMapper();
        String methodName = pjp.getSignature().getName();
        String className = pjp.getTarget().getClass().toString();
        Object[] array = pjp.getArgs();
        logger.info("method invoked" + className + ":" + methodName + "()" + "arguments:" + objectMapper.writeValueAsString(array));
        Object object = pjp.proceed();
        try {
            logger.info(className + ":" + methodName + "()" + "Response:" + objectMapper.writeValueAsString(object));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return object;

    }

}
