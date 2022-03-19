import java.util.Scanner;


public class Lab10 {
    // Celem dzisiejszych zajęć jest napisanie prostej "gry"
    // Na początku program powinien przyjąć od użytkownika dwie wartości:
    // - rozmiar planszy (liczba większa od 3, jeśli użytkownik poda mniejszą powinien polecieć wyjątek(np. TooSmallGameSizeException) 
    // nastepnie zostac zlapany i wyswietlona informacja uzytkownikowi "Podano zbyt mały rozmiar, spróbuj ponownie")
    // - prawdopodobienstwo wystapienia wody( wieksze od 0, analogiczna sytuacja do rozmiaru)
    // Na postawie tych wartości należy stworzyć kwadratową planszą (tablice tablic, lub listę list). Następnie należy ją wypełnić znakami:
    // - znak W -> woda z prawdopodobienstwem podanym przez uzytkownika
    // - znak S -> skarb, jeden na całą planszę
    // - znak G -> gracz, jeden na całą planszę
    // - pozostałe pola wypelnic znakiem *
    // Potem nalezy ja wyswietlic
    // Nastepnie program powinien zaczac zbierac opcje od uzytkownika:
    // - l -> gracz porusza sie w lewo
    // - p -> gracz porusza sie w prawo
    // - g -> gracz porusza sie w gore
    // - d -> gracz porusza sie w dol
    // Po wybraniu opcji plansza powinna przerysowac sie na nowo
    // Gra powinna obsługiwać wyjątki takie jak:
    // - wejscie w wodę -> powinien poleciec wyjatek -> gra konczy sie napisem "Wszedłeś w wodę, koniec gry"
    // - nierozpoznanie opcji -> CommandNotRecognisedException
    // - wejscie w pole skarbu -> powinien poleciec wyjatek -> gra konczy sie napisem "Wygrałeś!!!"
    // Wejscie w pole skarbu lub wody konczy wykonywanie programu

    //init
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Podaj rozmiar\n>");
        Integer size = sc.nextInt();
        System.out.print("Podaj prawdopodobienstwo wody\n>");
        SquareBoard board;
        Double pw;

        try {
            pw = sc.nextDouble();
            if(pw < 0 || pw > 1) { throw new BadProbabilityException(); }
        }
        catch(BadProbabilityException e) { System.out.println("Zle prawdopodobienstwo"); return;}
        try {
            board = new SquareBoard(size, pw);
        }
        catch(TooSmallGameSizeException e) { System.out.println("Zly rozmiar"); return; }
        Integer px = Long.valueOf(Math.round(Math.random() * size-1)).intValue();
        Integer py = Long.valueOf(Math.round(Math.random() * size-1)).intValue();
        if(px == -1) { px = 0; }
        if(py == -1) { py = 0; }
        while(board.isSquareWater(px,py) || board.isSquareTreasure(px,py)) {
            px = Long.valueOf(Math.round(Math.random() * size-1)).intValue();
            py = Long.valueOf(Math.round(Math.random() * size-1)).intValue();
            if(px == -1) { px = 0; }
            if(py == -1) { py = 0; }
        }
        
        Player p = new Player(
            px,
            py,
            board
            );

        while(true) {
            board.printBoard(p.x(), p.y());
            System.out.println("Komenda?\n>");
            Character command = sc.next().charAt(0);
            try {
                p.move(Player.char2Dir(command));
            }
            catch(VictoryException e) {
                System.out.println("Wygrales!!!!!!!!");
                break;
            }
            catch(GameOverException e) {
                System.out.println("Przegrales..............:(((");
                break;
            }
            catch(CantMoveHereException e) {
                System.out.println("Niepoprawny ruch, wybierz inny");
                continue;
            }
        }
    }
}
