package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.model.City;
import com.example.service.IParcelService;

@Controller
@RequestMapping("/parcel")
public class ParcelController {

	@Autowired
	private IParcelService parcelCRUD;

//	i. Get - /parcel/show/customer/{id}
	@GetMapping("/show/customer/{id}") // localhost:8080/parcel/show/customer/1
	public String getParcelByCustomerId(@PathVariable("id") int id, Model model) {
		try {
			model.addAttribute("parcel", parcelCRUD.selectAllParcelsByCustomerId(id));
			return "parcel-one-page";
		} catch (Exception e) {
			model.addAttribute("msg", e.getMessage());
			e.printStackTrace();
			return "error-page";
		}
	}

//	ii. Get - /parcel/show/driver/{id}
	@GetMapping("/show/driver/{id}") // localhost:8080/parcel/show/driver/4
	public String getParcelByDriverId(@PathVariable("id") int id, Model model) {
		try {
			model.addAttribute("parcel", parcelCRUD.selectAllParcelsDeliveredByDriverId(id));
			return "parcel-one-page";
		} catch (Exception e) {
			model.addAttribute("msg", e.getMessage());
			e.printStackTrace();
			return "error-page";
		}
	}

//	iii. Get - /parcel/show/price/{threshold}
	@GetMapping("/show/price/{threshold}") // localhost:8080/parcel/show/price/5
	public String getParcelByPrice(@PathVariable("threshold") float threshold, Model model) {
		try {
			model.addAttribute("parcel", parcelCRUD.selectAllParcelsPriceLessThan(threshold));
			return "parcel-one-page";
		} catch (Exception e) {
			model.addAttribute("msg", e.getMessage());
			e.printStackTrace();
			return "error-page";
		}
	}

//	iv. Get - /parcel/show/city/{cityparam}
	@GetMapping("/show/city/{cityparam}") // localhost:8080/parcel/show/city/Ventspils
	public String getParcelByCity(@PathVariable("cityparam") City cityparam, Model model) {
		try {
			model.addAttribute("parcel", parcelCRUD.selectAllParcelsDeliveredToCity(cityparam));
			return "parcel-one-page";
		} catch (Exception e) {
			model.addAttribute("msg", e.getMessage());
			e.printStackTrace();
			return "error-page";
		}
	}
//	v. Get un Post - /parcel/add/{customercode}/{driverid}

//	vi. Get - /parcel/change/{parcelid}/{driverid}

//	vii. Get - /parcel/calculate/income/{customerid}

//	viii. Get - /parcel/calculate/count/today

}
