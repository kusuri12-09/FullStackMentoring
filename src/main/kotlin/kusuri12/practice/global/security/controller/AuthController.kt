package kusuri12.practice.global.security.controller

import kusuri12.practice.global.security.dto.SignInRequest
import kusuri12.practice.global.security.dto.SignUpRequest
import kusuri12.practice.global.security.dto.TokenResponse
import kusuri12.practice.global.security.service.AuthService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/auth")
class AuthController(private val authService: AuthService) {
    @PostMapping("/sign-in")
    fun signIn(@RequestBody request: SignInRequest): TokenResponse {
        return authService.signIn(request)
    }

    @PostMapping("/sign-up")
    fun signUp(@RequestBody request: SignUpRequest) {
        return authService.signUp(request)
    }
}