package kusuri12.practice.domain.board.dto

class CreateBoardRequest (
    val title: String,
    val content: String,
    val author: String = "anonymous",
)