package com.exampleApi.RestTemplate.controller;

import com.exampleApi.RestTemplate.dto.PostDto;
import com.exampleApi.RestTemplate.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PostController {
    @Autowired
    private PostService postService;

    @GetMapping("/post")
    public ResponseEntity<List<PostDto>> getPosts(){

     return new ResponseEntity<>(postService.getPost(), HttpStatus.OK);
    }

    @GetMapping("/post/{id}")
    public ResponseEntity<PostDto> get(@PathVariable Integer id){
        return new ResponseEntity<>(postService.get(id),HttpStatus.OK );
    }

    @PostMapping("/post")
    public ResponseEntity<PostDto> save(@RequestBody PostDto postDto){
        return new ResponseEntity<>(postService.save(postDto), HttpStatus.CREATED);
    }

    @PutMapping("post/{id}")
    public ResponseEntity<PostDto> update (@PathVariable Integer id, @RequestBody PostDto postDto){
            return new ResponseEntity<>(postService.update(id, postDto), HttpStatus.OK);
    }

    public ResponseEntity<?> delete (@PathVariable Integer id){
        postService.delete(id);
        return new ResponseEntity<>("Post eliminado", HttpStatus.OK);
    }


}