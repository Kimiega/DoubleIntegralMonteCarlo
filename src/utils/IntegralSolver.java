package utils;

import models.Dot;
import models.Polygon;

import java.util.List;

public class IntegralSolver {
    private Polygon polygon;
    private Long fineness;

    public IntegralSolver(Long fineness, Polygon polygon) {
        this.fineness = fineness;
        this.polygon = polygon;
    }

    private Double function(double x, double y) {
        return x * Math.sin(x*y);
    }

    private Double monteCarloIntegralFunction(Double s, int N, Double sum) {
        return s/N*sum;
    }
    public Double integrateMonteCarlo() {
        Double answer;
        long finenessForSquare = 10000;
        Long fieldCount = polygon.countDotsInPolygon(finenessForSquare);
        Double dArea = polygon.getArea(finenessForSquare);
        Double s = fieldCount * dArea;
        //Double s = 128.0128D;
        System.out.println("Answer");
        List<Dot> selection = polygon.makeFieldInPolygon(fineness);
        int N = selection.size();
        double sum = 0D;
        for (Dot dot : selection) {
            sum += function(dot.getX(), dot.getY());
        }
        answer = monteCarloIntegralFunction(s, N, sum);
        return answer;
    }


}
