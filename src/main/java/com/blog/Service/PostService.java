package com.blog.Service;

import com.blog.payload.PostDto;

import java.util.List;

public interface PostService {
    public PostDto CreatePost(PostDto postdto);

    void deletePost(long id);

    List<PostDto> getAllPosts(int pageNo, int pageSize, String sortBy);

    PostDto updatePost(long postId, PostDto postDto);
}
