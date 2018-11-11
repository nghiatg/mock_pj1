/**
 * 
 */
package com.example.demo.controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Comment;
import com.example.demo.repository.CommentRepository;
import com.example.demo.repository.HrRepository;
import com.example.demo.repository.NewsRepository;
import com.example.demo.repository.TagRepository;
import com.example.demo.service.NewsService;

/**
 * @author User
 *
 */
@RestController
public class TestController {
	@Autowired
	private TagRepository tagRepo;
	@Autowired
	private NewsRepository newsRepo;

	@Autowired
	private HrRepository hrRepo;

	@Autowired
	private CommentRepository commentRepo;
	
	@Autowired
	private NewsService newsServiceImpl;

	@GetMapping(value = "/")
	public String test() {
		StringBuilder sb = new StringBuilder();
//		for (Tag t : tagRepo.findAll()) {
//			for(News n : t.getNews()) {
//				sb.append(t.getTagName()).append("\t").append(n.getContent()).append("\n");
//			}
//		}
		
//		for (News n : newsRepo.findAll()) {
//			for(Tag t : n.getTags()) {
//				sb.append(t.getTagName()).append("\t").append(n.getContent()).append("\n");
//			}
//		}
		
		for (Comment c : commentRepo.findAll()) {
			sb.append(c.getContent()).append("\t").append(c.getNews().getContent()).append("\t\t");
		}
		return sb.toString();
	}
	
	@PostMapping(value="/addNews")
	public String add(@RequestBody String dataReceived) {
		JSONObject dataAsJson = new JSONObject(dataReceived);
		String title = dataAsJson.getString("title");
		String content = dataAsJson.getString("content");
		String description = dataAsJson.getString("description");
		int creatorId = dataAsJson.getInt("creator");
		try {
			newsServiceImpl.addNews(title, description, content, creatorId);
			return "successfully";
		}catch(Exception e) {
			e.printStackTrace();
			return "failed";
		}
	}

}
