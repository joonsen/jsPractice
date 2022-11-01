package backjoon;

//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.io.IOException;
//import java.util.StringTokenizer;
import java.util.*;

public class Main{
    public static void main(String[] args){
    	Scanner sc = new Scanner(System.in);
    	   int king = 1;
	       int queen = 1;
	       int rook = 2;
	       int bishop = 2;
	       int knight = 2;
	       int pawn = 8;
	       
	       king = king - sc.nextInt();
	       queen = queen - sc.nextInt();
	       rook = rook - sc.nextInt();
	       bishop = bishop - sc.nextInt();
	       knight = knight - sc.nextInt();
	       pawn = pawn - sc.nextInt();
	       
	       System.out.println(king + " " + queen + " " + rook + " " + bishop + " " + knight + " " + pawn);
	      
    	
    	
    	
    	
    	
    	
    	
    	
    	
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int king = 1;
//        int queen = 1;
//        int rook = 2;
//        int bishop = 2;
//        int knight = 2;
//        int pawn = 8;
//        
//        StringTokenizer st = new StringTokenizer(br.readLine(), "");
//        king = king - Integer.parseInt(st.nextToken());
//        queen = queen - Integer.parseInt(st.nextToken());
//        rook = rook - Integer.parseInt(st.nextToken());
//        bishop = bishop - Integer.parseInt(st.nextToken());
//        knight = knight - Integer.parseInt(st.nextToken());
//        pawn = pawn - Integer.parseInt(st.nextToken());
//        
//        System.out.print(king + "");
//        System.out.print(queen + "");
//        System.out.print(rook + "");
//        System.out.print(bishop + "");
//        System.out.print(knight + "");
//        System.out.print(pawn + "");
    }
}