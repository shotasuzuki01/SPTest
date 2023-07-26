package com.example.form;
import lombok.Data;

	/**
	 * ユーザー情報のFormクラス
	 */
@Data
public class UserListForm {
	private String name;
	private String furigana;
	private String mail;
	private String pss;

}
