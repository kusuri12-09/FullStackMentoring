package kusuri12.practice.global.security.dto

data class SignUpRequest(
    val loginId: String,
    val password: String,
    val username: String,
    val email: String?,
)
