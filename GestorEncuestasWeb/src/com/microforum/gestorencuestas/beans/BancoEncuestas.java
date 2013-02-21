package com.microforum.gestorencuestas.beans;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.model.SelectItem;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.microforum.gestorencuestas.entities.Encuesta;
import com.microforum.gestorencuestas.entities.Pregunta;

@ManagedBean(eager=true)
@ApplicationScoped
public class BancoEncuestas {
	private Map<String,String> mapaEncuestas;
	private List<String> arrayEncuestas;
	private List<SelectItem> encuestaItems;
	
	
// Métodos Get/Set
	
	public Map<String, String> getMapaEncuestas() {
		return mapaEncuestas;
	}
	public void setMapaEncuestas(Map<String, String> mapaEncuestas) {
		this.mapaEncuestas = mapaEncuestas;
	}
	
	public List<String> getArrayEncuestas() {
		return arrayEncuestas;
	}
	public void setArrayEncuestas(List<String> arrayEncuestas) {
		this.arrayEncuestas = arrayEncuestas;
	}
	
	public List<SelectItem> getEncuestaItems() {
		return encuestaItems;
	}
	public void setEncuestaItems(List<SelectItem> encuestaItems) {
		this.encuestaItems = encuestaItems;
	}
	
//  Constructor
	public BancoEncuestas(){
		Configuration conf=new Configuration();
		SessionFactory sf=conf.configure().buildSessionFactory();
		Session session=sf.openSession();
		Query query=session.createQuery("from Encuesta");
		List<Encuesta> listadoEncuestas=query.list();
		int tam=listadoEncuestas.size();
		encuestaItems=new ArrayList<SelectItem>();
		arrayEncuestas=new ArrayList();
		encuestaItems.add(new SelectItem("----Encuestas disponibles----"));
		for(int i=0;i<listadoEncuestas.size();i++){
			arrayEncuestas.add(listadoEncuestas.get(i).getTexto());
			String ref=listadoEncuestas.get(i).getRef();
			String texto=listadoEncuestas.get(i).getTexto();
			encuestaItems.add(new SelectItem(ref,texto));
		}
		session.close();
	}
}
