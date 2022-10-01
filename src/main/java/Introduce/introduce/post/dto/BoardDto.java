package Introduce.introduce.post.dto;

import Introduce.introduce.post.domain.Board;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class BoardDto {

    private Long id;
    private String title;
    private String age;
    private String major;
    private String contents;
    private LocalDateTime createdTime;
    private LocalDateTime modifiedTime;

    public Board toEntity(){
        Board build = Board.builder()
                .id(id)
                .title(title)
                .age(age)
                .major(major)
                .contents(contents)
                .build();
        return build;
    }

    @Builder
    public BoardDto(Long id, String title, String age, String major, String contents, LocalDateTime createdTime, LocalDateTime modifiedTime){
        this.id = id;
        this.title=title;
        this.age = age;
        this.major = major;
        this.contents=contents;
        this.createdTime=createdTime;
        this.modifiedTime=modifiedTime;
    }
}
