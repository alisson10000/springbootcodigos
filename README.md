README - API de Segurança com JWT

Esta API foi desenvolvida para fornecer autenticação e autorização em uma aplicação utilizando JSON Web Tokens (JWT) com o framework Spring Boot. Abaixo estão as principais informações sobre como usar esta API:

Funcionalidades
Registro de Usuário

Endpoint: /api/register
Método: POST
Descrição: Este endpoint permite o registro de novos usuários na aplicação.
Corpo da Requisição: Deve conter os dados do usuário, incluindo nome de usuário e senha.
Autenticação de Usuário

Endpoint: /api/authenticate
Método: POST
Descrição: Este endpoint é utilizado para autenticar usuários e gerar um token JWT válido.
Corpo da Requisição: Deve conter o nome de usuário e a senha do usuário.
Proteção de Rotas

Todas as outras rotas da API são protegidas e exigem um token JWT válido para acesso.
Configuração
Chave Secreta JWT: A chave secreta utilizada para assinar e verificar os tokens JWT é definida na classe JwtUtil e pode ser modificada conforme necessário.

Configuração do Banco de Dados: Esta API utiliza o banco de dados H2 embutido para armazenar os detalhes dos usuários. Certifique-se de configurar corretamente as dependências e as propriedades do banco de dados no arquivo application.properties.

Configuração do Spring Security: A configuração de segurança é definida nas classes SecurityConfig e JwtRequestFilter. Essas classes implementam a lógica de autenticação e autorização usando tokens JWT.

Como Usar
Registro de Usuário:

Envie uma solicitação POST para /api/register com os dados do novo usuário no corpo da requisição.
Exemplo de Corpo da Requisição:
json
Copiar código
{
  "username": "exampleUser",
  "password": "examplePassword"
}
Autenticação de Usuário:

Envie uma solicitação POST para /api/authenticate com o nome de usuário e a senha do usuário no corpo da requisição.
Exemplo de Corpo da Requisição:
json
Copiar código
{
  "username": "exampleUser",
  "password": "examplePassword"
}
O endpoint retornará um token JWT válido.
Acesso às Rotas Protegidas:

Inclua o token JWT recebido no cabeçalho Authorization de todas as solicitações para as rotas protegidas.
O token JWT deve ser prefixado com Bearer.
Exemplo de Cabeçalho de Autorização:
makefile
Copiar código
Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJleGFtcGxlVXNlciIsImlhdCI6MTY0NTc3NzMzMywiZXhwIjoxNjQ1Nzc3OTMzfQ.F1FpbzHwNndSvfOz8Mj6AW3Fd7x1HZKQbcT0jC_EFCg
Dependências
Spring Boot
Spring Security
Spring Data JPA
H2 Database
JSON Web Tokens (JWT)
Execução
Clonar o Repositório:

bash
Copiar código
git clone (https://github.com/alisson10000/springbootcodigos/novoseguranca)
Importar o Projeto:

Importe o projeto para sua IDE favorita.
Executar a Aplicação:

Execute a aplicação Spring Boot.
Certifique-se de configurar corretamente as dependências e o banco de dados.
Contribuição
Sinta-se à vontade para contribuir com melhorias, correções ou novas funcionalidades para esta API. Basta abrir uma issue ou enviar um pull request no repositório GitHub.

Espero que esta API seja útil para implementar a segurança em sua aplicação utilizando tokens JWT. Se você tiver alguma dúvida ou sugestão, não hesite em entrar em contato.
