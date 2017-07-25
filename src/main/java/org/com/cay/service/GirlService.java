package org.com.cay.service;

import javax.transaction.Transactional;

import org.com.cay.entity.Girl;
import org.com.cay.repository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GirlService {

	@Autowired
	private GirlRepository girlRepository;
	
	@Transactional
	public void insertTwo(){
		Girl girl1 = new Girl();
		girl1.setAge(22);
		girl1.setName("aa");
		girlRepository.save(girl1);
		
		Girl girl2 = new Girl();
		girl2.setAge(32);
		girl2.setName("bbbb");
		girlRepository.save(girl2);
	}
}
