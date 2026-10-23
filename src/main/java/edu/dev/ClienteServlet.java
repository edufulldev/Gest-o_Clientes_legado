package edu.dev;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ClienteServlet", value = "/clientes")
public class ClienteServlet extends HttpServlet {

    private ClienteDAO clienteDAO = new ClienteDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       String acao = request.getParameter("acao");

      if(acao == null) {
          acao = "listar";
      }
      switch (acao) {
          case "novo":
              request.getRequestDispatcher("/WEB-INF/form-cliente.jsp").forward(request, response);
              break;

          case "editar":
              Long idEdicao = Long.parseLong(request.getParameter("id"));
              Cliente cliente = clienteDAO.buscarPorId(idEdicao);
              request.setAttribute("cliente", cliente);
              request.getRequestDispatcher("/WEB-INF/form-cliente.jsp").forward(request, response);
              break;

          case "excluir":
              Long idExclusao = Long.parseLong(request.getParameter("id"));
              clienteDAO.deletar(idExclusao);
              response.sendRedirect("clientes");
              break;

          default:
              List<Cliente> listaClientes = clienteDAO.listar();
              request.setAttribute("clientes", listaClientes);
              request.getRequestDispatcher("/WEB-INF/form-cliente.jsp").forward(request, response);
              break;
      }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Configura a codificação para aceitar acentos corretamente
        request.setCharacterEncoding("UTF-8");

        // Recebe os parâmetros enviados pelo formulário
        String idStr = request.getParameter("id");
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String telefone = request.getParameter("telefone");

       if(idStr == null || idStr.isEmpty()) {
           Cliente novoCliente = new Cliente(null, nome, email, telefone);
           clienteDAO.inserir(novoCliente);
       } else {
           Long id = Long.parseLong(idStr);
           Cliente clienteExistente = new Cliente(id, nome, email, telefone);
           clienteDAO.atualizar(clienteExistente);
       }
       response.sendRedirect("clientes");
    }
}
