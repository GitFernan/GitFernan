package com.microforum.gestorencuestas.servlet;

import java.io.IOException;
import java.io.Writer;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

@WebServlet("/ListadoUsuariosServlet")
public class ListadoUsuariosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ListadoUsuariosServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Writer writer=response.getWriter();
		Configuration conf=new Configuration();
		SessionFactory sf=conf.configure().buildSessionFactory();
		Session session=sf.openSession();
		Query query=session.createQuery("from Usuario");
		//Transaction tr=session.beginTransaction();
		RequestDispatcher rd=request.getRequestDispatcher("/listadoUsuarios.jsp");
		request.setAttribute("query", query);
		rd.forward(request,response);
		session.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
