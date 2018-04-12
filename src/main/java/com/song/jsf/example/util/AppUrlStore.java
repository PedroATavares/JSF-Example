package com.song.jsf.example.util;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

@ManagedBean
@ApplicationScoped
public class AppUrlStore implements Serializable {
	private static final long serialVersionUID = 1L;

	private String baseUrl = null;
	private String simpleCrudUrl = null;
	private String freshSafeCrudUrl = null;
	private String entryPoint = null;

	public String getBaseUrl() {return baseUrl; }
	public String getSimpleCrudUrl() { return simpleCrudUrl; }
	public String getFreshSafeCrudUrl() {return freshSafeCrudUrl; }
	public String getEntryPoint() {return entryPoint; }
	@PostConstruct
    public void init() {
		String baseUrl = "http://localhost:8080/";

		this.baseUrl = baseUrl;
		this.simpleCrudUrl = baseUrl + "simplecrud.xhtml";
		this.freshSafeCrudUrl = baseUrl + "freshsafecrud.xhtml";
		this.entryPoint = baseUrl + "welcome.xhtml";    }
}
