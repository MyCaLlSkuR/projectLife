package by.skuratovich.projectLife.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MainController {

    @GetMapping("/check")
    String check(@RequestParam int id){
        return String.valueOf(id);
    }

}
