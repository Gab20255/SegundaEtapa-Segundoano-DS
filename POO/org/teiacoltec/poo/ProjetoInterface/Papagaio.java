package ProjetoInterface;

public class Papagaio extends Ave implements InterfaceAnimaldomestico, InterfaceanimalAereo {
    protected String falarepetitiva; // Atributo específico do Papagaio

    // Ajustei o construtor para receber Envergadura como String para passar para caracteristica
    // e para setar o atributo falarepetitiva aqui
    public Papagaio(String nome, int idade, String som, String envergadura, String falarepetitiva) {
        super(nome, idade, som, envergadura); // envergadura fica como 'caracteristica' da Ave
        this.falarepetitiva = falarepetitiva;
        this.set_id_zoo(id_zoo);
        this.set_tipo("Ave");  // garante que o tipo está correto
    }

    public void Brincar() {
        System.out.println(nome + " está brincando de pular em seu viveiro");
    }

    public void levarParaPassear() {
        System.out.println(nome + " está passeando no céu da cidade de BH");
    }
    public void planar() {
        System.out.println(nome + " está planando num dia ensolarado para pousar em seu dono");
    }

    public void razante() {
        System.out.println(nome + " está fazendo um razante para pegar uma fruta");
    }

    public String get_Falarepetitiva() {
        return this.falarepetitiva;
    }

    public void set_Falarepetitiva(String falarepetitiva) {
        this.falarepetitiva = falarepetitiva;
    }
}

