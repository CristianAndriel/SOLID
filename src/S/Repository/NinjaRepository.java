package S.Repository;

import S.Models.Ninja;

public class NinjaRepository {
    public void save(Ninja ninja) {
        System.out.println("Ninja " + ninja.getNome() + " salvo no banco de dados.");
    }
}
