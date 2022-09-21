package com.quentinrouet.amazeni;

/**
 * Created by quentin for HelloWorld on 21/09/2022.
 */
class Rating{

   private float rate;
   private int count;

   public Rating(float rate, int count) {
      this.rate = rate;
      this.count = count;
   }

   public float getRate() {
      return rate;
   }

   public void setRate(float rate) {
      this.rate = rate;
   }

   public int getCount() {
      return count;
   }

   public void setCount(int count) {
      this.count = count;
   }

   @Override
   public String toString() {
      return "Rating{" +
              "rate=" + rate +
              ", count=" + count +
              '}';
   }
}
