package com.ecommerce.order.spike.rabbitmq.spring;

import com.ecommerce.order.common.event.DomainEvent;
import com.ecommerce.order.common.logging.AutoNamingLoggerFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class DomainEventReceiver {
    private static final Logger logger = AutoNamingLoggerFactory.getLogger();

    private NamedParameterJdbcTemplate jdbcTemplate;

    public DomainEventReceiver(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Transactional
    public Object aa(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();

        if (args[0] instanceof DomainEvent) {
            logger.info("======" + args[0].getClass().getName());
        }
        // do business success
        // do event table success
        // throw exception
//        throw new RuntimeException();
        Object proceed = joinPoint.proceed();
        if (1 > 0) {
            throw new RuntimeException("-----");
        }
        return proceed;
    }
}