package Introduce.introduce.post.service;

import Introduce.introduce.post.domain.Board;
import Introduce.introduce.post.dto.BoardDto;
import Introduce.introduce.post.repository.BoardRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BoardService {

    private final BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    @Transactional
    public Long savePost(BoardDto boardDto) {
        return boardRepository.save(boardDto.toEntity()).getId();
    }

    @Transactional
    public List<BoardDto> getBoardlist() {
        List<Board> boards = boardRepository.findAll();
        List<BoardDto> boardDtoList = new ArrayList<>();

        for (Board board : boards) {
            BoardDto boardDto = BoardDto.builder()
                    .id(board.getId())
                    .title(board.getTitle())
                    .age(board.getAge())
                    .major(board.getMajor())
                    .contents(board.getContents())
                    .createdTime(board.getCreatedTime())
                    .build();

            boardDtoList.add(boardDto);
        }

        return boardDtoList;
    }

    @Transactional
    public BoardDto getPost(Long id) {
        Optional<Board> boardWrapper = boardRepository.findById(id);
        Board board = boardWrapper.get();

        BoardDto boardDto = BoardDto.builder()
                .id(board.getId())
                .title(board.getTitle())
                .age(board.getAge())
                .major(board.getMajor())
                .contents(board.getContents())
                .createdTime(board.getCreatedTime())
                .modifiedTime(board.getModifiedTime())
                .build();

        return boardDto;
    }

    @Transactional
    public Long updatePost(Long id, BoardDto boardDto) {
        Board board = boardRepository.findById(id).orElseThrow(()
                -> new IllegalArgumentException("해당 게시글은 존재하지 않습니다." + id));
        board.update(boardDto);

        return id;
    }

    @Transactional
    public void deletePost(Long id) {
        boardRepository.deleteById(id);
    }

    @Transactional
    public List<BoardDto> searchPosts(String keyword){
        List<Board> boards = boardRepository.findByTitleContaining(keyword);
        List<BoardDto> boardDtoList = new ArrayList<>();

        if(boards.isEmpty()) return boardDtoList;

        for (Board board : boards) {
            boardDtoList.add(this.convertEntityToDto(board));
        }
        return boardDtoList;
    }

    private BoardDto convertEntityToDto(Board board){
        return BoardDto.builder()
                .id(board.getId())
                .title(board.getTitle())
                .age(board.getAge())
                .major(board.getMajor())
                .contents(board.getContents())
                .createdTime(board.getCreatedTime())
                .build();
    }
}
