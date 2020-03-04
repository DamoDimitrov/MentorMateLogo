public class LogoPrinter {
    private static StringBuilder logo;

    public LogoPrinter() {
        logo = new StringBuilder();
    }

    public void printingFigure(int n) {
        if (numberValidation(n)) {
            int halfRowsCount = n / 2 + 1;
            logo.append(concatRows(halfRowsCount, n));
//            for (int i = 0; i < halfRowsCount; i++) {
//                logo.append(topHalfRows(n, i));
//                logo.append(System.lineSeparator());
//            }
            for (int i = 0; i < halfRowsCount; i++) {
                logo.append(bottomHalfRows(n, i));
                logo.append(System.lineSeparator());
            }

            System.out.println(logo);
        } else {
            System.out.println("N must be an odd number and must be between 2 and 10 000");
        }
    }
    private static String concatRows(int rowsCount, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < rowsCount; i++) {
            sb.append(topHalfRows(n, i));
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }

    private static String topHalfRows(int n, int i) {
        String row = repeatingString(n - i, "-") +
                repeatingString(n + (i * 2), "*") +
                repeatingString(n - (i * 2), "-") +
                repeatingString(n + (i * 2), "*") +
                repeatingString(n - i, "-");
        return repeatingString(2, row);
    }

    private static String bottomHalfRows(int n, int i) {
        int rows = n / 2 + 1;
        String row = repeatingString(rows - (i + 1), "-") +
                repeatingString(n, "*") +
                repeatingString(i * 2 + 1, "-") +
                repeatingString(n * 2 - 1 - (i * 2), "*") +
                repeatingString(i * 2 + 1, "-") +
                repeatingString(n, "*") +
                repeatingString(rows - (i + 1), "-");
        return repeatingString(2, row);
    }

    private static String repeatingString(int n, String s) {
        return String.valueOf(s).repeat(n);
    }

    private boolean numberValidation(int n) {
        return n > 2 && n < 10000 && n % 2 != 0;
    }
}
