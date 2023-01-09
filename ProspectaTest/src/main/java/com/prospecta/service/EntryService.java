package com.prospecta.service;

import com.prospecta.Exception.EntryException;
import com.prospecta.model.Entry;

public interface EntryService {

	public Entry newEntry(Entry entry) throws EntryException;
}
