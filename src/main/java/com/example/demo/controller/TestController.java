/**
 * 
 */
package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Tag;
import com.example.demo.repository.TagRepository;

/**
 * @author User
 *
 */
@RestController
public class TestController {
	@Autowired
	private TagRepository tagRepo;

	@GetMapping(value = "/")
	public String test() {
		StringBuilder sb = new StringBuilder();
		for (Tag t : tagRepo.findAll()) {
			sb.append(t.getTagName()).append("\t");
		}
		return sb.toString();
	}

}
