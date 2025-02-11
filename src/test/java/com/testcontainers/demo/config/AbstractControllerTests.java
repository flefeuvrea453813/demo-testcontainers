package com.testcontainers.demo.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.testcontainers.demo.DemoTestContainersApplication;
import org.junit.jupiter.api.AfterEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = DemoTestContainersApplication.class)
@AutoConfigureMockMvc
public class AbstractControllerTests extends DemoIntegrationConfigurationTests {

    @Autowired
    protected MockMvc mockMvc;

    @Autowired
    protected ObjectMapper objectMapper;
}
