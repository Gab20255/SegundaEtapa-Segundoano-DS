#include <stdio.h>
#include <stdlib.h>
#include <string.h>
typedef struct Fossil{
    char nome[50];
    char especie[50];
    char era[50];
    char local[50];
    float idade;
};
struct Fossil cadastrarFossil(char nome[50], float idade, char especie[50], char era[50], char local[50]){
    struct Fossil f;
    strcpy(f.nome, nome);
    f.idade = idade;
    strcpy(f.especie, especie);
    strcpy(f.era, era);
    strcpy(f.local, local);
    return f;
}
void listarfossil(struct Fossil f[10]){
    for(int i=0; i<10; i++){
    printf("Fossil %d:\n", i+1);
    printf("Nome: %s\n", f[i].nome);
    printf("Idade: %.2f milhoes de anos\n", f[i].idade);
    printf("Especie: %s\n", f[i].especie);
    printf("Era: %s\n", f[i].era);
    printf("Local de descoberta: %s\n\n", f[i].local);
}
}
void Listarfosseisera(struct Fossil f[10], char era[20]) {
    printf("Fosseis da era %s:\n", era);
    for(int i=0; i<10; i++){
        if(strcmp(f[i].era, era) == 0){
            printf("Nome: %s\n", f[i].nome);
            printf("Idade: %.2f milhoes de anos\n", f[i].idade);
            printf("Especie: %s\n", f[i].especie);
            printf("Local de descoberta: %s\n\n", f[i].local);
        }
    }
}
int main()
{
    struct Fossil F[10];
    char nome[50];
    char especie[50];
    char era[50];
    char local[50];
    float idade;
    
    for(int i=0;i<10;i++){
        printf("Digite o nome do fossil\n");
fgets(nome, 50, stdin);
nome[strcspn(nome, "\n")] = '\0'; // remove o ENTER da string

printf("Digite a especie do fossil\n");
fgets(especie, 50, stdin);
especie[strcspn(especie, "\n")] = '\0';

printf("Digite a era em que essa especie viveu\n");
fgets(era, 50, stdin);
era[strcspn(era, "\n")] = '\0';

printf("Digite o local em que o fossil foi encontrado\n");
fgets(local, 50, stdin);
local[strcspn(local, "\n")] = '\0';

printf("Digite a idade desse fossil em milhoes de anos\n");
scanf("%f", &idade);
getchar(); // limpa o ENTER

F[i] = cadastrarFossil(nome, idade, especie, era, local);

// "Zerar" as strings (opcional)
nome[0] = '\0';
era[0] = '\0';
especie[0] = '\0';
local[0] = '\0';

}
    char era1[20];
    listarfossil(F);
    fgets(era1,20,stdin);
    Listarfosseisera(F,era1);
    
    return 0;
}