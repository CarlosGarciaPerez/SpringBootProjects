package com.api.RestOpenFeing.controller;

import com.api.RestOpenFeing.dto.PostDto;
import com.api.RestOpenFeing.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
public class postController {

    @Autowired
    private PostService postService;

    @PostMapping

    public ResponseEntity<PostDto> save (@RequestBody PostDto postDto){
        return new ResponseEntity<>(postService.save(postDto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<PostDto>> getPosts(){
        return new ResponseEntity<>(postService.getPosts(), HttpStatus.OK);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<PostDto>> getPostUserId (@PathVariable Integer userId){

        return new ResponseEntity<>(postService.getPostByUser(userId), HttpStatus.OK);
    }

    @PutMapping("/Id")
    public ResponseEntity<PostDto> update (@PathVariable Integer id,@RequestBody PostDto postDto){
        return new ResponseEntity<>(postService.update(id, postDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete (@PathVariable Integer id){
        postService.delete(id);
        return new ResponseEntity<>("Post eliminado", HttpStatus.OK);
    }



}
