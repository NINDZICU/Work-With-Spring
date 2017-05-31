package ru.kpfu.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.kpfu.filtres.User;

import javax.validation.Valid;

/**
 * Created by Anatoly on 04.04.2017.
 */
//TODO почему то стер User для JSR303 и вместо него теперь User для JPA
@Controller
@RequestMapping("/jsr303")
public class JSR303Controller {
    @RequestMapping(value = "/reg", method = RequestMethod.GET)
    public String registration(ModelMap map) {
        map.put("user", new User());
        return "registration";
    }

    @RequestMapping(value = "/reg", method = RequestMethod.POST)
    public String jsr303Handler(
            RedirectAttributes redirectAttributes,
            @Valid @ModelAttribute("user") User user,
            BindingResult result,
            ModelMap map
    ) {
        if (result.hasErrors()) {
            return "registration";
        } else {
            redirectAttributes.addFlashAttribute("message", "<span style=\"color:green\">Book \"" + user.getName() + "\" has been added successfully</span>");
            return "redirect:"+ MvcUriComponentsBuilder.fromMappingName("JSRC#registration").build();
        }
    }
}

