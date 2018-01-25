https://github.com/mitreid-connect/OpenID-Connect-Java-Spring-Server


docker build -t wpng-oidc:1.0 .



docker run -d -p 8080:8080 --name wpng-oidc wpng-oidc:1.0



Point your browser to http://localhost:3000. The admin user/pass login is canvas@example.edu / canvas-docker