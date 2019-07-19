package com.mx;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName EvaluateDivision
 * @Description
 * 利用并查集解决等式之间的数值传递
 * @Author miaoxu
 * @Date 2019/3/30 20:17
 * @Version 1.0
 **/
public class EvaluateDivision {
    HashMap<String, String> unionmap = new HashMap<>();
    HashMap<String, Double> map = new HashMap<>();
    class Path
    {
        String start;
        String end;
        public Path(String start, String end)
        {
            this.start = start;
            this.end = end;
        }

        @Override
        public boolean equals(Object obj) {
            Path path = (Path) obj;
            return path.start == this.start && path.end == this.end;
        }
    }

    class PathWeight
    {
        String start;
        double w;

        public PathWeight(String start, double w) {
            this.start = start;
            this.w = w;
        }
    }

    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        //建立节点之间的传递关系
        //建立图的关系
        double[] res = new double[queries.length];
        for (int i = 0; i < equations.length; i++)
        {
//            Path path = new Path(equations[i][0], equations[i][1]);

            if (unionmap.get(equations[i][0]) == null)
            {
                if (unionmap.get(equations[i][1]) == null)
                {
                    unionmap.put(equations[i][0].trim(), equations[i][0]);
                    unionmap.put(equations[i][1].trim(), equations[i][0].trim());
                    map.put(equations[i][0].trim() + equations[i][1].trim(), values[i]);
                }
                else
                {
                    unionmap.put(equations[i][0].trim(), equations[i][1].trim());
                    map.put(equations[i][1].trim() + equations[i][0].trim(), 1 / values[i]);
                }

            }
            else
            {
                map.put(equations[i][0].trim() + equations[i][1].trim(), values[i]);
                unionmap.put(equations[i][1].trim(), equations[i][0].trim());
            }

        }
        //遍历query，查询结果
        for (int i = 0; i < queries.length; i++)
        {
            res[i] = findConnection(queries[i]);
        }
        return res;
    }

//    public void initMap()
//    {
//        for (Map.Entry<Path, Double> entry : map.entrySet())
//        {
//            Path path = entry.getKey();
//            String start = path.start;
//            String end = path.end;
//
//        }
//    }

    public double findConnection(String[] query)
    {
        if (unionmap.get(query[0].trim()) == null || unionmap.get(query[1].trim()) == null)
        {
            return -1;
        }
        return find( query[0], query[1]);
    }

    public double find(String start, String end)
    {
        PathWeight rootStart = root(start);
        PathWeight rootEnd = root(end);
        if (rootEnd.start.equals(rootStart.start))
        {
            return rootEnd.w / rootStart.w;
        }

        return -1;

    }
    public PathWeight root(String s)
    {

        double tem = 1.0;

        while (!unionmap.get(s).equals(s))
        {
            String t = unionmap.get(s);
            tem *= map.get(t+s);
            s= t;

        }
        PathWeight pathWeight = new PathWeight(s, tem);
        return pathWeight;
    }

    public static void main(String[] args) {
        String[][] equations =   { {"a", "b"}, {"b","c"} };
        double[] values = {2.0, 3.0};
        String[][] queries  =  { {"a", "c"},{"b", "c"}, {"a", "e"}, {"a", "a"}, {"x", "x"} };
        new EvaluateDivision().calcEquation(equations, values, queries);
//        System.out.println(equations.length);
//        System.out.println(equations[0].length);
    }
}
