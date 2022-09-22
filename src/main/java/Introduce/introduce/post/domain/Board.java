package Introduce.introduce.post.domain;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.persistence.Column;

@Data
@NoArgsConstructor
@Entity
public class Board extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length=100, nullable = false)
    private String title;

    @Column(length=100, nullable = false)
    private String age;

    @Column(length=100, nullable = false)
    private String major;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String contents;

    @Builder
    public Board(Long id, String title, String age, String major, String contents) {
        this.id = id;
        this.title = title;
        this.age = age;
        this.major = major;
        this.contents = contents;
    }

}
