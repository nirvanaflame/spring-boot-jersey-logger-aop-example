package com.nf.thestartap.spring.aspect;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class LoggingService {

    @Autowired
    LoggerContext loggerContext;

    public List<LoggerInfo> getLoggers(String filter) {
        return loggerContext.getLoggerList().stream()
                .filter(logger -> filterLog(logger, filter))
                .map(logger -> new LoggerInfo(logger.getName(), getLevel(logger)))
                .toList();
    }
    
    @TransactionLog(serviceName = "change-log-level", args = {"loggerContext", "loggerInfo"})
    public void setLogLevel(LoggerInfo loggerInfo) {
        log.info("setLogLevel:: args: logger={}, level={}", loggerInfo.logger(), loggerInfo.level());

        Logger logger = loggerContext.getLogger(loggerInfo.logger());
        log.info("setLogLevel:: before update - logger={}, level={}", logger.getName(), getLevel(logger));
        logger.setLevel(Level.toLevel(loggerInfo.level()));
        log.info("setLogLevel:: after update - logger={}, level={}", logger.getName(), getLevel(logger));
    }

    
    private static boolean filterLog(Logger logger, String filter) {
        return filter.isBlank() || logger.getName().contains(filter);
    }

    private static String getLevel(Logger logger) {
        Level level = logger.getLevel();
        return level != null ? level.toString() : null;
    }

}
