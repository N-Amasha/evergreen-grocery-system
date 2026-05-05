package lk.evergreen.grocery.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import lk.evergreen.grocery.entity.User;
import lk.evergreen.grocery.repository.UserRepository;

@Service
public interface UserService {
    void saveUser(User user);
    User authenticate(String email, String password);
}
