package tde3;

import java.util.Scanner;
import java.util.ArrayList;

//Conta Corrente
public class ContaCorrente{
    private int numero;
    private double saldo;
    private Cliente cliente;

    Scanner teclado = new Scanner(System.in);

    public ContaCorrente(int numero) {
        super();
        this.numero = numero;
        saldo = 0;
    }
    public ContaCorrente() {

    }
    public void setCliente(Cliente cliente) {

    }
    public void depositaValor(double deposito) {
        System.out.println("Digite o valor do depósito: ");
        deposito = teclado.nextDouble();
        verificaSaldo();
        saldo += deposito;
        System.out.println("O saldo é: "+ saldo);
    }

    public void retiraValor(double saque) {
        System.out.println("Digite o valor do saque: ");
        saque = teclado.nextDouble();
        verificaSaldo();
        saldo -= saque;
        System.out.println("O saldo é: " + saldo);
    }
    public double verificaSaldo() {
        assert (saldo >= 0);
        return saldo;
    }
    public void imprimirConta(){
            System.out.println("Numero da conta: " + numero);
            System.out.println("Cliente: " + cliente.getNome());
            System.out.println("Saldo:" + cliente.getSaldo());
    }
    public double getSaldo() {
        return saldo;
    }
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}

//Cliente
public class Cliente extends ContaCorrente{
    private String nome;
    private ContaCorrente conta;

    public Cliente(String nome, int numero){
        this.nome = nome;
        this.conta = new ContaCorrente(numero);
        this.conta.setCliente(this);
    }
    public Cliente() {
    }
    public void opera(){
        conta.depositaValor(200);
        conta.retiraValor(20);
    }
    public void print(){
        System.out.println("Numero da conta: " + numero);
        System.out.println("Cliente: " + nome);
        System.out.println("Saldo:" + conta.getSaldo());
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public ContaCorrente getConta() {
        return conta;
    }
    public void setConta(ContaCorrente conta) {
        this.conta = conta;
    }
}

//Banco
public class Banco extends Cliente {
    private String nome;
    private ArrayList <Cliente> clientes;

    Scanner teclado = new Scanner(System.in);

    public Banco(String nome){
        super();
        this.nome = nome;
        clientes = new ArrayList<Cliente>();
    }
    public void addCliente(String nome, int conta){
    }
    void addCliente(Cliente nic) {
    }
    public void printClientes(){
        for (Cliente c : clientes){
            c.print();
        }
    }
}

//Leitura de dados
public class OBanco {

    public static void main(String[] args) {

        Banco a = new Banco("a");
        Cliente nicholas = new Cliente("Nicholas", 7474);
        a.addCliente(nicholas);
      
        Cliente gabriel = new Cliente("Gabriel", 0904);
        a.addCliente(gabriel);
        
        Cliente gustavo = new Cliente("Gustavo", 2003);
        a.addCliente(gustavo);

        System.out.println("BANCO PUCPR");
        System.out.println("Cliente: " + nicholas.getNome() + " - Operações: ");
        nicholas.opera();
        System.out.println("Cliente: " + gabriel.getNome() + " - Operações: ");
        gabriel.opera();
        System.out.println("Cliente: " + gustavo.getNome() + " - Operações: ");
        gustavo.opera();
      
        System.out.println("CLIENTES DO BANCO PUCPR");
        nicholas.imprimir();
        gabriel.imprimir();
        gustavo.imprimir();
    }
}
