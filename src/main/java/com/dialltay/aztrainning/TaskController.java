package com.dialltay.aztrainning;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;
    
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public String getTasks( Model model) {
        model.addAttribute("task", new Task());
        return "taskForm";
    }

    @PostMapping
    public String createTask(@ModelAttribute Task task, Model model, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "taskForm";
        }
        this.taskService.addTask(task);
        model.addAttribute("successMessage", "Task created successfully!");
        return "index";
    }
}
