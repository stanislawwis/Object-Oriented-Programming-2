import java.util.Scanner;

class Cesar {
	private static String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        String s_word = sc.nextLine();
        
        char[] word = s_word.toCharArray();
        int len = s_word.length();
        int shift = Integer.valueOf(args[1]);
        String mode = args[0];

        System.out.print("Dla alfabetu: " + alphabet + "\n" +
        	"Dla slowa: " + new String(word) + "\n" +
        	"Przesuniecia: " + shift + "\n" +
        	"Trybu: " + mode + "\n\n"
        	);

        if(mode.equals("decode")) {
        	shift = -shift;
        }
        else if(mode.equals("code")) {}
    	else {
    		System.out.println("Bad arguments");
    	}


    	for(int i = 0; i < len; i++) {
    		int alen = alphabet.length();
    		int index = (alphabet.indexOf(word[i]) + shift + (-shift/alen + 1) * alen) % alen;
    		if(!Character.isWhitespace(word[i])) {
    			word[i] = alphabet.charAt(index);
    		}
    	}

        System.out.println("Wynik: " + new String(word));
	}
}