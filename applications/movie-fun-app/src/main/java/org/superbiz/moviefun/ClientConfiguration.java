package org.superbiz.moviefun;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestOperations;
import org.superbiz.moviefun.albumsapi.AlbumsClient;
import org.superbiz.moviefun.moviesapi.MoviesClient;

@Configuration
public class ClientConfiguration {

    @Value("${albums.url}") String albumsUrl;
    @Value("${movies.url}") String moviesUrl;

    @Bean
    public AlbumsClient albumsClient(RestOperations restOperations) {
        System.err.println("albumsUrl = " + albumsUrl);
        return new AlbumsClient(albumsUrl, restOperations);
    }

    @Bean
    public MoviesClient moviesClient(RestOperations restOperations) {
        System.err.println("moviesUrl = " + moviesUrl);
        return new MoviesClient(moviesUrl, restOperations);
    }
}
