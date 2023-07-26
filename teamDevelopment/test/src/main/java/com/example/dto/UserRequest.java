package com.example.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Data;

/**
 * ユーザー情報 リクエストデータ
 */
@Data
public class UserRequest implements Serializable{
	 /**
	   * 名前
	   */
	@NotEmpty(message="名前を入力してください")
	@Size(max=100,message="名前は100桁以内で入力してください")
	private String name;

	 /**
	   * フリガナ
	   */
	@NotEmpty(message="フリガナを入力してください")
	@Size(max=100,message="名前は100桁以内で入力してください")
	private String furigana;


	 /**
	   * mail
	   */
	@NotEmpty(message="mailを入力してください")
	private String mail;

	 /**
	   * mail
	   */
	@NotEmpty(message="passを入力してください")
	private String pass;

}
