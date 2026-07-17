package br.com.dio.desafio.dominio;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class Dev {
    private String nome;
    private Set<Conteudo> conteudosInscricao = new LinkedHashSet<>();
    private Set<Conteudo> conteudosConcluidos = new LinkedHashSet<>();

    public double calcularProgresso() {
        int totalConteudos = conteudosInscricao.size() + conteudosConcluidos.size();

        if (totalConteudos == 0) {
            return 0;
        }

        return (conteudosConcluidos.size() * 100.0) / totalConteudos;
    }

    public String verificarStatus() {
        if (conteudosInscricao.isEmpty() && !conteudosConcluidos.isEmpty()) {
            return "Bootcamp concluído";
        } else if (!conteudosInscricao.isEmpty() && !conteudosConcluidos.isEmpty()) {
            return "Em andamento";
        } else if (!conteudosInscricao.isEmpty()) {
            return "Inscrito";
        } else {
            return "Sem inscrição";
        }
    }

    public String verificarNivel() {
        double xp = calcularTotalXp();

        if (xp < 100) {
            return "Iniciante";
        } else if (xp < 200) {
            return "Intermediário";
        } else {
            return "Avançado";
        }
    }

    public void exibirRelatorio() {
        System.out.println("===== RELATÓRIO DO DEV =====");
        System.out.println("Nome: " + nome);
        System.out.println("Status: " + verificarStatus());
        System.out.printf("Progresso: %.2f%%\n", calcularProgresso());
        System.out.println("Nível: " + verificarNivel());
        System.out.println("XP total: " + calcularTotalXp());
        System.out.println("Conteúdos pendentes: " + conteudosInscricao.size());
        System.out.println("Conteúdos concluídos: " + conteudosConcluidos.size());
        System.out.println("============================");
    }

    public void emitirCertificado() {
        if (conteudosInscricao.isEmpty() && !conteudosConcluidos.isEmpty()) {
            System.out.println("Certificado emitido para " + nome);
            System.out.println("Parabéns! Você concluiu todos os conteúdos do bootcamp.");
        } else {
            System.out.println(nome + " ainda não concluiu todos os conteúdos.");
        }
    }

    public void inscreverBootcamp(Bootcamp bootcamp) {
        this.conteudosInscricao.addAll(bootcamp.getConteudos());
        bootcamp.getDevsInscritos().add(this);
    }

    public void progredir(){
        Optional<Conteudo> conteudo = this.conteudosInscricao.stream().findFirst();
        if (conteudo.isPresent()){
            this.conteudosConcluidos.add(conteudo.get());
            this.conteudosInscricao.remove(conteudo.get());
        }else {
            System.out.println("Voce nao esta matriculado em nenhum conteudo!");
        }
    }

    public double calcularTotalXp(){
       return this.conteudosConcluidos
               .stream()
               .mapToDouble(Conteudo::calcularXp)
               .sum();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<Conteudo> getConteudosInscricao() {
        return conteudosInscricao;
    }

    public void setConteudosInscricao(Set<Conteudo> conteudosInscricao) {
        this.conteudosInscricao = conteudosInscricao;
    }

    public Set<Conteudo> getConteudosConcluidos() {
        return conteudosConcluidos;
    }

    public void setConteudosConcluidos(Set<Conteudo> conteudosConcluidos) {
        this.conteudosConcluidos = conteudosConcluidos;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Dev dev = (Dev) o;
        return Objects.equals(nome, dev.nome) && Objects.equals(conteudosInscricao, dev.conteudosInscricao) && Objects.equals(conteudosConcluidos, dev.conteudosConcluidos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, conteudosInscricao, conteudosConcluidos);
    }
}
