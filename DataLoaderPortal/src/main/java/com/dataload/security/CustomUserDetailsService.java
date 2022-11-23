package com.dataload.security;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.dataload.account.AccountDao;
import com.dataload.models.LoginDetails;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	@Autowired
	private AccountDao repository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<LoginDetails> user = repository.getByUserName(username);
		if (user.isPresent())
			return new org.springframework.security.core.userdetails.User(user.get().getUserName(),
					user.get().getPassword(), new ArrayList<>());
		return null;
	}
}
