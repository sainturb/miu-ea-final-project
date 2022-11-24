package miu.edu;

import org.modelmapper.ModelMapper;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EnableRabbit
public class TvshowApplication {

    public static void main(String[] args) {
        SpringApplication.run(TvshowApplication.class, args);
    }

    @Bean
    public ModelMapper returnModelMapperBean() {
        return new ModelMapper();
    }
}