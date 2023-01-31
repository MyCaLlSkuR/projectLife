package by.skuratovich.projectLife;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        System.out.println(isMatch("aa","a"));
    }





    public static boolean isMatch(String s, String p) {
        boolean correct = true;
        if (p.indexOf('?')==-1 && p.indexOf('*')==-1){
            return s.equals(p);
        }else {
            char[] charArray = p.toCharArray();
            for (int i = 0, j = 0; i< s.length(); i++, j++){
                if (charArray[j]=='?')
                    continue;
                if (charArray[j]=='*'){
                    continue;
                }
            }
            return true;
        }
    }


    //------------------------------------------------------------------------
    public static int closestMeetingNode(int[] edges, int node1, int node2) {

        HashMap<Integer,Integer> mapNode1 = fillMap(edges,node1);
        HashMap<Integer,Integer> mapNode2 = fillMap(edges,node2);
        HashMap<Integer,Integer> mapNode = new HashMap<>();

        for (int i = 0; i < edges.length; i++) {
            if (mapNode1.get(i)!=null&&mapNode2.get(i)!=null){
                mapNode.put(i,Math.max(mapNode1.get(i),mapNode2.get(i)));
            }
        }
        System.out.println(mapNode);

        TreeMap<Integer, Integer> sortedMap = new TreeMap<>(mapNode);
        if (!mapNode.isEmpty()) {
            int key = Collections.min(sortedMap.entrySet(), Map.Entry.comparingByValue()).getKey();
            return key;
        }else return -1;
    }
    static HashMap<Integer,Integer> fillMap(int[] edges,int node){
        HashMap<Integer,Integer> mapNode = new HashMap<>();
        int pointer = node;
        for (int i = 0; true; i++){
            mapNode.put(pointer, i);
            pointer = edges[pointer];
            if (mapNode.containsKey(pointer)||pointer == -1){
                break;
            }
        }
        return mapNode;
    }
}
