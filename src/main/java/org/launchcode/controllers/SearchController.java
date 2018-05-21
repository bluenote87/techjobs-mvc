package org.launchcode.controllers;

import org.launchcode.models.JobData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by LaunchCode
 */
@Controller
@RequestMapping("search")
public class SearchController {

    @RequestMapping(value = "")
    public String search(Model model) {
        model.addAttribute("columns", ListController.columnChoices);
        return "search";
    }

    // TODO #1 - Create handler to process search request and display results
    @RequestMapping(value = "results")
    public String searchResults(Model model, @RequestParam String searchType, @RequestParam String searchTerm) {
        model.addAttribute("columns", ListController.columnChoices);
        // HashMap<String, String> jobsList = new HashMap<>();
        ArrayList<HashMap<String, String>> jobs = new ArrayList<>();
        if (searchType.equals("all")) {
            jobs = JobData.findAll();
            //for (int i = 0; i < jobs.size(); i++) {
            //    HashMap<String, String> hashJob = new HashMap<>();
             //   hashJob = jobs.get(i);
             //   for (Map.Entry<String, String> data : hashJob.entrySet()) {
             //       jobsList.put(data.getKey(), data.getValue());
             //   }
            //}
        }
        model.addAttribute("columns", ListController.columnChoices);
        model.addAttribute("title", "Search Results");
        model.addAttribute("jobs", jobs);
        return "search";
    }
}
