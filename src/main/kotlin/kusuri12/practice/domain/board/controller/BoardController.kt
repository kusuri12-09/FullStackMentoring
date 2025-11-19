package kusuri12.practice.domain.board.controller

import kusuri12.practice.domain.board.dto.CreateBoardRequest
import kusuri12.practice.domain.board.dto.UpdateBoardRequest
import kusuri12.practice.domain.board.entity.Board
import kusuri12.practice.domain.board.service.BoardService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/board")
class BoardController(private val boardService: BoardService) {

    @GetMapping("/all")
    fun getAllBoard(): List<Board> {
        return boardService.getAllBoard()
    }

    @GetMapping
    fun getBoard(@RequestParam id: Long): Board {
        return boardService.getBoard(id)
    }

    @PostMapping
    fun createBoard(@RequestBody request: CreateBoardRequest): Board {
        return boardService.createBoard(request)
    }

    @DeleteMapping
    fun deleteBoard(@RequestParam id: Long) {
        boardService.deleteBoard(id)
    }

    @PutMapping
    fun updateBoard(@RequestParam id: Long, @RequestBody request: UpdateBoardRequest) {
        boardService.updateBoard(id, request)
    }

    @GetMapping("/search")
    fun searchTitle(@RequestParam query: String): List<Board> {
        return boardService.searchTitle(query)
    }
}