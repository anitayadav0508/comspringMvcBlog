package com.springMvc.blog.controller;

import com.springMvc.blog.entity.Blog;
import com.sun.org.apache.xpath.internal.operations.Mod;
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
    public String create(@RequestParam(name = "title") String title, @RequestParam String description) {

        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();   //session is starts
            Blog blog = new Blog(title, description);
            session.save(blog);
            session.getTransaction().commit();
            session.close();

        } catch (Exception e) {
            System.out.println(e);
        }

        return "welcome";

    }

    @RequestMapping("/read")
    public String read(Model model) {

        Session session = sessionFactory.getCurrentSession();
        List<Blog> blogList = new LinkedList<Blog>();

        try {
            session.beginTransaction();
            blogList = session.createQuery("from Blog").list();  //Hql query hibernate query language for retrieving data all those.
            session.getTransaction().commit();
            session.close();
            model.addAttribute("blogs", blogList);
        } catch (Exception e) {
            System.out.println(e);
        }

        return "read";
    }

    @RequestMapping("/delete")
    public String delete(@RequestParam("id") Integer id) {
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();
            Blog blog = session.get(Blog.class, id);
            session.delete(blog);
            session.getTransaction().commit();
            session.close();

        } catch (Exception e) {
            System.out.println(e);
        }
        return "redirect:read";
    }


    @RequestMapping("/get")
    public String getById(@RequestParam Integer id, Model model) {
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();
            Blog blog = session.get(Blog.class, id);
            session.getTransaction().commit();
            session.close();
            model.addAttribute("blog", blog);

        } catch (Exception e) {
            System.out.println(e);
        }

        return "retrieve";
    }

    @RequestMapping("/update")
    public String update(@RequestParam Integer id, @RequestParam String title, @RequestParam String description) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Blog blog = session.get(Blog.class, id);
       blog.setTitle(title);
       blog.setDescription(description);
       session.update(blog);
       session.getTransaction().commit();
       session.close();
       return "redirect:read";

    }
    @RequestMapping("/search")
    public String search(@RequestParam String title, Model model){
        List<Blog> blogList =  new LinkedList<Blog>();

       Session session =  sessionFactory.getCurrentSession();
       session.beginTransaction();
        blogList  =  session.createQuery("from Blog b where b.title=:title").setParameter("title",title).list();
        session.getTransaction().commit();
        session.close();

        model.addAttribute("searchList" ,blogList);
        return "searchList";

    }
    @RequestMapping("/s")
    public String searchByTitle(){
        return "search";
    }

}
