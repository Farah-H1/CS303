/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WEEK5;

/**
 *
 * @author HP
 */
public class GUI3 extends javax.swing.JFrame{
    int s[];
    public GUI3(int s[]){
    this.s=s;
    }
    
    public int BinarySearch (int low , int high){
        int mid,x=0;
        if(low > high){
        return 0 ;
        }else{
        mid = (low+high)/2;
        if(x==s[mid])
            return mid;
        else if(x <s[mid])
            return BinarySearch(low,mid-1);
        else
            return BinarySearch (mid+1,high);
        }
    }
}
