<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Gestão de Clientes - Início</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 40px; background-color: #f4f4f9; color: #333; }
        .container { max-width: 600px; margin: auto; background: white; padding: 30px; border-radius: 8px; box-shadow: 0 4px 8px rgba(0,0,0,0.1); }
        h1 { color: #2c3e50; }
        a { display: inline-block; margin-top: 15px; padding: 10px 20px; background-color: #3498db; color: white; text-decoration: none; border-radius: 4px; }
        a:hover { background-color: #2980b9; }
    </style>
</head>
<body>
    <div class="container">
        <h1>Bem-vindo ao Sistema de Gestão de Clientes</h1>
        <p>Aplicação desenvolvida para prática de Servlets e JSPs com Java 17.</p>

        <!-- Este link chama o mapeamento /clientes do nosso ClienteServlet -->
        <a href="clientes">Acessar Lista de Clientes</a>
    </div>
</body>
</html>