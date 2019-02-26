package org.superbiz.movies.moviesapi;

import feign.Feign;
import feign.jackson.JacksonDecoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClientConfiguration {

    @Value("${movies.url}") String moviesUrl;
    @Autowired
    MoviesClient moviesClient;

    @Bean
    public MoviesClient moviesClient() {
        return Feign.builder()
                .decoder(new JacksonDecoder())
                .target(MoviesClient.class, moviesUrl);
    }

    @Bean MovieServlet movieServlet() {
        return new MovieServlet(moviesClient);
    }
}
