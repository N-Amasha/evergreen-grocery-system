package lk.evergreen.grocery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import lk.evergreen.grocery.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
<<<<<<< Updated upstream

    // This allows you to find a user by email for login/validation
=======
>>>>>>> Stashed changes
    User findByEmail(String email);
}
