package miu.edu.config;

import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import lombok.RequiredArgsConstructor;
import miu.edu.dto.RatingDTO;

@Configuration
@RequiredArgsConstructor
public class RatingListenerConfig {

    private final KafkaProperties kafkaProperties;

    @Bean
    public ConsumerFactory<String, RatingDTO> ratingConsumerFactory() {
        return new DefaultKafkaConsumerFactory<>(
                kafkaProperties.buildConsumerProperties(), new StringDeserializer(),
                new JsonDeserializer<>(RatingDTO.class));
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, RatingDTO> kafkaRatingListenerStringContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, RatingDTO> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(ratingConsumerFactory());
        return factory;
    }

}
