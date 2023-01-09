package com.prospecta.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prospecta.Exception.EntryException;
import com.prospecta.model.Entry;
import com.prospecta.repository.EntryDao;
@Service
public class EntryServiceImpl implements EntryService {

	@Autowired
	EntryDao eDao;
	
	@Override
	public Entry newEntry(Entry entry) throws EntryException {


	//		Optional<Entry> existEntry=eDao.findByapi(entry.getApi());
	//		
	//		if(existEntry !=null)
	//		{
	//			throw new EntryException("This entry already exist !");
	//		}
	
			Entry newEntry=eDao.save(entry);
			return newEntry;
		}

	}


