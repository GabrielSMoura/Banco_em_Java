package com.mycompany.midas;

//importando as classes necesarias 
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AgenciaBancaria {
    
    static Scanner input = new Scanner(System.in);
    static ArrayList<Conta> contasBancarias;

    public static void main(String[] args) {
        contasBancarias = new ArrayList<Conta>();
        
        Pessoas pessoa1 = new Pessoas("Arthur", "12345678901", "arthur@gmail.com");
        Conta conta1 = new Conta(pessoa1);
        conta1.setTipoConta("Corrente");
        conta1.setSaldo(500.0);
        contasBancarias.add(conta1);

        Pessoas pessoa2 = new Pessoas("Astrogilda", "98765432101", "astrogilda@hotmail.com");
        Conta conta2 = new Conta(pessoa2);
        conta2.setTipoConta("Poupança");
        conta2.setSaldo(800.0);
        contasBancarias.add(conta2);
        
        Pessoas pessoa3 = new Pessoas("Eldizia", "58765932101", "eldizia@gmail.com");
        Conta conta3 = new Conta(pessoa3);
        conta3.setTipoConta("Corrente");
        conta3.setSaldo(100.0);
        contasBancarias.add(conta3);
        
        Pessoas pessoa4 = new Pessoas("Samuel", "58765492101", "samuel@gmail.com");
        Conta conta4 = new Conta(pessoa4);
        conta4.setTipoConta("Poupança");
        conta4.setSaldo(50.0);
        contasBancarias.add(conta4);
        
        Pessoas pessoa5 = new Pessoas("Zuleica", "58765439101", "zuleica@gmail.com");
        Conta conta5 = new Conta(pessoa5);
        conta5.setTipoConta("Poupança");
        conta5.setSaldo(800.0);
        contasBancarias.add(conta5); 
        
        operacoes();
    }
    
public static void operacoes() {
    
    //Exibissão de menu
    
    System.out.println("------------------------------------------------------");
    System.out.println("            BANCO MIDAS                                ");
    System.out.println("------------------------------------------------------");
    System.out.println("        Selecione uma operação desejada                ");
    System.out.println("------------------------------------------------------");
    System.out.println("  Opção 1 - Criar conta                                ");
    System.out.println("  Opção 2 - Visualizar conta                           ");
    System.out.println("  Opção 3 - Depositar                                  ");
    System.out.println("  Opção 4 - Sacar                                      ");
    System.out.println("  Opção 5 - Transferir                                 ");
    System.out.println("  Opção 6 - Listar                                     ");
    System.out.println("  Opção 7 - Excluir                                    ");
    System.out.println("  Opção 8 - Buscar conta                               ");
    System.out.println("  Opção 9 - Sair                                       ");
    System.out.println("------------------------------------------------------");


    int operacao = input.nextInt();
     // O que cada botão vai fazer
     
    switch (operacao) {
        case 1:
            criarConta();
            break;

        case 2:
            visualizarConta();
            break;

        case 3:
            depositar();
            break;

        case 4:
            sacar();
            break;

        case 5:
            transferir();
            break;

        case 6:
            listarContas();
            break;

        case 7:
            excluirConta();
            break;
            
        case 8:
            buscarConta();
            break;

        case 9:
            System.out.println("abraço prof, obrigado por usar o nosso banco :>");
            System.exit(0); // para o sistema

        default:
            System.out.println("Opção inválida!");
            operacoes();
            break;
    }
}
 // metodos de cada botão, ou o que cada botão vai fazer ou procurar

public static void visualizarConta() {
    System.out.println("Número da conta: ");
    int numeroConta = input.nextInt();

    Conta conta = encontrarConta(numeroConta);

    if (conta != null) {
        System.out.println(conta);

    } else {
        System.out.println("Conta não encontrada");
    }

    operacoes();
}
    
    public static void criarConta() {
        System.out.println("Selecione o tipo de conta:");
        System.out.println("1 - Conta Corrente");
        System.out.println("2 - Conta Poupança");
        int tipoConta = input.nextInt();
        
        if (tipoConta == 1) {
            criarContaCorrente();
        } else if (tipoConta == 2) {
            criarContaPoupanca();
        } else {
            System.out.println("Opção inválida!");
            operacoes();
        }
    }
    
    public static void criarContaCorrente() {
        input.nextLine(); // Consumir nova linha pendente
        
        System.out.println("\nNome: ");
        String nome = input.nextLine();
        
        System.out.println("\nCPF: ");
        String cpf = input.nextLine();
        
        System.out.println("\nEmail: ");
        String email = input.nextLine();
        
        Pessoas pessoa = new Pessoas(nome, cpf, email);
        
        ContaCorrente contaCorrente = new ContaCorrente(pessoa);
        contasBancarias.add(contaCorrente);
        
        System.out.println("Conta corrente criada com sucesso para: " + pessoa.getNome());
        operacoes();
    }
    
    public static void criarContaPoupanca() {
        input.nextLine(); // Consumir nova linha pendente
        
        System.out.println("\nNome: ");
        String nome = input.nextLine();
        
        System.out.println("\nCPF: ");
        String cpf = input.nextLine();
        
        System.out.println("\nEmail: ");
        String email = input.nextLine();
        
        Pessoas pessoa = new Pessoas(nome, cpf, email);
        
        ContaPoupanca contaPoupanca = new ContaPoupanca(pessoa);
        contasBancarias.add(contaPoupanca);
        
        System.out.println("Conta poupança criada com sucesso para: " + pessoa.getNome());
        operacoes();
    }
    
    private static Conta encontrarConta(int numeroConta) {
        for (Conta conta : contasBancarias) {
            if (conta.getNumeroConta() == numeroConta) {
                return conta;
            }
        }
        return null;
    }
    
    public static void depositar() {
        System.out.println("Número da conta: ");
        int numeroConta = input.nextInt();
        
        Conta conta = encontrarConta(numeroConta);
        
        if (conta != null) {
            System.out.println("Qual valor deseja depositar?");
            double valorDeposito = input.nextDouble();
            conta.depositar(valorDeposito);
            System.out.println("Valor depositado com sucesso!");
        } else {
            System.out.println("Conta não encontrada");
        }
        operacoes();
    }
    
    public static void sacar() {
        System.out.println("Número da Conta: ");
        int numeroConta = input.nextInt();
        
        Conta conta = encontrarConta(numeroConta);
        
        if (conta != null) {
            System.out.println("Qual valor deseja sacar?");
            double valorSaque = input.nextDouble();
            conta.sacar(valorSaque);
        } else {
            System.out.println("Conta não encontrada");
        }
        operacoes();
    }
    
    public static void transferir() {
        System.out.println("Remetente: ");
        int numeroContaRemetente = input.nextInt();
        
        Conta contaRemetente = encontrarConta(numeroContaRemetente);
        
        if (contaRemetente != null) {
            System.out.println("Destinatário: ");
            int numeroContaDestinatario = input.nextInt();
            
            Conta contaDestinatario = encontrarConta(numeroContaDestinatario);
            
            if (contaDestinatario != null) {
                System.out.println("Valor da transferência: ");
                double valor = input.nextDouble();
                
                contaRemetente.transferir(contaDestinatario, valor);
                System.out.println("Transferência realizada com sucesso!");
            } else {
                System.out.println("A conta destinatária não foi encontrada.");
            }
        } else {
            System.out.println("Conta remetente não encontrada");
        }
        operacoes();
    } 
    
public static void listarContas() {
    if (contasBancarias.size() > 0) {
        for (Conta conta : contasBancarias) {
            System.out.println(conta);

        }
    } else {
        System.out.println("Não há contas cadastradas.");
    }
    operacoes();
}
    
    public static void excluirConta() {
        System.out.println("Número da conta a ser excluída: ");
        int numeroConta = input.nextInt();

        Conta conta = encontrarConta(numeroConta);

        if (conta != null) {
            contasBancarias.remove(conta);
            System.out.println("Conta excluída com sucesso!");
        } else {
            System.out.println("Conta não encontrada");
        }

        operacoes();
    }
        public static void buscarConta() {
        input.nextLine(); // Consumir nova linha pendente

        System.out.println("Escolha o critério de busca:");
        System.out.println("1 - Nome");
        System.out.println("2 - CPF");
        System.out.println("3 - Email");
        System.out.println("4 - Número");
        int opcao = input.nextInt();

        input.nextLine(); // Consumir nova linha pendente

        String valor;

        switch (opcao) {
            case 1:
                System.out.println("Digite o nome:");
                valor = input.nextLine();
                buscarPorNome(valor);
                break;
            case 2:
                System.out.println("Digite o CPF:");
                valor = input.nextLine();
                buscarPorCPF(valor);
                break;
            case 3:
                System.out.println("Digite o email:");
                valor = input.nextLine();
                buscarPorEmail(valor);
                break;
            case 4:
                System.out.println("Digite o número:");
                valor = input.nextLine();
                buscarPorNumero(valor);
                break;
            default:
                System.out.println("Opção inválida!");
                operacoes();
                return;
        }

        operacoes();
    }

    private static void buscarPorEmail(String email) {
        List<Conta> contasEncontradas = new ArrayList<>();

        for (Conta conta : contasBancarias) {
            if (conta.getTitular().getEmail().equals(email)) {
                contasEncontradas.add(conta);
            }
        }

        if (!contasEncontradas.isEmpty()) {
            System.out.println("Contas encontradas com o email fornecido:");
            for (Conta contaEncontrada : contasEncontradas) {
                System.out.println(contaEncontrada);
            }
        } else {
            System.out.println("Nenhuma conta encontrada com o email fornecido.");
        }
    }

    private static void buscarPorCPF(String cpf) {
        List<Conta> contasEncontradas = new ArrayList<>();

        for (Conta conta : contasBancarias) {
            if (conta.getTitular().getCpf().equals(cpf)) {
                contasEncontradas.add(conta);
            }
        }

        if (!contasEncontradas.isEmpty()) {
            System.out.println("Contas encontradas com o CPF fornecido:");
            for (Conta contaEncontrada : contasEncontradas) {
                System.out.println(contaEncontrada);
            }
        } else {
            System.out.println("Nenhuma conta encontrada com o CPF fornecido.");
        }
    }

private static void buscarPorNome(String nome) {
    boolean encontrouConta = false;

    for (Conta conta : contasBancarias) {
        if (conta.getTitular().getNome().equalsIgnoreCase(nome)) {
            System.out.println(conta);
            encontrouConta = true;
        }
    }

    if (!encontrouConta) {
        System.out.println("Nenhuma conta encontrada com o nome fornecido.");
    }
}

private static void buscarPorNumero(String valor) {
    int numero = Integer.parseInt(valor);
    List<Conta> contasEncontradas = new ArrayList<>();

    for (Conta conta : contasBancarias) {
        if (conta.getNumeroConta() == numero) {
            contasEncontradas.add(conta);
        }
    }

    if (!contasEncontradas.isEmpty()) {
        System.out.println("Contas encontradas com o número " + numero + ":");
        for (Conta conta : contasEncontradas) {
            System.out.println(conta);
        }
    } else {
        System.out.println("Nenhuma conta encontrada com o número fornecido.");
    }
}



}

