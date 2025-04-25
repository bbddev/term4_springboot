package fpt.aptech.day2.controller;

import fpt.aptech.day2.dto.ProductDTO;
import fpt.aptech.day2.models.Product;
import fpt.aptech.day2.services.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {
    HomeService service;

    @Autowired
    public HomeController(HomeService service) {
        this.service = service;
    }
    @Value("${upload.path}")
    private String fileUpload;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("pList", service.getProducts());
        model.addAttribute("pList2", service.getManufacturers());
        return "index";
    }

    @GetMapping("create")
    public String create(Model model) {
        model.addAttribute("product",new Product());
        return "create";
    }

    @PostMapping("save")
    public String create(Model model,@ModelAttribute("product") ProductDTO product) {

        return "create";
    }
}
