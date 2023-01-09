package com.prospecta.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prospecta.model.Entry;

public interface EntryDao extends JpaRepository<Entry, Integer> {
  
	public Optional<Entry> findByapi(String api);
}
