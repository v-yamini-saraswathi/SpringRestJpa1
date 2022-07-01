package com.service;

import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.advices.ResourceNotFoundException;
import com.entity.Coder;
import com.respository.CoderRepository;

@Service
public class CoderService {
	
	@Autowired//autowires the object when dealing with the dependancy
	CoderRepository coderrepo;
	
	public List<Coder> getCoders()
	{
		List<Coder> lc=coderrepo.findAll();
		return lc;
	}
	
	public Coder addCoder(Coder c)
	{
		Coder c1=coderrepo.save(c);
		return c1;
	}
	
	public List<Coder> addCoders(List<Coder> lc)
	{
		List<Coder> lc1=coderrepo.saveAll(lc);
		return lc1;
	}
	
	public String deleteCoderById(int cid)throws Throwable
	{
		
		Supplier s1=()->new ResourceNotFoundException("Coder Does not exist in the database");
		Coder c1=coderrepo.findById(cid).orElseThrow(s1);
		coderrepo.deleteById(cid);
		return "Deleted";
	}
	
	public String deleteCoder(Coder c)throws Throwable
	{
		int id=c.getCid();
		Supplier s1=()->new ResourceNotFoundException("Coder Does not exist in the database");
		Coder c1=coderrepo.findById(id).orElseThrow(s1);
		coderrepo.delete(c1);
		return "Deleted";
	}
	
	public Coder updateCoder(Coder c) throws Throwable
	{
		
		int id=c.getCid();
		
		Supplier s1=()->new ResourceNotFoundException("Coder Does not exist in the database");
		
		Coder c1=coderrepo.findById(id).orElseThrow(s1);
		
		c1.setCname(c.getCname());
		c1.setTech(c.getTech());
		coderrepo.save(c1);
		return c1;
		
	}
	
	public Coder getCoderById(int cid) throws Throwable
	{
		Supplier s1=()->new ResourceNotFoundException("Coder Does not exist in the Database");
		Coder c1=coderrepo.findById(cid).orElseThrow(s1);
		return c1;
	}
	public Coder getCoderByCname(String cname) throws Throwable
	{
		Coder c=coderrepo.getCoderByCname(cname);
		if(c!=null)
		{
			return c;
		}
		else {
			throw new ResourceNotFoundException("Coder Does not exist in the Database");
		}
		
	}
	
	public List<Coder> getCoderByTechSorted(String tech) throws Throwable
	{
		
		List<Coder> lc=coderrepo.getCoderByTechSorted(tech);
		if(lc.size()!=0) 
		{
			return lc;
		}
		else{
			throw new ResourceNotFoundException("Coder Does not exist in the Database");
		}
		
	}
	public String deleteCoders(List<Coder>c)throws Throwable
	{
		if(c.isEmpty()) {
			throw new ResourceNotFoundException("Coder Does not exist in the Database");
		}
		coderrepo.deleteAll(c);
		return "Deleted";
	}
}
