package br.com.rpdesenvolve.spring_metrics_monitoring.adapter.configuration;

import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.stereotype.Component;

@Component
public class HealthIndicator extends AbstractHealthIndicator {

    @Override
    protected void doHealthCheck(Health.Builder builder) {
        builder
                .up()
                .withDetail("status", "Service is healthy");
    }
}
