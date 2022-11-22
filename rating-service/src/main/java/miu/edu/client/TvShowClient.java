package miu.edu.client;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "tvsgow-service", url = "https://")
public interface TvShowClient {
}
