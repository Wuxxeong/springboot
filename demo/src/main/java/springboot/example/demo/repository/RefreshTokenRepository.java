package springboot.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springboot.example.demo.domain.RefreshToken;

import java.util.Optional;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {
    Optional<RefreshToken> findByUserId(Long userId);

    Optional<RefreshToken> findByRefreshToken(String refreshToken);
}
