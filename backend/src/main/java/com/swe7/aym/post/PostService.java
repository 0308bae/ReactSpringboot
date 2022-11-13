package com.swe7.aym.post;

import com.swe7.aym.post.dto.PostDto;
import com.swe7.aym.post.dto.PostEndDto;
import com.swe7.aym.post.dto.PostSaveDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Transactional
public class PostService {
    private final PostRepository postRepository;

    public Long save(PostSaveDto requestDto) {
        return postRepository.save(requestDto.toEntity()).getPostId();
    }

    public Long updateEnd(Long id, PostEndDto postEndDto) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 게시글입니다!"));
        post.updateEnd(
                postEndDto.getClient_star(),
                postEndDto.getHelper_star(),
                postEndDto.getState()
        );
        return id;
    }

    public Long updateState(Long id, int state) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 게시글입니다!"));
        post.updateState(state);
        return id;
    }
    public Post findById(Long target_id) {
        return postRepository.findById(target_id)
                .orElseThrow(()->new IllegalArgumentException("게시글 조회 : 잘못된 아이디"));
    }
    public List<PostDto> findByState(int target_state) {
        return postRepository.findByState(target_state)
                .stream()
                .map(PostDto::new)
                .collect(Collectors.toList());
    }
    public List<PostDto> findByRecent() {
        return postRepository.findByRecent()
                .stream()
                .map(PostDto::new)
                .collect(Collectors.toList());
    }
    public List<PostDto> findByKeyword(String target_keyword) {
        return postRepository.findByKeyword(target_keyword)
                .stream()
                .map(PostDto::new)
                .collect(Collectors.toList());
    }
    public List<PostDto> findByClientId(Long id) {
        return postRepository.findByClientId(id)
                .stream()
                .map(PostDto::new)
                .collect(Collectors.toList());
    }
    public List<PostDto> findByCategory(String category) {
        return postRepository.findByCategory(category)
                .stream()
                .map(PostDto::new)
                .collect(Collectors.toList());
    }
}