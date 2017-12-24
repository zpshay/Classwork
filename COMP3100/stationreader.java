   import java.io.*;
	import java.util.Scanner;
	import java.lang.Integer;
	import java.util.ArrayList;
	import java.util.Iterator;
	
   public class stationreader {
		private ArrayList<Station> stations;
		private boolean isRead = false;
		
		public stationreader() {
			this.stations = new ArrayList<Station>(); 
		}
		
      public void stationFile () {
      
         String fileName = "isd-history.csv";
			ArrayList<String> lines = new ArrayList<String>();
         String line = null;
		
         try {
            FileReader fileReader = new FileReader(fileName);
          
            BufferedReader bufferedReader = new BufferedReader(fileReader);
         	line = bufferedReader.readLine();
           while((line = bufferedReader.readLine()) != null) {
			  		String replacedLine = line.replaceAll("\"","");
					lines.add(replacedLine);
           } 
			  for (String s : lines) {
			  	String[] x = s.split(",");
				this.stations.add(new Station(x[0],x[1],x[2],x[3],x[4],x[5],x[6],x[7],x[8],x[9],x[10]));
			  }
            bufferedReader.close(); 
				this.isRead = true;        
         }
            catch(FileNotFoundException ex) {
               System.out.println(
                  "Unable to open file '" + 
                  fileName + "'");                
            }
            catch(IOException ex) {
               System.out.println(
                  "Error reading file '" 
                  + fileName + "'");                  
            }	
	   }
		
		public ArrayList<String> findState(String userinput) {
			if (this.isRead == false) {
				stationFile();
			}
			ArrayList <Station> stationlist = this.stations;
			ArrayList<String> statelist = new ArrayList<String>();
		   for (Station s : stationlist) {
				String sstate = s.getSTATE();
				String ssname = s.getSNAME();
				String sctry = s.getCTRY();
				if (sstate.equals(userinput)) {
					String states = (ssname + " " + sstate + " " + sctry);
					statelist.add(states);
				}
			}
			return statelist;
		}
		public void getZip(String userinput) {
		
		
		}

		public ArrayList<String> getActive(String userinput) {
			if (this.isRead == false) {
				stationFile();
			}
			ArrayList <Station> stationlist = this.stations;
			ArrayList<String> statelist = new ArrayList<String>();
			for (Station s : stationlist) {
				String sdate = s.getBEGIN();
				String ssname = s.getSNAME();
				String ssyear = sdate.substring(0,4);
				String ssmonth = sdate.substring(4,6);
				String ssday = sdate.substring(6);
				int syear = Integer.parseInt(ssyear);
				int smonth = Integer.parseInt(ssmonth);
				int sday = Integer.parseInt(ssday);
				
				String usermonth = userinput.substring(0,4);
				String userday = userinput.substring(4,6);
				String useryear = userinput.substring(6);
				int umonth = Integer.parseInt(usermonth);
				int uday = Integer.parseInt(userday);
				int uyear = Integer.parseInt(useryear);
				
				if (syear <= uyear) {
					if (smonth <= umonth) {
						if (sday < uday) {
							String states = (ssname + " " + sdate);
							statelist.add(states);
						}
					}
				}
			}	
			return statelist;		
		}
		
		public ArrayList<String> getElevation(String userinput) {
			if (this.isRead == false) {
				stationFile();
			}
			ArrayList <Station> stationlist = this.stations;
			ArrayList<String> elevationlist = new ArrayList<String>();
			for (Station s : stationlist) {
				String sstate = s.getSTATE();
				String ssname = s.getSNAME();
				String sctry = s.getCTRY();
				String selevation = s.getELEV();
				int elevationNum = Integer.parseInt(selevation);
				int userElevation = Integer.parseInt(userinput);
				
				if(userElevation >= elevationNum) {
					
					String states = ssname + " " + sstate + " " + sctry;
					elevationlist.add(states);
					}

			}
			
			return elevationlist;			
		}


		
 }
	