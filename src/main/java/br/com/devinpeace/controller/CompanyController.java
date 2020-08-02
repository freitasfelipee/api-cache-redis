package br.com.devinpeace.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.devinpeace.model.Company;
import br.com.devinpeace.service.CompanyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/v1/company")
@Api(value = "/v1/company", tags = "Company", description = "")
public class CompanyController {
	
	@Autowired
	private CompanyService service;
	
	@ApiOperation(value = "List company by id.")
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public String findById(@ApiParam(value = "Company id.", required = true) @PathVariable Long id) throws Exception {
		
		try {
			
			Company company = this.service.findById(id);
			
			return company.toString();
			
		} catch(Exception e) {
			throw e;
		}
	}
	
	@ApiOperation(value = "Create a company.")
	@PostMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public String create(@RequestBody @Valid Company company, BindingResult result) throws Exception {
		
		try {
								
			company = this.service.create(company);
			
			return company.toString();
			
		} catch (Exception e) {
			throw e;
		}

	} 
	
	@ApiOperation(value = "Update a company.")
	@PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public String update(@ApiParam(value = "Company id.", required = true) @PathVariable("id") Long id, @RequestBody @Valid Company company, BindingResult result) throws Exception {

		try {
		
			company = this.service.update(company);
			
			return company.toString();
			
		} catch (Exception e) {
			throw e;
		}
		
	} 

}
