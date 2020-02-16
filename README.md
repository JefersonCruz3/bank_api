# Api de transferencia bancária

## Dependências

- Java 11
- Postgres 10

### Configurando banco de dados local

Por padrão, a aplicação tentará conectar com um banco de dados Postgres ao iniciar. Veja o arquivo `\src\main\resources\application.properties` para saber qual usuário e senha será utilizado. 

Você precisará criar um banco de dados vazio antes de iniciar a aplicação. O nome do banco padrão é `bancoapi` (veja o arquivo de configuração mencionado anteriormente).

## Desenvolvimento local

Para iniciar a aplicação ultilize o comando:

```java
./gradle bootrun
```

Para iniciar os testes automatizados ultilize o comando:

```java
./gradle test
```

## Descrição de tecnologias
A aplicação é construida com base no padrão de arquitetura `MVC`, utilizando `Gradle` como gerenciador de dependencias, `Flyway` como  ferramenta de migração de banco de dados,
 `Hibernate` como ferramenta para o mapeamento objeto-relacional de banco de dados com `JPA` para persistência de dados e `JUnit` para testes automatizados.

## Api de transferencia bancária V2
Para uma segunda versão da aplicação gostaria de implementar outros tipos de contas e relaciona-las com usuários, 
colocar validações de criacão de transferências para não ser possível criação de transferências de um usuário sem permição 
e desenvolver um sistema de arrecadação sobre cada transação.



