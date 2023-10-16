package com.pro.service;

import java.util.List;

import com.pro.Dto.Dto;
import com.pro.model.Manage;


public interface Service {
	public Manage create(Dto dto);
	public List<Dto> viewall();
	public Dto update (Dto dto ,int id) ;
	public String delete(int id);
	public Dto byId(int id);
}
