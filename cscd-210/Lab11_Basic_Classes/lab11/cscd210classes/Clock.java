package lab11.cscd210classes;


/**
 * Represents the Clock class
 * <br> All parameters are passed as final and all preconditions will be 
 * enforced
 */
public class Clock
{
   private int hour;
   private int minute;
   private int second;
   
   public Clock()
   {
         this.hour = 12;
         this.minute = 0;
         this.second = 0;
   }
   
   public Clock(final int hour, final int minute, final int second)
   {
         this.hour = hour;
         this.minute = minute;
         this.second = second;
   }
   
   public int getHour()
   {
         return this.hour;
   }
   
   public int getMinutes()
   {
         return this.minute;
   }   

   public int getSeconds()
   {
         return this.second;
   }
   
   public void setHour(final int hour)
   {
         if(hour < 0)
         {
               throw new IllegalArgumentException("Error param setHour");
         } // Exception
         
         this.hour = this.hour + hour;
         
         if(this.hour == 24)
         {
               this.hour = 00;
         }
         else if(this.hour > 24)
         {
               this.hour = this.hour % 24;
         }
   }     
   
    public void setMinutes(final int minute)
   {
         if(minute < 0)
         {
               throw new IllegalArgumentException("Error param setMinute");
         } // Exception
         
         this.minute = this.minute + minute;
         
         if(this.minute == 60)
         {
               this.minute = 00;
         }
         else if(this.minute > 60)
         {
               int tempMinute = this.minute % 60;
               this.hour = this.hour + ((this.minute - tempMinute) / 60);
               
               if(this.hour == 24)
               {
                     this.hour = 00;
               }
               else if(this.hour > 24)
               {
                     this.hour = this.hour % 24;
               }
               
               this.minute = tempMinute;
               
         }
   }
   
   @Override
   public String toString()
   {
         String strHour = "";
         String strMinute = "";
         String strSecond = "";
         String strFinal = ""; 
         
         if(this.hour < 10)
         {
               strHour = "0" + this.hour;
         }
         else
         {
               strHour = "" + this.hour;
         }
         
         if(this.minute < 10)
         {
               strMinute = "0" + this.minute;   
         }
         else
         {
               strMinute = "" + this.minute;
         }
         
         if(this.second < 10)
         {
               strSecond = "0" + this.second;  
         }
         else
         {
               strSecond = "" + this.second;
         }
         
         strFinal = strHour + ":" + strMinute + ":" + strSecond;
         
         return strFinal;
   }
                  
}// end class