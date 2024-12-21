package com.api.WebClient.Controller;

import com.api.WebClient.dto.PostDto;
import com.api.WebClient.service.PostService;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/posts")
public class PotsController {
    private final PostService postService;

        public PotsController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping
    public ResponseEntity<Mono<PostDto>> save (@RequestBody PostDto postDto){
         return new ResponseEntity<>(postService.save(postDto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Flux<PostDto>> getPosts(){
            return new ResponseEntity<>(postService.getPost(), HttpStatus.OK);
    }

    @GetMapping("/{userid}")
    public ResponseEntity<Flux<PostDto>> getPosts(@PathVariable Integer userId){
        return new ResponseEntity<>(postService.getPostsByUser(userId), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Mono<PostDto>> update (@PathVariable Integer id, @RequestBody PostDto postDto){
         return new ResponseEntity<>(postService.update(id, postDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete (@PathVariable Integer id){
            postService.delete(id);
            return new ResponseEntity<>("Posts eliminado!", HttpStatus.OK);
    }

}
