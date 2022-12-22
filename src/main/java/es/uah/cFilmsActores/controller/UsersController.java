package es.uah.cFilmsActores.controller;


import es.uah.cFilmsActores.model.Actor;
import es.uah.cFilmsActores.model.User;
import es.uah.cFilmsActores.paginator.PageRender;
import es.uah.cFilmsActores.service.IUsersService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.logging.Logger;

@Controller
@RequestMapping("/users")
public class UsersController {

    @Autowired
    IUsersService usersService;


@GetMapping (value = "/all")
public String usersList (Model model, @RequestParam(name = "page", defaultValue = "0") int page)   {
    Pageable pageable = PageRequest.of(page, 6);
    Page<User> all = usersService.findAll(pageable);
    PageRender<User> pageRender = new PageRender<User>("/users/all", all);
    model.addAttribute ( "title", "listado de todos los usuarios");
    model.addAttribute("allUsers", all);
    model.addAttribute("page", pageRender);
    return "users/usersList";
}

@GetMapping("/newUser")
    public String newUser (Model model) {
    model.addAttribute("title", "nuevo usuario");
    User user = new User();
    model.addAttribute("user", user);
    return "users/formUsers";
}


@GetMapping ("/search")
    public String search (Model model) {
    return "users/searchUser";
}

            @GetMapping ("/iduser/{id}")
    public String findUserById (Model model, @PathVariable("id") Integer id) {
    User user = usersService.findUserById(id);
    model.addAttribute("user", user);
    return "formUsers";
            }

            @GetMapping ("/username")
    public String findUserByUsername (Model model, @RequestParam("username") String username) {
    User user = usersService.findUserByUsername(username);
    model.addAttribute("username", "listado de usuarios por username");
    model.addAttribute("user", user);
    return "users/usersList";

            }

    @GetMapping ("/email")
    public String findUserByEmail (Model model, @RequestParam("email") String email) {
        User user = usersService.findUserByEmail(email);
        model.addAttribute("email", "listado de usuarios por email");
        model.addAttribute("user", user);
        return "users/usersList";

    }

    @PostMapping("/save")
    public String saveUser(Model model, User user, RedirectAttributes attributes)  {
    usersService.saveUser(user);
    model.addAttribute("title", "nuevo usuario");
    attributes.addFlashAttribute("msg", "los datos del usuario fueron guardados !");
    return "redirect:/users/all";
    }


    @GetMapping("edit/{id}")
    public String editUser(Model model, @PathVariable("id") Integer id) {
    User user = usersService.findUserById(id);
    model.addAttribute("titule", "Editar Usuario");
    model.addAttribute("user", user);
    return "users/formUsers";
    }

    @GetMapping ("/delete/{id}")
    public String deleteUser(Model model, @PathVariable("id")Integer id, RedirectAttributes attributes){
    usersService.deleteUser(id);
    attributes.addFlashAttribute("msg", "los datos del usuario fueron borrados!");
    return "redirect:/users/allUsers";
    }





}