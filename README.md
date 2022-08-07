# MOVIE APP
https://img.shields.io/badge/version-1.0.0-green <br/>
Tabela de conteúdos
=================
<!--ts-->
   * [Sobre](#Sobre)
   * [Como usar](#como-usar)
      * [Pré requisitos](#pré-requisitos)
      * [Iniciar aplicação](#iniciar-aplicação)
      * [Utilização](#utilização)
      * [Finalizar aplicação](#finalizar-aplicação)
   * [Tecnologias](#tecnologias)
   * [Autor](#autor)
<!--te-->

Sobre
=====
Esta aplicação possui uma base de filmes produzidos entre os anos 1980 e 2019, onde alguns desses filmes foram premiados com a categoria
de "Pior Filme do Golden Raspberry Awards". Atráves de API RESTful será possível visualizar os filmes na qual os produtores com maior e o
menor intervalo entre dois prêmios consecutivos.

Como usar
=========

Pré requisitos
--------------
* Deve-se ter instalado o Java da versão 8 em diante.Link para download www.java.com
* A porta 8080 de seu ambiente deve estar liberada. Caso não esteja liberada você pode identificar a aplicação que está utilizando essa
  mesma porta e finalizar com os seguintes comandos:
  + Listar processos/portas que estão sendo executadas, basta executar a seguinte instrução no prompt de comando do Windows.
  ```bash
  netstat -ao |find /i "listening"
  ```
  + Após identificar o PID do processo que está utilizando a porta 8080, basta executar a seguinte instrução no prompt de comando do Windows
    informando o PID.
  ```bash
  Taskkill /F /IM [PID]
  ```

Iniciar aplicação
-----------------
Basta executar o arquivo "movie-api" para iniciar a aplicação. Caso seu ambiente esteja identificando este arquivo como um arquivo tipo "zip",
basta clicar com o botão direito do mouse e abrir com "Java(TM) Platform SE binary".

Utilização
----------
Após realizar a inicialização da aplicação, basta acessar o link: http://localhost:8080/movies/intervaloDePremios tanto pelo Postman ou por qualquer
navegador.

Finalizar aplicação
-------------------
Primeiramente você deve listar os processos/portas com o seguinte comando no prompt de comando do Windows, e identificar o PID do processo que está
rodando na porta 8080 (porta na qual a aplicação está configurada).
  ```bash
  netstat -ao |find /i "listening"
  ```
Executar a seguinte instrução no prompt de comando do Windows informando o PID identificado para a porta 8080 do procedimento anterior.
  ```bash
  Taskkill /F /IM [PID]
  ```

Tecnologias
===========
+ Java 11.0.15
+ Spring Boot 2.7.1
+ API RESTful
+ H2Database
+ JUnit
+ Apache POI

Autor
=====
Ricardo Lima Fauzel
