package br.com.devinpeace.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.com.devinpeace.model.Company;

@Repository
public interface CompanyRepository extends PagingAndSortingRepository<Company, Long>{

}