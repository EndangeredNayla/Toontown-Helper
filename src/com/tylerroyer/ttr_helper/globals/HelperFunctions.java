package com.tylerroyer.ttr_helper.globals;

import java.awt.geom.GeneralPath;

public class HelperFunctions {
	public static GeneralPath createPolygonFromPoints(int[] xPoints, int[] yPoints) {
		// Code from https://docs.oracle.com/javase/tutorial/2d/geometry/arbitrary.html
		GeneralPath polygon = new GeneralPath(GeneralPath.WIND_EVEN_ODD, xPoints.length);
		polygon.moveTo(xPoints[0], yPoints[0]);

		for (int index = 1; index < xPoints.length; index++) {
			polygon.lineTo(xPoints[index], yPoints[index]);
		}

		polygon.closePath();
		return polygon;
	}
}
