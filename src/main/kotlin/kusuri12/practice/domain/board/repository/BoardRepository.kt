package kusuri12.practice.domain.board.repository

import kusuri12.practice.domain.board.entity.Board
import org.springframework.data.jpa.repository.JpaRepository

interface BoardRepository : JpaRepository<Board, Long> {

    fun findByTitleContains(title: String): List<Board>
}