package com.api.WebClient.service;

import com.api.WebClient.dto.PostDto;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PostService {
    private final WebClient webClient;

    public PostService(WebClient webClient) {
        this.webClient = webClient;
    }

    public Mono<PostDto> save(PostDto postDto){
        return webClient.post().uri("/posts").bodyValue(postDto).retrieve().bodyToMono(PostDto.class);
    }

    public Flux<PostDto> getPost(){
        return webClient.get().uri("/posts").retrieve().bodyToFlux(PostDto.class);
    }

    public Flux<PostDto> getPostsByUser (Integer userId){
        return webClient.get().uri("/users/"+userId+"/post").retrieve().bodyToFlux(PostDto.class);
    }

    public Mono<PostDto> update (Integer id, PostDto postDto){
        return webClient.put().uri("/posts"+id).bodyValue(postDto).retrieve().bodyToMono(PostDto.class);
    }

    public void delete(Integer id){
        webClient.delete().uri("/posts"+id).retrieve().bodyToMono(PostDto.class);
    }



}
