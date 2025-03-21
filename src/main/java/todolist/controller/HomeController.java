package todolist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import todolist.authentication.ManagerUserSession;
import todolist.dto.UsuarioData;
import todolist.service.UsuarioService;

@Controller
public class HomeController {

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    ManagerUserSession managerUserSession;

    @GetMapping("about")
    public String about(Model model) {
        Long userId = managerUserSession.usuarioLogeado();
        UsuarioData user = null;
        boolean userIsLoggedIn = userId != null;
        if (userId != null) {
            user = usuarioService.findById(userId);
        }

        model.addAttribute("userIsLoggedIn", userIsLoggedIn);
        model.addAttribute("user",user);
        return "about";
    }
}
