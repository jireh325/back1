package divdev.sn.todo_list.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import divdev.sn.todo_list.infrastructure.adapter.in.soap.TodoSoapService;
import jakarta.annotation.PreDestroy;
import jakarta.xml.ws.Endpoint;

@Configuration
public class TodoSoapConfig {

    private Endpoint endpoint; // Stocker l'instance de Endpoint

    @Bean
    public Endpoint endpoint(TodoSoapService todoSoapService) {
        String url = "http://localhost:8081/ws/todo";
        this.endpoint = Endpoint.publish(url, todoSoapService); // Stocker l'instance
        return this.endpoint;
    }

    @PreDestroy
    public void stopEndpoint() {
        if (this.endpoint != null) {
            this.endpoint.stop(); // Arrêter correctement le service SOAP
        }
    }
}
