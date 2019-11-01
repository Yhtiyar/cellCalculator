package com.cellCalcular.classes;

import java.util.ArrayList;
import java.util.List;

public class Rectangle extends RectangleObject {
    private List<HorizontalLine> horizontalLines;
    private List <VerticalLine> verticalLines;
    private List<Cell> cells;
    private boolean hasChanged;

    public Rectangle(float x, float y, float length, float height) {
        super(x, y, length, height);
        horizontalLines = new ArrayList<>();
        verticalLines = new ArrayList<>();
        cells = new ArrayList<>();
    }

    public void addHorizontalLine(float leftMargin, float topMargin, float length){
        changedList();
        float lastLineY = y;
        if (!horizontalLines.isEmpty()) {
            lastLineY = horizontalLines.get(horizontalLines.size() - 1).getY();
        }
        horizontalLines.add(new HorizontalLine(x + leftMargin,
                                               lastLineY + topMargin,
                                                  length,
                                                  leftMargin,
                                                  topMargin)
        );
    }

    public void addVerticalLine(float leftMargin, float topMargin, float length){
        changedList();
        float lastLineX = x;
        if (!verticalLines.isEmpty()) {
            lastLineX = verticalLines.get(verticalLines.size() - 1).getX();
        }
        verticalLines.add(new VerticalLine(lastLineX + leftMargin,
                                              y + topMargin,
                                              length,
                                              leftMargin,
                                              topMargin)
        );
    }

    public List<HorizontalLine> getHorizontalLines(){
        return List.copyOf(horizontalLines);
    }

    public List<VerticalLine> getVerticalLines(){
        return List.copyOf(verticalLines);
    }

    public List<Cell> getCells() {
        if (hasChanged)
            calculateCells();
        return List.copyOf(cells);
    }

    private  void changedList(){
        hasChanged = true;
    }
    private boolean intersects(HorizontalLine horizontalLine, VerticalLine verticalLine){
        return (verticalLine.getX() >= horizontalLine.getX()
                && verticalLine.getX() <= horizontalLine.getX() + horizontalLine.getLength()
                && verticalLine.getY() <= horizontalLine.getY()
                && verticalLine.getY() + verticalLine.getLength() >= horizontalLine.getY()
        );
    }

    private boolean intersectsNotAtTheBeginning(HorizontalLine horizontalLine, VerticalLine verticalLine){
        return (intersects(horizontalLine, verticalLine)
                && horizontalLine.getX() != verticalLine.getX()
                && horizontalLine.getY() != verticalLine.getY()
        );
    }

    private  void calculateCells(){
        cells = new ArrayList<>();
        List<VerticalLine> vLines= new ArrayList<>();
        vLines.add(new VerticalLine(x, y, height, 0, 0 ));
        vLines.addAll(verticalLines);
        vLines.add(new VerticalLine(x + length, y, height, 0, 0));

        List<HorizontalLine> hLines = new ArrayList<>();
        hLines.add(new HorizontalLine(x, y, length,  0, 0));
        hLines.addAll(horizontalLines);
        hLines.add(new HorizontalLine(x, y + height, length, 0, 0));

        /* some magic*/
        for (int i = 0; i < hLines.size(); i++){
            for (int j = 0; j < vLines.size(); j++){
                if (intersectsNotAtTheBeginning(hLines.get(i), vLines.get(j))){

                    for (int k = i - 1; k >= 0; k--){
                        for (int l = j - 1; l >= 0; l--){
                           if (intersects(hLines.get(k), vLines.get(l))
                                   && intersects(hLines.get(i), vLines.get(l))
                                   && intersects(hLines.get(k), vLines.get(j))
                           )
                           {
                               cells.add(new Cell(vLines.get(l).getX(),
                                            hLines.get(k).getY(),
                                            vLines.get(j).getX() - vLines.get(l).getX(),
                                            hLines.get(i).getY() - hLines.get(k).getY()
                                       ));
                               l = -1; k = -1;

                           }
                        }
                    }
                }
            }
        }

    }


}
