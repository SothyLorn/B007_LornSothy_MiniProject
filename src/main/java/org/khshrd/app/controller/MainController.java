package org.khshrd.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.khshrd.app.model.User;
import org.khshrd.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/admin")
public class MainController {
	private UserService userService;
	User user = new User();
	List<User> users = new ArrayList<>(); 
	

	@Autowired
	public MainController(UserService userService) {
		this.userService = userService;
	}
	//update
	@GetMapping("/user-edit")
	public String edit(ModelMap model, @RequestParam("hashcode") String hashcode) {
		User user=userService.findOne(hashcode);
		model.addAttribute("user", user);
		model.addAttribute("addStatus", false);
		System.out.println(user.getHashcode());
		return "/admin/user-cu";
	}
//	@RequestMapping("/user-edit")
//	public String tosEdit(String hashcode, ModelMap model){
//		return "/admin/user-list";
//	}
	@RequestMapping("/user/remove")
	public String remove(@RequestParam("hashcode") String user_hash) {
//		int confirm=JOptionPane.showConfirmDialog(null, "Are You Sure", "Delete", JOptionPane.YES_NO_OPTION);
//		if(confirm==JOptionPane.YES_OPTION){
//			
//			userserivce.delete(user_hash);
//		}
		if(userService.delete(user_hash)){
			System.out.println("Success");
		}
		return "redirect:/admin/user-list";
	}
	
	@RequestMapping(value="/update/{hashcode}")
	public String update(@ModelAttribute("user") User user,@PathVariable("hashcode") String hashcode) {		
		user.setUser_has(hashcode);
		
		userService.update(user);		
		System.out.println(user.getHashcode());
		return "redirect:/admin/user-list";
	}
	@RequestMapping("/user-cu")
	public String user_cu(ModelMap model){
		
		model.addAttribute("user", new User());
		model.addAttribute("addStatus", true);
		return "admin/user-cu";
	}
	/**
	 * save data from form to database
	 * @param user
	 * @param model
	 * @return
	 */
	@PostMapping("/user-list")
	public String userlist(@ModelAttribute User user, ModelMap model){
		model.addAttribute("user", userService.save(user));
		return "redirect:/admin/user-list";
	
	}
	@RequestMapping
    public List<User>getAllUser(){
    	return userService.getAllUser();
    }
	@RequestMapping("/user-list")
	public String UserList(ModelMap model){
		users = userService.getAllUser();
		
		model.addAttribute("USERS", users);
		return "admin/user-list";
	}
	@RequestMapping(value = "/user/aid{hashcode}")
	public String detailpage(ModelMap model, @RequestParam("hashcode") String hashcode) {
		User user = userService.findOne(hashcode);
		System.out.println(hashcode);
		model.addAttribute("USER", user);
		return "/admin/userdetail";
	}
}
