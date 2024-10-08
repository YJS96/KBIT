package org.scoula.controller.post;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.scoula.dto.post.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/post/v1")
public class PostController {
    private final PostRepository postRepository;
    private String context = "/post";

    @GetMapping("/show")
    public String postList(HttpServletRequest request, Model model) {
        log.info("========> 게시글 목록 페이지 호출, " + request.getRequestURI());

        model.addAttribute("postList", postRepository.findAll());
        return context + "/post-show";
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
    public String postSearch(
            @RequestParam("title") String title,
            @RequestParam("content") String content,
            HttpServletRequest request,
            Model model
    ) {
        log.info("========> 게시글 검색 기능 호출, " + request.getRequestURI());

        model.addAttribute("postList", postRepository.findByCond(title, content));
        return context + "/post-show";
    }
}
