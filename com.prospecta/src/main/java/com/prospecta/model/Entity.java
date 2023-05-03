package com.prospecta.model;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@lombok.Data
@AllArgsConstructor
@NoArgsConstructor
public class Entity implements Serializable{

	private int count;
	@JsonProperty("entries")
	private List<Data> entries;
}

