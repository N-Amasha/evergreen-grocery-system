package lk.evergreen.grocery.repository;

import lk.evergreen.grocery.entity.UserCard;
import lk.evergreen.grocery.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserCardRepository extends JpaRepository<UserCard, Long> {
    List<UserCard> findByUser(User user);
}
