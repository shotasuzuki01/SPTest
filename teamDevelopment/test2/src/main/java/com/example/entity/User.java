package com.example.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="user2")
public class User{
	/**
	 * ID
	 */
	@Id
	@Column(name="id")
	@GeneratedValue
	private long id;

	/**
	 * 名前
	 */

	@Column(name="name")
	private String name;

	/**
	 *
	 */

	@Column(name="age")
	private Integer age;

	/**
	 *
	 */
	@Column(name="business")
	private String business;


	@Column(name="email")
	private String email;
}
