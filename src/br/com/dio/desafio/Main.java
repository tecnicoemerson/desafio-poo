package br.com.dio.desafio;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args){
        Curso curso1 = new Curso();
        curso1.setTitulo("Curso Java");
        curso1.setDescricao("Apredendo poo");
        curso1.setCargaHoraria(8);
        System.out.println(curso1);

        Curso curso2 = new Curso();
        curso2.setTitulo("Curso estrutura de dados");
        curso2.setDescricao("OO");
        curso2.setCargaHoraria(8);
        System.out.println(curso2);

        Mentoria mentoria1 = new Mentoria();
        mentoria1.setTitulo("Material java");
        mentoria1.setDescricao("Como lidar com Java");
        mentoria1.setData(LocalDate.now());
        System.out.println(mentoria1);
    }
}
