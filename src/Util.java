import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Util {
    private static final DateTimeFormatter FORMATADOR_DATA = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private static final DecimalFormatSymbols SYMBOLS = new DecimalFormatSymbols(new Locale("pt", "BR"));
    private static final DecimalFormat FORMATADOR_MOEDA = new DecimalFormat("#,##0.00", SYMBOLS);

    public static String formatarData(LocalDate data) {
        return data.format(FORMATADOR_DATA);
    }

    public static String formatarMoeda(BigDecimal valor) {
        return FORMATADOR_MOEDA.format(valor);
    }
}