package br.com.dio.desafio;

import br.com.dio.desafio.dominio.Bootcamp;
import br.com.dio.desafio.dominio.Curso;
import br.com.dio.desafio.dominio.Dev;
import br.com.dio.desafio.dominio.Mentoria;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

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

        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setNome("Bootcamp Java developer");
        bootcamp.setDescricao("Descricao Bootcamp Java");
        bootcamp.getConteudos().add(curso1);
        bootcamp.getConteudos().add(curso2);
        bootcamp.getConteudos().add(mentoria1);

        System.out.println("--------");

        Dev devEmerson = new Dev();
        devEmerson.setNome("Emerson");
        devEmerson.inscreverBootcamp(bootcamp);
        System.out.println("Conteudos incritos Emerson " + devEmerson.getConteudosInscricao());
        devEmerson.progredir();
        devEmerson.progredir();
        System.out.println("-------------");
        System.out.println("Conteudos incritos Emerson " + devEmerson.getConteudosInscricao());
        System.out.println("Conteudos concluidos Emerson " + devEmerson.getConteudosConcluidos());
        System.out.println("XP: " + devEmerson.calcularTotalXp());
        devEmerson.exibirRelatorio();
        devEmerson.emitirCertificado();

        System.out.println("--------------------------");

        Dev devEverton = new Dev();
        devEverton.setNome("Everton");
        devEverton.inscreverBootcamp(bootcamp);
        System.out.println("Conteudos incritos Everton " + devEverton.getConteudosInscricao());
        devEverton.progredir();
        devEverton.progredir();
        devEverton.progredir();
        System.out.println("--------");
        System.out.println("Conteudos incritos Everton " + devEverton.getConteudosInscricao());
        System.out.println("Conteudos concluidos Everton " + devEverton.getConteudosConcluidos());
        System.out.println("XP: " + devEverton.calcularTotalXp());
        devEverton.exibirRelatorio();
        devEverton.emitirCertificado();

        System.out.println("===== RANKING DE DEVS POR XP =====");
        List<Dev> rankingDevs = Arrays.asList(devEmerson, devEverton);

        rankingDevs.stream()
                .sorted(Comparator.comparingDouble(Dev::calcularTotalXp).reversed())
                .forEach(dev -> System.out.println(
                        dev.getNome() + " - XP: " + dev.calcularTotalXp()
                ));
    }
}
