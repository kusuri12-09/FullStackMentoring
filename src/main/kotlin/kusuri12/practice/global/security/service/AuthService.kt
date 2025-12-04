package kusuri12.practice.global.security.service

import io.jsonwebtoken.Jwts
import io.jsonwebtoken.security.Keys
import kusuri12.practice.global.security.dto.SignInRequest
import kusuri12.practice.global.security.dto.SignUpRequest
import kusuri12.practice.global.security.dto.TokenResponse
import kusuri12.practice.global.security.entity.User
import kusuri12.practice.global.security.repository.UserRepository
import org.apache.coyote.BadRequestException
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service
import java.time.Instant
import java.util.Date
import kotlin.jvm.optionals.getOrNull

@Service
class AuthService(private val userRepository: UserRepository) {
    private val passwordEncoder = BCryptPasswordEncoder()
    private val privateKey = "안녕하세요"

    private val key = Keys.hmacShaKeyFor(privateKey.toByteArray())
    private val parser = Jwts.parser().verifyWith(key).build()

    fun signIn(request: SignInRequest): TokenResponse {
        val user = userRepository.findByLoginId(request.loginId).getOrNull() ?: throw NullPointerException()

        if (passwordEncoder.matches(user.password, request.password)) {
            val token = Jwts.builder()
                .id(user.id.toString())
                .subject("user")
                .claim("username", user.username)
                .issuedAt(Date.from(Instant.now()))
                .expiration(Date.from(Instant.now().plusSeconds(3600)))
                .signWith(key)
                .compact()

            return TokenResponse(token)
        }

        throw NullPointerException()
    }

    fun signUp(request: SignUpRequest) {
        if (userRepository.existsByLoginIdIgnoreCase(request.loginId)) {
            throw BadRequestException("이미 있는 아이디입니다.")
        }

        userRepository.save(User(0, request.loginId, passwordEncoder.encode(request.password), request.username, request.email))
    }
}