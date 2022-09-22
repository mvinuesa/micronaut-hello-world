package com.mvinuesa;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.runtime.server.EmbeddedServer;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

@MicronautTest
public class HelloControllerSpec {

    @Inject
    EmbeddedServer server; //

    @Inject
    @Client("/")
    HttpClient client; //

    @Test
    void testHelloWorldResponse() {
        String response = client.toBlocking() //
            .retrieve(HttpRequest.GET("/hello"));
        assertEquals("Hello World", response); //
    }
}