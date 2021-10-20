package group.controller;

import group.model.Transfer;
import group.model.Withdraw;
import group.service.transfer.ITransferService;
import group.service.withdraw.IWithdrawService;
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
public class WithdrawController {
    @Autowired
    private IWithdrawService withdrawService;

    @GetMapping("")
    public ModelAndView list(){
        List<Withdraw> withdrawList = withdrawService.findAll();
        ModelAndView modelAndView = new ModelAndView("/list");
        modelAndView.addObject("withdraw",new Withdraw());
        modelAndView.addObject("withdrawList", withdrawList);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView create(){
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("withdraw",new Withdraw());
        return modelAndView;
    }

    @PostMapping("/save")
    public ModelAndView save(Withdraw withdraw) {
        withdrawService.save(withdraw);
        return list();
    }

    @GetMapping ("/edit/{id}")
    public String edit (@PathVariable("id") int id, Model model) {
        Optional<Withdraw> withdraw = withdrawService.findById(id);
        model.addAttribute("withdraw",withdraw.get());
        return "/edit";
    }

    @PostMapping("/edit")
    public ModelAndView edit (Withdraw withdraw) {
        withdrawService.save(withdraw);
        return list();
    }

    @GetMapping("/delete/{id}")
    public ModelAndView deleteItem (@PathVariable ("id")int id){
        withdrawService.remove(id);
        return list();
    }
}