package Introduce.introduce.post.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import Introduce.introduce.post.domain.Board;


import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {

    List<Board> findByTitleContaining(String keyword);
}
