package miu.edu.client;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "user-service", url = "https://")
public interface UserClient {
}
