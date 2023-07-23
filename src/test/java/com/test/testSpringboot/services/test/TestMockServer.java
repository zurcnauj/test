package com.test.testSpringboot.services.test;

import com.google.gson.Gson;
import com.test.testSpringboot.__config.TestServiceTestConfig;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockserver.integration.ClientAndServer;
import org.mockserver.model.HttpRequest;
import org.mockserver.model.HttpResponse;
import org.mockserver.model.MediaType;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class TestMockServer {


    @BeforeAll
    public static void beforeAll(){
        ClientAndServer mockServer = ClientAndServer.startClientAndServer(9091);

        Gson gson = new Gson();
        ObjetoA objetoA = new ObjetoA();

        mockServer.when(HttpRequest
            .request("/simple")
            .withMethod("GET")
            .withPathParameter("param_key_00","param_value_01")
            .withHeader("header_key_00","header_value_00")
            .withBody( gson.toJson(objetoA))
            .withContentType(MediaType.APPLICATION_JSON)
        )
        .respond(
            HttpResponse.response()
            .withStatusCode(700)
            .withBody(gson.toJson(objetoA))
            .withContentType(MediaType.APPLICATION_JSON)
            .withHeader("header_key_00","header_value_00")
        );
    }
    @Test
    public void test(){
        assertTrue(true);
    }
}
