package com.example.springbootcrud.example.controller;

import com.example.springbootcrud.example.entity.News;
import com.example.springbootcrud.example.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NewsController {

    @Autowired
    private NewsService newsService;

    @PostMapping("/addNews")
    public News addNews(@RequestBody News news) {
        return  newsService.saveNews(news);
    }

    @PostMapping("/addNewss")
    public List<News> addListNews(@RequestBody List<News> news) {
        return  newsService.saveNews(news);
    }
    @GetMapping("/news")
    public List<News> findAllNews(){
        return newsService.getNews();
    }
    @GetMapping("/news/{id}")
    public News findNewsById(@PathVariable int id) {
        return newsService.getNewsById(id);
    }

    @PutMapping("/update")
    public News updateProduct(@RequestBody News news) {
        return newsService.updateNews(news);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable int id) {
        return newsService.deleteNews(id);
    }
}
