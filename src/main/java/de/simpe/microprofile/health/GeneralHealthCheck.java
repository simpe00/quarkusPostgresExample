package de.simpe.microprofile.health;

import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Liveness;

import javax.enterprise.context.ApplicationScoped;

@Liveness
@ApplicationScoped
public class GeneralHealthCheck implements HealthCheck {

    @Override
    public HealthCheckResponse call(){
        return HealthCheckResponse.up("General health check");
    }
}
