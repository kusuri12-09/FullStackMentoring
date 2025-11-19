package kusuri12.practice.domain.board.service

import jakarta.transaction.Transactional
import kusuri12.practice.domain.board.dto.CreateBoardRequest
import kusuri12.practice.domain.board.dto.UpdateBoardRequest
import kusuri12.practice.domain.board.entity.Board
import kusuri12.practice.domain.board.repository.BoardRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class BoardService(private val boardRepository: BoardRepository) {

    fun getAllBoard(): List<Board> {
        return boardRepository.findAll()
    }

    fun getBoard(id: Long): Board {
        return boardRepository.findByIdOrNull(id)
            ?: throw NullPointerException("게시글을 찾지 못했습니다.") // 500
    }

    fun createBoard(request: CreateBoardRequest): Board {
        val author = request.author.ifBlank { "anonymous" }
        return boardRepository.save(Board(0, request.title, request.content, author))
    }

    fun deleteBoard(id: Long) {
        boardRepository.deleteById(id)
    }

    @Transactional
    fun updateBoard(id: Long, request: UpdateBoardRequest) {
        val board = this.getBoard(id)
        board.title = request.title
        board.content = request.content
    }

    fun searchTitle(query: String): List<Board> {
        return boardRepository.findByTitleContains(query)
    }
}