package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2024-12-07
 */
@LeetCode(
        id = 3380,
        name = "Maximum Area Rectangle With Point Constraints I",
        url = "https://leetcode.com/problems/maximum-area-rectangle-with-point-constraints-i/",
        difficulty = Difficulty.MEDIUM
)
public class MaximumAreaRectangleWithPointConstraintsI {
    public int maxRectangleArea(int[][] points) {
        int area = -1;
        for (int p1 = 0; p1 < points.length; p1++) {
            int point1Y = points[p1][1];
            for (int p2 = 0; p2 < points.length; p2++) {
                int point2X = points[p2][0];
                int point2Y = points[p2][1];
                for (int p3 = 0; p3 < points.length; p3++) {
                    for (int p4 = 0; p4 < points.length; p4++) {
                        int point4X = points[p4][0];

                        Set<Integer> set = new HashSet<>();
                        set.add(p1);
                        set.add(p2);
                        set.add(p3);
                        set.add(p4);
                        boolean rect = isRectangle(points[p1], points[p2], points[p3], points[p4]);
                        boolean inside = somethingIsInside(p1, p2, p3, p4, points);

                        if (set.size() == 4 && rect && !inside) {
                            area = Math.max(area, (point4X - point2X) * (point2Y - point1Y));

                            rect = isRectangle(points[p1], points[p2], points[p3], points[p4]);
                            inside = somethingIsInside(p1, p2, p3, p4, points);
                        }
                    }
                }
            }
        }
        return area;
    }

    private boolean isRectangle(int[] p1, int[] p2, int[] p3, int[] p4) {
        return
                p1[0] == p2[0]
                        && p1[1] == p3[1]
                        && p3[0] == p4[0]
                        && p4[1] == p2[1];
    }

    private boolean somethingIsInside(int a, int b, int c, int d, int[][] points) {
        int[] p1 = points[a];
        int[] p2 = points[b];
        int[] p3 = points[c];
        int[] p4 = points[d];

        int minX = Math.min(p1[0], p3[0]);
        int maxX = Math.max(p1[0], p3[0]);

        int minY = Math.min(p1[1], p2[1]);
        int maxY = Math.max(p1[1], p2[1]);

        for (int i = 0; i < points.length; i++) {
            int[] point = points[i];
            if (i != a && i != b && i != c && i != d) {
                if (minX <= point[0] && point[0] <= maxX
                        && minY <= point[1] && point[1] <= maxY) {
                    return true;
                }
            }
        }
        return false;
    }
}