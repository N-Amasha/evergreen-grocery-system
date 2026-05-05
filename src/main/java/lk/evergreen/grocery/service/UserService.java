package lk.evergreen.grocery.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import lk.evergreen.grocery.entity.User;
import lk.evergreen.grocery.repository.UserRepository;

@Service
<<<<<<< Updated upstream

public class UserService {
    @Autowired
    private UserRepository repo;

    public User register(User user) {
        return repo.save(user);
    }

    public List<User> getAllUsers() {
        return repo.findAll();
    }
=======
public interface UserService {
    void saveUser(User user);
    User authenticate(String email, String password);
    void updateUserProfile(User user);
>>>>>>> Stashed changes
}
