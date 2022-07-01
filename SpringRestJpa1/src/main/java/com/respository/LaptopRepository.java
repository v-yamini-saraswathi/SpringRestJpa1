package com.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entity.Laptop;

@Repository
public interface LaptopRepository extends JpaRepository<Laptop,Integer>
{
	
	

}
