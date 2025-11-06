package com.project.blogging.service;

import com.project.blogging.entity.Post;
import com.project.blogging.model.PostRequest;
import com.project.blogging.model.PostResponse;
import com.project.blogging.repository.PostRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    private final ModelMapper modelMapper = new ModelMapper();

    public PostResponse create(PostRequest request) {
        Post post = modelMapper.map(request, Post.class);
        Post savePost = postRepository.save(post);
        return modelMapper.map(savePost, PostResponse.class);
    }

    public List<PostResponse> findAll() {
        List<Post> posts = postRepository.findAll();
        return posts.stream()
                .map(post -> modelMapper.map(post, PostResponse.class))
                .collect(Collectors.toList());
    }

    public PostResponse findById(Long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Post not found with id " + id));
        return modelMapper.map(post, PostResponse.class);
    }

    public List<PostResponse> findByFilter(String search) {
        List<Post> posts = postRepository.searchPosts(search);
        return posts.stream()
                .map(post -> modelMapper.map(post, PostResponse.class))
                .collect(Collectors.toList());
    }

    public PostResponse updatePost(PostRequest request, Long id) {
        Post postById = postRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Post Not Found with id " + id));
        postById.setTitle(request.getTitle());
        postById.setContent(request.getContent());
        postById.setCategory(request.getCategory());
        postById.setTags(request.getTags());
        return modelMapper.map(postById, PostResponse.class);
    }

    public void deleteById(Long id) {
        Post postById = postRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Post Not Found with id " + id));
        postRepository.deleteById(postById.getId());
    }
}
