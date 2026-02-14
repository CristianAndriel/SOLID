package S.Models;

//O S de Solid diz que, uma classe deve ser especialista numa única coisa, ou seja, ela deve ter apenas uma responsabilidade.

public class User {
    private String name;
    private String email;

    public User(String name, String email) {
    this.name = name;
    this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

}
