package lk.evergreen.grocery.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import lk.evergreen.grocery.entity.User;
import lk.evergreen.grocery.repository.UserRepository;

@Service

public class UserService {
    @Autowired
    private UserRepository repo;

    public User register(User user) {
        return repo.save(user);
    }

    public List<User> getAllUsers() {
        return repo.findAll();
    }
}
