package com.spring.online.teaching.controllers;

import java.util.List;

import java.util.logging.LogRecord;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.online.teaching.models.Role;
import com.spring.online.teaching.models.User;
import com.spring.online.teaching.payload.request.LoginRequest;
import com.spring.online.teaching.payload.request.SignupRequest;
import com.spring.online.teaching.payload.response.JwtResponse;
import com.spring.online.teaching.payload.response.MessageResponse;
import com.spring.online.teaching.repository.RoleRespository;
import com.spring.online.teaching.repository.UserRespository;
import com.spring.online.teaching.security.jwt.JwtUtils;
import com.spring.online.teaching.security.services.UserDetailsImpl;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class TestController {

	@Autowired(required = true)
	UserRespository repo = null;
	@Autowired(required = true)
	RoleRespository repo1 = null;
	@Autowired
	PasswordEncoder encoder;
	@Autowired
	JwtUtils jwtUtils;
	@Autowired
	AuthenticationManager authenticationManger;

	@GetMapping(path = "/get")
	@PreAuthorize("hasRole('STUDENT')")
	public List<Role> gettest() {
		return repo1.findAll();
	}

	@PostMapping(path = "auth/signup")

	public String test(@Valid SignupRequest singuprequest) {
		User user = new User(singuprequest.getName(), singuprequest.getEmail(),
				encoder.encode(singuprequest.getPassword()), singuprequest.getConfirm_password(),
				singuprequest.getRole_id());
		repo.save(user);
		return "you have added";
	}

	@PostMapping(path = "auth/signin")
	public ResponseEntity<?> signin(@Valid LoginRequest loginRequest) {
		Authentication auth = authenticationManger.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(auth);
		String jwt = jwtUtils.generateJwtToken(auth);
		UserDetailsImpl userDetail = (UserDetailsImpl) auth.getPrincipal();
		System.out.println(userDetail.getAuthorities());
		return ResponseEntity.ok(new JwtResponse(jwt, userDetail.getUsername(), userDetail.getPassword()));

	}

	@GetMapping(path = "/getinform")
	@PreAuthorize("hasRole('TEACHER')")
	public List<MessageResponse> getinformation() {
		return repo1.getinformation();
	}
}
