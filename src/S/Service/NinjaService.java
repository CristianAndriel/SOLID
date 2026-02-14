package S.Service;

import S.Models.Ninja;
import S.Repository.NinjaRepository;

public class NinjaService {
    private NinjaRepository ninjaRepository;

    public NinjaService() {
        this.ninjaRepository = new NinjaRepository();
    }

    // LÓGICA DE NEGÓCIO: Registrar um novo ninja no sistema
    public void registerNinja(Ninja ninja) {
        // 1. VALIDAÇÃO (Regra de negócio)
        if (ninja.getNome() == null || ninja.getNome().isEmpty()) {
            throw new IllegalArgumentException("Nome do ninja é obrigatório!");
        }

        if (ninja.getIdade() < 5) {
            throw new IllegalArgumentException("Ninja deve ter pelo menos 5 anos para ser registrado!");
        }

        // 2. PROCESSAMENTO (Lógica de negócio)
        System.out.println("Processando registro do ninja " + ninja.getNome() + "...");

        // 3. PERSISTÊNCIA (Chama o Repository)
        ninjaRepository.save(ninja);

        // 4. ORQUESTRAÇÃO (Outras operações após salvar)
        System.out.println("Ninja " + ninja.getNome() + " da aldeia " + ninja.getAldeia() + " registrado com sucesso!");
    }

    // LÓGICA DE NEGÓCIO: Promover ninja (apenas ninjas da Aldeia da Folha)
    public void promoteNinja(Ninja ninja) {
        // Validação de regra de negócio
        if (!ninja.getAldeia().equalsIgnoreCase("Folha")) {
            throw new IllegalStateException("Apenas ninjas da Aldeia da Folha podem ser promovidos aqui!");
        }

        if (ninja.getIdade() < 12) {
            throw new IllegalStateException("Ninja muito jovem para promoção!");
        }

        System.out.println("Ninja " + ninja.getNome() + " do clã " + ninja.getCla() + " foi promovido!");
    }

    // LÓGICA DE NEGÓCIO: Verificar se ninja pode participar de missões perigosas
    public boolean canGoOnDangerousMission(Ninja ninja) {
        // Regras de negócio complexas
        boolean isOldEnough = ninja.getIdade() >= 15;
        boolean isFromStrongClan = ninja.getCla().equalsIgnoreCase("Uchiha") ||
                                   ninja.getCla().equalsIgnoreCase("Hyuga") ||
                                   ninja.getCla().equalsIgnoreCase("Uzumaki");

        if (isOldEnough && isFromStrongClan) {
            System.out.println(ninja.getNome() + " está apto para missões perigosas!");
            return true;
        } else {
            System.out.println(ninja.getNome() + " não está apto para missões perigosas ainda.");
            return false;
        }
    }
}
