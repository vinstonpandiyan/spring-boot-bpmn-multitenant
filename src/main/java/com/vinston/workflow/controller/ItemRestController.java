package com.vinston.workflow.controller;

import java.util.Collections;
import java.util.Map;

import org.activiti.engine.RuntimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.vinston.workflow.model.ItemMasterEntity;
import com.vinston.workflow.repository.ItemPriceRepository;

@RestController
public class ItemRestController {

	@Autowired
	private RuntimeService runtimeService;
	@Autowired
	private ItemPriceRepository itemPriceRepository;
	

	@ResponseStatus(value = HttpStatus.OK)
	@RequestMapping(value = "/startItemPrice", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public void startItemPrice(@RequestBody Map<String, String> data) {

		ItemMasterEntity itemPrice = new ItemMasterEntity(data.get("name"), data.get("price"), "In-Progress");
		itemPriceRepository.save(itemPrice);

		Map<String, Object> vars = Collections.<String, Object> singletonMap("itemPrice", itemPrice);
		runtimeService.startProcessInstanceByKey("itemPriceApproval", vars);
	}

}
