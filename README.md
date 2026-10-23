# Gestão de Clientes Legado

Aplicação web desenvolvida em Java utilizando Servlets, JSP e Maven, com implantação no Apache Tomcat. 
O projeto tem como objetivo praticar e compreender a estrutura de aplicações Java Web tradicionais, comuns em sistemas corporativos legados.

## Tecnologias utilizadas

- **Java 17** — versão utilizada no ambiente de desenvolvimento.
- **Java Servlets** — processamento das requisições HTTP.
- **JSP (JavaServer Pages)** — camada de apresentação.
- **JSTL 1.2** — biblioteca de tags para páginas JSP.
- **Apache Tomcat 9** — servidor de aplicação web.
- **Apache Maven** — gerenciamento de dependências e build.
- **Servlet API 4.0.1** — API utilizada para desenvolvimento dos Servlets.

## Funcionalidades

- Cadastro de clientes.
- Listagem de clientes.
- Edição de clientes.
- Exclusão de clientes.
- Processamento de formulários via HTTP GET e POST.
- Encaminhamento de requisições para páginas JSP.
- Separação entre Servlet, camada de acesso a dados e modelo de domínio.

> Observação: as funcionalidades dependem da implementação e da configuração do banco de dados no ambiente de execução.

## Estrutura do projeto

```text
gestao-clientes-legado/
├── src/
│   └── main/
│       ├── java/
│       │   └── edu/
│       │       └── dev/
│       │           ├── Cliente.java
│       │           ├── ClienteDAO.java
│       │           ├── ClienteServlet.java
│       │           ├── ConnectionFactory.java
│       │           └── Main.java
│       └── webapp/
│           └── WEB-INF/
│               ├── clientes.jsp
│               ├── form-cliente.jsp
│               └── index.jsp
├── pom.xml
└── README.md
```

## Pré-requisitos

Antes de executar o projeto, tenha instalado:

- JDK 17.
- Apache Maven 3.9 ou compatível.
- Apache Tomcat 9.
- Banco de dados configurado conforme a implementação da classe `ConnectionFactory`.

## Compilação

Na raiz do projeto, execute:

```bash
mvn clean package
```

Após uma compilação bem-sucedida, o arquivo WAR será gerado em:

```text
target/gestao-clientes-legado.war
```

## Executando no Apache Tomcat

Copie o arquivo WAR para o diretório `webapps` do Tomcat:

```bash
cp target/gestao-clientes-legado.war ~/servidores/tomcat9/webapps/
```

Inicie o servidor:

```bash
~/servidores/tomcat9/bin/startup.sh
```

Para encerrar o servidor:

```bash
~/servidores/tomcat9/bin/shutdown.sh
```

Acesse a aplicação pelo navegador:

```text
http://localhost:8080/gestao-clientes-legado/clientes
```

O Servlet `ClienteServlet` é responsável pelo processamento das requisições relacionadas aos clientes. As páginas JSP estão dentro de `WEB-INF` e são acessadas por encaminhamento interno do Servlet.

## Aprendizados

Este projeto permite praticar:

- Desenvolvimento de aplicações Java Web tradicionais.
- Ciclo de vida de Servlets e processamento HTTP.
- Integração entre Servlets e JSP.
- Organização de código em modelo, acesso a dados e controle.
- Gerenciamento de dependências e empacotamento com Maven.
- Implantação de aplicações WAR no Tomcat.
- Manutenção e compreensão de sistemas legados.


---

Desenvolvido para fins de estudo e prática de desenvolvimento Java.
