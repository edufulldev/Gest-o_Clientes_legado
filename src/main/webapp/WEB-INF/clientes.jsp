<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Gestão de Clientes - Lista</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 40px; background-color: #f4f4f9; color: #333; }
        .container { max-width: 900px; margin: auto; background: white; padding: 30px; border-radius: 8px; box-shadow: 0 4px 8px rgba(0,0,0,0.1); }
        h1 { color: #2c3e50; }
        table { width: 100%; border-collapse: collapse; margin-top: 20px; }
        th, td { padding: 12px; border: 1px solid #ddd; text-align: left; }
        th { background-color: #3498db; color: white; }
        .btn { display: inline-block; padding: 8px 12px; color: white; text-decoration: none; border-radius: 4px; font-size: 14px; }
        .btn-novo { background-color: #3498db; margin-bottom: 15px; }
        .btn-editar { background-color: #f39c12; }
        .btn-excluir { background-color: #e74c3c; }
        .btn:hover { opacity: 0.8; }
    </style>
</head>
<body>
    <div class="container">
        <h1>Lista de Clientes</h1>

        <a href="clientes?acao=novo" class="btn btn-novo">Novo Cliente</a>

        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Nome</th>
                    <th>E-mail</th>
                    <th>Telefone</th>
                    <th>Ações</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="cliente" items="${clientes}">
                    <tr>
                        <td>${cliente.id}</td>
                        <td>${cliente.nome}</td>
                        <td>${cliente.email}</td>
                        <td>${cliente.telefone}</td>
                        <td>
                            <a href="clientes?acao=editar&id=${cliente.id}" class="btn btn-editar">Editar</a>
                            <a href="clientes?acao=excluir&id=${cliente.id}" class="btn btn-excluir" onclick="return confirm('Tem certeza que deseja excluir?')">Excluir</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <a href="index.jsp" style="display: inline-block; margin-top: 20px; color: #3498db; text-decoration: none;">Voltar ao Início</a>
    </div>
</body>
</html>