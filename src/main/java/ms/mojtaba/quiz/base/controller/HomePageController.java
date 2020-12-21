package ms.mojtaba.quiz.base.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomePageController {

    @GetMapping
    public ModelAndView homePage(){
        return new ModelAndView("home");
    }
}
