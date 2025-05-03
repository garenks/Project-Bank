package br.com.fecaf.controller;

import br.com.fecaf.model.Cliente;
import br.com.fecaf.model.Conta;

import java.util.Scanner;

public class Login {

    Scanner scanner = new Scanner(System.in);
    public Conta realizarLogin (Conta referenciaConta, Cliente referenciaCliente) {
        System.out.print("Informe o CPF: ");
        long cpfuser = scanner.nextLong();
        scanner.nextLine();
        System.out.println("Informe a Senha: ");
        String passwordUser = scanner.nextLine();


        Conta contaCliente = validarLogin(cpfuser, passwordUser, referenciaConta, referenciaCliente);
        if (contaCliente != null){
            return contaCliente;
        }else {
            System.out.println("Dados incorretos! Verifique novamente ou abra uma conta.");
        }
        return null;

    }

    public Conta validarLogin (long cpfuser, String passwordUser, Conta referenciaConta, Cliente referenciaCliente){
        Cliente dadosCliente = referenciaCliente.pesquisarCliente(cpfuser);

        if (dadosCliente != null) {
            Conta contaCliente = referenciaConta.pesquisarConta(dadosCliente);
            String password = contaCliente.getPassword();

            if (password .equals(passwordUser)) {
                return contaCliente;
            }
        }
        return null;

    }

}
