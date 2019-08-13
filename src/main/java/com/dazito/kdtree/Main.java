package com.dazito.kdtree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // For simplicity, lets assume we have a main square of size X=100 and Y=100
        List<Space> userInputSpaces = Arrays.asList(
                new Space("blockedSpace 1", 20, 20, 20, 0, 20, 0),
                new Space("blockedSpace 2", 20, 20, 20, 50, 50, 0)
        );

        computeFreeSpaces(userInputSpaces);
    }

    public static void computeFreeSpaces(List<Space> userInputSpaces) {
        List<KdTree.XYZPoint> xyzPointList = new ArrayList<>();

        for(Space userSpace : userInputSpaces) {
            // TODO: Ignore userInputSpaces that are bigger than the free space itself

            // Example of a possible userInputSpace where A, B, C and D represent points in the XY axis (we ignore Z axis for now)
            // userSpace.getX() and userSpace.getY() will give us the point C. We then add the width to get the point D or add the height
            // to get the point A

		/*
			  A ----- B
				|	|
				|	|
			  C ----- D
		 */

            int xA = userSpace.getX();
            int yA = userSpace.getY() + userSpace.getHeight();
            int xB = userSpace.getX() + userSpace.getWidth();
            int yB = userSpace.getY() + userSpace.getHeight();
            int xD = userSpace.getX() + userSpace.getWidth();
            int yD = userSpace.getY();

            KdTree.XYZPoint bPoint = new KdTree.XYZPoint(xB, yB);
            KdTree.XYZPoint cPoint = new KdTree.XYZPoint(userSpace.getX(), userSpace.getY());
            KdTree.XYZPoint aPoint = new KdTree.XYZPoint(xA, yA);
            KdTree.XYZPoint dPoint = new KdTree.XYZPoint(xD, yD);

            xyzPointList.add(aPoint);
            xyzPointList.add(bPoint);
            xyzPointList.add(cPoint);
            xyzPointList.add(dPoint);
        }

        KdTree<KdTree.XYZPoint> kdTree = new KdTree<>(xyzPointList);
        KdTree.KdNode root = kdTree.getRoot();

        System.out.println("--------------------------");
        visitAllNodes(root, null);
    }

    private static void visitAllNodes(KdTree.KdNode kdNode, Boolean isLesserNode) {
        if(kdNode == null) {
            return;
        }

        if(kdNode.getDepth() % 2 != 0) {
            // Horizontal line
            horizontalLine(kdNode, isLesserNode);
        }
        else {
            // Vertical Line
            verticalLine(kdNode);
        }

        if (kdNode.getGreater() != null) {
            visitAllNodes(kdNode.getGreater(), false);
        }

        if(kdNode.getLesser() != null) {
            visitAllNodes(kdNode.getLesser(), true);
        }
    }

    private static void horizontalLine(KdTree.KdNode kdNode, Boolean isLesserNode) {
        if(isLesserNode == null) {
            System.out.println("Parent | Horizontal line at " + kdNode.getId().toString());
            return;
        }

        if(isLesserNode) {
            System.out.println("Left side of vertical line | Horizontal line at " + kdNode.getId().toString());
        }
        else {
            System.out.println("Right side of vertical line| Horizontal line at " + kdNode.getId().toString());
        }
    }

    private static void verticalLine(KdTree.KdNode kdNode) {
        System.out.println("Vertical line at " + kdNode.getId().toString());
    }
}
