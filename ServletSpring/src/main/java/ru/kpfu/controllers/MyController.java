package ru.kpfu.controllers;

import com.sun.org.glassfish.gmbal.ParameterNames;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.kpfu.entities.UserValid;
import ru.kpfu.service.CalculateInterface;
import ru.kpfu.service.CalculateService;
import ru.kpfu.service.Services;
import ru.kpfu.service.UserValidator;

import java.util.Locale;

/**
 * Created by Anatoly on 28.02.2017.
 */
@Controller
public class MyController {
    @Autowired
    private CalculateInterface calculateService;
    @Autowired
    private Services services;
    @Autowired
    private MessageSource messageSource;

    @InitBinder
    private void initBinder(WebDataBinder binder) {
        binder.setValidator(new UserValidator());
    }

    @RequestMapping("/")
    public String index(ModelMap map) {

        map.put("viewVariable", "Index action");
        return "calculator";
    }

    @RequestMapping("/a")
    @ResponseBody
    public String responseBody() {
        return "Something text";
    }

    @RequestMapping("/calc")
    public String calculate(@RequestParam("value1") String value1, @RequestParam("operation") String operation,
                            @RequestParam("value2") String value2, ModelMap map) {
        if (services.validate(value1) && services.validate(value2)) {
            String result = String.valueOf(calculateService.calculate(value1, operation, value2));
            map.put("result", result);
        } else {
            map.put("error", "Enter correct values");
        }
        return "calculator";
    }

    @RequestMapping("/feedback")
    public String feedback(ModelMap map) {
        map.put("viewVariable", "You sent us a letter");
        return "index";
    }

    @RequestMapping("/information")
    public String informationAboutUs(ModelMap map) {
        map.put("viewVariable", "Hlopunov Anatoliy \n 89375239703");
        return "index";
    }

    @RequestMapping(value = "/reg", method = RequestMethod.GET)
    public String registration(ModelMap map, Locale locale) {
        map.put("user", new UserValid());
        System.out.println(locale.getLanguage());
//        System.out.println(messageSource.getMessage("locale", new String[]{locale.getDisplayName(locale)},locale));
        return "registration_valid";
    }

    @RequestMapping(value = "/reg", method = RequestMethod.POST)
    public String springHandler(
            RedirectAttributes redirectAttributes,
            @Validated @ModelAttribute("user") UserValid user,
            BindingResult result,
            ModelMap map){
                if(result.hasErrors()){
                    return "registration_valid";
                }else {
                    redirectAttributes.addFlashAttribute("message", "<span style=\"color:green\">Author \"" + user.getName()  + "\" has been added successfully</span>");
                    return "redirect:" + MvcUriComponentsBuilder.fromMappingName("MC#registration").build();
                }
    }
}