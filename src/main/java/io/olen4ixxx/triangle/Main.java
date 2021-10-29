package io.olen4ixxx.triangle;

import io.olen4ixxx.triangle.entity.CustomTriangle;
import io.olen4ixxx.triangle.exception.CustomTriangleException;
import io.olen4ixxx.triangle.entity.CustomTriangleFactory;
import io.olen4ixxx.triangle.filereader.TriangleReader;
import io.olen4ixxx.triangle.filereader.impl.TriangleFileReader;
import io.olen4ixxx.triangle.parser.CustomParser;
import io.olen4ixxx.triangle.parser.impl.CustomTriangleParser;
import io.olen4ixxx.triangle.service.TriangleCalculation;
import io.olen4ixxx.triangle.service.impl.TriangleCalculationService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigDecimal;

public class Main {
    private static final Logger logger = LogManager.getLogger();
    static Object obj[];

    public static void main(String[] args) throws CustomTriangleException {
        System.out.println(obj);
        BigDecimal b2 = new BigDecimal("23.43");
        BigDecimal b3 = new BigDecimal("24");
        b2 = b2.add(new BigDecimal("0.57"));
        System.out.println(b3.equals(b2)); //6
        System.out.println(b2);
        System.out.println(b3);

        int counter = 0;
        logger.info("Id generated: {}", counter++);
        System.out.println(counter);
        double d = 5.249;
        Double.hashCode(d);
        System.out.println(Double.toHexString(d));
        long l = Double.doubleToLongBits(d);
        System.out.println(Long.toHexString(l));
        System.out.println(Integer.toHexString((int) l));
        byte i = (byte) l;
        i = -2 ^ 2;
        System.out.println(i);
        System.out.println(Integer.toBinaryString(i));
        System.out.println(Integer.toBinaryString(i >>> 1));
        System.out.println(Integer.toBinaryString(i >> 1));

        TriangleReader reader = new TriangleFileReader();
        CustomParser parser = new CustomTriangleParser();
        TriangleCalculation calculation = new TriangleCalculationService();
        var list = parser.parseLinesToTriangleCoordinates(reader.readLines("data/triangle.txt"));
        CustomTriangleFactory factory = CustomTriangleFactory.getInstance();
//        double[] a1 = {1,2,3,4,5,6};
//        double[] a2 = {7,2,3,4,5,6};
//        list = List.of(a1,a2);
//        System.out.println(l1);

        for (double[] array : list) {
            var triangle = factory.createCustomTriangle(array);
            calculation.trianglePerimeter(triangle);
            calculation.triangleSquare(triangle);
            System.out.println(triangle.getVertexTwo());
            System.out.println(triangle.getVertexThree());
        }
    }
}
