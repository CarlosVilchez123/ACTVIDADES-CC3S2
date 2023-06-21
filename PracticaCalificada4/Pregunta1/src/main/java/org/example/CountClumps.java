package org.example;

public class CountClumps {

    /**
     * El metodo lo que hace es contar el numero de clumps que hay en un array.
     *
     * @param nums Es el array donde se efectuara el conteo de clumps, este array debe ser no nulo
     * @param size Es el tamaño del array, el tamaño del array debe ser mayor que 0
     * @return El metodo retorna el conteo de clumps
     */
    public int countClumps(int[] nums, int size){
        if(nums==null) return 0; //T1
        if(size<0) return 0; //T2

        int count_clumps=0;
        int result=0;
        //T3
        for(int i=0; i<size;i++){
            for(int j=i; j<size;j++) {
                if(nums[i]==nums[j]){
                    count_clumps++;
                }else break;

                if(count_clumps==size) return 1;
            }
            if(count_clumps>1){
                result++;
            }
            count_clumps=0;
        }

        return result;
    }
}
