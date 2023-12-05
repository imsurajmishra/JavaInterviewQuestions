package questions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.asyncq.questions.PalindromeCheck;

public class PalindromeTest {

    @Test
    public void givenPalindromesInputString_whenIsValid_thenReturnsTrue(){
        List<String> palindromes = List.of("ABA", "AA", "CCACC");
        palindromes.forEach(p -> {
            PalindromeCheck pc = new PalindromeCheck();
            boolean actual = pc.validate(p);
            assertEquals(true, actual);
        });

        palindromes.forEach(p -> {
            PalindromeCheck pc = new PalindromeCheck();
            boolean actual = pc.validateRec(p,0,p.length()-1);
            assertEquals(true, actual);
        });
    }

    @Test
    public void givenNonPalindromesInputString_whenIsValid_thenReturnsFalse(){
        List<String> nonPalindromes = List.of("ABAA", "AAP", "CACC");
        nonPalindromes.forEach(p -> {
            PalindromeCheck pc = new PalindromeCheck();
            boolean actual = pc.validate(p);
            assertEquals(false, actual);
        });

        nonPalindromes.forEach( p -> {
            PalindromeCheck pc = new PalindromeCheck();
            boolean actual = pc.validateRec(p,0,p.length()-1);
            assertEquals(false, actual);
        });
    }
}
