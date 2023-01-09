package com.prospecta.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.prospecta.Exception.EntryException;
import com.prospecta.model.Data;
import com.prospecta.model.DesiredResultDTO;
import com.prospecta.model.Entry;
import com.prospecta.service.EntryService;

@RestController
public class Controller {

	@Autowired
	RestTemplate restTemplate;
	@Autowired
	EntryService eService;
	
	@GetMapping("/entries/{category}")
	public List<DesiredResultDTO> entriesHandler(@PathVariable ("category") String category)
	{
		Data data=restTemplate.getForObject("https://api.publicapis.org/entries", Data.class);
		List<Entry> entries=data.getEntries();
		
		List<DesiredResultDTO> result=new ArrayList();
		
		for(Entry entry : entries)
		{
			String[] firstCat=entry.getCategory().split(" ");
			
			if(firstCat[0].equals(category))
			{
				result.add(new DesiredResultDTO(entry.getApi(),entry.getDescription()));
			}
		}
		
		return result;
	}
	
	@PostMapping("/entries")
	public ResponseEntity<String> saveNewEnyries(@RequestBody Entry entry) throws EntryException
	{
		Data data=restTemplate.getForObject("https://api.publicapis.org/entries", Data.class);
		List<Entry> entries=data.getEntries();
		
		entries.add(entry);
		
		for(Entry en:entries)
		{
			Entry entryNew=eService.newEntry(en);
		}
		
		
		return new ResponseEntity<String>("Entry added sucessfully ",HttpStatus.CREATED);
	}
	
}
