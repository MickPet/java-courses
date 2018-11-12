package rest.resttemplate.restClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.http.client.support.BasicAuthorizationInterceptor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import rest.resttemplate.model.User;
import rest.resttemplate.service.RestTemplateServices;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;


@RestController
public class ClientRestController {

    @Autowired
    private RestTemplateServices restTemplateServices;

    /*@RequestMapping(value = "/admin/update", method = RequestMethod.GET)
    public String updatePage(@RequestParam("update")Long id, Model model) {
        ResponseEntity<User> user = restTemplateServices.getUserById(id);
        model.addAttribute("user", user);
        return "updateModal";
    }*/


    /*@RequestMapping(value = "/admin/update", method = RequestMethod.GET)
    public ModelAndView updateApp(ModelAndView modelAndView, Long id) {
        modelAndView.addObject("user", restTemplateServices.getUserById(id));
        modelAndView.setViewName("updateModal");
        return modelAndView;
    }*/

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public ModelAndView userList(ModelAndView modelAndView) {
        modelAndView.addObject("users", restTemplateServices.showUsers());
        modelAndView.setViewName("userList");
        return modelAndView;
    }

    @RequestMapping(value = "/admin/add", method = RequestMethod.POST)
    public ModelAndView addUser(@RequestBody User user) {
        restTemplateServices.add(user);
        return new ModelAndView("redirect:/admin");
    }

    @RequestMapping(value = "/admin/update", method = RequestMethod.POST)
    public ModelAndView updateUser(User user) {
        restTemplateServices.update(user);
        return new ModelAndView("redirect:/admin");
    }

    /*@RequestMapping(value = "/admin/update", method = RequestMethod.POST)
    public ModelAndView updateUser(@RequestParam("id") String id, @RequestParam("name") String name, @RequestParam("password") String password) {
        User user = restTemplateServices.getUserById(Long.parseLong(id));
        user.setName(name);
        user.setPass(password);
        restTemplateServices.update(user);
        return new ModelAndView("redirect:/admin");
    }*/

    @RequestMapping(value = "/admin/delete", method = RequestMethod.GET)
    public ModelAndView deleteUser(@RequestParam("id") String id) {
        restTemplateServices.delete(id);
        return new ModelAndView("redirect:/admin");
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(ModelAndView modelAndView) {
        modelAndView.setViewName("loginPage");
        return modelAndView;
    }

    @RequestMapping(value = "/applyLogin", method = RequestMethod.POST)
    public ModelAndView applyLogin(HttpServletRequest request) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        restTemplateServices.login(username, password);
        return new ModelAndView("redirect:/admin");
    }

    /*@RequestMapping(value = "/logout", method = RequestMethod.GET)
    public ModelAndView logout() {
        restTemplate.getInterceptors().remove(0);
        return new ModelAndView("redirect:/login");
    }*/
}
