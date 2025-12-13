package com.dialltay.aztrainning;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {
    private final TaskService taskService;

    public HomeController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping({ "", "index.html", "index" })
    public String home(Model model) {
        model.addAttribute("tasks", taskService.getAllTasks());
        return "index";
    }

}
