package ch.aerztekasse.assignment.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class StoreControllerItTest {

         @Value(value="${local.server.port}")
        private int port;

        @Autowired
        private TestRestTemplate restTemplate;

        @Test
        public void getStoreReturnSuccess() throws Exception {
            ResponseEntity<String> storeEntity = restTemplate.getForEntity("/api/v1/stores/1", String.class);
            assertEquals(HttpStatus.OK, storeEntity.getStatusCode());
        }

        @Test
        public void getStoreReturnNotFound() throws Exception {
            ResponseEntity<String> storeEntity = restTemplate.getForEntity("/api/v1/stores/3", String.class);
            assertEquals(HttpStatus.NOT_FOUND, storeEntity.getStatusCode());
        }
}

