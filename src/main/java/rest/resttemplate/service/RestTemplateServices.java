package rest.resttemplate.service;

import org.springframework.http.client.support.BasicAuthorizationInterceptor;
import rest.resttemplate.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static org.codehaus.groovy.runtime.InvokerHelper.asList;

@Service
public class RestTemplateServices {

    @Autowired
    RestTemplate restTemplate;



    public List<User> showUsers() {
        String LIST = "http://localhost:8080/admin";
        ResponseEntity<User[]> response = restTemplate.exchange(LIST, HttpMethod.GET, null, User[].class);
        List<User> users = Arrays.asList(response.getBody());
        return users;
    }

    public void add(User user) {
        String ADD_USER = "http://localhost:8080/admin/add";
        HttpEntity<User> requestBody = new HttpEntity<>(user);
        restTemplate.exchange(ADD_USER, HttpMethod.POST, requestBody, User.class);
    }

    public void update(User user) {
        String UPDATE_USER = "http://localhost:8080/admin/update";
        //user.add("Authorization", "Basic YWRtaW5hZG1pbg==");
        HttpEntity<User> requestBody = new HttpEntity<>(user);
        //login("admin", "admin");
        restTemplate.exchange(UPDATE_USER, HttpMethod.PUT, requestBody, User.class).getBody();
    }

    public User getUserById(Long id) {
        String ID_USER = "http://localhost:8080/admin/update/" + id;
        ResponseEntity<User> response = restTemplate.exchange(ID_USER, HttpMethod.PUT, null, User.class);
        User user = response.getBody();
        return user;
    }

    public void delete(String id) {
        String DELETE_USER = "http://localhost:8080/admin/delete/" + Integer.parseInt(id);
        restTemplate.exchange(DELETE_USER, HttpMethod.DELETE, null, User.class);
    }

    public void login(String username, String password) {
        BasicAuthorizationInterceptor basicAuthorizationInterceptor = new BasicAuthorizationInterceptor(username, password); //правильный хедер и сервис настройцки на сервере инмемори
        restTemplate.getInterceptors().add(basicAuthorizationInterceptor);
    }

    /*public void login(String username, String password) {
        BasicAuthorizationInterceptor basicAuthorizationInterceptor = new BasicAuthorizationInterceptor(username, password); //правильный хедер и сервис настройцки на сервере инмемори
        restTemplate.setInterceptors(asList(basicAuthorizationInterceptor));
    }*/
}
