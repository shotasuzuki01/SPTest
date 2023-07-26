package com.example.service;

import java.util.Date;
import java.util.List;

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
@Transactional(rollbackFor = Exception.class)
public class UserService {

    /**
     * ユーザー情報 Repository
     */
    @Autowired
    UserRepository userRepository;

    /**
     * ユーザー情報 全検索
     * @return 検索結果
     */
    public List<User> searchAll() {
        return userRepository.findAll();
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
      user.setAddress(userUpdateRequest.getAddress());
      user.setName(userUpdateRequest.getName());
      user.setPhone(userUpdateRequest.getPhone());
      userRepository.save(user);
    }
    /**
     * ユーザー情報 物理削除
     * @param id ユーザーID
     */
    public void delete(Long id) {
      User user = findById(id);
      userRepository.delete(user);
    }

    /**
     * ユーザー情報新規登録
     * @param user ユーザー情報
     */
    public void create(UserRequest userRequest) {
        userRepository.save(CreateUser(userRequest));
    }

    /**
     * ユーザーTBLエンティティの生成
     * @param userRequest ユーザー情報リクエストデータ
     * @return ユーザーTBLエンティティ
     */
    private User CreateUser(UserRequest userRequest) {
        Date now = new Date();

        User user = new User();
        user.setName(userRequest.getName());
        user.setAddress(userRequest.getAddress());
        user.setPhone(userRequest.getPhone());
        return user;
    }
}