package com.api.RestOpenFeing.client;

import com.api.RestOpenFeing.dto.PostDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "post", url = "https://jsonplaceholder.typicode.com")
public interface PostClient {

    @PostMapping("/post")
    PostDto savePost(@RequestBody PostDto postDto);

    @GetMapping("/posts")
    List<PostDto> allPost();

    @GetMapping("users/{userId}/posts")
    List<PostDto> getPostByUserId(@PathVariable Integer userId);

    @PutMapping("/posts/{id}")
    PostDto updatePost(@PathVariable Integer id, PostDto postDto);

    @DeleteMapping("/post/{id}")
    void deletePost (@PathVariable Integer id);

}
