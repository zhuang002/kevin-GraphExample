/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphexample;

/**
 *
 * @author zhuan
 */
public class Coord {
    int a,b;
    public Coord(int i, int j) {
        a=i;
        b=j;
    }
    
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Coord)) return false;
        return this.a==((Coord)o).a && this.b==((Coord)o).b;
    }
}
