package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.dto.UserRequest;
import com.example.dto.UserUpdateRequest;
import com.example.service.UserListService;

/**
	 * ユーザー情報 Controller
	 */
@Controller
public class UserController {

	/**
	   * ユーザー情報 Service
	   */
	@Autowired
	private UserListService userService;

	/**
	  * ユーザー新規登録画面を表示
	  * @param model Model
	  * @return ユーザー新規登録画面
	  */
	@GetMapping(value = "/UserRegister")
	public String displayAdd(Model model) {
		model.addAttribute("userRequest", new UserRequest());
		return "UserRegister";
	}

	/**
	   * ユーザー新規登録
	   * @param userRequest リクエストデータ
	   * @param model Model
	   * @return ユーザー情報一覧画面
	   * */
	@RequestMapping(value = "/user/create", method = RequestMethod.POST)
	public String cretate( UserRequest userRequest, BindingResult result, Model model) {
		// ユーザー情報の登録
		userService.create(userRequest);
		return "/userList";
	}
	 /**
	   * ユーザー編集画面を表示
	   * @param id 表示するユーザーID
	   * @param model Model
	   * @return ユーザー編集画面
	   *
	@GetMapping("/{id}/UserRegisterEdit")
	public String displayEdit(@PathVariable Long id, Model model) {
	    com.example.entity.User user = userService.findById(id);
	    UserUpdateRequest userUpdateRequest = new UserUpdateRequest();
	    userUpdateRequest.setId(user.getId());
	    userUpdateRequest.setName(user.getName());
	    userUpdateRequest.setFurigana(user.getFurigana());
	    userUpdateRequest.setMail(user.getMail());
	    model.addAttribute("userUpdateRequest", userUpdateRequest);
	    return "UserRegisterEdit";
	  }
	  */
	  /**
	   * ユーザー更新
	   * @param userRequest リクエストデータ
	   * @param model Model
	   * @return ユーザー情報詳細画面
	   */
	@RequestMapping(value = "/user/update", method = RequestMethod.POST)
	  public String update( UserUpdateRequest userUpdateRequest, BindingResult result, Model model) {
	      return "UserRegisterEdit";
	    }









}
