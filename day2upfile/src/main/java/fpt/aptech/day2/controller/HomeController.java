package fpt.aptech.day2.controller;

import fpt.aptech.day2.dto.ProductDTO;
import fpt.aptech.day2.models.Manufacturer;
import fpt.aptech.day2.models.Product;
import fpt.aptech.day2.services.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.Map;

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
        model.addAttribute("mList", service.getManufacturers());
        return "index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("mList", service.getManufacturers());
        model.addAttribute("product", new Product());
        return "create";
    }

    @PostMapping("/save")
    public String save(Model model, @ModelAttribute("product") ProductDTO product) throws IOException {
        MultipartFile multipartFile = product.getPhoto();
        String fileName = multipartFile.getOriginalFilename();
        FileCopyUtils.copy(product.getPhoto().getBytes(),
                new File(fileUpload, fileName));
        Product newProduct = new Product(product.getName(), product.getPrice(),
                product.getQuantity(), fileName, product.getCategoryid());

        service.save(newProduct);
        model.addAttribute("pList", service.getProducts());
        model.addAttribute("mList", service.getManufacturers());
        return "redirect:/";
    }

    @GetMapping("/download")
    public ResponseEntity<ByteArrayResource> downloadFile(@RequestParam("fileName") String fileName) throws IOException {
        File file = new File(fileUpload + "/" + fileName);
        ByteArrayResource resource = new ByteArrayResource(Files.readAllBytes(file.toPath()));
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + file.getName())
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .contentLength(file.length())
                .body(resource);
    }

    @PostMapping("/Filter")
    public String search(Model model, @RequestParam("id") int categoryid) {
        if (categoryid == 0) {
            model.addAttribute("mList", service.getManufacturers());
            model.addAttribute("pList", service.getProducts());
            return "index";
        } else {
            Manufacturer category = service.findManufacturerById(categoryid);
            model.addAttribute("mList", service.getManufacturers());
            List<Product> productList = service.findByIdManufacture(category);
            model.addAttribute("pList", productList);
            return "index";
        }
    }

    @RequestMapping("/checkbox")
    public String DeleteM(@RequestParam("txtId") List<Integer> codeList) {
        service.deleteMProduct(codeList);
        return "redirect:/";
    }
//    @RequestMapping("/Checkbox")
//    public String DeleteM(@RequestParam("txtId") List<Integer> codeList) {
//        service.delConfig(codeList);
//        return "redirect:/";
//    }
}
