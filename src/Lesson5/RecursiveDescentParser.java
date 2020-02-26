package Lesson5;

/*
 * Expr -> Term + Expr | Term - Expr | Term
 * Term -> Factor * Term | Factor / Term | Factor
 * Factor -> Number | (Expr) | func(Expr)
 *
 * 2 + 2 - 3 * 2 + 3 * ( 4 + 5 ) - 6 * 7 + sin(10) + cos(12 + 1)
 *
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class RecursiveDescentParser {

    // решение из урока
//    private static Map<String, Function<Double, Double>> functionMap = buildFunctionMap();
//
//    private static Map<String,Function<Double,Double>> buildFunctionMap() {
//        Map<String, Function<Double, Double>> functionMap = new HashMap<>();
//        functionMap.put("sin", Math::sin);
//        functionMap.put("cos", Math::cos);
//        functionMap.put("tan", Math::tan);
//        return functionMap;
//    }

    private final List<String> tokens;
    private int pos = 0;

    public RecursiveDescentParser(List<String> tokens) {
        this.tokens = tokens;
    }

    public Double parse() {
        return expression();
    }

    private Double expression() {
        Double first = term();
        while (pos< tokens.size()) {
            String operator = tokens.get(pos);

            if (!operator.equals("+") && !operator.equals("-")) {
                break;
            } else {
                pos++;
            }

            Double second = term();
            if (operator.equals("+")) {
                first += second;
            } else {
                first -= second;
            }
        }
        return first;
    }

    private Double term() {
        Double first = factor();

        while (pos < tokens.size()) {
            String operator = tokens.get(pos);
            if (!operator.equals("*") && !operator.equals("/")) {
                return first;
            } else {
                pos++;
            }

            Double second = factor();
            if (operator.equals("*")) {
                first *= second;
            } else {
                first /= second;
            }
        }
        return first;
    }

    private Double factor() {
        String next = tokens.get(pos);
        Double result;
        if (next.equals("(")) {
            pos++;
            result = expression();
            String closingBracket = null;
            if (pos < tokens.size() && (closingBracket = tokens.get(pos)).equals(")")) {
                pos++;
                return result;
            }
            throw new IllegalStateException("')' expected but " + closingBracket);
        } else if (next.equals("sin")) {
            pos++;
            result = Math.sin(factor());
            if (tokens.get(pos).equals("(")) {
                pos++;
                result = expression();
                String closingBracket = null;
                if (pos < tokens.size() && (closingBracket = tokens.get(pos)).equals(")")) {
                    pos++;
                    return result;
                }
                throw new IllegalStateException("')' expected but " + closingBracket);
            }
            return result;
        }

        // решение из урока
//        else if (functionMap.containsKey(next)) {
//            pos++;
//            return functionMap.get(next).apply(factor());
//        }
        pos++;
        return Double.parseDouble(next);
    }

    public static void main(String[] args) {
        String expr = "2.111 * 3.5 + ( 3 + 4 * ( 2.1 + 3 ) - 10 ) * ( sin ( 5 ) - 7 + 4 - 2 ) + 11";
        RecursiveDescentParser recursiveDescentParser = new RecursiveDescentParser(Arrays.asList(expr.split(" ")));
        System.out.println(recursiveDescentParser.parse());
        System.out.println(2.111*3.5+(3 + 4 * (2.1 + 3) - 10 )*(Math.sin(5)-7+4-2) + 11);
    }
}


