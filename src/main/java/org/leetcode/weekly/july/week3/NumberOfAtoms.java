package org.leetcode.weekly.july.week3;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class NumberOfAtoms {

    public static void main(String[] args) {
        NumberOfAtoms n = new NumberOfAtoms();
        String res = n.countOfAtoms("H11He49NO35B7N46Li20");
        System.out.println(res);
    }
    int index = 0;
    String formula;
    public String countOfAtoms(String formula) {
        index = 0;
        this.formula = formula;
        StringBuilder sb = new StringBuilder();
        Map<String,Integer> map = count();
        for (Map.Entry<String , Integer> entry: map.entrySet()) {
            sb.append(entry.getKey());
            if(entry.getValue() > 1){
                sb.append(entry.getValue());
            }
        }
        return sb.toString();
    }

    private Map<String,Integer> count(){
        if(index >= formula.length()){
            return new TreeMap<>();
        }
        Map<String, Integer> map = new TreeMap<>();
        for (; index < formula.length(); index++) {
            char c = formula.charAt(index);
            if(c == '('){
                index++;
                //Add to current map
                Map<String, Integer> subMap = count();
                addToParentMap(map, subMap);
            }else if(c >= 'A' && c <= 'Z'){
                extractAtom(formula, map, c);
            }else if(c == ')'){
                extractAtomStack(formula, map);
                return map;
            }
        }
        return map;
    }

    private static void addToParentMap(Map<String, Integer> map, Map<String, Integer> subMap) {
        for (Map.Entry<String,Integer> enrty: subMap.entrySet()) {
            int val = map.getOrDefault(enrty.getKey(),0);
            map.put(enrty.getKey(),val+ enrty.getValue());
        }
    }

    private void extractAtomStack(String formula, Map<String, Integer> map) {
        StringBuilder sbProd = new StringBuilder();
        while(index+1 < formula.length() &&
                formula.charAt(index+1) >= '0' &&
                formula.charAt(index+1) <= '9'
        ){
            index++;
            sbProd.append(formula.charAt(index));
        }
        int intValue = 1;
        if(sbProd.length() > 0){
            intValue = Integer.valueOf(sbProd.toString()).intValue();
        }
        if(intValue > 1){
            for (String key: map.keySet()) {
                map.put(key, map.get(key)*intValue);
            }
        }
    }

    private void extractAtom(String formula, Map<String, Integer> map, char c) {
        StringBuilder sb = new StringBuilder();
        sb.append(c);
        while(index+1 < formula.length() &&
                formula.charAt(index+1) >= 'a' &&
                formula.charAt(index+1) <= 'z'){
            index++;
            sb.append(formula.charAt(index));
        }
        StringBuilder value = new StringBuilder();
        while(index+1 < formula.length() &&
                formula.charAt(index+1) >= '0' &&
                formula.charAt(index+1) <= '9'
        ){
            index++;
            value.append(formula.charAt(index));
        }
        int intValue = 1;
        if(value.length() > 0){
            intValue = Integer.valueOf(value.toString()).intValue();
        }
        map.put(sb.toString(),intValue+map.getOrDefault(sb.toString(),0));
    }
}
