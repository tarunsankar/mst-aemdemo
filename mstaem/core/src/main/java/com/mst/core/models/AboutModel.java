package com.mst.core.models;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.InjectionStrategy;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mst.core.models.dto.Links;

@Model(adaptables=Resource.class)
public class AboutModel {
	
    private final Logger logger = LoggerFactory.getLogger(getClass());
	
	@ValueMapValue(injectionStrategy=InjectionStrategy.OPTIONAL)
	private List<String> links = new ArrayList<>();
	
	public List<Links> aboutLinks = new ArrayList<>();
	
	@PostConstruct
	public void init() {
		Gson gson = new GsonBuilder().create();
		aboutLinks = links.stream()
						.map(link -> gson.fromJson(link, Links.class))
						.collect(Collectors.toList());
		
		logger.info("links "+links.size());
		logger.info("aboutLinks "+aboutLinks.size());
	}
	
}
