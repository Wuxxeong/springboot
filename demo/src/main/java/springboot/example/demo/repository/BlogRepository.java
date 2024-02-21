package springboot.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springboot.example.demo.domain.Article;

public interface BlogRepository extends JpaRepository<Article, Long> {
}
