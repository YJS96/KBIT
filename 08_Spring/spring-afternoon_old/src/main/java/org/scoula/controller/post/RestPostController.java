package org.scoula.controller.post;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.scoula.dto.post.PostDto;
import org.scoula.dto.post.PostRepository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping("/post/v1/rest")
public class RestPostController {
    private final PostRepository postRepository;
    private String context = "/post";

    @GetMapping("/show")
    public List<PostDto> postList(HttpServletRequest request) {
        log.info("========> 게시글 목록 페이지 호출, " + request.getRequestURI());

        List<PostDto> list = postRepository.findAll();

        return list;
    }

    @PostMapping("/delete")
    public String postDelete(@RequestParam("id") String id, HttpServletRequest request) {
        log.info("========> 게시글 삭제 기능 호출. " + request.getRequestURI());

        long postId = Long.parseLong(id);
        int affectedRows = postRepository.delete(postId);

        if (affectedRows > 0) log.info("삭제 성공");

        return "redirect:/post/v1/show/";
    }

    @GetMapping("/new")
    public String postNew(HttpServletRequest request) {
        log.info("========> 게시글 추가 페이지 호출, " + request.getRequestURI());
        return context + "/post-new";
    }

    @PostMapping("/new")
    public String postSave(
            @RequestParam("title") String title,
            @RequestParam("content") String content,
            HttpServletRequest request
    ) {
        log.info("========> 게시글 추가 기능 호출, " + request.getRequestURI());

        postRepository.save(title, content);

        return "redirect:/post/v1/show";
    }

    @GetMapping("/search")
    public List<PostDto> postSearch(
            @RequestParam("title") String title,
            @RequestParam("content") String content,
            HttpServletRequest request
    ) {
        log.info("========> 게시글 검색 기능 호출, " + request.getRequestURI());

        List<PostDto> searchedList = postRepository.findByCond(title, content);

        return searchedList;
    }
}
