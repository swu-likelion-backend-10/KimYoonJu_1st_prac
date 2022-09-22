package Introduce.introduce.post.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import Introduce.introduce.post.domain.Board;

public interface BoardRepository extends JpaRepository<Board, Long> {
}
