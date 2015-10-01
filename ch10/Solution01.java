package codingbootcamp;

public class codingbootcamp {
	
	public static int mergeSorted (int [] l1, int [] l2, int len1, int len2) {
		int inx1 = 0, inx2 = 0;
		int now_len = len1;
		int tmp;
		while (inx2 < len2) {
			if (inx1 < now_len) {
				if (l2[inx2] < l1[inx1]) {
					tmp = now_len;
					while (tmp >= inx1) {
						l1[tmp + 1] = l1[tmp];
						tmp--;
					}
					l1[inx1] = l2[inx2];
					now_len++;
					inx2++;
				}
			}
			else {
				l1[now_len++] = l2[inx2];
				inx2++;
			}
			inx1++;
		}
		return now_len;
	}
	
	public static void main(String[] args) {
       int [] l1 = new int [12];
       int [] l2 = {2,4,9};
       l1[0] = 2;
       l1[1] = 3;
       l1[2] = 4;
       l1[3] = 5;
       l1[4] = 11;
       int len = mergeSorted(l1, l2, 5, l2.length);
       for (int i=0; i<len; i++) System.out.println(l1[i]);
       System.out.println();
       
       int [] l11 = new int [12];
       int len2 = mergeSorted(l11, l2, 0, l2.length);
       for (int i=0; i<len2; i++) System.out.println(l11[i]);
    }
}