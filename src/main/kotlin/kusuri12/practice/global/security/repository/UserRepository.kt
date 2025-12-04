package kusuri12.practice.global.security.repository

import kusuri12.practice.global.security.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import java.util.Optional

interface UserRepository: JpaRepository<User, Long> {

    fun existsByLoginIdIgnoreCase(loginId: String): Boolean

    fun findByLoginId(loginId: String): Optional<User>
}