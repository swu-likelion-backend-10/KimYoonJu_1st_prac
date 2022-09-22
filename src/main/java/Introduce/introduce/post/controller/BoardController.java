package Introduce.introduce.post.controller;

import Introduce.introduce.post.dto.BoardDto;
import Introduce.introduce.post.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BoardController {

    private final BoardService boardService;

    public BoardController(BoardService boardService){
        this.boardService=boardService;
    }

    @GetMapping("/")
    public String list(){
        return "board/list.html";
    }
    @GetMapping("/post")
    public String write(){
        return "board/write.html";
    }
    @PostMapping("/post")
    public String write(BoardDto boardDto) {
        boardService.savePost(boardDto);
        return "redirect:/";
    }
}
