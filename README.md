🧩 Sistema de Funcionários e Setores
🎯 Objetivo

API REST em Spring Boot para gerenciar setores e funcionários, com relacionamento um-para-muitos e muitos-para-um.

🧱 Estrutura
🏢 Setor 

id, nome, descricao

Relacionamento: 1 setor → vários funcionários (@OneToMany)

👤 Funcionário 

id, nome, cargo, salario, setor

Relacionamento: 1 funcionário → 1 setor (@ManyToOne)

🔗 Relacionamento

Bidirecional:

Um setor possui vários funcionários.

Cada funcionário pertence a um setor.

⚙️ Tecnologias

Java 21 • Spring Boot 3+ • Spring Data JPA • PostgreSQL • Maven 

🚀 Endpoints Principais
Setores

GET /departments – listar
POST /departments – criar
PUT /departments/{id} – atualizar
DELETE /departments/{id} – remover

Funcionários

GET /employees – listar
POST /employees – criar
PUT /employees/{id} – atualizar
DELETE /employees/{id} – remover
