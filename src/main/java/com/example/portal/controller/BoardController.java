package com.example.portal.controller;  // ✅ 패키지명 확인

import com.example.portal.service.BoardService;  // ✅ 수정
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
public class BoardController {

    @Autowired
    private BoardService boardService;

    @GetMapping
    public String getBoard(Model model) {
        model.addAttribute("posts", boardService.getAllPosts());
        return "board";
    }
}
