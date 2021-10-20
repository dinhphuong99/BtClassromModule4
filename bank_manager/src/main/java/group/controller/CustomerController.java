package group.controller;

import group.model.Customer;
import group.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;

    @GetMapping("")
    public ModelAndView list(){
        List<Customer> customerList = customerService.findAll();
        ModelAndView modelAndView = new ModelAndView("/list");
        modelAndView.addObject("customer",new Customer());
        modelAndView.addObject("customerList", customerList);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView create(){
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("customer",new Customer());
        return modelAndView;
    }

    @PostMapping("/save")
    public ModelAndView save(Customer customer) {
        customerService.save(customer);
        return list();
    }

    @GetMapping ("/edit/{id}")
    public String edit (@PathVariable("id") int id, Model model) {
        Optional<Customer> customer = customerService.findById(id);
        model.addAttribute("customer",customer.get());
        return "/edit";
    }

    @PostMapping("/edit")
    public ModelAndView edit (Customer customer) {
        customerService.save(customer);
        return list();
    }

    @GetMapping("/delete/{id}")
    public ModelAndView deleteItem (@PathVariable ("id")int id){
        customerService.remove(id);
        return list();
    }
}
