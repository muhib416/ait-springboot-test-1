package com.example.springbootcrud.example.service;

import com.example.springbootcrud.example.entity.News;
import com.example.springbootcrud.example.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Service
public class NewsService {
    @Autowired
    private NewsRepository newsRepository;

    public News saveNews(News news) {
        LocalDate localDate = LocalDate.now();
        ZoneId defaultZoneId = ZoneId.systemDefault();

        Date date = Date.from(localDate.atStartOfDay(defaultZoneId).toInstant());
        news.setCreated_date(date);
        return newsRepository.save(news);
    }

    public List<News> saveNews(List<News> news) {
        LocalDate localDate = LocalDate.now();
        ZoneId defaultZoneId = ZoneId.systemDefault();
        List<News> listNews = new ArrayList<News>();
        Date date = Date.from(localDate.atStartOfDay(defaultZoneId).toInstant());
        for(News newNews : news) {
            if (newNews.getCreated_date() == null) {
                newNews.setCreated_date(date);
                listNews.add(newNews);
            }
        }
        return newsRepository.saveAll(listNews);
    }

    public List<News> getNews() {
        return  newsRepository.findAll();
    }

    public News getNewsById(int id) {
        return  newsRepository.findById(id).orElse(null);
    }

    public String deleteNews(int id) {
         newsRepository.deleteById(id);

         return "news Deleted" + id;
    }

    public News updateNews(News news) {
        News dataNews =  newsRepository.findById(news.getId()).orElse(null);
        dataNews.setTitle(news.getTitle());
        dataNews.setQuantity(news.getQuantity());
        dataNews.setDescription(news.getDescription());

        LocalDate localDate = LocalDate.now();
        ZoneId defaultZoneId = ZoneId.systemDefault();
        Date date = Date.from(localDate.atStartOfDay(defaultZoneId).toInstant());

        dataNews.setCreated_date(date);

        return  newsRepository.save(dataNews);
    }
}
