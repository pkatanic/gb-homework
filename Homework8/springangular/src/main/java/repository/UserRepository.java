package repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import entity.User;

public interface UserRepository extends JpaRepository<User, String>{
	User findByEmail(String email);
    Collection<User> findAllByRole(String role);
}
