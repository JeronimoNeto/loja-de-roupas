package br.com.jeronimoneto.javaWebApp.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.jeronimoneto.javaWebApp.business.bean.RoupaBean;

/**
 * Servlet implementation class CartController
 */
@WebServlet("/cart")
public class CartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public CartController() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//Recupera o httpsession
		HttpSession session = request.getSession();
		
		//Verifica se ja existe um cart ou cria um
		if (session.getAttribute("cart") == null) {
			
			//Caso nao exista lista de compra cria uma
			List<RoupaBean> cart = new ArrayList<>();
			session.setAttribute("cart", cart);			
		}
		
		//Recupera Lista de Compras
		List<RoupaBean> cart = (List<RoupaBean>) session.getAttribute("cart");
		
		//envia cart para o front
		request.setAttribute("cart", cart);
		
		//Soma os valores e envia para JSP
		Float total = 0f;
		for (RoupaBean roupa : cart) {
			total += roupa.getPreco();		
		}
		request.setAttribute("total", total);
		
		//Envia pagina JSP para requisicao
		request.getRequestDispatcher("/cart.jsp").forward(request, response);
	}


	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//Usuario clicou em remover
		String indexString = request.getParameter("remover");
		int index = Integer.parseInt(indexString) - 1; //count -1 based
		
		HttpSession session = request.getSession();
		List<RoupaBean> cart = (List<RoupaBean>) session.getAttribute("cart");
		
		//Remove a roupa do carrinho pelo indice
		cart.remove(index);
		
		doGet(request, response);
	}

}
