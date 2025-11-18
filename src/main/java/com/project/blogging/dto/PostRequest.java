package com.project.blogging.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostRequest {
    private String title;
    private String content;
    private String category;
    private List<String> tags;
}
