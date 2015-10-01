package codingbootcamp;

public class codingbootcamp {
	
	public static int sparseSearch(String st, String [] sr, int l, int r) {
		int mid = (l + r) / 2;
		int pace = 1;
		if (sr[mid].equals("")) {
			while(sr[mid].equals("")){
				if (mid - pace >= l && !sr[mid - pace].equals("")) { mid = mid - pace; break;}
				else if (mid + pace <= r && !sr[mid + pace].equals("")) {
					mid = mid + pace; 
					break;
				}
				else pace++;
			}
		}
		if (sr[mid].compareTo(st) < 0) {
			return sparseSearch(st, sr, mid + 1, r);
		}
		else if (sr[mid].compareTo(st) > 0) {
			return sparseSearch(st, sr, l, mid - 1);
		}
		else return mid;
	}
	
	public static void main(String[] args) {
       String [] sr = {"are u ready",  "", "letsgo", "what", "", "", "xyz", "", ""};
       System.out.println(sparseSearch("what", sr, 0, sr.length));
       System.out.println(sparseSearch("are u ready", sr, 0, sr.length));
       System.out.println(sparseSearch("xyz", sr, 0, sr.length));
       System.out.println(sparseSearch("letsgo", sr, 0, sr.length));
    }
}