package com.spring.online.teaching.security.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.spring.online.teaching.models.User;
import com.spring.online.teaching.payload.response.RoleResponse;
import com.spring.online.teaching.repository.UserRespository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRespository userRepository;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// User user = userRepository.findByName(username).orElseThrow(() -> new
		// UsernameNotFoundException("User 404"));
		RoleResponse user = userRepository.findByUsername(username);
		try {
			if (username.contains(user.getUsername())) {
				return UserDetailsImpl.build(user);
			} else {
				return null;
			}
		} catch (Exception e) {
			throw new UsernameNotFoundException("user 404");
		}

	}

}
