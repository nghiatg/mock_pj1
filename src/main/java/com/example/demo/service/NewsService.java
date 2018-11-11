package com.example.demo.service;

public interface NewsService {
	public boolean addNews(String title, String description, String content, int creator);
	public boolean deleteNews(int id);
	
}
