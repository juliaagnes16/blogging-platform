package com.project.blogging.controller;

import com.project.blogging.dto.PostRequest;
import com.project.blogging.dto.PostResponse;
import com.project.blogging.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/blog")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping
    public ResponseEntity<PostResponse> create(@RequestBody PostRequest request) {
        try {
            PostResponse response = postService.create(request);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping
    public ResponseEntity<List<PostResponse>> findAll() {
        List<PostResponse> response = postService.findAll();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostResponse> findById(@PathVariable Long id) {
        PostResponse response = postService.findById(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/filter")
    public ResponseEntity<List<PostResponse>> findByFilter(@RequestParam(required = false) String keyword) {
        List<PostResponse> response = postService.findByFilter(keyword);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updatePost(@RequestBody PostRequest request, @PathVariable Long id) {
        try {
            PostResponse response = postService.updatePost(request, id);
            return ResponseEntity.ok(response);
        } catch (ConfigDataResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable Long id) {
        try {
            postService.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (ConfigDataResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
