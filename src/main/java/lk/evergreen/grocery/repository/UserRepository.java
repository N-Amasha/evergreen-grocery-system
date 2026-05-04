package lk.evergreen.grocery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import lk.evergreen.grocery.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
}
