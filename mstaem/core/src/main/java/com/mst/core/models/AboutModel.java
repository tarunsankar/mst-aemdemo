package com.mst.core.models;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Optional;
import org.apache.sling.models.annotations.injectorspecific.InjectionStrategy;
import org.apache.sling.models.annotations.injectorspecific.ScriptVariable;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mst.core.models.dto.Links;

@Model(adaptables=Resource.class)
public class AboutModel {
	
	@ValueMapValue(injectionStrategy=InjectionStrategy.OPTIONAL)
	private List<String> links = new ArrayList<>();
	
	@Inject @Optional
	public String title1;

	@Inject @Optional
	public String description1;

	@Inject @Optional
	private String icons1;
	
	public List<Links> aboutLinks = new ArrayList<>();
	
	@PostConstruct
	public void init() {
		Gson gson = new GsonBuilder().create();
		aboutLinks = links.stream()
						.map(link -> gson.fromJson(link, Links.class))
						.collect(Collectors.toList());
	}
	
	public String getIcons1() {
		return icons1;
	}
	
	public String getTitle1() {
		return title1;
	}

	public String getDescription1() {
		return description1;
	}



}
