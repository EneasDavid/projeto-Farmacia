package pacott;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import entidade.Farmacia;
import java.util.ArrayList;
/**
 * Servlet implementation class FarmaciaServlert
 */
@WebServlet("/FarmaciaServlet")
public class FarmaciaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       ArrayList <Farmacia> clientes = new ArrayList <>();
    /**
     * @see HttpServlet#HttpServlet()
     */
       public void init () throws ServletException {
       	
       	super.init();
       }
    public FarmaciaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		//doGet so serve pra direcionamento porque retorna as informações pela URL
		var acao = request.getParameter("acao");
		if (acao.equals("Listar")) {
			request.setAttribute("clientes", this.clientes);
			request.getRequestDispatcher("WEB-INF/vizualizacao/Listar.jsp").forward(request, response);
			return;
		}
		if (acao.equals("Excluir")) {
			this.remover(Integer.parseInt(request.getParameter("id")));
			request.setAttribute("clientes", this.clientes);
			request.getRequestDispatcher("WEB-INF/vizualizacao/Listar.jsp").forward(request, response);
			return;
		}
		if (acao.equals("Editar")) {
			request.setAttribute("clientes", this.Busca(Integer.parseInt(request.getParameter("id"))));//request so pega String
			request.getRequestDispatcher("WEB-INF/vizualizacao/Atualizar.jsp").forward(request, response);
			return;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet(request, response);
		var nome = request.getParameter("nome");
		var cpf = request.getParameter("cpf");
		if (request.getParameter("id")==null) {
			var cadastro = new Farmacia(nome, cpf, retornoId());
			clientes.add(cadastro);
			response.sendRedirect("http://localhost:8080/Projeto/FarmaciaServlet?acao=Listar");
		} else {
			var idCliente = Integer.parseInt(request.getParameter("id"));
			var atualizacao = new Farmacia(nome, cpf, idCliente);
			this.atualizar(atualizacao);
			response.sendRedirect("http://localhost:8080/Projeto/FarmaciaServlet?acao=Listar");
		}
	}
//Codigos de funcionalidades
	private void remover(int id) {
		this.clientes.remove(Busca(id));
	}
	private Farmacia Busca(int index) {
		for (Farmacia Gutemberg:clientes) {
			if (Gutemberg.getId()==index) {
				return Gutemberg;
			}
		}
		return null;
	}
	public int retornoId() {
		return this.clientes.size()+1;
	}
	private void atualizar(Farmacia Genesis) {
		var id = this.clientes.indexOf(Busca(Genesis.getId()));
		this.clientes.set(id, Genesis);
	}
}
