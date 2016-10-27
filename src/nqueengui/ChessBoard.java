/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nqueengui;

import java.util.ArrayList;

public class ChessBoard 
{
    
    private int n;
    public int count;
    public Queen[] q;
    public ArrayList<int[]> solutions;
    
    ChessBoard(int size)
    {
        n=size;
        count=0;
        q=new Queen[n];
        for(int i=0;i<n;i++){
            q[i]=new Queen();
        }
        solutions = new ArrayList<>();
    }

    public void check(int k)
    {
        if(k==n)
        {
            addSolution();
        }
        else
        {
            for(int i=0;i<n;i++)
            {
                q[k].setColNumber(i);
                if(q[k].isConsistent(q,k)) check(k+1);
                
            }
        }    
    } 

    public void addSolution()
    {
        int i,j;
        int solution[] = new int[n];
        count++;
        for(i=0;i<n;i++)
        {
            for(j=0;j<n;j++)
            {
                if(q[i].getColNumber()==j)
                {
                    solution[i] = j;
                    
                }
            }  
        }
        solutions.add(solution);
    } 
}
