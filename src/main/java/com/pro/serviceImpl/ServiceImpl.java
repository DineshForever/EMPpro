package com.pro.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.pro.Dto.Dto;
import com.pro.model.Manage;
import com.pro.repository.Repository;
import com.pro.service.Service;
@org.springframework.stereotype.Service
public class ServiceImpl implements Service {
	 @Autowired
	    private Repository repo; 
	    @Autowired
	    private ModelMapper modelMapper;

	@Override
	public Manage create(Dto dto) {
		
		Manage man=modelMapper.map(dto, Manage.class);
		 repo.save(man);
		
		return null;
	}

	@Override
	public List<Dto> viewall() {
		 List<Manage> manage = repo.findAll();
	        List<Dto> dtos = new ArrayList<Dto>();
	        for (Manage man : manage) {
	            Dto dto = modelMapper.map(man, Dto.class);
	            dtos.add(dto);
	        }
	        return dtos;
	}

	@Override
	public Dto update(Dto dto, int id) {
		 Manage man = repo.findById(id).orElse(null);
	       
         modelMapper.map(dto, man);
         man = repo.save(man);
         return modelMapper.map(man, Dto.class);
		
	}

	@Override
	public String delete(int id) {
		repo.deleteById(id);
        return "ID was deleted";
	}

	@Override
	public Dto byId(int id) {
		
	        Manage man = repo.findById(id).orElse(null);
	      
	            return modelMapper.map(man, Dto.class);
	}
	

}
