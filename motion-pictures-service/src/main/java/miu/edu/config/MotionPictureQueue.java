package miu.edu.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MotionPictureQueue {
    @Bean
    public Queue movieQueue() {
        return new Queue("movieQueue", true);
    }

    @Bean
    public Queue tvShowQueue() {
        return new Queue("tvShowQueue", true);
    }

    @Bean
    public DirectExchange motionPictureExchange(){
        return new DirectExchange("motionPictureDirectExchange");
    }

    @Bean
    Binding movieQueueBinding(Queue movieQueue, DirectExchange motionPictureExchange) {
        return BindingBuilder.bind(movieQueue).to(motionPictureExchange).with("MOVIE");
    }

    @Bean
    Binding tvShowQueueBinding(Queue tvShowQueue, DirectExchange motionPictureExchange) {
        return BindingBuilder.bind(tvShowQueue).to(motionPictureExchange).with("TVSHOW");
    }
}
