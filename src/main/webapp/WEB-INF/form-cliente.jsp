<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Gestão de Clientes - Formulário</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 40px; background-color: #f4f4f9; color: #333; }
        .container { max-width: 500px; margin: auto; background: white; padding: 30px; border-radius: 8px; box-shadow: 0 4px 8px rgba(0,0,0,0.1); }
        h1 { color: #2c3e50; }
        .form-group { margin-bottom: 15px; }
        label { display: block; margin-bottom: 5px; font-weight: bold; }
        input[type="text"], input[type="email"] { width: 100%; padding: 8px; box-sizing: border-box; border: 1px solid #ccc; border-radius: 4px; }
        button { background-color: #27ae60; color: white; padding: 10px 15px; border: none; border-radius: 4px; cursor: pointer; }
        button:hover { background-color: #219653; }
        a { display: inline-block; margin-top: 15px; text-decoration: none; color: #3498db; }
    </style>
</head>
<body>
    <div class="container">
        <h1>${cliente != null ? 'Editar Cliente' : 'Cadastrar Novo Cliente'}</h1>

        <form action="clientes" method="post">
            <!-- Campo oculto para enviar o ID caso seja uma edição -->
            <input type="hidden" name="id" value="${cliente.id}">

            <div class="form-group">
                <label for="nome">Nome:</label>
                <input type="text" id="nome" name="nome" value="${cliente.nome}" required>
            </div>

            <div class="form-group">
                <label for="email">E-mail:</label>
                <input type="email" id="email" name="email" value="${cliente.email}" required>
            </div>

            <div class="form-group">
                <label for="telefone">Telefone:</label>
                <input type="text" id="telefone" name="telefone" value="${cliente.telefone}" required>
            </div>

            <button type="submit">Salvar</button>
        </form>

        <a href="clientes">Voltar para a Lista</a>
    </div>
</body>
</html>