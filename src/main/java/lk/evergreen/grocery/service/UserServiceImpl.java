package lk.evergreen.grocery.service;

import lk.evergreen.grocery.entity.User;
import lk.evergreen.grocery.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService { // Added 'implements UserService'

    @Autowired
    private UserRepository userRepository;

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    public User authenticate(String email, String password) {
        User user = userRepository.findByEmail(email);

        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }

    @Override
    public void updateUserProfile(User updatedUser) {
        // 1. Fetch the existing user from the database by ID
        User existingUser = userRepository.findById(updatedUser.getId()).orElse(null);

        if (existingUser != null) {
            // 2. Update only the fields that are allowed to change
            existingUser.setName(updatedUser.getName());
            // Add other fields here like phone or address

            // 3. Save the changes
            userRepository.save(existingUser);
        }
    }
}