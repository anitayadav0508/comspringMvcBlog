package com.springMvc.blog.controller;

import com.springMvc.blog.entity.Blog;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Controller
@RequestMapping("/blog")
public class BlogController {
    SessionFactory sessionFactory = new Configuration()
            .configure("hibernate.cfg.xml")
            .addAnnotatedClass(Blog.class)
            .buildSessionFactory();
    @RequestMapping("/insert")
    public String create(@RequestParam(name = "title") String title , @RequestParam String  description){

        Session session = sessionFactory.getCurrentSession();
        try{
            session.beginTransaction();   //session is starts
            Blog blog = new Blog(title,description);
            session.save(blog);
            session.getTransaction().commit();
            session.close();

        }catch (Exception e){
            System.out.println(e);
        }

        return "welcome";

    }

    @RequestMapping("/read")
    public String read( Model model){

        Session session = sessionFactory.getCurrentSession();
        List<Blog> blogList = new LinkedList<Blog>();

        try {
            session.beginTransaction();
            blogList =  session.createQuery("from Blog").list();
            session.getTransaction().commit();
            session.close();
            model.addAttribute("blogs" , blogList );
        }catch (Exception e){
            System.out.println(e);
        }

        return  "read";
    }

}
