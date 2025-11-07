#include <stdio.h>
#include <stdlib.h>
#include <string.h>

struct Fosseis {
    char nome[20];
    float idade;
    char especie[20];
    char era[20];
    char local[20];
} ;

struct Fosseis cadastrarFossil(char nome[20], float idade, char especie[20], char era[20], char local[20]) {
    struct Fosseis f;
    strcpy(f.nome, nome);
    f.idade = idade;
    strcpy(f.especie, especie);
    strcpy(f.era, era);
    strcpy(f.local, local);
    return f;
}

void Listarfosseis(struct Fosseis f[10]) {
    for(int i=0; i<10; i++){
        printf("Fossil %d:\n", i+1);
        printf("Nome: %s\n", f[i].nome);
        printf("Idade: %.2f milhões de anos\n", f[i].idade);
        printf("Especie: %s\n", f[i].especie);
        printf("Era: %s\n", f[i].era);
        printf("Local de descoberta: %s\n\n", f[i].local);
    }
    
}

void Listarfosseisera(struct Fosseis f[10], char era[20]) {
    printf("Fosseis da era %s:\n", era);
    for(int i=0; i<10; i++){
        if(strcmp(f[i].era, era) == 0){
            printf("Nome: %s\n", f[i].nome);
            printf("Idade: %.2f milhões de anos\n", f[i].idade);
            printf("Especie: %s\n", f[i].especie);
            printf("Local de descoberta: %s\n\n", f[i].local);
        }
    }
}

int main() {
    struct Fosseis fossis[10];

    // Exemplo de cadastro de 10 fosseis
    fossis[0] = cadastrarFossil("Fossil1", 150.0, "EspecieA", "Mesozoica", "LocalA");
    fossis[1] = cadastrarFossil("Fossil2", 200.0, "EspecieB", "Paleozoica", "LocalB");
    fossis[2] = cadastrarFossil("Fossil3", 65.0, "EspecieC", "Cenozoica", "LocalC");
    fossis[3] = cadastrarFossil("Fossil4", 300.0, "EspecieD", "Paleozoica", "LocalD");
    fossis[4] = cadastrarFossil("Fossil5", 120.0, "EspecieE", "Mesozoica", "LocalE");
    fossis[5] = cadastrarFossil("Fossil6", 400.0, "EspecieF", "Paleozoica", "LocalF");
    fossis[6] = cadastrarFossil("Fossil7", 80.0, "EspecieG", "Cenozoica", "LocalG");
    fossis[7] = cadastrarFossil("Fossil8", 250.0, "EspecieH", "Mesozoica", "LocalH");
    fossis[8] = cadastrarFossil("Fossil9", 500.0, "EspecieI", "Paleozoica", "LocalI");
    fossis[9] = cadastrarFossil("Fossil10", 30.0, "EspecieJ", "Cenozoica", "LocalJ");

    // Listar todos os fosseis
    Listarfosseis(fossis);

    // Listar fosseis de uma era específica
    Listarfosseisera(fossis, "Mesozoica");

    return 0;
}
