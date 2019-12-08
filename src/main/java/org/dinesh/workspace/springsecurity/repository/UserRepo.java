package org.dinesh.workspace.springsecurity.repository;

import org.dinesh.workspace.springsecurity.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<User, Integer> {

	public User findByUsername(String username);
}
