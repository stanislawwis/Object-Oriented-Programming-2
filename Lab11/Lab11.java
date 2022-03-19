import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Scanner;

public class Lab11 {
    public static String[] getArgs(String arg) {
        return Arrays.stream(arg.split("[\\s+(),]"))
                .filter(w -> !w.isEmpty())
                .toArray(String[]::new);
    }

   // Celem dzisiejszych zajęć jest skorzystanie z mechanizmu refleksji
//    Na początku wypisujemy wszystkie możliwe metody z klasy Math które maja 1 lub 2 argumenty

    public static Boolean parsesAsDouble(String arg) {
        Double x;
        try {
            x = Double.valueOf(arg);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public static Object parseArg(String type, String toparse) throws NumberFormatException {
            if(type.equals("int")) {
                try {
                    return Integer.valueOf(toparse);
                } catch (NumberFormatException e) { throw e; }
            }
            else if(type.equals("double")){
                try {
                    return Double.valueOf(toparse);
                } catch (NumberFormatException e) { throw e; }
            }
            else if(type.equals("long")){
                try {
                    return Long.valueOf(toparse);
                } catch (NumberFormatException e) { throw e; }
            }
            else if(type.equals("float")){
                try {
                    return Float.valueOf(toparse);
                } catch (NumberFormatException e) { throw e; }
            }
            else {
                System.out.println("Jak do tego doszlo :((");
                return null;
            }
        }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Class math = java.lang.Math.class;
        Method[] methods = Arrays.stream(math.getMethods()).filter(m -> 0 < m.getParameterCount() && m.getParameterCount() < 2).toArray(Method[]::new);
        String[] names = Arrays.stream(methods).map(m -> m.getName()).toArray(String[]::new);
        for(Method method : methods) {
            System.out.println(method);
        }
        // take input
        System.out.println("\n\nWywolaj funkcje dostepna w pakiecie Math, jedno- lub dwuargumentowa");
        String input = sc.next();
        String[] tokens = getArgs(input);

        // validate any call
        // 1. validate length of tokens
        if(tokens.length > 3 || tokens.length < 2) { System.out.println("Wywolaj funkcje na 1 lub 2 argumentach."); return; }
        // 2. validate valid name of func
        if(Arrays.stream(names).filter(n -> n.equals(tokens[0])).findAny().isEmpty()) { System.out.println("Wywolaj funkcje o poprawnej nazwie"); return; }
        // 3. validate that args are numeric
        if(!(Arrays.stream(tokens,1,tokens.length).allMatch(arg -> parsesAsDouble(arg)))) { System.out.println("Argumenty musza byc typu numerycznego"); return; }

        // if passed validation, invoke
        // 1. find methods of that name
        Method[] tocall = Arrays.stream(methods).filter(m -> m.getName().equals(tokens[0])).toArray(Method[]::new);

        // 2. call in sequence
        Object result = null;
        for(Method method: tocall) {
            if(tokens.length - 1 != method.getParameterCount()) { continue; }
            // parse string args as formal argument types of method
            String[] splitm = method.toString().split(" ");
            String[] ts = getArgs(splitm[splitm.length-1]);
            String type1 = ts[1];
            String type2;
            try { type2 = ts[2]; } catch(IndexOutOfBoundsException e) { type2 = null; }
            Object arg1;
            Object arg2;
            try { arg1 = parseArg(type1, tokens[1]); } catch(NumberFormatException e) { continue; }
            try { arg2 = parseArg(type2, tokens[2]); } catch(IndexOutOfBoundsException e) { arg2 = null; } catch(NumberFormatException e) { continue; }
            try {
                if(arg2 != null) {
                    result = method.invoke(null, arg1, arg2);
                } else {
                    result = method.invoke(null, arg1);
                }
            } catch (Exception e) { System.out.println("Wystapil nieobslugiwany blad"); }
            System.out.println("Wynik: " + result);
        }
        if(result == null) {
            System.out.println("Poprawna nazwa funkcji, ale nie lista argumentow");
        }
       
    }

    // Następnie użytkownik wpisuje funkcję matematyczną do wywołania, np. tan(1.0), należy obsłużyc wszystkie funkcje z klasy Math, które zawierają 1 lub 2 argumenty
    // Metodę w klasie Math należy znaleźć przy użyciu metody "getMethod" z klasy Class
    // Następnie wypisujemy wynik równania i kończymy program
    // Oczywiście program musi obsługiwać wyjątki takie jak: wywołanie metody która nie istnieje w klaie Math, Wywoałenie metody ze złą liczbą argumentów, 
    // czy podaniem do funkcji typu argumentu innego niz int/float/double
    // Mamy napisaną metodę getArgs do której podajemy np: "sin(4.12)" i otrzymujemy tablicę: [sin, 4.12]
}
