package ev.controller;

import ev.domain.BookInfo;
import ev.service.BookInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/info/bookInfo")
public class BookInfoController {

    @Autowired
    private BookInfoService bis;

    @RequestMapping("/findAll")
    public String findAll(Model model){
        List<BookInfo> bisAll = bis.findAll();
        model.addAttribute("bisAll",bisAll);
        return "list";
    }

    @RequestMapping("/add")
    public String addBookInfo(BookInfo bookInfo){
        bis.addBookInfo(bookInfo);
        return "redirect:findAll";
    }

    @RequestMapping("/update")
    public String updateBookInfo(BookInfo bookInfo){
        bis.updateBookInfo(bookInfo);
        return "redirect:findAll";
    }

    @RequestMapping("/delete")
    public String deleteBookInfo(int id){
        bis.deleteBookInfo(id);
        return "redirect:findAll";
    }

    @RequestMapping("findById")
    public String findById(int id,Model model){
        BookInfo bookInfo = bis.findById(id);
        model.addAttribute("bookInfo",bookInfo);
        return "update";
    }

}
