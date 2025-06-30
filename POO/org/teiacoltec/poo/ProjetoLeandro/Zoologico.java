package ProjetoLeandro;

public class Zoologico {
    final private String nome;
    private Animal[] listaAnimais;
    public Zoologico(String nome){
        this.nome=nome;
        this.listaAnimais=new Animal[10];
    }
    public Animal Buscar_Animal(String nome_do_animal) throws AnimalNaoEncontradoExcepition{
        for(Animal a: this.listaAnimais){
            if(a.get_nome().compareTo(nome_do_animal)==0){
                return a;
            }
        }
        return null;
    }
    public void listarAnimais(){
        System.out.println("Zoologico "+nome+"\n");
        System.out.println("Animais:\n");
        for(int i=0; i<listaAnimais.length; i++){
            exibirAmimal(listaAnimais[i]);
        }
    }
    public void AdicionarAnimal(Animal animal_adicionado)throws AnimalNaoEncontradoExcepition{
        
    }
    public void exibirAmimal(Animal animal){
        System.out.println("Dados do Animal\n---------------------");
        System.out.println("Nome do Animal: "+animal.get_nome());
        System.out.println("Som do Animal: "+animal.get_som());
        System.out.println("Idade:"+animal.get_idade()+"\n---------------------\n");
    }
}
