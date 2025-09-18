import java.util.Scanner;

public class FilaAtendimento {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        Metodos vetor = new Metodos(100);
        
        int opcao;
        
        do{
            System.out.println("--- MENU FILA ---"
                    + "\n1 - Gerar nova senha"
                    + "\n2 - Fila dos pacientes"
                    + "\n3 - Chamar proximo cliente"
                    + "\n4 - Remover cliente da fila"
                    + "\n5 - Verificar proximo cliente da fila"
                    + "\n0 Sair");
            System.out.println("Escolha uma opcao: ");
            opcao = sc.nextInt();
            
            sc.nextLine();
            
            switch(opcao){
                case 1 -> {
                    System.out.println("1 - Gerar senha"
                            + "\n2 - Gerar senha preferencial");
                    int opcaoSenha = sc.nextInt();
                    boolean prioridade = (opcaoSenha == 2);
                    sc.nextLine();
                    
                    System.out.println("Digite seu nome");
                    String nome = sc.nextLine();
                    
                    int senha = vetor.gerarSenha();
                    Fila cliente = new Fila(nome, senha, prioridade);
                    vetor.adicionarCliente(cliente);
                    System.out.println("Senha: " + senha);                  
                }
                case 2 -> {
                    Fila[] lista = vetor.listarFila();
                    if (lista.length > 0) {
                    for (Fila a : lista) {
                    System.out.println(a);
                }
                } else {
                    System.out.println("Sem pacientes na fila.");
                }
            }

                case 3 -> {
                    Fila proximo = vetor.proximoCliente();
                    if (proximo != null) {
                    System.out.println("Atendendo: " + proximo);
                } else {
                    System.out.println("Fila vazia");
                }
            }
                case 4 -> {
                    Fila[] lista = vetor.listarFila();
                    if (lista.length > 0) {
                    for (Fila a : lista) {
                    System.out.println(a);
                }
                } else {
                    System.out.println("Sem pacientes na fila.");
                }                        
                    System.out.println("Digite o numero da senha a ser removida:");
                int senhaRemover = sc.nextInt();
                boolean removido = vetor.removerClientePorSenha(senhaRemover);
                if (removido) {
                    System.out.println("Cliente removido com sucesso.");
                } else {
                    System.out.println("Cliente com essa senha nao encontrado.");
                }
            }
                case 5 -> {
                    Fila proximo = vetor.espiarProximo();
                    if (proximo != null) {
                        System.out.println("Proximo paciente a ser atendido: " + proximo);
                    } else {
                        System.out.println("Fila vazia");
                    }
                }
            }            
        }while(opcao !=0);       
    
    sc.close();
    }    
}
