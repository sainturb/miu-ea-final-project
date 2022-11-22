package miu.edu.client;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "movie-service", url = "https://")
public interface MovieClient {
}
