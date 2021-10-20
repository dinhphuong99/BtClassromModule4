package group.controller;

import group.model.Transfer;
import group.service.transfer.ITransferService;
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
public class TransferController {
    @Autowired
    private ITransferService transferService;

    @GetMapping("")
    public ModelAndView list(){
        List<Transfer> transferList = transferService.findAll();
        ModelAndView modelAndView = new ModelAndView("/list");
        modelAndView.addObject("transfer",new Transfer());
        modelAndView.addObject("transferList", transferList);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView create(){
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("transfer",new Transfer());
        return modelAndView;
    }

    @PostMapping("/save")
    public ModelAndView save(Transfer transfer) {
        transferService.save(transfer);
        return list();
    }

    @GetMapping ("/edit/{id}")
    public String edit (@PathVariable("id") int id, Model model) {
        Optional<Transfer> transfer = transferService.findById(id);
        model.addAttribute("transfer",transfer.get());
        return "/edit";
    }

    @PostMapping("/edit")
    public ModelAndView edit (Transfer transfer) {
        transferService.save(transfer);
        return list();
    }

    @GetMapping("/delete/{id}")
    public ModelAndView deleteItem (@PathVariable ("id")int id){
        transferService.remove(id);
        return list();
    }
}