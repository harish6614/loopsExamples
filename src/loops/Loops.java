/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loops;

import java.util.ArrayList;
import java.util.List;

/**
 * Loops class contains several static utility methods defined using loops.
 * @author Harish Bondalapati
 */
public class Loops {
    
    /**
     * Returns sum of first n positive odd numbers starting from 1.
     * @param n Number of odd numbers
     * Sum=1+3+5+......nth odd number
     * @return Sum of n odd numbers
     */
    public static int sumOfOdd(int n){
    int sum=0;
        for(int i=0;i<n;i++){
            sum+=2*i+1;
        }
        return sum;
    }
    
    /**
     * This method takes all the Students for a course in a section as a list of
     * student objects and then computes the possible combinations in which the 
     * students can be arranged.
     * 
     * @param studentList List of student to be organized.
     * @return All possible combinations of seating arrangements computed.
     */
    public static ArrayList<String> organizeSeats(ArrayList<Student> studentList){
        ArrayList<String> order=new ArrayList<>();
        ArrayList<String> temp=new ArrayList<>();
        for(Student s:studentList){
            /*Can chage add criteria based on the requirement like all the 
            students must be from same section etc.
            Asumption: All the students belong to same section of a course.*/
            temp.add(s.getFirstName());
        }
        int n=temp.size();
        
        ArrayList<ArrayList<String>> combos=new ArrayList<>();
        combos.add(temp);
        order.add(getString(temp));
        for(int i=0;i<n;i++){
            int size=combos.size();
            for(int j=0;j<size;j++){
                ArrayList<String> current=(ArrayList<String>) combos.get(j).clone();
                temp=(ArrayList<String>) current.clone();
                temp.add(i,temp.get(n-1));
                temp.remove(n);
                while(!temp.equals(current)){
                    combos.add((ArrayList<String>) temp.clone());
                    order.add(getString(temp));
                    temp.add(i,temp.get(n-1));
                    temp.remove(n);
                }
            }           
        }
        return order;
    }
    
    private static String getString(ArrayList<String> sl){
        String s=sl.toString().replaceAll(", ", ",");
        return s.substring(1, s.length()-1);
    }
    
    /**
     * This method takes all the Students for a course in a section as a list of
     * student objects and then computes the possible combinations in which the 
     * students can be arranged in a restricted order for the students provided 
     * in the second argument.
     * 
     * @param studentList List of student to be organized.
     * @param restrictedList All students who cannot sit adjacent to any other 
     * in the list.
     * @return All possible combinations of restricted seating arrangements 
     * computed.
     */
    public static ArrayList<String> restrictedOrders(ArrayList<Student> studentList,ArrayList<Student> restrictedList){
        for(Student s:restrictedList){
            studentList.remove(s);
        }
        studentList.add(new Student("###","999"));
        ArrayList<String> restrictedOrder=new ArrayList<>();
        ArrayList<String> order1=organizeSeats(studentList);
        ArrayList<String> order2=organizeSeats(restrictedList);
        for(String s1:order2){
            for(String s2:order1){
                restrictedOrder.add(s2.replaceFirst("###", s1));
            }
        }
        return restrictedOrder;
    }
    
    /**
     * Method to compute an arthmatic expression and return final result.
     * In case of a illegal expression format this method throws error.
     * 
     * @param str Expression to be evaluated.
     * @return Result of the evaluated expression
     */
    public static long evaluateComplexExp(String str){
        str="("+str+")";
        
        ArrayList<Character> operators=new ArrayList<Character>();
        ArrayList<String> operands=new ArrayList<String>();
        String opTemp=str.replaceAll("[0-9]+", "");
        
        for(char ch:opTemp.toCharArray()){
            operators.add(ch);
        }
        for(String s:str.split("[()*/%+-]")){
            operands.add(s);
        }
        
        boolean hasExp=true;
        int idxC,idxO=-1;
        while(hasExp){
            idxC=opTemp.indexOf(")");
            if(idxC!=-1)
            idxO=opTemp.lastIndexOf("(", idxC);
            if(idxO!=-1 && idxC>idxO){
                if((operators.get(idxO+1)=='+' || operators.get(idxO+1)=='-') &&
                        "".equals(operands.get(idxO+1)))
                    operands.set(idxO+1,"0");
                if(idxC-idxO>1)
                evaluateExp(operators.subList(idxO+1, idxC)
                                ,operands.subList(idxO+1, idxC+1));
                operators.remove(idxO);
                operators.remove(idxO);
                operands.remove(idxO);
                if(operands.size()-1>idxO)
                operands.remove(idxO+1);
                opTemp=opTemp.substring(0, idxO)+opTemp.substring(idxC+1);
            }else
                hasExp=false;
        }
        return Long.parseLong(operands.get(0));
    }
    
    private static String evaluateExp(List<Character> operators,List<String> operands){
        String operations="*/%-+";
        for(char op:operations.toCharArray()){
            while(operators.contains(op)){
                int idx=operators.indexOf(op);
                String output=""+evaluateSimpleExp(operators.get(idx),
                        Integer.parseInt(operands.get(idx)),Integer.parseInt(operands.get(idx+1)));
                operands.set(idx, output);
                operands.remove(idx+1);
                operators.remove(idx);
            }
            if(operators.size()==0)
                break;
        }
        return operands.get(0);
    }
        
    private static long evaluateSimpleExp(char op,long op1,long op2){
        switch(op){
            case '*' :
                return op1*op2;
            case '/' :
                return op1/op2;
            case '%' :
                return op1%op2;
            case '+' :
                return op1+op2;
            case '-' :
                return op1-op2;
        }
        return 1/0;
    }
}
