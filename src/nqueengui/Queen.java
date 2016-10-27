/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nqueengui;

/**
 *
 * @author Harsh
 */
public class Queen 
{

    public int colNumber;

    public int getColNumber()
    {
        return colNumber;
    }

    public void setColNumber(int x)
    {
        colNumber=x;
    }
    
    public boolean isConsistent(Queen[] q,int k)
    {
        for(int j=0;j<k;j++)
        {

            if(q[j].getColNumber() == colNumber) return false;
            else if((q[j].getColNumber() - colNumber)==(j-k)) return false;
            else if((q[j].getColNumber() - colNumber)==(k-j)) return false;
        }
        return true;
    }
};