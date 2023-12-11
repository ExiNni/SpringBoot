package com.kh.springdb.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

<<<<<<< HEAD
=======
import com.kh.springdb.model.User;

>>>>>>> a2fb727ff38c343a847366930d450a7ab66f585a
public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findByUsername(String username);
}
