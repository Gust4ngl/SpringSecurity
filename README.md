Criar as migrations

adicionar as dependencias spring security, jwt e auth0 no pom.xml

criar as classes baseadas nas migrations; 
	permission (gust4.model)
	user (gust4.model), essa classe tambem mapeia a user_permission, que é responsavel por 
		saber qual as permissoes que o usuario possui

criar a interface responsavel por acessar o banco de dados;
	UserRepository
	
Criar a classe UserServices
	
Criar exceptions personalizadas e adicionalas ao handler
	invalidjwt

Criar as classes 
	AccountCredentialsVO (gust4.data.security)
	TokenVO (gust4.data.security)
	
Criar a classe que é responsavel por criar o tokenJWT
	JwtTokenProvider(gust4.security.jwt)

Criar a classe JwtTokenfilter (gust4.security.jwt)

Criar a classe JwtConfigurer (gust4.security.jwt)

Criar a classe de configurações de segurança, Security config

criar classe services

criar a classe controller

	
