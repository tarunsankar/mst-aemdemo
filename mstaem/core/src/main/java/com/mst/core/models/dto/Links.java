package com.mst.core.models.dto;

import java.util.Map;
import java.util.function.Consumer;

/**
 * Columns a generic bean class for twoColumn Component,
 * Contains information like colSpan value for both the column in desktop and tablet view.
 * 
 */
public class Links {
	public String title;
	public String description;
	public String icons;

	public String getTitle() {
		return title;
	}
	public String getDescription() {
		return description;
	}
	public String getIcons() {
		return icons;
	}

}
