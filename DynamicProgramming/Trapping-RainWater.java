public int trap(int[] height) {
       if(height == null || height.length == 1) {
           return 0;
       }
       
       int firstPillar = -1;
       int trappedWater = 0;
       
       for(int i = 0; i < height.length; i++) {
           if(firstPillar == -1) { //to find the first pillar
               if(height[i] > 0) {
                   firstPillar = i;                   
               }
               continue;
           }
           
           if(height[i] >= height[firstPillar]) {              
               for(int j = firstPillar + 1; j < i; j++) {                   
                   trappedWater += height[firstPillar] - height[j];
               }
               firstPillar = i;
           }           
       }
       
       int lastUsedPillar = firstPillar;
       firstPillar = -1;
       for(int i = height.length - 1; i >= lastUsedPillar; i--) {
           if(firstPillar == -1) { //to find the first pillar
               if(height[i] > 0) {
                   firstPillar = i;                   
               }
               continue;
           }
           
           if(height[i] >= height[firstPillar]) {              
               for(int j = firstPillar - 1; j > i; j--) {                   
                   trappedWater += height[firstPillar] - height[j];
               }
               firstPillar = i;
           }           
       }
       
       return trappedWater;
   }    
