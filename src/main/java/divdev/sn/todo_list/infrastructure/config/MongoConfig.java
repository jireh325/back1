package divdev.sn.todo_list.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

import java.util.Optional;

@Configuration
public class MongoConfig {
    
    @Bean
    public AuditorAware<String> auditorProvider() {
        // You can provide the current user's ID here if needed
        return () -> Optional.of("system");
    }
}