package ProjetoInterface;

import java.util.ArrayList;
import java.util.List;

public class GerenciadorZoologicos {
    protected List<Zoologico> zoologicos= new ArrayList<Zoologico>();
    GerenciadorZoologicos(List<Zoologico> zoologicos){
        this.zoologicos=new ArrayList<Zoologico>();
    }
    public void Desagregação(Animal Animal_a_ser_desagregado) throws AnimalNaoEncontradoException{
        for(int i=0; i<zoologicos.size(); i++){
            if(zoologicos.get(i).get_id_zoo()==Animal_a_ser_desagregado.get_id_zoo()){
                zoologicos.get(i).removerAnimal(Animal_a_ser_desagregado.get_nome());;
            }
        }
    }
}
