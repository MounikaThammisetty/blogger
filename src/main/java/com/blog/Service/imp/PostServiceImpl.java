package com.blog.Service.imp;

import com.blog.Service.PostService;
import com.blog.entity.Post;
import com.blog.exception.ResourceNotFoundException;
import com.blog.payload.PostDto;
import com.blog.repository.PostRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {
    private PostRepository PostRepo;

    public PostServiceImpl(PostRepository postRepo) {
        PostRepo = postRepo;
    }
    @Override
    public PostDto CreatePost(PostDto postdto) {
     Post p = new Post();
     p.setDescription(postdto.getDescription());
     p.setContent(postdto.getContent());
     p.setTitle(postdto.getTitle());

     Post savedPost = PostRepo.save(p);

     PostDto dto = new PostDto();

     dto.setId(savedPost.getId());
     dto.setTitle(savedPost.getTitle());
     dto.setDescription(savedPost.getDescription());
     dto.setContent(savedPost.getContent());
     dto.setMessage("post is created");
        return dto;
    }

    @Override
    public void deletePost(long id) {
//        Optional<Post> byId = PostRepo.findById(id);
//        if(byId.isPresent()) {
//            PostRepo.deleteById(id);
//        }else{
//            throw new ResourceNotFoundException("post not found with id:"+id);
//        }
        Post post=PostRepo.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("post not found with id:"+id)
        );

        PostRepo.deleteById(id);
   }

    @Override
    public List<PostDto> getAllPosts(int pageNo, int pageSize, String sortBy) {
        Pageable pageable=PageRequest.of(pageNo,pageSize, Sort.by(sortBy));
        Page<Post> pagePosts = PostRepo.findAll(pageable);

        List<Post> posts = pagePosts.getContent();
        List<PostDto> dtos = posts.stream().map(p -> mapToDto(p)).collect(Collectors.toList());
        return dtos;
    }

    @Override
    public PostDto updatePost(long postId, PostDto postDto) {
        Post post=PostRepo.findById(postId).orElseThrow(
                ()->new ResourceNotFoundException("post Not Found with id:"+postId)
        );
        post.setTitle(postDto.getTitle());
        post.setContent(postDto.getContent());
        post.setDescription(postDto.getDescription());

        Post savedPost = PostRepo.save(post);

        PostDto dto = mapToDto(savedPost);
        return dto;
    }

    PostDto mapToDto(Post post){
        PostDto dto = new PostDto();

        dto.setId(post.getId());
        dto.setTitle(post.getTitle());
        dto.setDescription(post.getDescription());
        dto.setContent(post.getContent());
        dto.setMessage("post is created");
        return dto;
    }
}
