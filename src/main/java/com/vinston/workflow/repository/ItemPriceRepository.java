package com.vinston.workflow.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.vinston.workflow.model.ItemMasterEntity;

public interface ItemPriceRepository extends JpaRepository<ItemMasterEntity, Integer> {

	@Modifying
	@Query("update ItemMasterEntity u set u.workflowStatus = ?2 where u.name = ?1")
	public void updateItemStatus(String name, String status);
	
}
