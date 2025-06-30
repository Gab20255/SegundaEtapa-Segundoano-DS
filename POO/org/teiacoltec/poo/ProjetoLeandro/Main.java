package ProjetoLeandro;

public class Main {
    public static void main(String[] args) {
        Cachorro max= new Cachorro("Max", 5, "AUAU", "Macio", "Golden");
        Gato felix= new Gato("Felix", 4, "MIaaau", "Muito macio", "Verde");
        exibirAmimal(max);
        exibirAmimal(felix);
        InteragircomAnimalDomestico(max);
    }
    public static void exibirAmimal(Animal animal){
        System.out.println("Dados do Animal\n---------------------");
        System.out.println("Nome do Animal: "+animal.get_nome());
        System.out.println("Som do Animal: "+animal.get_som());
        System.out.println("Idade:"+animal.get_idade()+"\n---------------------\n");
    }
    public static void InteragircomAnimalDomestico(InterfaceAnimalDomestico animal){
        animal.levarParaPassear();
        animal.Brincar();
    }
}
