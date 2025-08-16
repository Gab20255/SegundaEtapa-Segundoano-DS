package org.teiacoltec.poo.Classes;
import java.awt.Color;
import java.awt.Image;
import org.teiacoltec.poo.Enumeracao.Status;

public class Cliente {
    private static int ids=0;
    private int id;
    private String apelido;
    private Image avatar;
    private Color cor;
    private Status status;

    public Cliente( String apelido, Image avatar, Color cor, Status status) {
        this.id =++ids;
        this.apelido = apelido;
        this.avatar = avatar;
        this.cor = cor;
        this.status = status;
    }



    //Getters e Setters
    public int get_ID(){
        return this.id;
    }
    public String get_apelido(){
        return this.apelido;
    }
    public Image get_avatar(){
        return this.avatar;
    }
    public Color get_cor(){
        return this.cor;
    }
    public Status get_status(){
        return this.status;
    }
    public void set_ID(int id){
        this.id=id;
    }
    public void set_apelido(String apelido){
        this.apelido=apelido;
    }
    public void set_avatar(Image avatar){
        this.avatar=avatar;
    }
    public void set_cor(Color cor){
        this.cor=cor;
    }
    public void set_status(Status status){
        this.status=status;
    }
}
