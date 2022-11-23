package miu.edu;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class RatingApplication {

    public static void main(String[] args) {
        SpringApplication.run(RatingApplication.class, args);
    }

    @Bean
    public ModelMapper getModelMapper() {
        return new ModelMapper();
    }

    // @Bean
    // public ObjectMapper getObjectMapper() {
    // ObjectMapper mapper = new ObjectMapper();
    // mapper.registerModule(new JavaTimeModule());
    // return mapper;
    // }
    //
    // @Bean
    // public RequestContextListener requestContextListener() {
    // return new RequestContextListener();
    // }
}
