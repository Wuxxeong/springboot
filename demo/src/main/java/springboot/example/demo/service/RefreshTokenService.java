package springboot.example.demo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import springboot.example.demo.domain.RefreshToken;
import springboot.example.demo.repository.RefreshTokenRepository;

@RequiredArgsConstructor
@Service
public class RefreshTokenService {

    private final RefreshTokenRepository refreshTokenRepository;

    public RefreshToken findByRefreshToken(String refreshToken) {
        return refreshTokenRepository.findByRefreshToken(refreshToken)
                .orElseThrow(() -> new IllegalArgumentException("unexpected token"));
    }
}
