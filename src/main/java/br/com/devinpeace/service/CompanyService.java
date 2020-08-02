package br.com.devinpeace.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import br.com.devinpeace.model.Company;
import br.com.devinpeace.repository.CompanyRepository;

@Service
public class CompanyService {

	@Autowired
	private CompanyRepository repository;

	@Cacheable(cacheNames = "Company", key = "#id")
	public Company findById(Long id) throws Exception {
		return repository.findById(id).orElseThrow(() -> new Exception());
	}

	@CacheEvict(cacheNames = "Company", allEntries = true)
	public Company create(Company company) {
		return repository.save(company);
	}

	@CachePut(cacheNames = "Company", key = "#company.getId()")
	public Company update(Company company) {
		return repository.save(company);
	}

	@CacheEvict(cacheNames = "Company", key = "#id")
	public void delete(Long id) {
		repository.deleteById(id);
	}

}
