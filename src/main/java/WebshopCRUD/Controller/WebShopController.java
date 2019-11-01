package WebshopCRUD.Controller;

import WebshopCRUD.Model.Product;
import WebshopCRUD.Repository.ProductRepository;
import WebshopCRUD.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class WebShopController {

    @Autowired
    ProductService productService;
    @Autowired
    ProductRepository productRepository;

   @GetMapping("/")
    public String index (Model model) {

       model.addAttribute("products", productService.getAllProducts());
       return "index";
   }

   @GetMapping("/create")
    public String showCreate()
    {
     return "create";
    }

   @PostMapping("/create")
    public String createProduct (@ModelAttribute Product product)
   {
       productService.addProduct(product);
       //Sikre mod refresh problem.
       return "redirect:/";
   }

   //GetMapping til delete, tager {id} og så som PathVariable så den kan finde id´et og slette det i databasen
   @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id)
    {
        productService.deleteProduct(id);
        return "redirect:/";
    }

    @GetMapping("/update/{id}")
        public String update(@PathVariable("id") int id, Model model)
    {
        model.addAttribute("products",productService.findProductById(id));
        return "/update";
    }
    @PostMapping("/update")
    public String updateDoIt(@ModelAttribute Product product, int id) {
        //kald update service
        productService.updateProduct(product);
        //sikr mod refresh fejl og sletter igen
        return "redirect:/";
    }
}
