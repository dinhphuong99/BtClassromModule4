package group.controller;

import group.model.Deposit;
import group.service.deposit.IDepositService;
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
@RequestMapping("/deposit")
public class DepositController {
    @Autowired
    private IDepositService depositService;

    @GetMapping("")
    public ModelAndView list(){
        List<Deposit> depositList = depositService.findAll();
        ModelAndView modelAndView = new ModelAndView("/list");
        modelAndView.addObject("deposit",new Deposit());
        modelAndView.addObject("depositList", depositList);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView create(){
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("deposit",new Deposit());
        return modelAndView;
    }

    @PostMapping("/save")
    public ModelAndView save(Deposit deposit) {
        depositService.save(deposit);
        return list();
    }

    @GetMapping ("/edit/{id}")
    public String edit (@PathVariable("id") int id, Model model) {
        Optional<Deposit> deposit = depositService.findById(id);
        model.addAttribute("deposit",deposit.get());
        return "/edit";
    }

    @PostMapping("/edit")
    public ModelAndView edit (Deposit deposit) {
        depositService.save(deposit);
        return list();
    }

    @GetMapping("/delete/{id}")
    public ModelAndView deleteItem (@PathVariable ("id")int id){
        depositService.remove(id);
        return list();
    }
}