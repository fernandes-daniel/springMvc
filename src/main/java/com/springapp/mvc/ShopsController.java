package com.springapp.mvc;

import com.springapp.entity.Shop;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/shop")
public class ShopsController {

    @RequestMapping(value = "{name}",method = RequestMethod.GET)
    public @ResponseBody Shop getAction(@PathVariable String name){
        Shop shop = new Shop();
        shop.setName(name);
        shop.setStaffName(new String[]{"Maria", "Manel"});
        return shop;
    }
}
