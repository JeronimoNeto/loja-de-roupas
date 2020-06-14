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

import br.com.jeronimoneto.javaWebApp.Enums.CategoriaEnum;
import br.com.jeronimoneto.javaWebApp.business.bean.CatalogoBean;
import br.com.jeronimoneto.javaWebApp.business.bean.RoupaBean;

/**
 * Servlet implementation class CatalogoController
 */
@WebServlet("/catalogo")
public class CatalogoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private CatalogoBean catalogoBean;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CatalogoController() {
        super();
       
        //Inicia o catalogo com as roupas padrão
        catalogoBean = new CatalogoBean();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Recupera os valores do Select no Front
		String[] codigosCategoria = request.getParameterValues("categoria");
	
		
		//Envia as roupas do catalogo para o FrontEnd
		request.setAttribute("roupas", catalogoBean.getRoupasFiltradas(codigosCategoria) );
		request.setAttribute("categorias", CategoriaEnum.values());
		
		//Usuario clicou no botao adicionar
		if (request.getParameter("adicionar") != null) {
			
			HttpSession session = request.getSession();
			//Verifica se ja existe um cart ou cria um
			if (session.getAttribute("cart") == null) {
				//Caso nao exista lista de compra cria uma
				List<RoupaBean> cart = new ArrayList<>();
				session.setAttribute("cart", cart);			
			}
			
			//Identifica qual roupa o usuario clicou pelo codigo da roupa
			List<RoupaBean> cart =(List<RoupaBean>) session.getAttribute("cart");
			
			//Identifica o codigo da roupa que o usuario clicou
			String codigoString = request.getParameter("adicionar");
			Integer codigo = Integer.parseInt(codigoString);
			
			//Procura todas as roupas e procura aquela com codigo igual
			List<RoupaBean> todasAsRoupas = catalogoBean.getRoupas();
			for (RoupaBean roupa : todasAsRoupas) {
				if (roupa.getCodigo().equals(codigo)) {
					cart.add(roupa);
				}			
			}			
		}
		
		// Envia pagina JSP na requisicao
		request.getRequestDispatcher("/catalogo.jsp").forward(request, response);		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
