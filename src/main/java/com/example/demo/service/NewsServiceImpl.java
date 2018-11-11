package com.example.demo.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.News;
import com.example.demo.repository.HrRepository;
import com.example.demo.repository.NewsRepository;

import utilities.Utils;

@Service
public class NewsServiceImpl implements NewsService {
	@Autowired
	private NewsRepository newsRepo;
	@Autowired
	private HrRepository hrRepo;

	@Override
	public boolean addNews(String title, String description, String content, int creator) {
		News addedNews = new News();
		addedNews.setCreateDate(Utils.changeDateToString(new Date()));
		addedNews.setTitle(title);
		addedNews.setContent(content);
		addedNews.setDescription(description);
		addedNews.setCreator(hrRepo.findById(creator).get());
		newsRepo.save(addedNews);
		return false;
	}

	@Override
	public boolean deleteNews(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
