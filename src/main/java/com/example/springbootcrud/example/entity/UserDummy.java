package com.example.springbootcrud.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDummy {
	private String name;
    private String hp;
    private String email;
    private List<String> alamat;
    
    public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getHp() {
		return hp;
	}
	public void setHp(String hp) {
		this.hp = hp;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<String> getAlamat() {
		return alamat;
	}
	public void setAlamat(List<String> alamat) {
		this.alamat = alamat;
	}
}
