package loops;

import java.util.ArrayList;

/**
 * LoopsDriver class contains a main method which is used to test and invoke 
 * various methods of Loops class.
 * @author Harish Bondalapati
 */
public class LoopsDriver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        System.out.println("Sum of first 4 odd num is :"+Loops.sumOfOdd(4));
        
        ArrayList<Student> studentsList=new ArrayList<Student>();
        ArrayList<Student> restrictedList=new ArrayList<Student>();
        
        studentsList.add(new Student("Adam","101"));
        studentsList.add(new Student("Bob","103"));
        studentsList.add(new Student("Charlie","104"));
        
        ArrayList<String> seatingCombos=Loops.organizeSeats(studentsList);
        System.err.println("Possible seating arrangements are:");
        int count=1;
        for(String s:seatingCombos){
            System.out.println((count++)+". "+s);}
        
        studentsList.add(new Student("David","107"));
        studentsList.add(new Student("Effie","109"));
        
        restrictedList.add(studentsList.get(2));
        restrictedList.add(studentsList.get(3));
        
        ArrayList<String> restrictedCombos=
                Loops.restrictedOrders(studentsList, restrictedList);
        System.out.println("\nRestricted seating arrangements are:");
        count=1;
        for(String s:restrictedCombos){
            System.err.println((count++)+". "+s);}
        
        System.out.println("(1+2) :"
                +Loops.evaluateComplexExp("(1+2)"));
        System.out.println("(1+3)/(2%5) :"
                +Loops.evaluateComplexExp("(1+3)/(2%5)"));
        System.out.println("((2+4)*((3*2)-(2/4)+(9%4)) :"
         +Loops.evaluateComplexExp("((2+4)*((3*2)-(2/4)+(9%4)))"));
        System.out.println("(2+4)/((7/3)+(2*4))+(8*4)/((9-2)-(-8*9)) :"
         +Loops.evaluateComplexExp("(2+4)/((7/3)+(2*4))+(8*4)/((9-2)-(-8*9))"));
    }
    
}
