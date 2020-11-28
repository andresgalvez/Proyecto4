/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto4;

import static java.lang.Math.cos;
import static java.lang.Math.sin;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.RadialGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.*;
import javafx.scene.text.Text;
import javafx.scene.transform.*;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @author AndresGalvez
 */
public class Proyecto4 extends Application {

    Group shapes;

    public void lineas(Group grupo) {
        Line linea = new Line(20, 30, 150, 100);
        linea.setStroke(Color.CRIMSON);
        linea.setStrokeWidth(6);

        for (int i = 0; i < 400; i += 4) {
            Line lin = new Line(20, i, 400, 200);
            lin.setStroke(Color.DODGERBLUE);
            lin.setStrokeWidth(1);
            shapes.getChildren().add(lin);

            Line linV = new Line(i, 20, 200, 400);
            linV.setStroke(Color.DARKGREEN);
            linV.setStrokeWidth(1);
            shapes.getChildren().add(linV);
        }

        shapes.getChildren().add(linea);
    }

    public void cuadricula(Group grupo) {

        for (int i = 0; i <= 500; i += 10) {
            Line lin = new Line(0, i, 500, i);
            lin.setStroke(Color.SKYBLUE);
            if (i % 100 == 0) {
                lin.setStroke(Color.CADETBLUE);
            }
            lin.setStrokeWidth(1);
            shapes.getChildren().add(lin);

            Line linV = new Line(i, 0, i, 500);
            linV.setStroke(Color.SKYBLUE);
            if (i % 100 == 0) {
                linV.setStroke(Color.CADETBLUE);
            }
            linV.setStrokeWidth(1);
            shapes.getChildren().add(linV);
        }

    }

    public void figuras(Group grupo) {

        Rectangle rect = new Rectangle(50, 50, 100, 150);
        rect.setFill(Color.BEIGE);
        rect.setStroke(Color.CRIMSON);
        rect.setStrokeWidth(3);

        Rectangle rectR = new Rectangle(200, 50, 100, 150);
        rectR.setArcHeight(60);
        rectR.setArcWidth(90);
        rectR.setFill(null); // Sin relleno
        rectR.setStroke(Color.BLACK);
        rectR.setStrokeWidth(3);

        Ellipse elipse = new Ellipse(400, 120, 50, 80);
        elipse.setStroke(Color.BLACK);
        elipse.setFill(null); // Sin relleno
        elipse.setStrokeWidth(3);

        Ellipse elipseH = new Ellipse(150, 300, 80, 40);
        elipseH.setStroke(Color.BLACK);
        elipseH.setFill(null); // Sin relleno
        elipseH.setStrokeWidth(3);

        Circle circulo = new Circle(300, 300, 100);
        circulo.setStroke(Color.BLACK);
        circulo.setFill(null); // Sin relleno
        circulo.setStrokeWidth(3);

        grupo.getChildren().addAll(rect, rectR, elipse, elipseH, circulo);

    }

    public void figurasArcos(Group grupo) {
        for (int i = 0; i < 12; i++) {
            Arc arc = new Arc();
            //Setting properties to cubic curve
            arc.setCenterX(0);
            arc.setCenterY(0);
            arc.setRadiusX(200);
            arc.setRadiusY(200);
            arc.setStartAngle(i * 30);
            arc.setLength(30);
            arc.setType(ArcType.ROUND);
            //Setting other properties
            arc.setFill(Color.CHOCOLATE);
            arc.setStrokeWidth(2.0);
            arc.setStroke(Color.BROWN);

            grupo.getChildren().addAll(arc);
        }
    }

    public void arcoPunta(Group grupo) {
        int radio = 200;

        for (int i = 0; i < 12; i++) {
            Arc arc = new Arc();
            double xfinal = radio * cos(Math.toRadians(i * 30 + 30));
            double xinicial = radio * cos(Math.toRadians(i * 30));
            double yfinal = radio * sin(Math.toRadians(i * 30 + 30));
            double yinicial = radio * sin(Math.toRadians(i * 30));
            double distancia = Math.sqrt(Math.pow(xfinal - xinicial, 2) + Math.pow(yfinal - yinicial, 2));

            //Setting properties to cubic curve
            arc.setCenterX((xfinal + xinicial) / 2);
            arc.setCenterY((yfinal + yinicial) / 2);
            arc.setRadiusX(distancia / 2);
            arc.setRadiusY(distancia / 2);
            arc.setStartAngle(i * -30 - 105);
            arc.setLength(180);
            arc.setType(ArcType.CHORD);
            //Setting other properties
            arc.setFill(Color.CHOCOLATE);
            arc.setStrokeWidth(2.0);
            arc.setStroke(Color.BLACK);

            grupo.getChildren().addAll(arc);
        }
    }

    public void figurasPoly(Group grupo) {

        Polyline poli = new Polyline(20, 100, 40, 250, 60, 70, 200, 120);

        Polyline poli2 = new Polyline();
        poli2.getPoints().addAll(new Double[]{
            10.0, 480.0,
            120.0, 320.0,
            190.0, 300.0,
            200.0, 380.0,
            450.0, 450.0,
            10.0, 370.0,
            68.5, 290.0,
            100.0, 290.0
        });
        poli2.setStroke(Color.BLUE);
        poli2.setStrokeWidth(4);
        //poli2.setFill(Color.SKYBLUE);
        poli2.setStrokeType(StrokeType.CENTERED);

        Polygon polig = new Polygon();
        polig.getPoints().addAll(new Double[]{
            200.0, 180.0,
            220.0, 320.0,
            290.0, 300.0,
            200.0, 320.0,
            350.0, 350.0,
            210.0, 370.0,
            168.5, 290.0,
            100.0, 290.0
        });
        polig.setStroke(Color.BLUE);
        polig.setStrokeWidth(2);
        polig.setFill(Color.BURLYWOOD);
        polig.setStrokeType(StrokeType.CENTERED);

        grupo.getChildren().addAll(poli, poli2, polig);

    }

    public void figurasCurvas(Group grupo) {

        Line control1 = new Line(100, 100, 200, 70);
        Line control2 = new Line(110, 200, 260, 180);
        CubicCurve cubica = new CubicCurve(100, 100, 200, 70, 110, 200, 260, 180);
        cubica.setStroke(Color.CHOCOLATE);
        cubica.setStrokeWidth(3);
        cubica.setFill(null);

        Line contrl1 = new Line(80, 300, 240, 270);
        Line contrl2 = new Line(240, 270, 260, 380);
        QuadCurve quad = new QuadCurve(80, 300, 240, 270, 260, 380);
        quad.setStroke(Color.DARKVIOLET);
        quad.setStrokeWidth(3);
        quad.setFill(null);

        grupo.getChildren().addAll(control1, control2, cubica, contrl1, contrl2, quad);

    }

    public void figurasPath(Group grupo) {

        Path camino = new Path();

        // Inicio
        MoveTo inicio = new MoveTo(100, 100);

        LineTo linea1 = new LineTo(300, 16);
        LineTo linea2 = new LineTo(280, 180);
        //linea horizontal
        HLineTo lineaH = new HLineTo(150);
        //linea vertical
        VLineTo lineaV = new VLineTo(250);
        ArcTo arco1 = new ArcTo(80, 50, 45, 230, 160, false, true);

        //Cubic
//        Line c1 = new Line(230, 160, 250, 180);c1.setStroke(Color.RED);
//        Line c2 = new Line(180, 230, 200, 270);c2.setStroke(Color.RED);
        CubicCurveTo ccurva = new CubicCurveTo(250, 180, 180, 230, 200, 270);
        //QuadCurve
        QuadCurveTo qcurva = new QuadCurveTo(250, 350, 130, 350);
        QuadCurveTo qcurva2 = new QuadCurveTo(0, 150, 50, 150);

        //Juntas todos los segmentos
        camino.getElements().add(inicio);
        camino.getElements().addAll(linea1, new LineTo(400, 120), linea2, lineaH, lineaV, arco1, ccurva, qcurva, qcurva2);
        camino.getElements().add(new ClosePath());

        grupo.getChildren().addAll(camino);

        String caminoSVG = "M100 100 "
                + "L300 16 "
                + "L280 180 "
                + "H150 "
                + "V250 "
                + "A80 50 45 0 1 230 160 "
                + "C250 180 180 230 200 270 "
                + "Q250 350 130 350 "
                + "Q2 150 100 100";

        SVGPath svgcamino = new SVGPath();
        svgcamino.setContent(caminoSVG);

        svgcamino.setStroke(Color.BROWN);
        svgcamino.setStrokeWidth(3);
        svgcamino.setFill(null);
        grupo.getChildren().addAll(svgcamino);

        Text texto = new Text("CUBICA");
        texto.setX(20);
        texto.setY(20);
        texto.setStyle("-fx-font-family:Mistral;");
        grupo.getChildren().addAll(texto);
    }

    public void transformaciones(Group grupo) {

        Ellipse refA = new Ellipse(100, 100, 80, 60);
        refA.setFill(null);
        refA.setStroke(Color.GREY);
        refA.setStrokeWidth(1);

        Ellipse ellipseA = new Ellipse(100, 100, 80, 60);
        ellipseA.setFill(Color.ORANGE);

        Translate desp = new Translate(); // Desplazamiento
        desp.setX(100);
        desp.setY(50);
        ellipseA.getTransforms().add(desp); // Desplazamiento

        Ellipse refB = new Ellipse(200, 300, 80, 60);
        refB.setFill(null);
        refB.setStroke(Color.GREY);
        refB.setStrokeWidth(1);

        Ellipse ellipseB = new Ellipse(200, 300, 80, 60);
        ellipseB.setFill(Color.VIOLET);

        Scale escala = new Scale(1.5, 0.5, 200, 300); // Cambio de tamaño
//        escala.setPivotX(200); 
//        escala.setPivotY(300); 
//        escala.setX(1.5);
//        escala.setY(0.5);
        ellipseB.getTransforms().addAll(escala); // Tamaño

        grupo.getChildren().addAll(refA, ellipseA, ellipseB, refB);
    }

    ;

    public void transformaciones2(Group grupo) {
        for (int i = 0; i < 30; i++) {
            String svgForma = "M50 50 L120 80 H150 A50 50 0 0 1 150 180 H120 V150 Z";
            SVGPath refA = new SVGPath();
            refA.setContent(svgForma);
            refA.setFill(null);
            refA.setStroke(Color.GREY);
            refA.setStrokeWidth(1);

            SVGPath formaA = new SVGPath();
            formaA.setContent(svgForma);
            formaA.setFill(Color.ORANGE);

            double cx = 0, cy = 0;
            Circle centro = new Circle(cx, cy, 3);

            Rotate rota = new Rotate(); // Rotacion
            rota.setPivotX(cx);
            rota.setPivotY(cy);
            rota.setAngle(45 * i);
            formaA.getTransforms().add(rota); // Rotacion

            grupo.getChildren().addAll(refA, formaA, centro);
        }
    }

    ;
    
     

    public void Centro(Group grupo) {
        Circle circle = new Circle();
        circle.setCenterX(0);
        circle.setCenterY(0);
        circle.setRadius(50.0f);

        //Setting the radial gradient
        Stop[] stops = new Stop[]{
            new Stop(0.0, Color.WHITE),
            new Stop(0.3, Color.RED),
            new Stop(1.0, Color.DARKRED)
        };
        RadialGradient gradiente = new RadialGradient(0, 0, .5, .5, .9, true, CycleMethod.NO_CYCLE, stops);
        circle.setFill(gradiente);
        grupo.getChildren().addAll(circle);
    }

    public void polygon1(Group grupo) {
        for (int i = 0; i < 30; i++) {
            Polygon polygon1 = new Polygon();
            polygon1.getPoints().addAll(new Double[]{
                -60.0, -60.0,//punta
                25.0, 75.0,
                75.0, 25.0

            });
            polygon1.setFill(Color.RED);
            polygon1.setRotate(15 * i);
            grupo.getChildren().addAll(polygon1);
        }
    }

    public void poligono(Group grupo) {

        for (int i = 0; i < 1; i++) {
            Polygon polygon = new Polygon();
            polygon.getPoints().addAll(new Double[]{
                -120.0, -120.0,//punta
                50.0, 250.0,
                250.0, 50.0

            });

            polygon.setRotate(15 * i);

            grupo.getChildren().addAll(polygon);
        }
    }

    public void rombo(Group grupo, int numeroPetalos, int radio) {

        double angulo = 360.0 / numeroPetalos;
        System.out.println("11");
        for (int i = 0; i < numeroPetalos; i++) {
            System.out.println("22");
            Circle circle = new Circle();
            circle.setCenterX((radio - 50) * cos(Math.toRadians(i * angulo + (angulo / 2))));
            circle.setCenterY((radio - 50) * sin(Math.toRadians(i * angulo + (angulo / 2))));
            circle.setRadius(25.0f);
            System.out.println("33");
            Stop[] stops = new Stop[]{
                new Stop(0.0, Color.WHITE),
                new Stop(0.1, Color.RED),
                new Stop(0.2, Color.ORANGE),
                new Stop(0.3, Color.YELLOW),
                new Stop(0.4, Color.GREEN),
                new Stop(0.5, Color.BLUE),
                new Stop(0.6, Color.DARKRED),
                new Stop(0.7, Color.PURPLE),
                new Stop(0.8, Color.VIOLET),
                new Stop(1.0, Color.WHITE)
            };
            System.out.println("44");
            RadialGradient gradiente = new RadialGradient(0, 0, .5, .5, .9, true, CycleMethod.NO_CYCLE, stops);
            circle.setFill(gradiente);
            System.out.println("55");
            Polygon polygon1 = new Polygon();
            polygon1.getPoints().addAll(new Double[]{
                0.0, 0.0,//
                radio * cos(Math.toRadians(i * angulo)), radio * sin(Math.toRadians(i * angulo)),
                (radio + 50) * cos(Math.toRadians(i * angulo + (angulo / 2))), (radio + 50) * sin(Math.toRadians(i * angulo + (angulo / 2))),
                radio * cos(Math.toRadians(i * angulo + angulo)), radio * sin(Math.toRadians(i * angulo + angulo))

            });
            System.out.println("66");
            polygon1.setFill(Color.RED);
            System.out.println("77");
            polygon1.setStroke(Color.CORAL);
            System.out.println("88");
            grupo.getChildren().addAll(polygon1, circle);
            System.out.println("99");
        }
        System.out.println("0000");
    }

    public void petaloRedondo(Group grupo, int numeroPetalos, int radio) {

        int petalos = numeroPetalos;

        if (numeroPetalos % 2 != 0) {
            petalos += 1;
        }

        double angulo = 360.0 / petalos;
        Color[] colores = {Color.BLACK, Color.BURLYWOOD, Color.DARKORCHID, Color.DARKGREEN, Color.LINEN};
        int color1 = (int) (Math.random() * colores.length + 1);
        int color2 = (int) (Math.random() * colores.length + 1);
        int color3 = (int) (Math.random() * colores.length + 1);
        int color4 = (int) (Math.random() * colores.length + 1);
        for (int i = 0; i < petalos; i++) {

            double xfinal = radio * cos(Math.toRadians(i * angulo + angulo));
            double xinicial = radio * cos(Math.toRadians(i * angulo));
            double yfinal = radio * sin(Math.toRadians(i * angulo + angulo));
            double yinicial = radio * sin(Math.toRadians(i * angulo));
            double distancia = Math.sqrt(Math.pow(xfinal - xinicial, 2) + Math.pow(yfinal - yinicial, 2));

            Polygon polygon1 = new Polygon();
            polygon1.getPoints().addAll(new Double[]{
                0.0, 0.0,//
                xfinal, yfinal,
                xinicial, yinicial

            });

            Stop[] stops = new Stop[]{
                new Stop(0.0, colores[color1]),
                new Stop(0.3, colores[color2]),
                new Stop(0.6, colores[color3]),
                new Stop(1.0, colores[color4])
            };
            RadialGradient gradiente = new RadialGradient(360, 0, .5, .5, 0.4, true, CycleMethod.NO_CYCLE, stops);
            polygon1.setFill(gradiente);

            polygon1.setStroke(Color.TRANSPARENT);
            //polygon1.setStrokeType(StrokeType);
            Arc arc = new Arc();
            double angulo2 = (angulo * 0.5) + 90;

            //Setting properties to cubic curve
            arc.setCenterX((xfinal + xinicial) / 2);
            arc.setCenterY((yfinal + yinicial) / 2);
            arc.setRadiusX(distancia / 2);
            arc.setRadiusY(distancia / 2);
            arc.setStartAngle(i * -angulo - angulo2);
            arc.setLength(180);
            arc.setType(ArcType.OPEN);
            //Setting other properties
            arc.setFill(Color.DARKRED);
            arc.setStrokeWidth(2.0);
            arc.setStroke(Color.CORAL);

            grupo.getChildren().addAll(polygon1, arc);
        }
    }

    @Override
    public void start(Stage primaryStage) {
        String petalos, niveles, figura;
        int numeroPetalos, numeroNiveles, tipoFigura;

        niveles = JOptionPane.showInputDialog("cuantos niveles");
        numeroNiveles = Integer.parseInt(niveles);
        int radio = 50;

        for (int i = numeroNiveles; i >= 1; i--) {

            figura = JOptionPane.showInputDialog("0:aleatorio 1:Punta  2:Petalo redondo  ");
            tipoFigura = Integer.parseInt(figura);
            petalos = JOptionPane.showInputDialog("cuantos petalos");
            numeroPetalos = Integer.parseInt(petalos);
            if (tipoFigura == 0) {

                int opcion = (int) (Math.random() * 1 + 1);
                System.out.println(opcion);
                if (opcion == 1) {
                    System.out.println("ALEATORIO1");
                    rombo(shapes, numeroPetalos, 200);

                } else {
                    System.out.println("ALEATORIO2");
                    petaloRedondo(shapes, numeroPetalos, radio * i);

                }
            }
            if (tipoFigura == 1) {
                rombo(shapes, numeroPetalos, 200);
            } else {
                petaloRedondo(shapes, numeroPetalos, 150);
            }
        }
        Centro(shapes);

        StackPane area = new StackPane();
        area.getChildren().add(shapes);
        area.setStyle("-fx-background-color:white;");

        BorderPane root = new BorderPane();
        root.setCenter(area);

        Scene scene = new Scene(root, 510, 540);

        primaryStage.setTitle("Shapes");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        launch(args);
    }

}
