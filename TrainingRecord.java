// An implementation of a Training Record as an ArrayList
package com.stir.cscu9t4practical1;




import java.util.*;


public class TrainingRecord {
    private List<Entry> tr;
    private List<CycleEntry> CycleRecord;
    private List<SprintEntry> SprintRecord;
    private List<SwimEntry> SwimRecord;
    
    public TrainingRecord() {
        tr = new ArrayList<Entry>();
        CycleRecord = new ArrayList<CycleEntry>();
        SprintRecord = new ArrayList<SprintEntry>();
        SwimRecord = new ArrayList<SwimEntry>();
    } //constructor
    
    // add a record to the list
   public void addEntry(Entry e){
       tr.add(e);    
   } // addClass
   
   public void addCycleEntry(CycleEntry e)
   {
	   tr.add(e);
       CycleRecord.add(e);    
   } // addClass
   
   public void addSprintEntry(SprintEntry e)
   {
	   tr.add(e);
       SprintRecord.add(e);    
   } // addClass
   
   
   public void addSwimEntry(SwimEntry e)
   {
	   tr.add(e);
       SwimRecord.add(e);
   } // addClass
   
   public String lookupAllEntriesForSelectedActivity(int d, int m, int y, String SelectedActivity)
   {   
       String result = "No entries found";
       int counter = 0;
     
      if(SelectedActivity.equals("Cycle"))
       {
    	   ListIterator<CycleEntry> cycleIter = CycleRecord.listIterator();
    	   
           while (cycleIter.hasNext())
           {
              CycleEntry current = cycleIter.next();
              if (current.getDay() == d && current.getMonth() == m && current.getYear() == y)
              {
            	  counter++;
            	  if(counter == 1) 
            	  {
            		  result = current.getCycle(); 
            	  }
            	  else 
            	  {
            		  result = result.concat(current.getCycle()); 
            	  }
              }
           }
       }
             else if(SelectedActivity.equals("Sprint"))
       {
    	   ListIterator<SprintEntry> sprintIter = SprintRecord.listIterator();
    	   
           while (sprintIter.hasNext())
           {
              SprintEntry current = sprintIter.next();
              if (current.getDay() == d && current.getMonth() == m && current.getYear() == y)
              {
            	  counter++;
            	  if(counter == 1) 
            	  {
            		  result = current.getSprint(); 
            	  }
            	  else 
            	  {
            		  result = result.concat(current.getSprint()); 
            	  }
              }
           }
       }
       
       else if(SelectedActivity.equals("Swim"))
       {
    	   ListIterator<SwimEntry> swimIter = SwimRecord.listIterator();
    	   
           while (swimIter.hasNext())
           {
              SwimEntry current = swimIter.next();
              if (current.getDay() == d && current.getMonth() == m && current.getYear() == y)
              {
            	  counter++;
            	  if(counter == 1) 
            	  {
            		  result = current.getSwim(); 
            	  }
            	  else 
            	  {
            		  result = result.concat(current.getSwim()); 
            	  }
              }
           }
       }

       return result;
   }
   
   
   public String lookupEntry (int d, int m, int y) {
       ListIterator<Entry> iter = tr.listIterator();
       String result = "No entries found";
       while (iter.hasNext()) {
          Entry current = iter.next();
          if (current.getDay()==d && current.getMonth()==m && current.getYear()==y) 
             result = current.getEntry();
            }
       return result;
   } 
   

   public int getNumberOfEntries(){
       return tr.size();
   }
   // Clear all entries
   public void clearAllEntries(){
       tr.clear();
   }
   
   
   public String FindAll(int d, int m, int y) {
    List<Entry> entriesOnDate = new ArrayList<>();
    for (Entry entry : tr) {
        if (entry.getDay() == d && entry.getMonth() == m && entry.getYear() == y) {
            entriesOnDate.add(entry);
        }
    }
    if (entriesOnDate.isEmpty()) {
        return "No entries found for " + d + "/" + m + "/" + y;
    } else {
        StringBuilder result = new StringBuilder();
        for (Entry entry : entriesOnDate) {
            result.append(entry.getEntry()).append("\n\n");
        }
        // Remove the last "\n\n" added in the loop
        result.delete(result.length() - 2, result.length());
        return result.toString();
    }
}
   
} // TrainingRecord