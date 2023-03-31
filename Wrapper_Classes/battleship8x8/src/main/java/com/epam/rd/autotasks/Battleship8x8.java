package com.epam.rd.autotasks;

import java.math.BigInteger;

public class Battleship8x8 {
    private final long ships;
    private long shots = 0L;

    public Battleship8x8(final long ships) {
        this.ships = ships;
    }
    
    public boolean shoot(String shot) {
    	int let = shot.charAt(0)-64;
    	int num = shot.charAt(1)-48;    	 
        int index = 63 - ((num-1)*8+(let-1));  //индекс от 63 до 0
                
        BigInteger fire = BigInteger.valueOf(shots);         
        fire = fire.setBit(index); //Возвращает BigInteger, значение которого эквивалентно этому BigInteger с определяемым набором битов.        
        
        BigInteger map = BigInteger.valueOf(ships); 
        if(map.testBit(index)) {
        	//Возвраты true если и только если определяемый бит устанавливается.
        	 shots = fire.longValue();
        	return true;
        }
        
        shots = fire.longValue(); //Преобразовывает этот BigInteger в a long.
        return false;
    }

    public String state() {
    	StringBuilder s = new StringBuilder();
        BigInteger map = BigInteger.valueOf(ships);
        BigInteger fire = BigInteger.valueOf(shots);
        boolean m, f;
        
        for (int i = 0; i < 64; i++) {
            m = map.testBit(63-i);
            f = fire.testBit(63-i);
            
            if (m && f) {
                s.append("☒");
            } else if (m) {
                s.append("☐");
            } else if (f) {
                s.append("×");
            } else {
                s.append(".");
            }
            if ((i % 9) == 0) {
                s.insert(i, "\n");
            }
        }
        return s.toString();
    }
}
