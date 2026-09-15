# Url Shortener App
handling http requests using spring boot backend

# Features
* using http codes `201 CREATED`
* using standard packages `controller`, `service`, `components` and `repository` 
* IoC spring dependency injection

# Testing

Request

```powershell
curl -Uri "http://localhost:8080/links" 
   -Method POST 
   -Headers @{ "Content-Type" = "application/json" } 
  -Body '{"url":"example.com"}'
```

Response

```powershell
StatusCode        : 201
Content           : {"url":"example.com","code":"cad06b7e-447b-4427-a5ba-d47895a85308"}
```
