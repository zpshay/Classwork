public class Station {
	private String USAF;
	private String WBAN;
	private String SNAME;
	private String CTRY;
	private String STATE;
	private String ICAO;
	private String LAT;
	private String LON;
	private String ELEV;
	private String BEGIN;
	private String END;

	public Station(String USAF, String WBAN, String SNAME, String CTRY,
	String STATE, String ICAO, String LAT, String LON, String ELEV, String BEGIN,
	String END) {
		this.USAF = USAF;
		this.WBAN = WBAN;
		this.SNAME = SNAME;
		this.CTRY = CTRY;
		this.STATE = STATE;
		this.ICAO = ICAO;
		this.LAT = LAT;
		this.LON = LON;
		this.ELEV = ELEV;
		this.BEGIN = BEGIN;
		this.END = END;	
	}
	
	public String getUSAF() {
		return this.USAF;
	}
	public String getWBAN() {
		return this.WBAN;
	}
	public String getSNAME() {
		return this.SNAME;
	}
	public String getCTRY() {
		return this.CTRY;
	}
	public String getSTATE() {
		return this.STATE;
	}
	public String getICAO() {
		return this.ICAO;
	}
	public String getLAT() {
		return this.LAT;
	}
	public String getLON() {
		return this.LON;
	}
	public String getELEV() {
		return this.ELEV;
	}
	public String getBEGIN() {
		return this.BEGIN;
	}
	public String getEND() {
		return this.END;
	}

}