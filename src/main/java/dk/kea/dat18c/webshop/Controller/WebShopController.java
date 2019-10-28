package dk.kea.dat18c.webshop.Controller;

import dk.kea.dat18c.webshop.Model.Product;
import dk.kea.dat18c.webshop.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class WebShopController {

    @Autowired
    ProductService productService;

   @GetMapping("/")
    public String index (Model model) {

       model.addAttribute("products", productService.getAllProducts());
       return "index";
   }



}
