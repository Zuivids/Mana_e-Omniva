package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.model.Driver;
import com.example.service.IDriverCRUDService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/driver")
public class DriverController {

	@Autowired
	private IDriverCRUDService driverCRUD;

	@GetMapping("/show/all") // localhost:8080/driver/show/all
	public String getDriverList(Model model) {
		try {
			model.addAttribute("drivers", driverCRUD.selectAllDriver());
			return "driver-all-page";
		} catch (Exception e) {
			model.addAttribute("msg", e.getMessage());
			e.printStackTrace();
			return "error-page";
		}
	}

	@GetMapping("/show/all/{id}") // localhost:8080/driver/show/all/4
	public String getDriverById(@PathVariable("id") int id, Model model) {
		try {
			
			model.addAttribute("driver", driverCRUD.selectDriverById(id));
			return "driver-one-page";
		} catch (Exception e) {
			model.addAttribute("msg", e.getMessage());
			e.printStackTrace();
			return "error-page";
		}
	}

	@GetMapping("/remove/{id}") // localhost:8080/driver/remove/4
	public String getDriverDeleteById(@PathVariable("id") int id, Model model) {
		try {
			driverCRUD.deleteDriverById(id);
			
			model.addAttribute("drivers", driverCRUD.selectAllDriver());
			return "driver-all-page";
		} catch (Exception e) {
			model.addAttribute("msg", e.getMessage());
			e.printStackTrace();
			return "error-page";
		}
	}

	@GetMapping("/add") // localhost:8080/driver/add
	public String getDriverInsert(Model model) {
		model.addAttribute("driver", new Driver());
		return "driver-add-page";
	}

	@PostMapping("/add")
	public String postDriverInsert(@Valid Driver driver, BindingResult result) {
		if (result.hasErrors()) {
			return "driver-add-page";
		}
		try {
			driverCRUD.insertNewDriver(driver);
		} catch (Exception e) {
			return "driver-add-page";
		}
		return "redirect:/driver/show/all";
	}

	@GetMapping("/update/{id}") // localhost:8080/driver/update/1
	public String getDriverUpdateById(@PathVariable("id") int id, Model model) {
		try {
			Driver driver = driverCRUD.selectDriverById(id);
			model.addAttribute("driver", driver);
			model.addAttribute("id", id);
			return "driver-update-page";
		} catch (Exception e) {
			model.addAttribute("msg", e.getMessage());
			return "error-page";
		}
	}

	@PostMapping("/update/{id}")
	public String postDriverUpdateById(@PathVariable("id") int id, @Valid Driver driver, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			return "driver-update-page";
		} else {
			try {
				driverCRUD.updateDriverById(id, driver);
				return "redirect:/driver/show/all";
			} catch (Exception e) {
				model.addAttribute("msg", e.getMessage());
				return "error-page";
			}
		}

	}

}
