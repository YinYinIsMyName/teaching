package com.spring.online.teaching.controllers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import java.util.Optional;
import java.util.logging.LogRecord;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.online.teaching.models.CreateSection;
import com.spring.online.teaching.models.PostContent;
import com.spring.online.teaching.models.Role;
import com.spring.online.teaching.models.Tag;
import com.spring.online.teaching.models.User;
import com.spring.online.teaching.payload.request.CommentRequest;
import com.spring.online.teaching.payload.request.CreateSectionRequest;
import com.spring.online.teaching.payload.request.LoginRequest;
import com.spring.online.teaching.payload.request.PostContentRequest;
import com.spring.online.teaching.payload.request.SectionJoinRequest;
import com.spring.online.teaching.payload.request.SignupRequest;
import com.spring.online.teaching.payload.response.ContentResponse;
import com.spring.online.teaching.payload.response.JwtResponse;
import com.spring.online.teaching.payload.response.MessageResponse;
import com.spring.online.teaching.payload.response.ResponseMessage;
import com.spring.online.teaching.repository.CreateSectionRepository;
import com.spring.online.teaching.repository.RoleRespository;
import com.spring.online.teaching.repository.UserRespository;
import com.spring.online.teaching.security.jwt.JwtUtils;
import com.spring.online.teaching.security.services.CommentServiceImpl;
import com.spring.online.teaching.security.services.CreateSectionServiceImpl;
import com.spring.online.teaching.security.services.PostContentServiceImpl;
import com.spring.online.teaching.security.services.TagServiceImpl;
import com.spring.online.teaching.security.services.UserDetailsImpl;
import com.spring.online.teaching.security.services.UserDetailsServiceImpl;

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
	@Autowired
	CreateSectionServiceImpl createsectionserviceimpl = null;
	@Autowired
	CreateSectionRepository createsectionRepository;
	@Autowired
	PostContentServiceImpl postcontentserviceimpl;
	@Autowired
	CommentServiceImpl commentserviceimpl;
	@Autowired
	UserDetailsServiceImpl userdetailseriveimpl;
	@Autowired
	TagServiceImpl tagServiceimpl;

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
		return ResponseEntity.ok(new JwtResponse(jwt, userDetail.getUsername(), userDetail.getPassword(),
				userDetail.getUserId(), userDetail.getAuthorities()));

	}

	@GetMapping(path = "/getinform")
	@PreAuthorize("hasRole('TEACHER')")
	public List<MessageResponse> getinformation() {
		return repo1.getinformation();
	}

	@PostMapping(path = "/postsection")
	public ResponseEntity<?> createSection(@Valid CreateSectionRequest sectionRequest) {
		String unique_section_key = createsectionserviceimpl.randomUnique(6, 5, 't');
		CreateSection section = new CreateSection(1, unique_section_key, sectionRequest.getClassname(),
				sectionRequest.getSubject(), sectionRequest.getRoom(), sectionRequest.getSection(),
				sectionRequest.getStream(), sectionRequest.isShow_items(), sectionRequest.getDate_time());
		System.out.println(section);
		createsectionserviceimpl.createSection(section);
		return ResponseEntity.ok(new ResponseMessage("section has been created"));
	}

	@PutMapping(path = "/putsection")
	public ResponseEntity<CreateSection> findBySectionId(@RequestParam("id") long id,
			@Valid CreateSectionRequest createSectionRequest) {
		CreateSection sectionData = createsectionserviceimpl.EditSectionById(id, createSectionRequest);
		if (sectionData != null) {
			return new ResponseEntity<>(createsectionRepository.save(sectionData), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping(path = "/post")
	public ResponseEntity<?> addPostConent(@RequestParam("userId") long userId, @RequestParam("createId") long createId,
			@Valid @RequestBody PostContentRequest request) {
		postcontentserviceimpl.storepost(createId, userId, request);
		return ResponseEntity.ok(new ResponseMessage("content has been added"));
	}

	@PostMapping(path = "/comments")
	public ResponseEntity<?> comments(@RequestParam("postid") long postId, @RequestParam("userid") long userId,
			@RequestBody CommentRequest request) {
		commentserviceimpl.addcomments(postId, userId, request);
		return ResponseEntity.ok(new ResponseMessage("you have commented on this post"));
	}

	@PostMapping(path = "/section/join")
	public ResponseEntity<CreateSection> joinSection(@RequestParam("username") String username,
			@RequestBody SectionJoinRequest request) {
		String unique_code = request.getUnique_code();
		CreateSection sectionByUniqueCode = createsectionserviceimpl.readSection(unique_code);
		tagServiceimpl.writeIntoTagMethod(username, unique_code);
		if (sectionByUniqueCode != null) {
			return new ResponseEntity<>(sectionByUniqueCode, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping(path = "/post/section/{createId}")
	public ResponseEntity<?> readPostContent(@PathVariable("createId") long createId) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMM,dd yyyy");
		DateTimeFormatter dtft = DateTimeFormatter.ofPattern("hh:mm a");
		LocalDateTime now = LocalDateTime.now();
		String formattedDate = dtf.format(now);
		List<ContentResponse> contents = postcontentserviceimpl.readByTime(createId, formattedDate);
		if (contents.size() > 0) {
			return new ResponseEntity<>(contents, HttpStatus.OK);
		} else {
			return ResponseEntity.ok(new ResponseMessage("no content is not found"));
		}

	}

}
