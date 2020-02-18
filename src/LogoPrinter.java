public class LogoPrinter {
    private static StringBuilder logo;

    public LogoPrinter() {
        logo = new StringBuilder();
    }

    public void printFigure(int n) {
        if (numberChecker(n)) {
            int halfRowsCount = n / 2 + 1;
            for (int i = 0; i < halfRowsCount; i++) {
                logo.append(topHalfRow(n, i));
                logo.append(System.lineSeparator());
            }
            for (int i = 0; i < halfRowsCount; i++) {
                logo.append(botHalfRow(n, i, halfRowsCount));
                logo.append(System.lineSeparator());
            }

            System.out.println(logo);
        } else {
            System.out.println("N must be an odd number and must be between 2 and 10 000");
        }
    }

    private boolean numberChecker(int n) {
        boolean flag = false;
        if (n > 2 && n < 10000 && n % 2 != 0) {
            flag = true;
        }
        return flag;
    }

    private static String topHalfRow(int n, int i) {
        String row = "";
        for (int j = 0; j < 2; j++) {
            row += repeater(n - i, "-");
            row += repeater(n + (i * 2), "*");
            row += repeater(n - (i * 2), "-");
            row += repeater(n + (i * 2), "*");
            row += repeater(n - i, "-");
        }
        return row;
    }

    private static String botHalfRow(int n, int i, int rows) {
        String row = "";
        for (int j = 0; j < 2; j++) {
            row += repeater(rows - (i + 1), "-");
            row += repeater(n, "*");
            row += repeater(i * 2 + 1, "-");
            row += repeater(n * 2 - 1 - (i * 2), "*");
            row += repeater(i * 2 + 1, "-");
            row += repeater(n, "*");
            row += repeater(rows - (i + 1), "-");
        }
        return row;
    }

    private static String repeater(int n, String s) {
        return String.valueOf(s).repeat(n);
    }
}
