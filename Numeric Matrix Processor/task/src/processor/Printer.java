package processor;

public class Printer {
    public static String toArray(double[][] matrix){
        StringBuilder out = new StringBuilder();

        boolean isFloat = false;
        for (double[] doubles : matrix) {
            for (int j = 0; j < matrix[0].length; j++) {
                int integer = (int) doubles[j];
                double decimalSection = doubles[j] - integer;
                if (decimalSection > 0) {
                    isFloat = true;
                    break;
                }
            }
        }
        for (double[] doubles : matrix) {
            for (int j = 0; j < matrix[0].length; j++) {
                int integer = (int) doubles[j];
                if (isFloat) {
                    if (doubles[j] == 0){
                        out.append(0).append(" ");
                    }else{
                        out.append(String.format("%.2f", doubles[j])).append(" ");
                    }

                } else {
                    out.append(integer).append(" ");
                }

            }
            out.delete(out.length() - 1, out.length());
            out.append('\n');
        }
        return out.toString().trim();
    }
}
