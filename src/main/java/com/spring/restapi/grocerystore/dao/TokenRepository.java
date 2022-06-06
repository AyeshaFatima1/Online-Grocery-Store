package com.spring.restapi.grocerystore.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spring.restapi.grocerystore.model.AuthenticationToken;
import com.spring.restapi.grocerystore.model.User;

@Repository
public interface TokenRepository extends JpaRepository<AuthenticationToken, Integer> {
	
    AuthenticationToken findTokenByUser(User user);
    
    AuthenticationToken findTokenByToken(String token);
}
