import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;
import java.util.stream.Collectors;

public class Principal {
    public static void main(String[] args) {
        List<Funcionario> funcionarios = new ArrayList<>();

        // 3.1 Inserir funcionários (exemplo comum de tabelas desse teste)
        funcionarios.add(new Funcionario("Maria", LocalDate.of(2000, 10, 18), new BigDecimal("2009.44"), "Operador"));
        funcionarios.add(new Funcionario("João", LocalDate.of(1990, 5, 12), new BigDecimal("2284.38"), "Operador"));
        funcionarios.add(new Funcionario("Caio", LocalDate.of(1961, 5, 2), new BigDecimal("9836.14"), "Coordenador"));
        funcionarios.add(new Funcionario("Miguel", LocalDate.of(1988, 10, 14), new BigDecimal("19119.88"), "Diretor"));
        funcionarios.add(new Funcionario("Alice", LocalDate.of(1995, 1, 5), new BigDecimal("2234.68"), "Recepcionista"));
        funcionarios.add(new Funcionario("Heitor", LocalDate.of(1999, 11, 19), new BigDecimal("1582.72"), "Operador"));
        funcionarios.add(new Funcionario("Arthur", LocalDate.of(1993, 3, 31), new BigDecimal("4071.84"), "Contador"));
        funcionarios.add(new Funcionario("Laura", LocalDate.of(1994, 7, 8), new BigDecimal("3017.45"), "Gerente"));
        funcionarios.add(new Funcionario("Heloísa", LocalDate.of(2003, 5, 24), new BigDecimal("1606.85"), "Eletricista"));
        funcionarios.add(new Funcionario("Helena", LocalDate.of(1996, 9, 2), new BigDecimal("2799.93"), "Gerente"));

        // 3.2 Remover João
        funcionarios.removeIf(f -> f.getNome().equals("João"));

        // 3.3 Imprimir todos os funcionários com formatações
        System.out.println("=== Funcionários ===");
        funcionarios.forEach(System.out::println);

        // 3.4 Aumento de 10%
        funcionarios.forEach(f -> f.setSalario(f.getSalario().multiply(new BigDecimal("1.10"))));

        // 3.5 Agrupar por função
        Map<String, List<Funcionario>> porFuncao = funcionarios.stream()
                .collect(Collectors.groupingBy(Funcionario::getFuncao));

        // 3.6 Imprimir agrupados
        System.out.println("\n=== Agrupados por função ===");
        porFuncao.forEach((funcao, lista) -> {
            System.out.println("\nFunção: " + funcao);
            lista.forEach(System.out::println);
        });

        // 3.8 Aniversariantes mês 10 e 12
        System.out.println("\n=== Aniversariantes em Outubro e Dezembro ===");
        funcionarios.stream()
                .filter(f -> {
                    int m = f.getDataNascimento().getMonthValue();
                    return m == 10 || m == 12;
                })
                .forEach(System.out::println);

        // 3.9 Funcionário com maior idade
        Funcionario maisVelho = funcionarios.stream()
                .min(Comparator.comparing(Funcionario::getDataNascimento))
                .orElse(null);
        if (maisVelho != null) {
            int idade = Period.between(maisVelho.getDataNascimento(), LocalDate.now()).getYears();
            System.out.println("\n=== Funcionário mais velho ===");
            System.out.println("Nome: " + maisVelho.getNome() + " | Idade: " + idade);
        }

        // 3.10 Ordem alfabética
        System.out.println("\n=== Funcionários em ordem alfabética ===");
        funcionarios.stream()
                .sorted(Comparator.comparing(Funcionario::getNome))
                .forEach(System.out::println);

        // 3.11 Total dos salários
        BigDecimal total = funcionarios.stream()
                .map(Funcionario::getSalario)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println("\n=== Total dos salários ===");
        System.out.println(Util.formatarMoeda(total));

        // 3.12 Quantos salários mínimos (R$1212,00)
        BigDecimal salarioMinimo = new BigDecimal("1212.00");
        System.out.println("\n=== Salários mínimos por funcionário ===");
        funcionarios.forEach(f -> {
            BigDecimal qtd = f.getSalario().divide(salarioMinimo, 2, java.math.RoundingMode.HALF_UP);
            System.out.println(f.getNome() + " ganha " + qtd + " salários mínimos.");
        });
    }
}