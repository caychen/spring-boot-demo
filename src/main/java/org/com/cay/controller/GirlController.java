package org.com.cay.controller;

import java.util.List;

import org.com.cay.entity.Girl;
import org.com.cay.repository.GirlRepository;
import org.com.cay.service.GirlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GirlController {

	@Autowired
	private GirlRepository girlRepository;
	
	@Autowired
	private GirlService girlService;
	
	@GetMapping("/girls")
	//查询所有数据
	public List<Girl> getGirls(){
		return girlRepository.findAll();
	}
	
	@PostMapping("/girls")
	//添加一条数据
	public Girl girlAdd(@RequestParam("name") String name, @RequestParam("age")int age){
		Girl girl = new Girl();
		girl.setName(name);
		girl.setAge(age);
		
		return girlRepository.save(girl);
	}
	
	//查询指定id的girl
	@GetMapping("/girls/{id}")
	public Girl getGirl(@PathVariable("id") int id){
		return girlRepository.findOne(id);
	}
	
	//更新
	@PutMapping("/girls/{id}")
	public Girl updateGirl(@PathVariable("id") int id,@RequestParam("name") String name, @RequestParam("age")int age){
		Girl girl = new Girl();
		girl.setId(id);
		girl.setAge(age);
		girl.setName(name);
		
		return girlRepository.save(girl);
	}
	
	//删除
	@DeleteMapping("/girls/{id}")
	public void deleteGirl(@PathVariable("id") int id){
		girlRepository.delete(id);
	}
	
	//通过年龄查询一组数组
	@GetMapping("/girls/age/{age}")
	public List<Girl> girlListByAge(@PathVariable("age") int age){
		return girlRepository.findByAge(age);
	}
	
	@PostMapping("/girls/two")
	public void insertTwo(){
		girlService.insertTwo();
		
	}
}
