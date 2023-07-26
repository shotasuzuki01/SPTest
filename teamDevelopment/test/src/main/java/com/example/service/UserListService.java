package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dto.UserRequest;
import com.example.dto.UserUpdateRequest;
import com.example.entity.User;
import com.example.repository.UserRepository;

/**
 * ユーザー情報 Service
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class UserListService {
	  /**
	   * ユーザー情報 Repository
	   */
	@Autowired
	private UserRepository userRepository;

	  /**
	   * ユーザー情報 新規登録
	   * @param user ユーザー情報
	   */

	public void create(UserRequest userRequest) {
		User user=new User();
		user.setName(userRequest.getName());
		user.setFurigana(userRequest.getFurigana());
		user.setMail(userRequest.getMail());
		user.setPass(userRequest.getPass());
		userRepository.save(user);
	}
	 /**
	   * ユーザー情報 主キー検索
	   * @return 検索結果
	   */
	  public User findById(Long id) {
	    return userRepository.findById(id).get();
	  }
	  /**
	   * ユーザー情報 更新
	   * @param user ユーザー情報
	   */
	  public void update(UserUpdateRequest userUpdateRequest) {
	    User user = findById(userUpdateRequest.getId());
	    user.setName(userUpdateRequest.getName());
	    user.setFurigana(userUpdateRequest.getFurigana());
	    user.setMail(userUpdateRequest.getMail());
	    user.setPass(userUpdateRequest.getPass());
	    userRepository.save(user);
	  }

}
