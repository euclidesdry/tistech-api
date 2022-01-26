package api.tistech.config.profiles;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

@Configuration
@Profile({"prod"})
@PropertySource(value = {"file:/u01/environments/integration-api/${spring.profiles.active}.properties"})
public class DefaultConfiguration {
}
