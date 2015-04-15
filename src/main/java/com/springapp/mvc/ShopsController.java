package com.springapp.mvc;

import com.springapp.entity.Shop;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/shop")
public class ShopsController {

    @RequestMapping(value = "{name}",method = RequestMethod.GET)
    public @ResponseBody Shop getAction(@PathVariable String name, @RequestParam float age){
        String message =
                new StringBuilder(200)
                        .append(name)
                        .append(" is")
                        .append(age)
                        .append(" decades old")
                        .toString();

        Shop shop = new Shop();
        shop.setName(message);
        shop.setStaffName(new String[]{"Joao", "Joana"});

        return shop;
    }
}
