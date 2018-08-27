package com.example.controller;

import com.example.entity.Book;
import com.example.entity.Test;
import com.example.service.BookService;
import com.example.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class TestController {
    @Autowired
    BookService bookService;

    @RequestMapping(value = "/test_page",method = RequestMethod.GET)
    public String test_query(Model model){
        List<Book> list = bookService.selectAllBook();
        model.addAttribute("list",list);
        return "test_page";
    }

//    @RequestMapping(value = "/test_page_by_testName",method = RequestMethod.GET)
//    public String test_query_by_testName(@RequestParam("testName") String testName,Model model) {
//        List<Test> list = testService.selectBytestName(testName);
//        model.addAttribute("list", list);
//        return "test_page";
//    }
}
