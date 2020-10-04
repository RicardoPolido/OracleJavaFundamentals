import java.util.Scanner;

public class TestaProduto {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Integer menuChoice, maxSize = getNumProducts(scanner);

        if (maxSize == 0) {
            System.out.println("Não há produtos!");
        } else {

            Produto[] produtos = new Produto[maxSize];
            addToInventory(produtos, scanner);

            do {
                menuChoice = getMenuOption(scanner);
                executeMenuChoice(menuChoice, produtos, scanner);
            } while (menuChoice != 0);
        }
    }

    private static void executeMenuChoice(Integer menuChoice, Produto[] produtos, Scanner scanner) {

        switch (menuChoice) {
            case 1:
                System.out.println("Exibir Lista de Produtos");
                displayInventory(produtos);
                break;
            case 2:
                System.out.println("Adicionar Estoque");
                addInventory(produtos, scanner);
                break;
            case 3:
                System.out.println("Deduzir Estoque");
                deductInventory(produtos, scanner);
                break;
            case 4:
                System.out.println("Descontinuar Estoque");
                discontinueInventory(produtos, scanner);
            default:
                System.out.println("Saindo do Programa ...");
        }
    }

    private static Integer getNumProducts(Scanner scanner) {

        Integer maxSize = -1;

        do {
            try {

                System.out.println("Insira o número de produtos que gostaria de adicionar.");
                System.out.print("Insira 0 (zero) se não quiser adicionar produtos: ");
                maxSize = scanner.nextInt();

                if (maxSize < 0) {
                    System.out.println("Valor incorreto inserido.");
                } else if (maxSize == 0) {
                    System.out.println("Programa finalizado.");
                }

            } catch (Exception e) {
                System.out.println("Expection: " + e.getMessage());
                clearBuffer(scanner);
            }

        } while (maxSize < 0);

        return maxSize;
    }

    private static void addToInventory(Produto[] produtos, Scanner scanner) {

        Integer stockChoice = -1;

        for(int i = 0; i < produtos.length; i++){
            do {
                try {
                    System.out.println("1: CD");
                    System.out.println("2: DVD");
                    System.out.println("Insira o tipo de produto: ");
                    stockChoice = scanner.nextInt();

                    if (stockChoice != 1 && stockChoice != 2) {
                        System.out.println("Somente os números 1 ou 2 são permitidos!");
                    }
                } catch (Exception e) {
                    System.out.println("Exceção: " + e.getMessage());
                    clearBuffer(scanner);
                }

            } while (!(stockChoice >= 1 && stockChoice <= 2));

            if (stockChoice == 1) {
                addCDToInventory(produtos, scanner, i);
            } else {
                addDVDToInventory(produtos, scanner, i);
            }
        }
    }

    private static void addCDToInventory(Produto[] produtos, Scanner scanner, Integer indice) {

        Long tempId;
        Integer tempQuantidade, tempNumeroMusicas;
        String tempNome, tempArtista, tempSelo;
        Double tempPreco;


        System.out.println("Por favor insira os dados do CD: ");
        System.out.print("Insira o nome do CD: ");
        tempNome = scanner.next();
        System.out.print("Insira o nome do artista: ");
        tempArtista = scanner.next();
        System.out.print("Insira o nome do selo de gravação: ");
        tempSelo = scanner.next();
        System.out.print("Insira o número de músicas: ");
        tempNumeroMusicas = scanner.nextInt();
        System.out.print("Insira a quantidade em estoque para este produto: ");
        tempQuantidade = scanner.nextInt();
        System.out.print("Insira o preço para este produto: ");
        tempPreco = scanner.nextDouble();
        System.out.print("Insira o número do item: ");
        tempId = scanner.nextLong();

        produtos[indice] = new CD(tempId, tempNome, tempPreco, tempQuantidade, true, tempArtista, tempNumeroMusicas, tempSelo);

    }

    private static void addDVDToInventory(Produto[] produtos, Scanner scanner, Integer indice) {

        Long tempId;
        Integer tempQuantidade, tempDuracao, tempClassEtaria;
        String tempNome, tempEstudio;
        Double tempPreco;

        System.out.println("Por favor insira os dados do DVD: ");
        System.out.print("Insira o nome do DVD: ");
        tempNome = scanner.next();
        System.out.print("Insira o nome do estúdio cinematográfico: ");
        tempEstudio = scanner.next();
        System.out.print("Insira a classificação etária: ");
        tempClassEtaria = scanner.nextInt();
        System.out.print("Insira a duração em minutos: ");
        tempDuracao = scanner.nextInt();
        System.out.print("Insira a quantidade em estoque para este produto: ");
        tempQuantidade = scanner.nextInt();
        System.out.print("Insira o preço para este produto: ");
        tempPreco = scanner.nextDouble();
        System.out.print("Insira o número do item: ");
        tempId = scanner.nextLong();


        produtos[indice] = new DVD(tempId, tempNome, tempPreco, tempQuantidade, true, tempDuracao, tempClassEtaria, tempEstudio);
    }

    private static Integer getMenuOption(Scanner scanner) {

        Integer opcao = -1;
        String menu = "1. Exibir Inventário" + "\n" +
                "2. Adicionar Estoque" + "\n" +
                "3. Deduzir Estoque" + "\n" +
                "4. Descontinuar Produto" + "\n" +
                "0. Sair" + "\n";

        do {
            try {
                System.out.println(menu);
                System.out.print("Insira uma opção de menu: ");
                opcao = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Exceção: " + e.getMessage());
                clearBuffer(scanner);
            }

        } while (!(opcao >= 0 && opcao <= 4));

        return opcao;
    }

    private static Integer getProductNumber(Produto[] produtos, Scanner scanner) {
        Integer productChoice = -1;

        for (int i = 0; i < produtos.length; i++) {
            System.out.println("Indice do Produto: " + i);
            System.out.println("Nome do Produto: " + produtos[i].getNome());
        }

        do {
            try {
                System.out.print("Selecione um índice de produto para ser alterado: ");
                productChoice = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Exceção: " + e.getMessage());
                clearBuffer(scanner);
            }

        } while (!(productChoice >= 0 && productChoice < produtos.length));

        return productChoice;
    }

    private static void addInventory(Produto[] produtos, Scanner scanner) {

        Integer productChoice, updateValue = -1;

        productChoice = getProductNumber(produtos, scanner);

        do {
            System.out.println("Quantos produtos deseja adicionar?");
            updateValue = scanner.nextInt();
        } while (updateValue < 0);

        produtos[productChoice].addToInventory(updateValue);
    }

    private static void deductInventory(Produto[] produtos, Scanner scanner) {

        Integer productChoice, updateValue = -1;

        productChoice = getProductNumber(produtos, scanner);

        do {
            try {
                System.out.println("Quantos produtos deseja deduzir?");
                updateValue = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Exceção: " + e.getMessage());
                clearBuffer(scanner);
            }

        } while (!(updateValue >= 0 && updateValue < produtos[productChoice].getQuantidade()));

        produtos[productChoice].deductFromInventory(updateValue);
    }

    private static void displayInventory(Produto[] produtos) {
        for (Produto produto : produtos) {
            System.out.println(produto.toString());
        }
    }

    private static void discontinueInventory(Produto[] produtos, Scanner scanner) {
        Integer productChoice = getProductNumber(produtos, scanner);
        produtos[productChoice].setAtivo(false);
    }

    private static void clearBuffer(Scanner scanner) {
        if (scanner.hasNextLine()) {
            scanner.nextLine();
        }
    }
}