package xyz.cafeconleche.web.aws.service;

import java.util.List;

import xyz.cafeconleche.web.aws.vo.BabyName;

public interface BabyNamesService {

	List<BabyName> findAll();
	
	BabyName findByName(String name);
	
	BabyName save(BabyName babyName);
	
	BabyName upcate(BabyName babyName);
	
	BabyName delete(BabyName babyName);
	
	long count();
	
}
