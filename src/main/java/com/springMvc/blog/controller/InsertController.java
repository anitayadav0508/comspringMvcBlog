package com.springMvc.blog.controller;

import com.springMvc.blog.entity.Book;
import com.springMvc.blog.entity.BookDetail;
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
@RequestMapping("/insert")
public class InsertController {

    @RequestMapping("/data")
    public String data(Model model , @RequestParam(name = "name") String name,
                       @RequestParam(name = "no_of_pages") Integer no_of_pages,@RequestParam(name = "title")String title){
        SessionFactory sessionFactory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Book.class)
                .addAnnotatedClass(BookDetail.class).buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();
            Book book = new Book(name);
            BookDetail bookDetail = new BookDetail(title,no_of_pages);
            book.setBookDetail(bookDetail);
            session.save(book);
            model.addAttribute("msg","data added Sucessfully");
            session.getTransaction().commit();
            session.close();

        }catch (Exception e){
            System.out.println(e);
        }

        return "sucess";

    }


    @RequestMapping("/fetch")
    public String fetch(Model model){
//        List<Book> books = new LinkedList<Book>();
        List<BookDetail> bookDetails = new LinkedList<BookDetail>();

        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Book.class)
                .addAnnotatedClass(BookDetail.class).buildSessionFactory();
      Session session =   sessionFactory.getCurrentSession();

      try {
          session.beginTransaction();

//          books = (List<Book>)session.createQuery("from Book").list();
          bookDetails = (List<BookDetail>)session.createQuery("from BookDetail").list();
          System.out.println("bookDetails");
          for(BookDetail bookDetail : bookDetails){
              System.out.println(bookDetail);
          }

//          model.addAttribute("listofbooks",books);
          model.addAttribute("listofbooks",bookDetails);
          session.getTransaction().commit();
          session.close();

      }catch (Exception e){

          e.printStackTrace();
      }

   return "display";
    }

    @RequestMapping("/home")
    public String home(){
        return "add";
    }
}
