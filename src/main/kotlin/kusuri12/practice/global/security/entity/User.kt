package kusuri12.practice.global.security.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

@Entity
class User (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    @Column(nullable = false, unique = true)
    val loginId: String,

    @Column(nullable = false)
    val password: String,

    @Column
    val username: String,

    @Column(unique = true)
    val email: String?,

) : UserDetails {
    override fun getAuthorities(): Collection<GrantedAuthority> = emptyList()

    override fun getPassword(): String = this.password

    override fun getUsername(): String = this.username
}