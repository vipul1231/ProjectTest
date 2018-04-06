import com.walkerdigital.toolkit.money.Currency;

/******************************
 * INSTRUCTIONS
 *
 * Steps:
 * 1. Add Unit tests for all public methods.
 * 2. All methods must have Javadoc comments.
 * 3. Fix the bug. Run the main method and you will see HKD and MYR are the same. This is not correct.
 * 4. New functionality: create and implement a public interface for adding new currencies at runtime
 * 5. Refactor the Currency class and explain why your refactors are improvements.
 *
 * When the updates have been completed, zip up the project and email it back.
 * Use of 3rd-party software (e.g. frameworks like Maven) is encouraged where applicable, however please point out all instances where the code you used was not your own.
 * Provide information on how long you worked on it and explain your changes.
 ******************************/
public class Main {

    public static void main(String[] args) {
        Currency currencyUSD = Currency.getByCurrencyCode("USD");
        Currency currencyHKD = Currency.getByCurrencyCode("HKD");
        Currency currencyMYR = Currency.getByCurrencyCode("MYR");

        boolean currenciesAreSame = currencyUSD.equals(currencyHKD);
        if (currenciesAreSame) {
            System.out.println("USD and HKD currencies are the same.");
        }
        else {
            System.out.println("USD and HKD currencies are different.");
        }

        currenciesAreSame = currencyUSD.equals(currencyMYR);
        if (currenciesAreSame) {
            System.out.println("USD and MYR currencies are the same.");
        }
        else {
            System.out.println("USD and MYR currencies are different.");
        }

        currenciesAreSame = currencyHKD.equals(currencyMYR);
        if (currenciesAreSame) {
            System.out.println("HKD and MYR currencies are the same.");
        }
        else {
            System.out.println("HKD and MYR currencies are different.");
        }
    }
}
