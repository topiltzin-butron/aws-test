package xyz.cafeconleche.web.aws.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xyz.cafeconleche.web.aws.dao.BabyNamesRepository;
import xyz.cafeconleche.web.aws.service.BabyNamesService;
import xyz.cafeconleche.web.aws.vo.BabyName;

@Service
public class BabyNamesServicePojoImpl implements BabyNamesService {

	@Autowired
	private BabyNamesRepository babyNamesRepository;

	@Override
	public List<BabyName> findAll() {
		List<BabyName> names = (List<BabyName>) babyNamesRepository.findAll();
		return names;
	}

	@Override
	public BabyName findByName(String name) {
		BabyName babyName = babyNamesRepository.findByName(name);
		return babyName;
	}

	@Override
	public BabyName save(BabyName babyName) {
		return babyNamesRepository.save(babyName);
	}

	@Override
	public BabyName upcate(BabyName babyName) {
		return save(babyName);
	}

	@Override
	public BabyName delete(BabyName babyName) {
		babyNamesRepository.delete(babyName);
		return babyName;
	}

	@Override
	public long count() {
		return babyNamesRepository.count();
	}

	
}
