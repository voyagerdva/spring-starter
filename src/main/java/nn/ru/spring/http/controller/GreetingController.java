package nn.ru.spring.http.controller;

import nn.ru.spring.dto.UserReadDto;
import org.springframework.context.support.BeanDefinitionDsl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;

import nn.ru.spring.database.entity.Role;

@Controller
@RequestMapping("/api/v1")
@SessionAttributes({"user"})
public class GreetingController {

    @ModelAttribute("roles")
    public List<Role> roles() {
        return Arrays.asList(Role.values());
    }

    @GetMapping("/hello")
    public String hello(Model model,
                        HttpServletRequest request,
                        @ModelAttribute("userReadDto") UserReadDto userReadDto) {
//        request.getSession().setAttribute(); // sessionScope
//        request.setAttribute();              // requestScope
//        request.getSession().getAttribute("user");
        model.addAttribute("user", new UserReadDto(1L, "Ivan"));

        return "greeting/hello";
    }

//    @GetMapping("/hello/{id}")
//    public ModelAndView hello2(ModelAndView modelAndView, HttpServletRequest request,
//                              @RequestParam Integer age,
//                              @RequestHeader String accept,
//                              @CookieValue("JSESSIONID") String jsessionId,
//                              @PathVariable("id") Integer id) {
//        String ageParamValue = request.getParameter("age");
//        String acceptHeader = request.getHeader("accept");
//        Cookie[] cookies = request.getCookies();
//
//        modelAndView.setViewName("greeting/hello");
//
//        return modelAndView;
//    }

    @GetMapping("bye")
    public String bye(@SessionAttribute("user") UserReadDto user, Model model) {
//        request.getSession().getAttribute("user");
        return "greeting/bye";
    }
}
