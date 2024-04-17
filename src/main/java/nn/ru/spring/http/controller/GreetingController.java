package nn.ru.spring.http.controller;

import nn.ru.spring.database.repository.CompanyRepository;
import nn.ru.spring.dto.UserReadDto;
import org.postgresql.jdbc.PreferQueryMode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/api/v1")
@SessionAttributes({"user"})
public class GreetingController {

    @GetMapping("/hello")
    public ModelAndView hello(ModelAndView modelAndView, HttpServletRequest request) {
//        request.getSession().setAttribute(); // sessionScope
//        request.setAttribute();              // requestScope
//        request.getSession().getAttribute("user");
        modelAndView.setViewName("greeting/hello");
        modelAndView.addObject("user", new UserReadDto(1L, "Ivan"));

        return modelAndView;
    }

    @GetMapping("/hello/{id}")
    public ModelAndView hello2(ModelAndView modelAndView, HttpServletRequest request,
                              @RequestParam Integer age,
                              @RequestHeader String accept,
                              @CookieValue("JSESSIONID") String jsessionId,
                              @PathVariable("id") Integer id) {
        String ageParamValue = request.getParameter("age");
        String acceptHeader = request.getHeader("accept");
        Cookie[] cookies = request.getCookies();

        modelAndView.setViewName("greeting/hello");

        return modelAndView;
    }

    @GetMapping("bye")
//    @RequestMapping(value = "/bye", method = RequestMethod.GET)
    public ModelAndView bye(@SessionAttribute("user") UserReadDto user) {
//        request.getSession().getAttribute("user");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("greeting/bye");


        return modelAndView;
    }
}
