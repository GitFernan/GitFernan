package com.microforum.gestorencuestas.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class TareasUsuarios {
	private static String tarea;
	public String[] userTasks={
		"nueva encuesta","recuperar encuesta"
	};
	public String getTarea() {
		return tarea;
	}
	public void setTarea(String tarea) {
		this.tarea = tarea;
	}
	public String[] getUserTasks() {
		return userTasks;
	}
}
