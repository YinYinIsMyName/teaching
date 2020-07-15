package com.spring.online.teaching.security.services;

import java.security.SecureRandom;

import java.util.Optional;
import java.util.Random;

import javax.security.auth.Subject;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.online.teaching.models.CreateSection;
import com.spring.online.teaching.payload.request.CreateSectionRequest;
import com.spring.online.teaching.repository.CreateSectionRepository;

@Service
public class CreateSectionServiceImpl {
	final private String ALPHA = "ABCDEFGHIJKLMNOPQRSTUV123456789";
	final private Random rng = new SecureRandom();

	@Autowired
	CreateSectionRepository createsectionrepository;

	@Transactional
	public void createSection(CreateSection section) {
		System.out.println(section.getCurrentTime());
		createsectionrepository.save(section);
	}

	private char randomChar() {
		return ALPHA.charAt(rng.nextInt(ALPHA.length()));
	}

	public String randomUnique(int length, int spacing, char spaceChar) {
		StringBuilder sb = new StringBuilder();
		int spacer = 0;
		while (length > 0) {
			if (spacer == spacing) {
				sb.append(spaceChar);
				spacer = 0;
			}
			length--;
			spacer++;
			sb.append(randomChar());
		}
		return sb.toString();
	}

	public CreateSection EditSectionById(long id, CreateSectionRequest request) {

		Optional<CreateSection> createSection = createsectionrepository.findById(id);
		if (createSection.isPresent()) {
			CreateSection _section = createSection.get();
			_section.setUniquekey(request.getUnique_code());
			_section.setClassname(request.getClassname());
			_section.setSubject(request.getSubject());
			_section.setRoom(request.getRoom());
			_section.setSection(request.getSection());
			_section.setStream(request.getStream());
			_section.setShow_items(request.isShow_items());
			_section.setCurrentTime(request.getDate_time());
			return _section;
		} else {
			return null;
		}
	}

	public void test() {
		System.out.println("hello");
	}

	public CreateSection readSection(String unique_code) {

		CreateSection readSection = createsectionrepository.findByUniqueKey(unique_code);

		return readSection;
	}
}
