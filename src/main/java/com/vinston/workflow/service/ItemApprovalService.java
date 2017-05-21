package com.vinston.workflow.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vinston.workflow.repository.ItemPriceRepository;

@Component
public class ItemApprovalService {
	
	@Autowired
	private ItemPriceRepository itemPriceRepository;

	public ItemApprovalService() {
	}
	
	public void rejectItemPrice(String name) {
		itemPriceRepository.updateItemStatus(name, "Rejected");
        System.out.println("\n\n\n\nReject Item Price..............");
    } 
	
	public void acceptItemPrice(String name) {
		
		itemPriceRepository.updateItemStatus(name, "Completed");
		
        System.out.println("\n\n\n\nAccepted Item Price................: "+name);
    }

}
