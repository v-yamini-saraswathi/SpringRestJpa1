package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.entity.Laptop;
import com.respository.CoderRepository;
import com.respository.LaptopRepository;

@Service
public class LaptopService {
	
	@Autowired//autowires the object when dealing with the dependancy
	LaptopRepository laptoprepo;
	
	public Laptop addLaptop(Laptop l){
		
		 laptoprepo.save(l);
		return l;
		
	}

}
