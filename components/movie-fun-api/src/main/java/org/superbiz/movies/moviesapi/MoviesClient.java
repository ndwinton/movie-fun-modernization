/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.superbiz.movies.moviesapi;


import feign.Headers;
import feign.Param;
import feign.RequestLine;

import java.util.List;


public interface MoviesClient {

    @RequestLine("POST /")
    @Headers("Content-type: application/json")
    public void addMovie(MovieInfo movie);

    @RequestLine("DELETE /{id}")
    public void deleteMovieId(@Param("id") Long id);

    @RequestLine("GET /?start={start}&pageSize={pageSize}")
    public List<MovieInfo> findAll(@Param("start") int firstResult, @Param("pageSize") int maxResults);

    @RequestLine("GET /count")
    int countAll();

    @RequestLine("GET /count?field={field}&key={key}")
    int count(@Param("field") String field, @Param("key") String searchTerm);

    @RequestLine("GET /?field={field}&key={key}&start={start}&pageSize={pageSize}")
    List<MovieInfo> findRange(@Param("field") String field,
                              @Param("key") String searchTerm,
                              @Param("start") int firstResult,
                              @Param("pageSize") int maxResults);

    @RequestLine("GET /")
    List<MovieInfo> getMovies();

}
