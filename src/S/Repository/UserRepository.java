package S.Repository;

import S.User;

public class UserRepository {
    public void save(User user) {
        String name = user.getName();
        System.out.println("Salvando usuário: " + name + " no banco de dados");
    }
}
