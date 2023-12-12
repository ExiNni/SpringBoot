package com.kh.springdb.repository;

import java.util.Optional;

import com.kh.springdb.model.User;

public interface UserRepository extends JpaRepository<User, int> {
	Optional<User> findByUsername(String username);
}
